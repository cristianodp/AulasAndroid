package br.dinizdev.exerciciokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById(R.id.btn_enviar)

        btn.setOnClickListener {
            exibirMensagem()
        }

    }

    fun exibirMensagem(){

        var editText = findViewById(R.id.editText) as EditText;
        var nome = editText.text;
        var msg =  resources.getString(R.string.msg)+" "+nome;

        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();


    }
}
