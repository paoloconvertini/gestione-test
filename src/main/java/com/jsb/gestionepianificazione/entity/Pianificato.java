package com.jsb.gestionepianificazione.entity;

import javax.persistence.*;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.setField("field-1");
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(uniqueConstraints= @UniqueConstraint(
        name="dipAndprog",
        columnNames={"dipendente_id", "progetto_id"} ))
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
    private Boolean flagPianificato;

    private Dipendente dipendente;

    private Progetto progetto;

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

    public Boolean getFlagPianificato() {
        return flagPianificato;
    }

    public void setFlagPianificato(Boolean flagPianificato) {
        this.flagPianificato = flagPianificato;
    }


}
