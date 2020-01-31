package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author laste
 */
@Entity
@Table(name = "director")
public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDirector")
    private int idDirector;
    
    @OneToOne
    @JoinColumn(name = "idStore")
    private Store store;
    
    @Column(name = "firstName", unique=true, nullable=false)
    private String firstName;
    
    @Column(name = "lastName", unique=true, nullable=false)
    private String lastName;
    
    @Column(name = "mail", unique=true, nullable=false)
    private String mail;
    
    @Column(name = "password")
    private String password;  

    public Director() {
    }

    public Director(int idDirector, String firstName, String lastName, String mail, String password) {
        this.idDirector = idDirector;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }
    
    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
