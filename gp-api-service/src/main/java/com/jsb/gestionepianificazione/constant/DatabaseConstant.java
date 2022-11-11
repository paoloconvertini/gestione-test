package com.jsb.gestionepianificazione.constant;

public class DatabaseConstant {
    public final static String ID_PROGETTO = "idProgetto";
    public final static String PROGETTO_ID = "progetto_id";
    public final static String ID_DIPENDENTE = "idDipendente";
    public final static String DIPENDENTE_ID = "dipendente_id";
    public final static String PIANIFICATO_FIND_BY_FK = "Pianificato.findByFK";
    public final static String PIANIFICATO_FIND_BY_ID_PROGETTO = "Pianificato.findByIdProgetto";

    public final static String PIANIFICATO_FIND_BY_ID_DIPENDENTE = "Pianificato.findByIdDipendente";
    public final static String FLAG_PROGRAMMATO = "flagProgrammato";
    public final static String DIPENDENTE_FIND_ALL = "Dipendente.findAll";
    public final static String PROGETTO_FIND_ALL = "Progetto.findAll";

    public final static String DIP_AND_PROG = "dipAndprog";
    public final static String RIEPILOGO = "Pianificato.riepilogo";

    public final static String RIEPILOGO_QUERY = "select CONCAT(D.nome, ' ', D.cognome) as dipendente,\n" +
            "       SUM(p.gennaio) as gennaio,\n" +
            "       SUM(p.febbraio) as febbraio,\n" +
            "       SUM(p.marzo) as marzo,\n" +
            "       SUM(p.aprile) as aprile,\n" +
            "       SUM(p.maggio) as maggio,\n" +
            "       SUM(p.giugno) as giugno,\n" +
            "       SUM(p.luglio) as luglio,\n" +
            "       SUM(p.agosto) as agosto,\n" +
            "       SUM(p.settembre) as settembre,\n" +
            "       SUM(p.ottobre) as ottobre,\n" +
            "       SUM(p.novembre) as novembre,\n" +
            "       SUM(p.dicembre) as dicembre, p.flagProgrammato,\n" +
            "      GROUP_CONCAT(distinct P2.nome ORDER BY P2.nome ASC SEPARATOR ', ') as progetti,\n" +
            "      ( SUM(p.gennaio) + SUM(p.febbraio) + SUM(p.marzo) + SUM(p.aprile) +\n" +
            "        SUM(p.maggio) + SUM(p.giugno) + SUM(p.luglio) + SUM(p.agosto) +\n" +
            "        SUM(p.settembre) + SUM(p.ottobre) + SUM(p.novembre) + SUM(p.dicembre) ) as pianificato\n" +
            "from Pianificato p\n" +
            "join Dipendente D on p.dipendente_id = D.id\n" +
            "join Progetto P2 on p.progetto_id = P2.id\n" +
            "where p.flagProgrammato = true\n" +
            "group by p.dipendente_id, p.flagProgrammato";



}
