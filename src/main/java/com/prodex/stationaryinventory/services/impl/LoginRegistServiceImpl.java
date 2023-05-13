package com.prodex.stationaryinventory.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prodex.stationaryinventory.common.HashingPassword;
import com.prodex.stationaryinventory.common.enums.RoleType;
import com.prodex.stationaryinventory.entities.UserBase;
import com.prodex.stationaryinventory.entities.UserBase.UserBaseBuilder;
import com.prodex.stationaryinventory.models.AuthResponse;
import com.prodex.stationaryinventory.models.LoginRequest;
import com.prodex.stationaryinventory.models.RegistRequest;
import com.prodex.stationaryinventory.repository.DaoUserBaseRepository;
import com.prodex.stationaryinventory.services.LoginRegistService;

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

        Optional<UserBase> userNow = daoUserRepository.findById(registRequest.getIdEmployee());
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
                .idEmployee(registRequest.getIdEmployee())
                .username(registRequest.getUsername())
                .firstName(registRequest.getFirstName())
                .lastName(registRequest.getLastName())
                .fullName(registRequest.getFullName())
                .telNo(registRequest.getTelNo())
                .isLocked(false)
                .isLogin(false)
                .role(RoleType.STAFF)
                .password(hashingPassword.tryHashPassword(registRequest.getPassword()));
        daoUserRepository.saveAndFlush(newUser.build());
    }

}
