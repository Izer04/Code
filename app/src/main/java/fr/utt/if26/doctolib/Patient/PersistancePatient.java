package fr.utt.if26.doctolib.Patient;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


import fr.utt.if26.doctolib.Entity.Patient;
import fr.utt.if26.doctolib.Persistance;
import fr.utt.if26.doctolib.PersistanceInterface;

public class PersistancePatient extends Persistance implements PersistanceInterface<Patient> {

    public PersistancePatient(Context context) {
        super(context);
    }

    @Override
    public void add(Patient entity) {
        ContentValues values= new ContentValues();
        values.put(Persistance.ATTRIBUT_NUMSS,entity.getNumSS() );
        values.put(Persistance.ATTRIBUT_EMAIL, entity.getEmail());
        values.put(Persistance.ATTRIBUT_MDP, entity.getMdp());
        values.put(Persistance.ATTRIBUT_PROFIL, "patient");
        values.put(Persistance.ATTRIBUT_NOM,entity.getNom());
        values.put(Persistance.ATTRIBUT_PRENOM,entity.getPrenom() );
        values.put(Persistance.ATTRIBUT_TELEPHONE,entity.getTelephone() );
        values.put(Persistance.ATTRIBUT_ADRESSE,entity.getAdresse() );
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Persistance.TABLE_PATIENT, null, values);
        db.close();
    }

    @Override
    public void update(Patient entity) {

    }

    @Override
    public Patient get(int key) {
        return null;
    }

    @Override
    public Patient get(String email, String mdp, String profil) {

        Patient patient;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM patient WHERE email= ? AND mdp= ? AND profil= ? ", new String[]{email, mdp, profil});
        if (cursor != null && cursor.moveToFirst() ){
            patient = new Patient(cursor.getString(0),cursor.getString(1), cursor.getString(2), cursor.getString(3));
            System.out.println(patient.toString());
            cursor.close();
        }else{
            patient = null;
        }
        return patient;
    }


    @Override
    public void delete(Patient entity) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public ArrayList<Patient> getAll() {
        return null;
    }

    @Override
    public void initData() {

    }
}
