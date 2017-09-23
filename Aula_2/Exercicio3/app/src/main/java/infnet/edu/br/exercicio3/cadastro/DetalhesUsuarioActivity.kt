package infnet.edu.br.exercicio3.cadastro

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import infnet.edu.br.exercicio3.R

class DetalhesUsuarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_usuario)

        val usr = intent.getSerializableExtra("usr") as Usuario

        val dadosUsr = findViewById<TextView>(R.id.dadosUsr);

        dadosUsr.text = usr.toString()


    }
}
