package fr.utt.if26.doctolib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import fr.utt.if26.doctolib.Entity.Medecin;
import fr.utt.if26.doctolib.Entity.Patient;
import fr.utt.if26.doctolib.Medecin.DisponibiliteAdd;
import fr.utt.if26.doctolib.Medecin.MedecinAdd;
import fr.utt.if26.doctolib.Medecin.PersistanceMedecin;
import fr.utt.if26.doctolib.Patient.DisponibiliteReservation;
import fr.utt.if26.doctolib.Patient.DisponibiliteReservation1;
import fr.utt.if26.doctolib.Patient.PatientAdd;
import fr.utt.if26.doctolib.Patient.PersistancePatient;
import fr.utt.if26.doctolib.Utils.Encryption;

public class Connexion extends AppCompatActivity {

    private String profil="";
    private Integer idMedecin;
    private String idpatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        final PersistancePatient persistance1= new PersistancePatient(this);
        final PersistanceMedecin persistance2= new PersistanceMedecin(this);

        //persistance.initData();
        //Traitement du radioGroup
        final RadioGroup radioGroup= findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_patient:
                        profil="patient";
                        break;

                    case R.id.radio_medecin:
                        profil="medecin";
                        break;
                }
            }
        });

        final Button bt=findViewById(R.id.connecter);
        bt.setOnClickListener(new View.OnClickListener() {
            Patient p;
            Medecin m;
            @Override
            public void onClick(View v) {
                if(profil.equals(new String("patient"))){
                    String email= ((EditText)findViewById(R.id.ed_email)).getText().toString();
                    String mdp= ((EditText)findViewById(R.id.ed_password)).getText().toString();
                    String encMdp="";

                    try {
                        encMdp= Encryption.encrypt(email,mdp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //p = persistance1.get(email, mdp, profil);
                    p = persistance1.get(email, encMdp, profil);

                }else{
                    String email= ((EditText)findViewById(R.id.ed_email)).getText().toString();
                    String mdp= ((EditText)findViewById(R.id.ed_password)).getText().toString();
                    String encMdp="";

                    try {
                        encMdp= Encryption.encrypt(email,mdp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    m = persistance2.get(email, encMdp, profil);
                }

                if(profil.equals(new String("patient"))&& p!=null){
                    //traitement à faire pour le patient
                    idpatient = p.getNumSS();
                    makeToast1();
                    ((EditText)findViewById(R.id.ed_email)).setText("");
                    ((EditText)findViewById(R.id.ed_password)).setText("");
                    launchPatient();
                }else if(profil.equals(new String("medecin"))&& m!=null) {
                    //Traitement à faire pour le medecin
                    idMedecin=m.getId();
                    makeToast1();
                    ((EditText)findViewById(R.id.ed_email)).setText("");
                    ((EditText)findViewById(R.id.ed_password)).setText("");
                    launchMedecin();
                }else {
                    makeToast();
                }
            }
        });

        // Traitement des différentes création de compte

        final TextView register1 =(TextView)findViewById(R.id.register1);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                medecin();
            }
        });

        final TextView register2 =(TextView)findViewById(R.id.register2);
        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient();
            }
        });

    }

    private void makeToast() {
        Toast.makeText(this, " Paramètres de connexion invalides", Toast.LENGTH_LONG).show();
    }

    private void makeToast1() {
        Toast.makeText(this, " Connexion réussie " + profil, Toast.LENGTH_LONG).show();
    }
    private void launchMedecin(){
        Intent intent= new Intent(this, DisponibiliteAdd.class);
        intent.putExtra("idMedecin",idMedecin);
        startActivity(intent);
    }
    private void launchPatient(){
        Intent intent= new Intent(this, DisponibiliteReservation1.class);
        intent.putExtra("idPatient",idpatient);
        startActivity(intent);
    }

    private void patient() {
        Intent intent= new Intent(this, PatientAdd.class);
        startActivity(intent);
    }

    private void medecin() {
        Intent intent= new Intent(this, MedecinAdd.class);
        startActivity(intent);
    }
}
