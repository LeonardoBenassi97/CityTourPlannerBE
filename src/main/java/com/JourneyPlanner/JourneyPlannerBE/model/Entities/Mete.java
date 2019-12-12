package com.JourneyPlanner.JourneyPlannerBE.model.Entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mete")
@NamedQuery(name = "Mete.findAll", query = "SELECT m FROM Mete m")
//@NamedQuery(name = "Mete.findById", query = "SELECT m FROM Mete m WHERE m.id = ?")
public class Mete implements Serializable
{
    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_meta")
    private String id;

    @Column(name="nome")
    private String nomeMeta;

    @Column(name="lat")
    private String latitudine;

    @Column(name="longt")
    private String longitudine;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="lastupdate")
    private Date lastUpdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "indirizzo_id", referencedColumnName = "id_indirizzo")
    private Indirizzi indirizzo;



    public String getId() {
        return id;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Indirizzi getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(Indirizzi indirizzo) {
        this.indirizzo = indirizzo;
    }
}
