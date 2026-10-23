package com.bunli.service;

import com.bunli.dto.UserRequest;
import com.bunli.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest userRequest);

    UserResponse update(Long id, UserRequest userRequest);

    UserResponse findById(Long id);

    void delete(Long id);

    List<UserResponse> findAll();
}
