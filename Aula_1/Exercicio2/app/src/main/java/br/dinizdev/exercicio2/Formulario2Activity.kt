package br.dinizdev.exercicio2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Spinner

class Formulario2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario2)

        val spinner = findViewById(R.id.spinner) as Spinner

        val adapter = ArrayAdapter.createFromResource(
                this,
                R.array.bloco_array,
                android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter



    }
}
