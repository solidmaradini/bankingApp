package com.example.finalProject.entities.DTO;

import java.math.BigDecimal;

public class TrasnferResponseDTO {

    private String sendingName;
    private String receivingName;
    private BigDecimal amount;

    public TrasnferResponseDTO(String sendingName, String receivingName, BigDecimal amount) {
        this.sendingName = sendingName;
        this.receivingName = receivingName;
        this.amount = amount;
    }

    public String getSendingName() {
        return sendingName;
    }

    public void setSendingName(String sendingName) {
        this.sendingName = sendingName;
    }

    public String getReceivingName() {
        return receivingName;
    }

    public void setReceivingName(String receivingName) {
        this.receivingName = receivingName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
