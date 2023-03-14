package org.backery.Model.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "input")
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "updated")
    private LocalDate updated;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_stored")
    private Stored idStored;

    @OneToMany(mappedBy = "idInput")
    private Set<Userxproccess> userxproccesses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idInput")
    private Set<Detail> details = new LinkedHashSet<>();

    public Input(Integer id, String name, Integer amount, LocalDate updated) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.updated = updated;
    }
}