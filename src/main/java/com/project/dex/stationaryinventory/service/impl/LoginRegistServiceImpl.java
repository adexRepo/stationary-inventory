package com.project.dex.stationaryinventory.service.impl;

import org.springframework.stereotype.Service;

import com.project.dex.stationaryinventory.model.AuthResponse;
import com.project.dex.stationaryinventory.model.LoginRequest;
import com.project.dex.stationaryinventory.model.RegistRequest;
import com.project.dex.stationaryinventory.service.LoginRegistService;

@Service
public class LoginRegistServiceImpl implements LoginRegistService {

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        return null;
        
    }

    @Override
    public AuthResponse regist(RegistRequest registRequest) {
        // var newUser = UserBase.builder()
        // .noInduk(registRequest.getNoInduk())
        // .username(registRequest.getUsername())
        // .name(registRequest.getName())
        // .email(registRequest.getEmail())
        // .isActive(true)
        // .role(registRequest.getRole())
        // .telNo(registRequest.getTelNo())
        // .password()

        return null;
    }
    
}
