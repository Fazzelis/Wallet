package backend.wallet.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import backend.wallet.api.dto.user.UserCreateDto;
import backend.wallet.api.dto.user.UserGetDto;
import backend.wallet.api.dto.user.UserPatchDto;
import backend.wallet.api.dto.user.UserSignInDto;
import backend.wallet.api.mapper.UserMapper;
import backend.wallet.core.service.UserService;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/sign_in")
    public UserGetDto signIn(@RequestParam HashMap<String, String> params){
        return userMapper.map(userService.signIn(UserSignInDto.builder()
                        .email(params.get("email"))
                        .password(params.get("password"))
                        .build()));
    }

    @GetMapping("/{id}")
    public UserGetDto getById(@PathVariable(name = "id") UUID id) {
        return userMapper.map(userService.getById(id));
    }

    @PostMapping
    public HashMap<String, UUID> create(@RequestBody UserCreateDto userCreateDto) {
        return userService.create(userMapper.map(userCreateDto));
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable(name = "id") UUID userId, @RequestBody UserPatchDto userPatchDto) {
        userService.update(userId, userMapper.map(userPatchDto));
    }
}
