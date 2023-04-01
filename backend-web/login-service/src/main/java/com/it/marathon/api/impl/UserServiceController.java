package com.it.marathon.api.impl;

import com.it.marathon.api.UserServiceAPI;
import com.it.marathon.dto.CredentialsDTO;
import com.it.marathon.dto.UserIdDTO;
import com.it.marathon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserServiceController implements UserServiceAPI {

    private final UserService userService;
    @Override
    public List<UserIdDTO> getUsers() {
        return userService.getUsers();
    }

    @Override
    public UserIdDTO login(CredentialsDTO credentialsDTO) {
        return userService.findUserWithCredentials(credentialsDTO);
    }

    @Override
    public void register(CredentialsDTO credentialsDTO) {
        userService.addUser(credentialsDTO);
    }
}
