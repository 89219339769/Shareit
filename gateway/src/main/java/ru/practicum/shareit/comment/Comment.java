package ru.practicum.shareit.comment;

import lombok.*;
import ru.practicum.shareit.item.Item;
import ru.practicum.shareit.user.userDto.UserDto;


import java.time.LocalDateTime;



@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;


    private String text;


    private Item item;


    private UserDto author;

    private LocalDateTime created;
}
