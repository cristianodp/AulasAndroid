package br.dinizdev.exercicio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var btn = findViewById(R.id.button);

        btn.setOnClickListener {
            val intent = Intent(this,FormularioActivity::class.java)
            startActivity(intent)
        }

    }
}
