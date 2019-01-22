package fr.utt.if26.doctolib.Patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

import fr.utt.if26.doctolib.adaptateur.ReservationAdapter;
import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.MainActivity;
import fr.utt.if26.doctolib.Medecin.PersistanceDisponibilite;
import fr.utt.if26.doctolib.R;


public class DisponibiliteReservation extends AppCompatActivity {

    PersistanceDisponibilite persistance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilite_reservation);

        persistance= new PersistanceDisponibilite(this);
        ArrayList<Disponibilite> listDisponibilite;
        if(persistance.getAll()==null){
            listDisponibilite= null;
        }else{
            listDisponibilite= persistance.getAll();
        }

        final ReservationAdapter adapter = new ReservationAdapter(listDisponibilite,this );
        ListView lv= findViewById(R.id.list_medecin_disponible);
        lv.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.search);

        searchView.setActivated(true);
        searchView.setQueryHint("Medecin, Spécialité");
        searchView.onActionViewExpanded();
        searchView.setIconified(false);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_patient, menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_patient_reserver :
                return true;
            case R.id.menu_patient_mesreservation :
                return true;
            case R.id.menu_patient_deconnexion :
                deconnexion();
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }

    private  void deconnexion(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
