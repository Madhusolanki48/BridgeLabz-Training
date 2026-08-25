package com.example.fundoonotes.dto;

import jakarta.validation.constraints.NotBlank;

public class CheckListRequest {
    @NotBlank
    private String itemName;

    private String status;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
