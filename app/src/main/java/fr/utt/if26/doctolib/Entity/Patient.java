package fr.utt.if26.doctolib.Entity;

import java.io.Serializable;

public class Patient implements Serializable {
    private String numSS;
    private String email;
    private String mdp;
    private String profil;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    public Patient() {
    }

    public Patient(String numSS, String email, String mdp, String profil) {
        this.numSS = numSS;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
    }

    public Patient(String numSS, String nom, String prenom, String adresse, String telephone) {
        this.numSS = numSS;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Patient(String numSS, String email, String mdp, String profil, String nom, String prenom, String telephone, String adresse) {
        this.numSS = numSS;
        this.email = email;
        this.mdp = mdp;
        this.profil = profil;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresse = adresse;
    }

    public String getNumSS() {
        return numSS;
    }

    public void setNumSS(String numSS) {
        this.numSS = numSS;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        return "Patient{" +
                "numSS=" + numSS +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
