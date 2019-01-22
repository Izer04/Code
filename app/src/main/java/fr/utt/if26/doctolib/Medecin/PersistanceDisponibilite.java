package fr.utt.if26.doctolib.Medecin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.Persistance;
import fr.utt.if26.doctolib.PersistanceInterface;

public class PersistanceDisponibilite extends Persistance implements PersistanceInterface<Disponibilite> {
    public PersistanceDisponibilite(Context context) {
        super(context);
    }

    @Override
    public void add(Disponibilite entity) {

        ContentValues values= new ContentValues();
        //values.put(Persistance.ATTRIBUT_ID,0);
        values.put(Persistance.ATTRIBUT_JOUR, entity.getJour());
        values.put(Persistance.ATTRIBUT_HEURE_DEBUT,entity.getHeure_debut());
        values.put(Persistance.ATTRIBUT_HEURE_FIN,entity.getHeure_fin());
        values.put(Persistance.ATTRIBUT_RESERVE,entity.getReserve());
        values.put("id_medecin",entity.getIdMedecin());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Persistance.TABLE_DISPONIBILITE, null, values);
        db.close();
    }

    @Override
    public void update(Disponibilite entity) {

    }

    @Override
    public Disponibilite get(int key) {
        return null;
    }

    @Override
    public Disponibilite get(String email, String mdp, String profil) {
        return null;
    }

    @Override
    public void delete(Disponibilite entity) {

    }

    @Override
    public int count() {
        return 0;
    }

    public ArrayList<Disponibilite> getAllDocteur(int idCompte) {

        List<Disponibilite> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM " + Persistance.TABLE_DISPONIBILITE +" WHERE id_medecin=?";
        Cursor cursor = db.rawQuery(selectQuery,new String[]{idCompte+""});

        if (cursor.moveToFirst()) {
            do {
                Disponibilite disponibilite = new Disponibilite();
                disponibilite.setJour(cursor.getString(1));
                disponibilite.setHeure_debut(cursor.getString(2));
                disponibilite.setHeure_fin(cursor.getString(3));
                disponibilite.setReserve(cursor.getInt(4)>0);
                // Adding module to list
                list.add(disponibilite);
            } while (cursor.moveToNext());
        }
        return (ArrayList<Disponibilite>) list;
    };

//Les medecin disponibles pour ce filtre

    public ArrayList<Disponibilite> getAllDocteurDisponible(String filterStr) {

        List<Disponibilite> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println("J'execute la requete");

        String selectQuery = "SELECT * FROM " + Persistance.TABLE_DISPONIBILITE +" JOIN "+ Persistance.TABLE_MEDECIN +
                " ON disponibilite.id_medecin = medecin.id WHERE medecin.specialite LIKE ? OR medecin.nom LIKE ?";

        Cursor cursor = db.rawQuery(selectQuery, new String[]{"'%" + filterStr + "%'", "'%" + filterStr + "%'"});

        if (cursor.moveToFirst()) {
            do {
                Disponibilite disponibilite = new Disponibilite();
                disponibilite.setJour(cursor.getString(1));
                disponibilite.setHeure_debut(cursor.getString(2));
                disponibilite.setHeure_fin(cursor.getString(3));
                disponibilite.setReserve(cursor.getInt(4)>0);
                // Adding module to list
                list.add(disponibilite);
            } while (cursor.moveToNext());
        }
        return (ArrayList<Disponibilite>) list;
    }


    public ArrayList<Disponibilite> getAllDocteurSpecialite(String filterStr) {

        List<Disponibilite> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT * FROM "+ Persistance.TABLE_DISPONIBILITE;

        /*String selectQuery1 = "SELECT * FROM " + Persistance.TABLE_DISPONIBILITE + " ds, "
                + Persistance.TABLE_MEDECIN +" md WHERE ds.id_medecin = md.id AND md.specialite ='"+ filterStr+"'";*/

        //Cursor cursor = db.rawQuery(selectQuery, new String[]{ "'"+filterStr+"'"});
       Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Disponibilite disponibilite = new Disponibilite();
                disponibilite.setJour(cursor.getString(1));
                disponibilite.setHeure_debut(cursor.getString(2));
                disponibilite.setHeure_fin(cursor.getString(3));
                disponibilite.setReserve(cursor.getInt(4)>0);
                // Adding module to list
                list.add(disponibilite);
            } while (cursor.moveToNext());
        }
        return (ArrayList<Disponibilite>) list;
    }


    @Override
    public ArrayList<Disponibilite> getAll() {

        List<Disponibilite> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        /*String selectQuery = "SELECT * FROM "+Persistance.TABLE_DISPONIBILITE +" JOIN "+ Persistance.TABLE_MEDECIN +
                " ON disponibilite.id_medecin = medecin.id";*/

        String selectQuery = "SELECT * FROM "+ Persistance.TABLE_DISPONIBILITE;

        /*String selectQuery = "SELECT * FROM "+Persistance.TABLE_DISPONIBILITE +" JOIN "+ Persistance.TABLE_MEDECIN +
                " ON disponibilite.id_medecin = medecin.id";
*/
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            do {
                Disponibilite disponibilite = new Disponibilite();
                disponibilite.setJour(cursor.getString(1));
                disponibilite.setHeure_debut(cursor.getString(2));
                disponibilite.setHeure_fin(cursor.getString(3));
                disponibilite.setReserve(cursor.getInt(4)>0);
                // Adding module to list
                list.add(disponibilite);
            } while (cursor.moveToNext());
        }
        return (ArrayList<Disponibilite>) list;
    }

    @Override
    public void initData() {

    }
}
