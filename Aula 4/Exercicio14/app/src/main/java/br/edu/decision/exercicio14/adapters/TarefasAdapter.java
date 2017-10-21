package br.edu.decision.exercicio14.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.edu.decision.exercicio14.R;
import br.edu.decision.exercicio14.model.Tarefa;

/**
 * Created by crist on 07/10/2017.
 */

public class TarefasAdapter extends ArrayAdapter<Tarefa> {
    ArrayList<Tarefa> data;
    private Context context;
    private Tarefa itemdata;

    public TarefasAdapter(Context context, int textViewResourceId, ArrayList<Tarefa> data){
        super(context, textViewResourceId);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount(){
        return data.size();
    }

    @Override
    public long getItemId(int i){
        return data.get(i).getId();
    }

    @Override
    public View getView(int position, View item, ViewGroup parent){
        View row = item;
        TextView textTitulo;
        TextView textDescricao;

        if(item == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(R.layout.item_list, parent, false);
        }

        textTitulo = (TextView) row.findViewById(R.id.titulo);
        textDescricao = (TextView) row.findViewById(R.id.descricao);

        itemdata = this.data.get(position);
        textTitulo.setText("Tarefa " + String.valueOf(itemdata.getId()));
        textDescricao.setText(itemdata.getDescricao());

        return row;
    }
}
