package org.backery.Model.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "output")
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "updated")
    private LocalDate updated;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_stored")
    private Stored idStored;

    @OneToMany(mappedBy = "idOutput")
    private Set<Userxproccess> userxproccesses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idOutput")
    private Set<Detail> details = new LinkedHashSet<>();

    public Output(Integer id, String name, LocalDate updated, Integer amount) {
        this.id = id;
        this.name = name;
        this.updated = updated;
        this.amount = amount;
    }
}