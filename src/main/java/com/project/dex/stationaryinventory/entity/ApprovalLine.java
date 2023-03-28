package com.project.dex.stationaryinventory.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class ApprovalLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long approvalId;

    @JoinColumn(name="stationary_id")
    public Stationary stationaryId;
    
    @JoinColumn(name="no_induk")
    public Borrowers borrowerId;
    
    @JoinColumn(name="user_id")
    public UserBase approver;
    
    public Date approvedAt;

    public Date borrowAt;
    
    public Date borrowUntil;

    public String remarkApprover;
    
}
