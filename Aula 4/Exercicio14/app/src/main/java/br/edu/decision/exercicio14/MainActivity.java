package br.edu.decision.exercicio14;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.decision.exercicio14.adapters.TarefasAdapter;
import br.edu.decision.exercicio14.model.Tarefa;
import br.edu.decision.exercicio14.utils.conexao.JSONParser;
import br.edu.decision.exercicio14.utils.conexao.NetworkState;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Tarefa> tarefas;
    private TarefasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        tarefas = new ArrayList<Tarefa>();
        adapter = new TarefasAdapter(this, android.R.id.text1, this.tarefas);
        listView.setAdapter(adapter);

        TarefasTask task = new TarefasTask();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
        else{
            task.execute();
        }
    }

    public void showError(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void addItem(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    private void updateList(){
        this.adapter.notifyDataSetChanged();
    }

    class TarefasTask extends AsyncTask<Void, Void, JSONObject>{
        private String url = "";
        private JSONParser jsonParser = new JSONParser();

        public TarefasTask(){
            this.url = getResources().getString(R.string.url);
        }

        @Override
        protected void onPreExecute(){
            if(!NetworkState.isNetworkAvailable(getSystemService(Context.CONNECTIVITY_SERVICE))){
                showError(getResources().getString(R.string.erro));
            }
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            try {
                JSONObject json = jsonParser.makeHttpRequest(url, "GET", params);
                return json;
            } catch(Exception e){
                showError(getResources().getString(R.string.erro_http));
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject response){
            JSONArray jsonArray;

            if(response != null){
                try {
                    jsonArray = response.getJSONArray("tarefa");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject json = jsonArray.getJSONObject(i);

                        Tarefa tarefa = new Tarefa();
                        tarefa.setId(Integer.parseInt(json.getString("id")));
                        tarefa.setDescricao(json.getString("descricao"));
                        tarefa.setImagem(json.getString("imagem"));

                        addItem(tarefa);
                    }
                    updateList();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
