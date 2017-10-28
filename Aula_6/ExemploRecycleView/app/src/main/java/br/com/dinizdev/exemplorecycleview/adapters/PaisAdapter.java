package br.com.dinizdev.exemplorecycleview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.dinizdev.exemplorecycleview.Model.Pais;
import br.com.dinizdev.exemplorecycleview.R;

/**
 * Created by eafdecision3 on 28/10/17.
 */

public class PaisAdapter extends RecyclerView.Adapter<PaisViewHolder> {

    private List<Pais> paises;
    private Context context;

    public PaisAdapter(Context context,List<Pais> paises){
        this.paises = paises;
        this.context = context;
    }

    @Override
    public PaisViewHolder onCreateViewHolder(ViewGroup parent, int itemView) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
        PaisViewHolder paisViewHolder = new PaisViewHolder(context,view);

        return paisViewHolder;
    }

    @Override
    public void onBindViewHolder(PaisViewHolder holder, int position) {
        Pais pais = paises.get(position);
        holder.textViewNome.setText(pais.getNome());
        holder.imageViewBandeira.setImageResource(pais.getBandeira());
        holder.imageViewCartaoPostal.setImageResource(pais.getCartaoPostal());
    }

    @Override
    public int getItemCount() {
        return paises.size();
    }
}


