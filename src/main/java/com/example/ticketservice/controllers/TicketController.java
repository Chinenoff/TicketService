package com.example.ticketservice.api;

import com.example.ticketservice.entity.Ticket;
import com.example.ticketservice.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor

public class TicketController {

    private final TicketService ticketService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);

    @GetMapping(value = "/tickets")
    public ResponseEntity<List<Ticket>> getAllAvaliableTickets() {
        final List<Ticket> tickets = ticketService.findAllAvaliableTickets();
        LOGGER.info("Create user request received: {}");

        return tickets != null &&  !tickets.isEmpty()
                ? new ResponseEntity<>(tickets, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Пример пагинации
  /*  @GetMapping(params = { "page", "size" })
    public List<Foo> findPaginated(@RequestParam("page") int page,
                                   @RequestParam("size") int size, UriComponentsBuilder uriBuilder,
                                   HttpServletResponse response) {
        Page<Foo> resultPage = service.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<Foo>(
                Foo.class, uriBuilder, response, page, resultPage.getTotalPages(), size));

        return resultPage.getContent();
    }*/



}
