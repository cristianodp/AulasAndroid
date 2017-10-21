package br.edu.decision.exercicio10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.edu.decision.exercicio10.Adapters.EstadosAdapter;
import br.edu.decision.exercicio10.Models.Estado;

public class MainActivity extends AppCompatActivity {
    ArrayList<Estado> estados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.lista_estados);

        estados = new ArrayList<Estado>();
        estados.add(new Estado("Acre", "AC", "Rio Branco", R.drawable.acre, 23858927));
        estados.add(new Estado("Alagoas", "AL", "Maceió", R.drawable.alagoas, 23858927));
        estados.add(new Estado("Amapá", "AP", "Macapá", R.drawable.amapa, 23858927));
        estados.add(new Estado("Amazonas", "AM", "Manaus", R.drawable.amazonas, 23858927));
        estados.add(new Estado("Bahia", "BA", "Salvador", R.drawable.bahia, 23858927));
        estados.add(new Estado("Ceará", "CE", "Fortaleza", R.drawable.ceara, 23858927));

        EstadosAdapter adapter = new EstadosAdapter(this, android.R.id.text1, estados);
        listView.setAdapter(adapter);
    }
}
