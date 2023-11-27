package com.example.ticketservice.repositores;

import com.example.ticketservice.entity.User;
import com.example.ticketservice.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class UserRepositoryImpl {
    private final JdbcTemplate jdbcTemplate;

    public void createUser(User user) {
        jdbcTemplate.update("insert into users (login, password, first_name, last_name, " +
                        "middle_name) values (?, ?, ?, ?, ?)",
                user.getLogin(), user.getPassword(), user.getFirstName(), user.getLastName(),
                user.getMiddleName());
    }
    /*public void createUser(String login, String password, String firstName, String lastName,
                           String middleName) {
        jdbcTemplate.update("insert into users (login, password, first_name, last_name, " +
                        "middle_name) values (?, ?, ?, ?, ?)",
                login, password, firstName, lastName, middleName);
    }*/

    public User findUserByLogin(String login) {

        User user = jdbcTemplate.queryForObject("select * from users where login = ?",
                new UserMapper(), login);
        return user;
    }

}
