package fr.utt.if26.doctolib.Medecin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import fr.utt.if26.doctolib.Connexion;
import fr.utt.if26.doctolib.Entity.Medecin;
import fr.utt.if26.doctolib.R;
import fr.utt.if26.doctolib.Utils.Encryption;

public class MedecinAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medecin_add);
        final PersistanceMedecin persistance= new PersistanceMedecin(this);


        //Mise en place du spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.specialiteMedecine,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        Spinner specialiteChoice = (Spinner) findViewById(R.id.activity_medecin_specialite);
        specialiteChoice.setAdapter(adapter);


        //Insertion

        final Button bt=findViewById(R.id.activity_medecin_button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= ((EditText)findViewById(R.id.activity_medecin_ed_email)).getText().toString();
                String mdp= ((EditText)findViewById(R.id.activity_medecin_ed_password)).getText().toString();
                String nom= ((EditText)findViewById(R.id.activity_medecin_ed_nom)).getText().toString();
                String prenom= ((EditText)findViewById(R.id.activity_medecin_ed_prenom)).getText().toString();
                String telephone= ((EditText)findViewById(R.id.activity_medecin_ed_telephone)).getText().toString();
                String adresse= ((EditText)findViewById(R.id.activity_medecin_ed_adresse)).getText().toString();
                String specialite=  ((Spinner) findViewById(R.id.activity_medecin_specialite)).getSelectedItem().toString();

                String encPassword="";
                try {
                     encPassword = Encryption.encrypt(email,mdp);
                    System.out.println("Encrypté: "+encPassword);

                    System.out.println("Decrypté:  "+Encryption.decrypt(email, encPassword));
                }catch (Exception e){
                    e.printStackTrace();
                }

                //Medecin medecin = new Medecin(0, email,mdp,"medecin",nom, prenom,telephone, adresse, specialite);
                Medecin medecin = new Medecin(0, email,encPassword,"medecin",nom, prenom,telephone, adresse, specialite);
                persistance.add(medecin);
                makeToast();
                launchConnexion();
                ((EditText)findViewById(R.id.activity_medecin_ed_email)).setText("");
                ((EditText)findViewById(R.id.activity_medecin_ed_password)).setText("");
                ((EditText)findViewById(R.id.activity_medecin_ed_nom)).setText("");
                ((EditText)findViewById(R.id.activity_medecin_ed_prenom)).setText("");
                ((EditText)findViewById(R.id.activity_medecin_ed_telephone)).setText("");
                ((EditText)findViewById(R.id.activity_medecin_ed_adresse)).setText("");

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
