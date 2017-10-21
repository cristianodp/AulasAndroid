package infnet.edu.br.exercicio14.Utils.conexao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import infnet.edu.br.exercicio14.R;
import infnet.edu.br.exercicio14.Tarefa;

/**
 * Created by eafdecision3 on 07/10/17.
 */

public class TarefaAdapter extends BaseAdapter {
    List<Tarefa> tarefas;
    Context context;

    public TarefaAdapter(List<Tarefa> tarefas, Context context) {
        this.tarefas = tarefas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.tarefas.size();
    }

    @Override
    public Object getItem(int i) {
        return this.tarefas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.tarefas.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_tarefa,viewGroup,false);

        TextView textViewTitulo = (TextView) v.findViewById(R.id.textViewTitulo);
        TextView textViewDescricao = (TextView) v.findViewById(R.id.textViewDescricao);

        textViewTitulo.setText(tarefas.get(i).getTarefa());
        textViewDescricao.setText(tarefas.get(i).getDescricao());


        return v;
    }
}
