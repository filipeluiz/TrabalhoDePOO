package br.com.filipeluiz.POO;

/**
 *
 * @author filipe
 */
public class Contato {
    private String email;
    private String fone;
    
    public Contato() {
        this.email = "";
        this.fone = "";
    }
    
    public Contato(String email, String tel) {
        this.email = email;
        this.fone = tel;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setTelefone(String tel){
        this.fone = tel;
    }
    
    public String getTelefone() {
        return this.fone;
    }
   
    @Override
    public String toString() {
        return "\nEmail: " + this.getEmail() + 
               "\nTelefone: " + this.getTelefone();
    }
}
