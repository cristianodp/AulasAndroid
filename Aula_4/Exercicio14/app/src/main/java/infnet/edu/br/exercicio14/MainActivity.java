package infnet.edu.br.exercicio14;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import infnet.edu.br.exercicio14.Utils.conexao.JSONParser;
import infnet.edu.br.exercicio14.Utils.conexao.NetworkState;
import infnet.edu.br.exercicio14.Utils.conexao.TarefaAdapter;

public class MainActivity extends AppCompatActivity {

    List<Tarefa> tarefas = new ArrayList<Tarefa>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lista);
        TarefasTask task = new TarefasTask(this);


        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            task.execute();
        }

    }


    class TarefasTask extends AsyncTask<Void,Void,JSONObject>{

        private String url = "";
        private Context context;
        private JSONParser jsonParserv = new JSONParser();

        public TarefasTask(Context context){
            this.context = context;
            this.url = getResources().getString(R.string.url);
        }

        @Override
        protected void onPreExecute() {
            if(!NetworkState.isNetworkAvilable(getSystemService(Context.CONNECTIVITY_SERVICE))){
                Toast.makeText(context,"Voce nao possui conexao",Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected JSONObject doInBackground(Void... voids) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            try {
                JSONObject json = new JSONParser().makeHttpRequest(url, "GET", params);

                return  json;
            }catch (Exception e){

                Toast.makeText(context,"Error ao executar conexao http",Toast.LENGTH_LONG).show();

            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {


            JSONArray jsonArray;
            if (jsonObject != null){
                try {
                    jsonArray = jsonObject.getJSONArray("tarefa");

                    for (int i = 0;i < jsonArray.length();i++){
                        JSONObject json  = jsonArray.getJSONObject(i);
                        int id = json.getInt("id");
                        String desc = json.getString("descricao");
                        String img = json.getString("imagem");
                        tarefas.add(new Tarefa(id,desc,img));
                    }

                    carregaLista();



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void carregaLista() {


        TarefaAdapter adapter = new TarefaAdapter(tarefas,this);

        listView.setAdapter(adapter);




    }
}
