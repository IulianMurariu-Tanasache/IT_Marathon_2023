package com.it.marathon.api;

import com.it.marathon.dto.CredentialsDTO;
import com.it.marathon.dto.UserIdDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/users")
public interface UserServiceAPI {

    @GetMapping("")
    List<UserIdDTO> getUsers();

    @PostMapping("/login")
    UserIdDTO login(@RequestBody CredentialsDTO credentialsDTO);

    @PostMapping("/register")
    void register(@RequestBody CredentialsDTO credentialsDTO);
}
