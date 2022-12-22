package ru.practicum.shareit.booking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.booking.BookingStatus;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.model.ItemDtoVeryShort;
import ru.practicum.shareit.user.model.User;

import javax.persistence.*;
import java.time.LocalDateTime;



@Getter
@Setter
@Builder
public class BookingDtoShort {

        private Long id;


        private LocalDateTime start;


        private LocalDateTime end;

        private BookingStatus status;


        private ItemDtoVeryShort item;


        private Long bookingId;

    }



