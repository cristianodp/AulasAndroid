package br.edu.decision.exercicio10.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.decision.exercicio10.Models.Estado;
import br.edu.decision.exercicio10.R;

/**
 * Created by crist on 30/09/2017.
 */

public class EstadosAdapter extends ArrayAdapter<Estado> {
    private LayoutInflater inflater;
    private ArrayList<Estado> estados;
    private Context context;

    public EstadosAdapter(Context context, int textView, ArrayList<Estado> data){
        super(context, textView);
        this.estados = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return estados.size();
    }

    @Override
    public Estado getItem(int i) {
        return estados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = ((Activity)this.context).getLayoutInflater();
        View itemView = inflater.inflate(R.layout.item_estado, viewGroup, false);

        Estado estado = estados.get(i);

        TextView textEstado = (TextView) itemView.findViewById(R.id.estado);
        TextView textCapital = (TextView) itemView.findViewById(R.id.capital);
        TextView textArea = (TextView) itemView.findViewById(R.id.area);
        ImageView imgBandeira = (ImageView) itemView.findViewById(R.id.bandeira);

        textEstado.setText(estado.getNome() + " - " + estado.getUf());
        textCapital.setText(estado.getCapital());
        textArea.setText(String.valueOf(estado.getArea()));
        imgBandeira.setImageResource(estado.getBandeira());

        return itemView;
    }
}
