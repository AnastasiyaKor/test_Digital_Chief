package com.example.demo.controllers;

import com.example.demo.Marker;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody @Validated({Marker.Create.class}) UserDto userDto) {
        log.info("Received a request to create a user");
        User user = userService.create(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(user);
    }

    @PatchMapping("/{userId}")
    public UserDto update(@RequestBody @Validated({Marker.Update.class}) UserDto userDto, @PathVariable Long userId) {
        log.info("Received a request to update the user under the ID: {}", userId);
        User user = userService.update(UserMapper.toUser(userDto), userId);
        return UserMapper.toUserDto(user);
    }

    @GetMapping
    public List<UserDto> getAll() {
        log.info("Received a request to get all users");
        List<User> users = userService.getAll();
        return UserMapper.toUsersDtoList(users);
    }

    @GetMapping("/{userId}")
    public UserDto getById(@PathVariable Long userId) {
        log.info("A request was received to get a user under the ID:{}", userId);
        User user = userService.getById(userId);
        return UserMapper.toUserDto(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        log.info("A request was received to delete a user under the ID:{}", userId);
        userService.delete(userId);
    }
}
