package fr.utt.if26.doctolib.Entity;

import java.io.Serializable;

public class Medecin implements Serializable {
    private Integer id;
    private String email;
    private String mdp;
    private String profil;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private String specialite;

    public Medecin() {
    }

    public Medecin(Integer id, String nom, String prenom, String telephone, String adresse, String specialite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public Medecin(Integer id, String email, String mdp, String profil) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
    }

    public Medecin(String email, String mdp, String profil) {
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
    }

    public Medecin(Integer id, String email, String mdp, String profil, String nom, String prenom, String telephone, String adresse, String specialite) {
        this.id = id;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    @Override
    public String toString() {
        return "Medecin{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }
}
