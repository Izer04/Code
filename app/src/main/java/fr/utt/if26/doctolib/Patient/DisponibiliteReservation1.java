package fr.utt.if26.doctolib.Patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import fr.utt.if26.doctolib.MainActivity;
import fr.utt.if26.doctolib.adaptateur.ReservationAdapter;
import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.Medecin.PersistanceDisponibilite;
import fr.utt.if26.doctolib.R;

public class DisponibiliteReservation1 extends AppCompatActivity {

    PersistanceDisponibilite persistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilite_reservation1);


        //Mise en place du spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.specialiteMedecine,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
        Spinner specialiteChoice = (Spinner) findViewById(R.id.reservation_spinner);
        specialiteChoice.setAdapter(adapter);


        persistance= new PersistanceDisponibilite(this);
        ArrayList<Disponibilite> listDisponibilite;
        if(persistance.getAll()==null){
            listDisponibilite= null;
        }else{
            listDisponibilite= persistance.getAll();
        }

        final ReservationAdapter adapt = new ReservationAdapter(listDisponibilite,this );
        ListView lv= findViewById(R.id.list_reservation);
        lv.setAdapter(adapt);


        final Button rechercher= findViewById(R.id.reservation_rechercher);
        rechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String specialite=  ((Spinner) findViewById(R.id.reservation_spinner)).getSelectedItem().toString();
                specialite=specialite.toLowerCase();
                System.out.println(specialite);
                ArrayList<Disponibilite> disponibilites= persistance.getAllDocteurSpecialite(specialite);
                adapt.setmData(disponibilites);
                System.out.println(disponibilites.toString());
                ListView lv= findViewById(R.id.list_reservation);
                lv.setAdapter(adapt);
            }
        });


        //Validation
        final ListView listView=(ListView) findViewById(R.id.list_reservation);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox= findViewById(R.id.reservation_lv_reserve);

                    System.out.println(position);

            }
        });
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CheckBox checkBox= findViewById(R.id.reservation_lv_reserve);
                if (checkBox.isSelected()){
                    System.out.println(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
                reserver();
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
    private  void reserver(){
        Intent intent= new Intent(this, DisponibiliteReservation1.class);
        startActivity(intent);
    }
}
