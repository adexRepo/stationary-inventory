package com.project.dex.stationaryinventory.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.dex.stationaryinventory.common.utility.HashingPassword;
import com.project.dex.stationaryinventory.jpa.entity.UserBase;
import com.project.dex.stationaryinventory.jpa.entity.UserBase.UserBaseBuilder;
import com.project.dex.stationaryinventory.jpa.repository.DaoUserBaseRepository;
import com.project.dex.stationaryinventory.model.AuthResponse;
import com.project.dex.stationaryinventory.model.LoginRequest;
import com.project.dex.stationaryinventory.model.RegistRequest;
import com.project.dex.stationaryinventory.service.LoginRegistService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginRegistServiceImpl implements LoginRegistService {

    private final DaoUserBaseRepository daoUserRepository;

    @Override
    public AuthResponse login(LoginRequest loginRequest) {

        return null;

    }

    @Override
    public AuthResponse regist(RegistRequest registRequest) {

        HashingPassword hashingPassword = new HashingPassword();
        Optional<UserBase> userNow = daoUserRepository.findById(registRequest.getNoInduk());
        AuthResponse response = new AuthResponse();

        userNow.ifPresentOrElse(
                (e) -> response.setOkAuthenticated(false),
                () -> {
                    UserBaseBuilder newUser = UserBase.builder()
                            .noInduk(registRequest.getNoInduk())
                            .username(registRequest.getUsername())
                            .name(registRequest.getName())
                            .email(registRequest.getEmail())
                            .isActive(true)
                            .role(registRequest.getRole())
                            .telNo(registRequest.getTelNo())
                            .password(hashingPassword.tryHashPassword(registRequest.getPassword()));
                    daoUserRepository.saveAndFlush(newUser.build());
                    response.setOkAuthenticated(true);
                });

        return response;
    }

}
