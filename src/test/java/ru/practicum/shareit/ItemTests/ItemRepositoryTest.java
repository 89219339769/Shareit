package ru.practicum.shareit.ItemTests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.practicum.shareit.ShareItApp;
import ru.practicum.shareit.item.ItemRepository;
import ru.practicum.shareit.item.model.Item;
import ru.practicum.shareit.user.UserRepository;
import ru.practicum.shareit.user.model.User;
import java.util.Collection;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(classes = ShareItApp.class)
class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void searchTest() {

        User user = new User();
        user.setName("name");
        user.setEmail("email@email.com");
        userRepository.save(user);
        itemRepository.save(Item.builder().name("name").description("description").available(true).owner(user).build());


        List<Item> items = itemRepository.search("desc");
        assertThat(items.stream().count(), equalTo(1L));
    }

    @Test
    void findAllByOwnerIdTest() {
        User user = new User();
        user.setName("name");
        user.setEmail("email@email.com");
        userRepository.save(user);

        itemRepository.save(Item.builder().name("name").description("description").available(true).owner(user).build());
        Collection<Item> items = itemRepository.findAllByOwnerIdIsOrderById(user.getId());
        assertThat(items.stream().count(), equalTo(1L));
    }
}



