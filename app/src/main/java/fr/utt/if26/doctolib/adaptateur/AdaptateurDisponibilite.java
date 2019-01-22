package fr.utt.if26.doctolib.adaptateur;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.ArrayList;
import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.R;


public class AdaptateurDisponibilite extends ArrayAdapter<Disponibilite> {
    ArrayList<Disponibilite> disponibilites ;
    Context contexte;
    int ressource;

    public AdaptateurDisponibilite(Context context, int resource, ArrayList<Disponibilite>data) {
        super(context, resource, data);
        this.disponibilites=data;
        this.contexte=context;
        this.ressource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) contexte).getLayoutInflater();
        View v = inflater.inflate(ressource, parent, false);

        Disponibilite disponibilite = disponibilites.get(position);

        TextView tv_jour = (TextView) v.findViewById(R.id.disponibilite_lv_jour);
        tv_jour.setText(disponibilite.getJour());

        TextView tv_heureD = (TextView) v.findViewById(R.id.disponibilite_lv_heureDebut);
        tv_heureD.setText(disponibilite.getHeure_debut());

        TextView tv_heureF = (TextView) v.findViewById(R.id.disponibilite_lv_heureFin);
        tv_heureF.setText(disponibilite.getHeure_fin());

        CheckBox tv_reserve = (CheckBox) v.findViewById(R.id.disponibilite_lv_reserve);
         tv_reserve.setSelected(disponibilite.getReserve());
        return v;
    }
}
