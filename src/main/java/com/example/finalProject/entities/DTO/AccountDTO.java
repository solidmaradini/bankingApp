package com.example.finalProject.entities.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountDTO {

    @NotEmpty
    private String balance;
    private String penaltyFee;
    @NotNull
    private Long primaryOwnerId;
    private Long secondaryOwnerId;

    private String interestedRate;

    private String minimumBalance;

    public AccountDTO(String balance, String penaltyFee, Long primaryOwnerId, Long secondaryOwnerId, String interestedRate, String minimumBalance) {
        this.balance = balance;
        this.penaltyFee = penaltyFee;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.interestedRate = interestedRate;
        this.minimumBalance = minimumBalance;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(String penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Long getPrimaryOwnerId() {
        return primaryOwnerId;
    }

    public void setPrimaryOwnerId(Long primaryOwnerId) {
        this.primaryOwnerId = primaryOwnerId;
    }

    public Long getSecondaryOwnerId() {
        return secondaryOwnerId;
    }

    public void setSecondaryOwnerId(Long secondaryOwnerId) {
        this.secondaryOwnerId = secondaryOwnerId;
    }

    public String getInterestedRate() {
        return interestedRate;
    }

    public void setInterestedRate(String interestedRate) {
        this.interestedRate = interestedRate;
    }

    public String getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(String minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
