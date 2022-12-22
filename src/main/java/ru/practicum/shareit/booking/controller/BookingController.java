
package ru.practicum.shareit.booking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.booking.BookingService;
import ru.practicum.shareit.booking.model.BookingDtoShort;
import ru.practicum.shareit.booking.model.BookingShortDtoWithItemId;
import ru.practicum.shareit.item.model.ItemDtoShort;

import java.util.List;


@RestController
    @RequestMapping("/bookings")
    @RequiredArgsConstructor
    public class BookingController {
        private final BookingService bookingService;

        @PostMapping
        public BookingDtoShort add(@RequestHeader("X-Sharer-User-Id") Long userId,
                                   @RequestBody BookingShortDtoWithItemId booking) {

            return     bookingService.saveBooking(userId, booking);
        }


    @GetMapping("/{id}")
    public BookingDtoShort findBookingById(@PathVariable Long id) {
        return bookingService.getById(id);
    }





    @PatchMapping("/{bookingId}")
    public BookingDtoShort approve(@PathVariable Long bookingId, @RequestHeader("X-Sharer-User-Id") Long userId,
                              @RequestParam Boolean approved) {
        return bookingService.approve(bookingId, userId, approved);
    }



    @GetMapping
    public List<Booking> getAllByUser(@RequestHeader("X-Sharer-User-Id") Long userId,
                                      @RequestParam(defaultValue = "ALL") String state) {
        return bookingService.getAllBokingsSortByState(userId, state);
    }


}