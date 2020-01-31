package entity;

import java.io.Serializable;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laste
 */
@Entity
@Table (name="shelf")
public class Shelf implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShelf")
    private int idShelf;
   
    @ManyToOne
    @JoinColumn(name = "idStore")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Store store;
     
    @Column(name = "name", unique=true, nullable=false)
    private String name;
   
    @OneToMany(mappedBy = "shelf", fetch=FetchType.EAGER, orphanRemoval=true, cascade=CascadeType.ALL)
    private List<Item> items;
    
    public Shelf() {
    }
    
    public Shelf(int idShelf, String name) {
        this.idShelf = idShelf;
        this.name = name;
    }

    public int getIdShelf() {
        return idShelf;
    }

    public void setIdShelf(int idShelf) {
        this.idShelf = idShelf;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
