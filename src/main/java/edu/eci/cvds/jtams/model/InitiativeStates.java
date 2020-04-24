package edu.eci.cvds.jtams.model;

public enum InitiativeStates {

	ESPERA(1),REVISION(2),PROYECTO(3),SOLUCIONADO(4);

    private final int id;

    InitiativeStates(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
