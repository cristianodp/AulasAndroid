package br.com.dinizdev.exemplorecycleview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.dinizdev.exemplorecycleview.Model.Pais;
import br.com.dinizdev.exemplorecycleview.R;

/**
 * Created by eafdecision3 on 28/10/17.
 */

public class PaisViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Context context;
    public TextView textViewNome;
    public ImageView imageViewBandeira;
    public ImageView imageViewCartaoPostal;



    public PaisViewHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;
        textViewNome = itemView.findViewById(R.id.textViewPais);
        imageViewBandeira = itemView.findViewById(R.id.imageViewBandeira);
        imageViewCartaoPostal = itemView.findViewById(R.id.imageViewCartaoPostal);
        this.itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(context,textViewNome.getText().toString(),Toast.LENGTH_SHORT).show();
    }
}
