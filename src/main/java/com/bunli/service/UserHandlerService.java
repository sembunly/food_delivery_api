package com.bunli.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class UserHandlerService {

    public void userNameHasText(String username){
        if (StringUtils.hasText(username)){
            return;
        }
       throw new IllegalArgumentException("Username is empty");
    }

    public void phoneNumberHasText(String phoneNumber){
        if (StringUtils.hasText(phoneNumber)){
            return;
        }
        throw new IllegalArgumentException("Phone number is empty");
    }

}
