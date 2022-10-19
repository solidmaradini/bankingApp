package com.example.finalProject.entities.DTO;

public class TransferDTO {
     private String amount;
    private Long sendingId;
    private Long receivingId;

    public TransferDTO(String balance, Long idAccountHolder, Long idAccountHolderToTransfer) {

        this.amount = balance;
        this.sendingId = idAccountHolder;
        this.receivingId = idAccountHolderToTransfer;
    }


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getSendingId() {
        return sendingId;
    }

    public void setSendingId(Long sendingId) {
        this.sendingId = sendingId;
    }

    public Long getReceivingId() {
        return receivingId;
    }

    public void setReceivingId(Long receivingId) {
        this.receivingId = receivingId;
    }

}
