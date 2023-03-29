package com.project.dex.stationaryinventory.service;

import com.project.dex.stationaryinventory.model.AuthResponse;
import com.project.dex.stationaryinventory.model.LoginRequest;
import com.project.dex.stationaryinventory.model.RegistRequest;

public interface LoginRegistService {
    
    public AuthResponse login(LoginRequest loginRequest);

    public AuthResponse regist(RegistRequest registRequest);
}
