package br.dinizdev.exercicio2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FormularioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        findViewById(R.id.btn_cadastrar).setOnClickListener {
            val intent = Intent(this,Formulario2Activity::class.java)
            startActivity(intent);

        }
    }
}
