package fr.utt.if26.doctolib.Medecin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.MainActivity;
import fr.utt.if26.doctolib.R;

public class DisponibiliteAdd extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener datePickerDialogListener;
    private EditText jour;
    private Integer idMedecin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disponibilite_add);

        // Récupération des extras
        Bundle extras = getIntent().getExtras();
        idMedecin=  extras.getInt("idMedecin");

        final PersistanceDisponibilite persistance= new PersistanceDisponibilite(this);

        jour =(EditText)findViewById(R.id.activity_disponibilite_ed_jour);
        jour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int annee=calendar.get(Calendar.YEAR);
                int mois=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        DisponibiliteAdd.this,
                        android.R.style.Theme_Holo_Light_DarkActionBar,
                        datePickerDialogListener,
                        annee,mois,day
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        datePickerDialogListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                String jour1 = dayOfMonth + "/" + month + "/" + year;
                jour.setText(jour1);
            }
        };

        // Insertion dans la base de données

        Button button=(Button)findViewById(R.id.activity_disponibilite_ajouter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jour= ((EditText)findViewById(R.id.activity_disponibilite_ed_jour)).getText().toString();
                String heureD= ((EditText)findViewById(R.id.activity_disponibilite_ed_heured)).getText().toString();
                String heureF= ((EditText)findViewById(R.id.activity_disponibilite_ed_heuref)).getText().toString();
                Disponibilite disponibilite = new Disponibilite(jour, heureD, heureF,false,idMedecin);
                persistance.add(disponibilite);
                ((EditText)findViewById(R.id.activity_disponibilite_ed_jour)).setText("");
                ((EditText)findViewById(R.id.activity_disponibilite_ed_heured)).setText("");
                ((EditText)findViewById(R.id.activity_disponibilite_ed_heuref)).setText("");
                launchDisponibilite();

            }
        });
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
                launchDisponibilite();
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
    private  void deconnexion(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
