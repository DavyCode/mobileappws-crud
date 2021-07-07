package com.rubeecare.app.ws.mobileappws.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubeecare.app.ws.mobileappws.UserRepository;
import com.rubeecare.app.ws.mobileappws.io.entity.UserEntity;
import com.rubeecare.app.ws.mobileappws.service.UserService;
import com.rubeecare.app.ws.mobileappws.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");

        UserEntity newUser = userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(newUser, returnValue);

        return returnValue;
    }

}
