package infnet.edu.br.exercicio11;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by eafdecision3 on 07/10/17.
 */

public class MainActivityJava extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivityJava.this,LoginActivity.class );
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);

    }
}
