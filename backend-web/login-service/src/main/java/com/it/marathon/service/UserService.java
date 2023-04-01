package com.it.marathon.service;

import com.it.marathon.dto.CredentialsDTO;
import com.it.marathon.dto.UserIdDTO;

import java.util.List;

public interface UserService {
    List<UserIdDTO> getUsers();
    UserIdDTO findUserWithCredentials(CredentialsDTO credentials);
    void addUser(CredentialsDTO userIdDTO);
}
