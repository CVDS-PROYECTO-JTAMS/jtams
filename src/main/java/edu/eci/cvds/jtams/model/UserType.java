package edu.eci.cvds.jtams.model;

public enum UserType {
    ADMINISTRATOR(0);

    private final int id;

    UserType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
