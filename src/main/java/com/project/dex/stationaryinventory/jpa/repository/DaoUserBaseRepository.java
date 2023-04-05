package com.project.dex.stationaryinventory.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.dex.stationaryinventory.jpa.entity.UserBase;
public interface DaoUserBaseRepository extends JpaRepository<UserBase, Long>{

    Optional<UserBase> findByEmail(String email);
    Optional<UserBase> findByUsername(String username);
}
    
