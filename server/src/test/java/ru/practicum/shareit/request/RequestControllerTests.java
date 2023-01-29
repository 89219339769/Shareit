package ru.practicum.shareit.request;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import ru.practicum.shareit.exceptions.NotFoundException;
import ru.practicum.shareit.item.controller.ItemController;
import ru.practicum.shareit.item.model.Item;

import ru.practicum.shareit.user.controller.UserController;
import ru.practicum.shareit.user.model.User;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RequestControllerTests {
    @Autowired
    private RequestController itemRequestController;

    @Autowired
    private ItemController itemController;
    @Autowired
    private UserController userController;

    private Request request;

    private User user;

    @BeforeEach
    void init() {
        request = Request.builder()
                .description("test")
                .build();

        user = new User();
        user.setName("name");
        user.setEmail("user@email.com");

    }



    @Test
    void getByIdRequestTest() {
        userController.create(user);
        itemRequestController.add(user.getId(), request);
        RequestDto requestDto = ItemRequestMapper.toItemRequestDto(request);
        RequestDtoForTest requestDtoForTest = ItemRequestMapper.toItemRequestDtoForTest(requestDto);

        RequestDto requestDtoTest = itemRequestController.getRequestById(1L, 1L);
        RequestDtoForTest requestDtoForTestTest = ItemRequestMapper.toItemRequestDtoForTest(requestDtoTest);
        assertEquals(requestDtoForTest, requestDtoForTestTest);

    }


}
