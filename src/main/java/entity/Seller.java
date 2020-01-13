package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author laste
 */
@Entity
@Table(name = "tab_seller")
public class Seller implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "idSeller")
    private int idSeller;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idStore")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idShelf")
    private Shelf belongsTo;
    
    @Column(name = "isAdmin")
    private boolean isAdmin;
    
    @Column(name = "firstName", unique=true)
    private String firstName;
    
    @Column(name = "lastName", unique=true)
    private String lastName;
    
    @Column(name = "mail", unique=true)
    private String mail;
    
    @Column(name = "password")
    private String password;   

    public Seller() {
    }

    public Seller(int idSeller, boolean isAdmin, String firstName, String lastName, String mail, String password) {
        this.idSeller = idSeller;
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }
    
    public int getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public Shelf getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(Shelf belongsTo) {
        this.belongsTo = belongsTo;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
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