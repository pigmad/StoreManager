package entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author laste
 */
@Entity
@Table(name = "item")
public class Item implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem")
    private int idItem;
    
    @ManyToOne
    @JoinColumn(name = "idShelf")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shelf shelf;
    
    @Column(name = "name", unique=true, nullable=false)
    private String name;
    
    @Column(name = "price",nullable=false)
    private double price;
    
    @Column(name = "quantity", nullable=false)
    private int quantity;
    
    public Item() {
    }
    
    public Item(int idItem, String name, double price, int quantity) {
        this.idItem = idItem;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void setShelf(Shelf shelf) {
        this.shelf = shelf;
    }
    
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("Nom : ").append(name).append("; \n");
        buffer.append("Ref : ").append(idItem).append("; \n");
        buffer.append("Prix : ").append(price).append("; \n");
        buffer.append("Quantity : ").append(quantity).append("; \n");
        return buffer.toString();
    }
}
