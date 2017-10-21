package br.com.dinizdev.exemploretrofit;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import br.com.dinizdev.exemploretrofit.adapters.AdapterPacote;
import br.com.dinizdev.exemploretrofit.models.Pacote;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);
        /*
        PacoteTask task = new PacoteTask();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }else {

            task.execute();
        }
        */



    }

    @Override
    protected void onResume() {

        Call<List<Pacote>>  call = RestClient.getInstance().getPacotes2("Paris", 20);

        call.enqueue(new Callback<List<Pacote>>() {
            public void onResponse(Call<List<Pacote>> call, Response<List<Pacote>> response) {
                List<Pacote> lista = response.body();


                AdapterPacote adapter = new AdapterPacote(MainActivity.this,lista);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Pacote>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro ao fazer requisicao",Toast.LENGTH_LONG).show();
            }
        });




        super.onResume();
    }

    class PacoteTask extends AsyncTask<Void, Void, List<Pacote>>
    {
        @Override
        protected List<Pacote> doInBackground(Void... voids) {
            Call<List<Pacote>> lista = RestClient.getInstance().getPacotes("Paris",20);

            try {
                return lista.execute().body();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Pacote> pacotes) {

            AdapterPacote adapter = new AdapterPacote(MainActivity.this,pacotes);
            listView.setAdapter(adapter);

        }
    }
}
