package com.example.ticketservice.repositores;

import com.example.ticketservice.entity.User;
import java.util.List;

public interface UserRepository {
    void addUser(User user);
    void removeUser(User user);
    void updateUser(User user); // Think it as replace for set

    List query(UserSpecification specification);
}
