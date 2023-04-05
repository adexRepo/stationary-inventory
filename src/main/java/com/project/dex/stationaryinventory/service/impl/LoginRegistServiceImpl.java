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

    /* ------------------------------ Authenticate ------------------------------ */
    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<UserBase> userNow;
        if (loginRequest.getUsernameOrEmail().contains("@")) {
            userNow = daoUserRepository.findByEmail(loginRequest.getUsernameOrEmail());
        } else {
            userNow = daoUserRepository.findByUsername(loginRequest.getUsernameOrEmail());
        }

        if (!userNow.isPresent()) {
            return new AuthResponse(false, "username or email is wrong!");
        }

        if (userNow.get().isLogin()) {
            return new AuthResponse(false, "can't login two person at the same time!");
        }

        return loginChecker(userNow.get(), loginRequest.getPassword());
    }

    private AuthResponse loginChecker(UserBase user, String password) {
        HashingPassword hashingPassword = new HashingPassword();
        String hashPass = hashingPassword.tryHashPassword(password);
        if (hashPass.equals(user.getPassword())) {
            user.setLogin(false);
            daoUserRepository.saveAndFlush(user);
            return new AuthResponse(true, "user authenticate!");
        } else {
            return new AuthResponse(true, "Wrong password!");
        }
    }

    /* ------------------------------ Registration ------------------------------ */
    @Override
    public AuthResponse regist(RegistRequest registRequest) {

        Optional<UserBase> userNow = daoUserRepository.findById(registRequest.getNoInduk());
        AuthResponse response = new AuthResponse();

        userNow.ifPresentOrElse(
                (e) -> response.setOkAuthenticated(false),
                () -> {
                    if (registRequest.getUsername().contains("@")) {
                        return;
                    }
                    registration(registRequest);
                    response.setOkAuthenticated(true);
                });

        return response;
    }

    private void registration(RegistRequest registRequest) {
        HashingPassword hashingPassword = new HashingPassword();
        UserBaseBuilder newUser = UserBase.builder()
                .noInduk(registRequest.getNoInduk())
                .username(registRequest.getUsername())
                .name(registRequest.getName())
                .email(registRequest.getEmail())
                .isActive(true)
                .isLogin(false)
                .role(registRequest.getRole())
                .telNo(registRequest.getTelNo())
                .password(hashingPassword.tryHashPassword(registRequest.getPassword()));
        daoUserRepository.saveAndFlush(newUser.build());
    }

}
