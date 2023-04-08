package com.prodex.stationaryinventory.services;

import com.prodex.stationaryinventory.models.AuthResponse;
import com.prodex.stationaryinventory.models.LoginRequest;
import com.prodex.stationaryinventory.models.RegistRequest;

public interface LoginRegistService {
    
    public AuthResponse login(LoginRequest loginRequest);

    public AuthResponse regist(RegistRequest registRequest);
}
