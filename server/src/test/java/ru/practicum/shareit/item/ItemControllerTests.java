package ru.practicum.shareit.item;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import ru.practicum.shareit.exceptions.NotFoundException;
import ru.practicum.shareit.item.controller.ItemController;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.item.model.ItemDtoForBooker;
import ru.practicum.shareit.item.model.ItemDtoForOwner;
import ru.practicum.shareit.request.Request;
import ru.practicum.shareit.request.RequestController;
import ru.practicum.shareit.user.controller.UserController;
import ru.practicum.shareit.user.model.User;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ItemControllerTests {


    @Autowired
    private UserController userController;

    @Autowired
    private RequestController requestController;
    @Autowired
    private ItemController itemController;


    private ItemDtoForOwner itemDtoForOwner;
    private ItemDtoForBooker itemDtoForBooker;
    private Item item;
    private User user;

    private Request request;

    @BeforeEach
    void init() {
        item = Item.builder()
                .name("name")
                .description("description")
                .available(true)
                .build();


        itemDtoForOwner = ItemDtoForOwner.builder()
                .id(1)
                .name("name")
                .description("description")
                .available(true)
                .ownerId(1)
                .lastBooking(null)
                .nextBooking(null)
                .comments(List.of())
                .build();

        itemDtoForBooker = ItemDtoForBooker.builder()
                .id(1)
                .name("name")
                .description("description")
                .available(true)
                .ownerId(1)
                .lastBooking(null)
                .nextBooking(null)
                .comments(List.of())
                .build();



        user = new User();
        user.setName("name");
        user.setEmail("user@email.com");

        request = Request.builder()
                .description("test")
                .build();


    }








    @Test
    void getItemTestWithWrongId() {
        assertThrows(NotFoundException.class, () -> itemController.getById(99L, 2L));
    }




}
