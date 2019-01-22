package fr.utt.if26.doctolib.Patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.utt.if26.doctolib.Connexion;
import fr.utt.if26.doctolib.Entity.Patient;
import fr.utt.if26.doctolib.R;
import fr.utt.if26.doctolib.Utils.Encryption;

public class PatientAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_add);
         final PersistancePatient persistance= new PersistancePatient(this);

        final Button bt=findViewById(R.id.activity_patient_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= ((EditText)findViewById(R.id.activity_patient_ed_email)).getText().toString();
                String mdp= ((EditText)findViewById(R.id.activity_patient_ed_password)).getText().toString();
                String numSS= ((EditText)findViewById(R.id.activity_patient_ed_numss)).getText().toString();
                String nom= ((EditText)findViewById(R.id.activity_patient_ed_nom)).getText().toString();
                String prenom= ((EditText)findViewById(R.id.activity_patient_ed_prenom)).getText().toString();
                String telephone= ((EditText)findViewById(R.id.activity_patient_ed_telephone)).getText().toString();
                String adresse= ((EditText)findViewById(R.id.activity_patient_ed_adresse)).getText().toString();

                String encPassword="";
                try {
                    encPassword = Encryption.encrypt(email,mdp);
                    System.out.println("Encrypté: "+encPassword);

                    System.out.println("Decrypté:  "+Encryption.decrypt(email, encPassword));
                }catch (Exception e){
                    e.printStackTrace();
                }

                Patient patient = new Patient(numSS, email,encPassword,"patient",nom, prenom,telephone, adresse);
                //Patient patient = new Patient(numSS, email,mdp,"patient",nom, prenom,telephone, adresse);
                persistance.add(patient);
                makeToast();
                launchConnexion();
                ((EditText)findViewById(R.id.activity_patient_ed_email)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_password)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_numss)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_nom)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_prenom)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_telephone)).setText("");
                ((EditText)findViewById(R.id.activity_patient_ed_adresse)).setText("");
            }
        });
    }

    private void makeToast() {
        Toast.makeText(this, " Compte crée avec succès", Toast.LENGTH_LONG).show();
    }

    private void launchConnexion() {
        Intent intent= new Intent(this, Connexion.class);
        startActivity(intent);
    }
}
