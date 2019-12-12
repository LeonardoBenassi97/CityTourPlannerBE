package com.JourneyPlanner.JourneyPlannerBE.model.Entities;


import javax.persistence.*;

@Entity
@Table(name = "indirizzi")
public class Indirizzi
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_indirizzo")
    private Long id;

//    @OneToOne(mappedBy = "indirizzo")
//    private Mete meta;

    @Column(name="indirizzo")
    private String indirizzo;

    @Column(name="cap")
    private String cap;

    @Column(name="citta")
    private String citta;

    @Column(name="provincia")
    private String provincia;

    @Column(name="stato")
    private String stato;

    public Long getId() {
        return id;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCap() {
        return cap;
    }

    public String getCitta() {
        return citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getStato() {
        return stato;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

//    public Mete getMeta() {
//        return meta;
//    }
//
//    public void setMeta(Mete meta) {
//        this.meta = meta;
//    }
}
