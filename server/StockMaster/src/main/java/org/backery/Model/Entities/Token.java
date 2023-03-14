package org.backery.Model.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
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

    @Column(name = "issuedat")
    private Date issuedat;

    @Column(name = "expiredat")
    private Date expiredat;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private User idUser;


    public Token() {

    }

}