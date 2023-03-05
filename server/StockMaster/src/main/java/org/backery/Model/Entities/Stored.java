package org.backery.Model.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.backery.Model.Entities.Product;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "stored")
public class Stored {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    private Product idProduct;

    @Column(name = "available")
    private Integer available;

    @Column(name = "updated")
    private LocalDate updated;

    public Stored() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public Stored(Integer id, String name, Product idProduct, Integer available, LocalDate updated) {
        this.id = id;
        this.name = name;
        this.idProduct = idProduct;
        this.available = available;
        this.updated = updated;
    }
}