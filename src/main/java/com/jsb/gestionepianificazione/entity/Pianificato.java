package com.jsb.gestionepianificazione.entity;

import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.*;

@Entity
@ToString
@NamedQuery(name = PIANIFICATO_FIND_BY_ID_PROGETTO, query = "Select p from Pianificato p where p.progetto.id =:idProgetto")
@NamedQuery(name = PIANIFICATO_FIND_BY_ID_DIPENDENTE, query = "Select p from Pianificato p where p.dipendente.id =:idDipendente")
@NamedQuery(name = PIANIFICATO_FIND_BY_FK, query = "Select p from Pianificato p where p.progetto.id =:idProgetto and p.dipendente.id =:idDipendente and p.flagProgrammato =:flagProgrammato")
@Table(uniqueConstraints= @UniqueConstraint(
        name=DIP_AND_PROG,
        columnNames={DIPENDENTE_ID, PROGETTO_ID, FLAG_PROGRAMMATO} )
)
public class Pianificato {
    private Long id;
    private Double gennaio;
    private Double febbraio;
    private Double marzo;
    private Double aprile;
    private Double maggio;
    private Double giugno;
    private Double luglio;
    private Double agosto;
    private Double settembre;
    private Double ottobre;
    private Double novembre;
    private Double dicembre;
    private Boolean flagProgrammato;

    private Dipendente dipendente;

    private Progetto progetto;

    @Column(length = 2000)
    private String note;

    @OneToOne(targetEntity = Progetto.class)
    public Progetto getProgetto() {
        return progetto;
    }

    public void setProgetto(Progetto progetto) {
        this.progetto = progetto;
    }

    @OneToOne(targetEntity = Dipendente.class)
    public Dipendente getDipendente() {
        return dipendente;
    }

    public void setDipendente(Dipendente dipendente) {
        this.dipendente = dipendente;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGennaio() {
        return gennaio;
    }

    public void setGennaio(Double gennaio) {
        this.gennaio = gennaio;
    }

    public Double getFebbraio() {
        return febbraio;
    }

    public void setFebbraio(Double febbraio) {
        this.febbraio = febbraio;
    }

    public Double getMarzo() {
        return marzo;
    }

    public void setMarzo(Double marzo) {
        this.marzo = marzo;
    }

    public Double getAprile() {
        return aprile;
    }

    public void setAprile(Double aprile) {
        this.aprile = aprile;
    }

    public Double getMaggio() {
        return maggio;
    }

    public void setMaggio(Double maggio) {
        this.maggio = maggio;
    }

    public Double getGiugno() {
        return giugno;
    }

    public void setGiugno(Double giugno) {
        this.giugno = giugno;
    }

    public Double getLuglio() {
        return luglio;
    }

    public void setLuglio(Double luglio) {
        this.luglio = luglio;
    }

    public Double getAgosto() {
        return agosto;
    }

    public void setAgosto(Double agosto) {
        this.agosto = agosto;
    }

    public Double getSettembre() {
        return settembre;
    }

    public void setSettembre(Double settembre) {
        this.settembre = settembre;
    }

    public Double getOttobre() {
        return ottobre;
    }

    public void setOttobre(Double ottobre) {
        this.ottobre = ottobre;
    }

    public Double getNovembre() {
        return novembre;
    }

    public void setNovembre(Double novembre) {
        this.novembre = novembre;
    }

    public Double getDicembre() {
        return dicembre;
    }

    public void setDicembre(Double dicembre) {
        this.dicembre = dicembre;
    }

    public Boolean getFlagProgrammato() {
        return flagProgrammato;
    }

    public void setFlagProgrammato(Boolean flagProgrammato) {
        this.flagProgrammato = flagProgrammato;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pianificato that = (Pianificato) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
