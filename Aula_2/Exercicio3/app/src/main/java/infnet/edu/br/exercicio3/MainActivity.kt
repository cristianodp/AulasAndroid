package infnet.edu.br.exercicio3

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import infnet.edu.br.exercicio3.cadastro.CadastroActivity
import infnet.edu.br.exercicio3.cadastro.DetalhesUsuarioActivity
import infnet.edu.br.exercicio3.contar.ContarActivity

class MainActivity : AppCompatActivity() {

    var contar = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btContar = findViewById<Button>(R.id.btContar)

        btContar.setOnClickListener {

            val intent = Intent(this, ContarActivity::class.java)
            startActivity(intent)

        }

        var btCad = findViewById<Button>(R.id.btCadastro)
        btCad.setOnClickListener {

            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)

        }
    }



}
