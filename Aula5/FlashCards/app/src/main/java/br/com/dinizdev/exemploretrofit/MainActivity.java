package br.com.dinizdev.exemploretrofit;

import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.io.IOException;
import java.util.List;

import br.com.dinizdev.exemploretrofit.adapters.AdapterPacote;
import br.com.dinizdev.exemploretrofit.models.Pacote;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView) findViewById(R.id.listView);

        PacoteTask task = new PacoteTask();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }else {

            task.execute();
        }

        //AdapterPacote adapterPacote = new AdapterPacote(this,lista);



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
