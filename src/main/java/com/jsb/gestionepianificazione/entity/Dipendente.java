package com.jsb.gestionepianificazione.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.DIPENDENTE_FIND_ALL;

@Entity
@ToString
@Getter @Setter
@NamedQuery(name = DIPENDENTE_FIND_ALL, query = "Select d from Dipendente d ORDER BY d.cognome, d.nome")
public class Dipendente {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500)
    private String nome;

    @Column(length = 500)
    private String cognome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Dipendente that = (Dipendente) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
