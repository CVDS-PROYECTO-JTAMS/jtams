package edu.eci.cvds.jtams.model;

public enum UserType {
    ADMINISTRATOR(0),PERSONAL(1),PROPONENT(2),PUBLIC(3);

    private final int id;

    UserType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
