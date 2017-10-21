package br.edu.decision.exercicio11;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private String texto = null;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        new Thread(){
                public void run(){
                    texto = getResources().getString(R.string.texto);
                    handler.post(atualizarTextView);
                }
        }.start();
    }

    private Runnable atualizarTextView = new Runnable() {
        @Override
        public void run() {
            textView.setText(texto);
        }
    };
}
