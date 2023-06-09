
package ru.practicum.shareit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.shareit.client.BaseClient;
import ru.practicum.shareit.user.userDto.UserDto;



@Service
public class UserClient extends BaseClient {
    private static final String API_PREFIX = "/users";
    private static final String SHAREIT_SERVER_URL = "http://localhost:9090";

    @Autowired
    public UserClient(@Value(SHAREIT_SERVER_URL) String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl + API_PREFIX))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }


    public ResponseEntity<Object> postUser(UserDto user) {
        return post("", user);
    }


    public ResponseEntity<Object> getUsers() {
        return get("");
    }

    public ResponseEntity<Object> getUser(Long userId) {
        return get("/" + userId);
    }


    public ResponseEntity<Object> updateUser(long id, UserDto user) {
        return patch("/" + id, user);

    }

    public ResponseEntity<Object> deleteUser(long id) {
        return delete("/" + id);
    }
}
