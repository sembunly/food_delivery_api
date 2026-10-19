package com.bunli.service.impl;

import com.bunli.dto.UserRequest;
import com.bunli.dto.UserResponse;
import com.bunli.model.User;
import com.bunli.repository.DeliveryRepository;
import com.bunli.repository.UserRepository;
import com.bunli.service.UserHandlerService;
import com.bunli.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final DeliveryRepository deliveryRepository;
    private final UserHandlerService userHandlerService;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
                           DeliveryRepository deliveryRepository,
                           UserHandlerService userHandlerService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.deliveryRepository = deliveryRepository;
        this.userHandlerService = userHandlerService;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        userHandlerService.userNameHasText(userRequest.getUsername());
        userHandlerService.phoneNumberHasText(userRequest.getPhoneNumber());

        User user = modelMapper.map(userRequest, User.class);
        log.info("Creating User: {}", user);

        userRepository.save(user);

        return null;
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserResponse> findAll() {
        return List.of();
    }
}
