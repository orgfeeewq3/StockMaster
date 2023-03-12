package org.backery.Model.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "\"timestamp\"")
    private Instant timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user")
    private User idUser;


    public Token(String token, User user) {
        this.content = token;
        this.active = true;
        this.timestamp = Instant.now();
        this.idUser = user;
    }
}