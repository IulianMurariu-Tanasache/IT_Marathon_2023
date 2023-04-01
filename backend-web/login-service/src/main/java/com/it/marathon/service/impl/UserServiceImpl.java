package com.it.marathon.service.impl;

import com.it.marathon.dto.CredentialsDTO;
import com.it.marathon.dto.UserIdDTO;
import com.it.marathon.entity.UserEntity;
import com.it.marathon.repository.UserRepository;
import com.it.marathon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserIdDTO> getUsers() {
        return userRepository.findAll()
                .stream().map(entity -> modelMapper.map(entity, UserIdDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserIdDTO findUserWithCredentials(CredentialsDTO credentials) {
        return new UserIdDTO(
                userRepository.findUserByCredentials(credentials.getUsername(), credentials.getPassword())
                .orElse(new UserEntity())
                .getId()
        );
    }

    @Override
    public void addUser(CredentialsDTO credentialsDTO) {
        UserEntity newUser = new UserEntity();
        newUser.setUsername(credentialsDTO.getUsername());
        newUser.setPassword(credentialsDTO.getPassword());
        userRepository.save(newUser);
    }
}
