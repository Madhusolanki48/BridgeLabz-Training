package com.clinic.dto;

public class Specialization {
    private int specializationId;
    private String name;
    private String description;
    private boolean active;

    public Specialization() {
    }

    public Specialization(int specializationId, String name, String description, boolean active) {
        this.specializationId = specializationId;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public int getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(int specializationId) {
        this.specializationId = specializationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String toString() {
        return "[" + specializationId + "] " + name + " | " + description;
    }
}
