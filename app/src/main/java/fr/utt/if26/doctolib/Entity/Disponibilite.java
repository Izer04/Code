package fr.utt.if26.doctolib.Entity;

import java.io.Serializable;


public class Disponibilite implements Serializable {

    private Integer id;
    private Integer idMedecin;
    private String jour;
    private String heure_debut;
    private String heure_fin;
    private Boolean reserve;

    public Disponibilite() {
    }

    public Disponibilite(String jour, String heure_debut, String heure_fin, Boolean reserve, Integer idMedecin) {
        this.jour = jour;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
        this.reserve = reserve;
        this.idMedecin = idMedecin;
    }

    public Disponibilite(String jour, String heure_debut, String heure_fin) {
        this.jour = jour;
        this.heure_debut = heure_debut;
        this.heure_fin = heure_fin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure_debut() {
        return heure_debut;
    }

    public void setHeure_debut(String heure_debut) {
        this.heure_debut = heure_debut;
    }
    public String getHeure_fin() {
        return heure_fin;
    }

    public void setHeure_fin(String heure_fin) {
        this.heure_fin = heure_fin;
    }

    public Boolean getReserve() {
        return reserve;
    }

    public void setReserve(Boolean reserve) {
        this.reserve = reserve;
    }

    public Integer getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(Integer idMedecin) {
        this.idMedecin = idMedecin;
    }
}
