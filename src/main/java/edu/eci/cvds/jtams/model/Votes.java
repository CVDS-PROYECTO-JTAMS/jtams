package edu.eci.cvds.jtams.model;

public class Votes {

	 private int user_id;
	 private int ini_id;

	    public Votes(int id, int iniciativa1) {
	        this.user_id = id;
	        this.ini_id=iniciativa1;
	    }

	    public int getId() {
	        return user_id;
	    }

	    public void setId(int id) {
	        this.user_id = id;
	    }

		public int getIniciativa() {
			return ini_id;
		}

		public void setIniciativa(int iniciativa) {
			this.ini_id = iniciativa;
		}

	    
	}