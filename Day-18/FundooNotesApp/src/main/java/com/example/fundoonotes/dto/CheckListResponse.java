package com.example.fundoonotes.dto;

public class CheckListResponse {
    private int id;
    private String itemName;
    private String status;
    private boolean deleted;

    public CheckListResponse(int id, String itemName, String status, boolean deleted) {
        this.id = id;
        this.itemName = itemName;
        this.status = status;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStatus() {
        return status;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
