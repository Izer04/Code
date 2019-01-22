package fr.utt.if26.doctolib.Medecin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.MainActivity;
import fr.utt.if26.doctolib.R;
import fr.utt.if26.doctolib.adaptateur.AdaptateurDisponibilite;

public class DisponibiliteListe extends AppCompatActivity {

    private Integer idMedecin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilite_liste);
        final PersistanceDisponibilite persistance= new PersistanceDisponibilite(this);

        Bundle extras = getIntent().getExtras();
        idMedecin=  extras.getInt("idMedecin");

        ArrayList<Disponibilite> listDisponibilite= persistance.getAllDocteur(idMedecin);

        AdaptateurDisponibilite adaptateur = new AdaptateurDisponibilite(this, R.layout.disponibilite,listDisponibilite );

        ListView lv= findViewById(R.id.disponibilite_liste_lv);
        lv.setAdapter(adaptateur);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_medecin, menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_medecin_declarer :
                launchDisponibiliteAdd();
                return true;
            case R.id.menu_medecin_consulter :
                launchDisponibilite();
                return true;
            case R.id.menu_medecin_deconnexion :
                deconnexion();
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }

    private void launchDisponibilite(){
        Intent intent= new Intent(this, DisponibiliteListe.class);
        intent.putExtra("idMedecin",idMedecin);
        startActivity(intent);
    }

    private void launchDisponibiliteAdd(){
        Intent intent= new Intent(this, DisponibiliteAdd.class);
        intent.putExtra("idMedecin",idMedecin);
        startActivity(intent);
    }

    private  void deconnexion(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
