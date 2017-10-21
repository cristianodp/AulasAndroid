package br.com.dinizdev.exemploretrofit.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.dinizdev.exemploretrofit.R;
import br.com.dinizdev.exemploretrofit.models.Pacote;

/**
 * Created by eafdecision3 on 21/10/17.
 */

public class AdapterPacote extends BaseAdapter {

    private Activity activity;
    private List<Pacote> lista;


    public AdapterPacote(Activity activity, List<Pacote> lista) {
        this.activity = activity;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        view = activity.getLayoutInflater().inflate(R.layout.pacote_item,null);

        viewHolder = new ViewHolder(view);
      /*  if(view == null){
            view = activity.getLayoutInflater().inflate(R.layout.pacote_item,null);

            viewHolder = new ViewHolder(view);

            view.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) view.getTag();

        }
*/
        Pacote pacote = lista.get(i);

        viewHolder.textViewTitulo.setText(pacote.getTitulo());
        viewHolder.textViewNome.setText(pacote.getNome());
        viewHolder.textViewPerco.setText(String.valueOf(pacote.getPreco()));
        viewHolder.textViewDiaria.setText(String.valueOf(pacote.getNumDiarias()));

        Picasso.with(activity).load(pacote.getImagem()).into(viewHolder.imageView);



        return view;
    }

    public class ViewHolder {

        protected ImageView imageView;
        protected TextView textViewTitulo;
        protected TextView textViewNome;
        protected TextView textViewPerco;
        protected TextView textViewDiaria;

        public ViewHolder(View v){


            imageView = v.findViewById(R.id.imageView);
            textViewTitulo = v.findViewById(R.id.textViewTitulo);
            textViewNome = v.findViewById(R.id.textViewNome);
            textViewPerco = v.findViewById(R.id.textViewPerco);
            textViewDiaria = v.findViewById(R.id.textViewDiaria);



        }

    }


}
