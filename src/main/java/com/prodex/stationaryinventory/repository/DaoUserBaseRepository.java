package com.prodex.stationaryinventory.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodex.stationaryinventory.entities.UserBase;
public interface DaoUserBaseRepository extends JpaRepository<UserBase, Long>{

    Optional<UserBase> findByEmail(String email);
    Optional<UserBase> findByUsername(String username);
}
    
