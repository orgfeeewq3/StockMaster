package org.backery.Model.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.backery.Model.Entities.Product;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "idStored")
    private Set<Input> inputs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idStored")
    private Set<Output> outputs = new LinkedHashSet<>();

    public Stored(Integer id, String name, Product idProduct, Integer available, LocalDate updated) {
        this.id = id;
        this.name = name;
        this.idProduct = idProduct;
        this.available = available;
        this.updated = updated;
    }
}