package fr.utt.if26.doctolib;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public  class Persistance extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "doctolib.db"; // nom du fichier pour la base


    // Table Compte
    public static final String TABLE_COMPTE = "compte";
    public static final String TABLE_MEDECIN = "medecin";
    public static final String TABLE_PATIENT = "patient";
    public static final String TABLE_DISPONIBILITE = "disponibilite";

    public static final String ATTRIBUT_ID = "id";
    public static final String ATTRIBUT_SPECIALITE = "specialite";

    // Table Patient


    public static final String ATTRIBUT_NUMSS = "num_ss";
    public static final String ATTRIBUT_EMAIL = "email";
    public static final String ATTRIBUT_MDP = "mdp";
    public static final String ATTRIBUT_PROFIL= "profil";
    public static final String ATTRIBUT_NOM = "nom";
    public static final String ATTRIBUT_PRENOM = "prenom";
    public static final String ATTRIBUT_ADRESSE = "adresse";
    public static final String ATTRIBUT_TELEPHONE = "telephone";

    //Table disponibilite
    public static final String ATTRIBUT_JOUR = "jour";
    public static final String ATTRIBUT_HEURE_DEBUT = "heure_debut";
    public static final String ATTRIBUT_HEURE_FIN = "heure_fin";
    public static final String ATTRIBUT_RESERVE = "reserve";

  /*  static  final String TABLE_COMPTE_CREATE =
            "CREATE TABLE " + TABLE_COMPTE + "( " +
                    ATTRIBUT_ID +" INTEGER primary key AUTOINCREMENT, "+
                    ATTRIBUT_EMAIL +" TEXT not null,"+
                    ATTRIBUT_MDP + " TEXT not null,"+
                    ATTRIBUT_PROFIL + " TEXT not null" +
                    ")";

    */
    static final String TABLE_PATIENT_CREATE =
            "CREATE TABLE " + TABLE_PATIENT + "( " +
                    ATTRIBUT_NUMSS + " INTEGER PRIMARY KEY," +
                    ATTRIBUT_EMAIL + " TEXT NOT NULL,"+
                    ATTRIBUT_MDP + " TEXT NOT NULL,"+
                    ATTRIBUT_PROFIL + " TEXT NOT NULL,"+
                    ATTRIBUT_NOM + " TEXT NOT NULL," +
                    ATTRIBUT_PRENOM + " TEXT NOT NULL," +
                    ATTRIBUT_TELEPHONE +" TEXT NOT NULL,"+
                    ATTRIBUT_ADRESSE + " TEXT NOT NULL" +
                    ")";


    static  final String TABLE_MEDECIN_CREATE =
            "CREATE TABLE " + TABLE_MEDECIN + "( " +
                    ATTRIBUT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ATTRIBUT_EMAIL + " TEXT NOT NULL,"+
                    ATTRIBUT_MDP + " TEXT NOT NULL,"+
                    ATTRIBUT_PROFIL + " TEXT NOT NULL,"+
                    ATTRIBUT_NOM + " TEXT NOT NULL," +
                    ATTRIBUT_PRENOM + " TEXT NOT NULL," +
                    ATTRIBUT_TELEPHONE +" TEXT NOT NULL,"+
                    ATTRIBUT_ADRESSE + " TEXT NOT NULL," +
                    ATTRIBUT_SPECIALITE+" TEXT NOT NULL" +
                    ")";

     static  final String TABLE_DISPONIBILITE_CREATE =
            "CREATE TABLE " + TABLE_DISPONIBILITE + "( " +
                    ATTRIBUT_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                    ATTRIBUT_JOUR +" DATE NOT NULL,"+
                    ATTRIBUT_HEURE_DEBUT + " TEXT NOT NULL,"+
                    ATTRIBUT_HEURE_FIN + " TEXT NOT NULL," +
                    ATTRIBUT_RESERVE + " BOOLEAN NOT NULL," +
                    "id_medecin INTEGER NOT NULL," +
                    " FOREIGN KEY(id_medecin) REFERENCES medecin(id)" +
                    ")";



    public Persistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
      //  db.execSQL(TABLE_COMPTE_CREATE);
        db.execSQL(TABLE_PATIENT_CREATE);
        db.execSQL(TABLE_MEDECIN_CREATE);
        db.execSQL(TABLE_DISPONIBILITE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         Log.w(Persistance.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PATIENT);
        onCreate(db);
    }

}
