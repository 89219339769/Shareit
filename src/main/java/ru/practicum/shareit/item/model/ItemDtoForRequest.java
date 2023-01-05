package ru.practicum.shareit.item.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDtoForRequest {

    private Long id;

    private String name;

    private long ownerId;


}

