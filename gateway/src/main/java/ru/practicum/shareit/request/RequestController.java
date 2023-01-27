package ru.practicum.shareit.request;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.exceptions.BadRequestException;
import ru.practicum.shareit.exceptions.NotFoundException;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
public class RequestController {

    private final RequestClient requestClient;


    @PostMapping
    public ResponseEntity<Object> add(@RequestHeader("X-Sharer-User-Id") Long userId,
                                      @RequestBody Request request) {


        return requestClient.addRequest(userId, request);
    }


    @GetMapping("/all")
    public ResponseEntity<Object> getAllWithItems(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                  @RequestParam(defaultValue = "0") int from,
                                                  @RequestParam(defaultValue = "10") int size) {
        return requestClient.getAllRequestsWithItems(userId, from, size);
    }


    @GetMapping()
    public ResponseEntity<Object> getAll(@RequestHeader("X-Sharer-User-Id") Long userId) {
        return requestClient.getAllRequestsByUser(userId);
    }


    @GetMapping("/{requestId}")
    public ResponseEntity<Object> getRequestById(@RequestHeader("X-Sharer-User-Id") Long userId,
                                                 @PathVariable Long requestId) {
        try {
         requestClient.getRequestById(userId, requestId);
        } catch (NotFoundException e) {
            System.out.println("Невозможно создать запрос - " +
                    "не найден пользователь с id: " + userId);
        }
        return requestClient.getRequestById(userId, requestId);
    }
}
