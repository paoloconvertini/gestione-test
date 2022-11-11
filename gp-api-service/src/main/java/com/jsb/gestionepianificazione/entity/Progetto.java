package com.jsb.gestionepianificazione.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.PROGETTO_FIND_ALL;

@Entity
@ToString
@Getter @Setter
@NamedQuery(name = PROGETTO_FIND_ALL, query = "Select p from Progetto p ORDER BY p.nome")
public class Progetto {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 500)
    private String nome;

    @Column(length = 2000)
    private String descrizione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Progetto progetto = (Progetto) o;
        return id != null && Objects.equals(id, progetto.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
