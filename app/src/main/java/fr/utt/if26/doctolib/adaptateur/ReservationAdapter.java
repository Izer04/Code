package fr.utt.if26.doctolib.adaptateur;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import fr.utt.if26.doctolib.Entity.Disponibilite;
import fr.utt.if26.doctolib.Medecin.PersistanceDisponibilite;
import fr.utt.if26.doctolib.R;

public class ReservationAdapter extends BaseAdapter/* implements Filterable */{

    ArrayList<Disponibilite> mData;
    ArrayList<Disponibilite> mStringFilterList ;

    private LayoutInflater inflater;
    //ValueFilter valueFilter;
    Context contexte;
    PersistanceDisponibilite persistanceDisponibilite;

    public ReservationAdapter(ArrayList<Disponibilite> cancel_type) {
        mData=cancel_type;
        mStringFilterList = cancel_type;
    }
    public ReservationAdapter(ArrayList<Disponibilite> cancel_type, Context cont) {
        mData=cancel_type;
        mStringFilterList = cancel_type;
        contexte=cont;
    }

    public ArrayList<Disponibilite> getmData() {
        return mData;
    }

    public void setmData(ArrayList<Disponibilite> mData) {
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        View v = inflater.inflate(R.layout.reservation, parent, false);

        Disponibilite disponibilite = mData.get(position);

        TextView tv_jour = (TextView) v.findViewById(R.id.reservation_lv_jour);
        tv_jour.setText(disponibilite.getJour());

        TextView tv_heureD = (TextView) v.findViewById(R.id.reservation_lv_heureDebut);
        tv_heureD.setText(disponibilite.getHeure_debut());

        TextView tv_heureF = (TextView) v.findViewById(R.id.reservation_lv_heureFin);
        tv_heureF.setText(disponibilite.getHeure_fin());

        CheckBox tv_reserve = (CheckBox) v.findViewById(R.id.reservation_lv_reserve);
        tv_reserve.setSelected(disponibilite.getReserve());
        return v;
    }
/*

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<Disponibilite> filterList;
                persistanceDisponibilite = new PersistanceDisponibilite(contexte);
                System.out.println("//////Je suis dedans§§§§§");
                filterList = persistanceDisponibilite.getAllDocteurDisponible(constraint.toString());
                System.out.println("Je suis dedans§§§§§");
                results.count = filterList.size();
                results.values = filterList;
                System.out.println("Resulats "+results.values.toString());
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData = (ArrayList<Disponibilite>) results.values;
            notifyDataSetChanged();
        }

    }*/
}
