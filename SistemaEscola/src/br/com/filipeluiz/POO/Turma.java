package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Turma {   
    private int serie;
    private String turno;
    
    public Turma() {  
    }

    public Turma(int serie, String turno) {
        this.serie = serie;
        this.turno = turno;       
    }    

    public int getSerie() {
        return this.serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getTurno() {
        return this.turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Serie = " + this.getSerie() + "º" + ", Turno = " + this.getTurno(); 
    }
}
