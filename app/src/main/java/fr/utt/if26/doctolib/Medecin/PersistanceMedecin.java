package fr.utt.if26.doctolib.Medecin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


import fr.utt.if26.doctolib.Entity.Medecin;
import fr.utt.if26.doctolib.Persistance;
import fr.utt.if26.doctolib.PersistanceInterface;

public class PersistanceMedecin extends Persistance implements PersistanceInterface<Medecin> {

    public PersistanceMedecin(Context context) {
        super(context);
    }

    @Override
    public void add(Medecin entity) {
        ContentValues values= new ContentValues();
        //values.put(Persistance.ATTRIBUT_ID,0);
        values.put(Persistance.ATTRIBUT_EMAIL, entity.getEmail());
        values.put(Persistance.ATTRIBUT_MDP, entity.getMdp());
        values.put(Persistance.ATTRIBUT_PROFIL, "medecin");
        values.put(Persistance.ATTRIBUT_NOM,entity.getNom());
        values.put(Persistance.ATTRIBUT_PRENOM,entity.getPrenom());
        values.put(Persistance.ATTRIBUT_TELEPHONE,entity.getTelephone());
        values.put(Persistance.ATTRIBUT_ADRESSE,entity.getAdresse() );
        values.put(Persistance.ATTRIBUT_SPECIALITE,entity.getSpecialite());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Persistance.TABLE_MEDECIN, null, values);
        db.close();
    }

    @Override
    public void update(Medecin entity) {

    }

    @Override
    public Medecin get(int key) {
        return null;
    }

    @Override
    public Medecin get(String email, String mdp, String profil) {
        Medecin medecin;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM medecin WHERE email= ? AND mdp= ? AND profil= ? ", new String[]{email, mdp, profil});
        if (cursor != null && cursor.moveToFirst()){
            medecin = new Medecin(Integer.getInteger(cursor.getString(0)),cursor.getString(1), cursor.getString(2), cursor.getString(3));
            cursor.close();
        }else{
            medecin = null;
        }
        return medecin;
    }

    @Override
    public void delete(Medecin entity) {

    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public ArrayList<Medecin> getAll() {
        return null;
    }

    @Override
    public void initData() {

    }
}
