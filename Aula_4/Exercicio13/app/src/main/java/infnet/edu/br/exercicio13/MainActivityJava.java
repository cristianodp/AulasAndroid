package infnet.edu.br.exercicio13;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivityJava extends AppCompatActivity{

    ProgressBar ç;
    TextView contador;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = (TextView) findViewById(R.id.contador);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ProgressAsyncTask task = new ProgressAsyncTask();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB){
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }else {
            task.execute();
        }
    }

    class ProgressAsyncTask extends AsyncTask<Void, Integer, Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0;i<=100; i++){
                final  Integer value = i;
                try{
                    Thread.sleep(100);
                    publishProgress(value);
                }catch (InterruptedException e){
                    publishProgress(value);
                }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            contador.setText(values[0].toString());
            progressBar.setProgress(values[0]);

            super.onProgressUpdate(values);
        }
    }
}
