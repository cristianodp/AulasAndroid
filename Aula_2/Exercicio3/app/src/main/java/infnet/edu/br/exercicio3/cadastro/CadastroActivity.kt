package infnet.edu.br.exercicio3.cadastro

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import infnet.edu.br.exercicio3.R

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val btCad = findViewById<Button>(R.id.btCadastrar)
        btCad.setOnClickListener {

            val usr = Usuario()

            usr.nome = findViewById<EditText>(R.id.editNome).text.toString()
            usr.email = findViewById<EditText>(R.id.editEmail).text.toString()
            usr.telefone = findViewById<EditText>(R.id.editFone).text.toString()
            usr.idade = findViewById<EditText>(R.id.editIdade).text.toString().toInt()

            var i = Intent(this,DetalhesUsuarioActivity::class.java)
            i.putExtra("usr",usr )
            startActivity(i);
            
        }


    }



}
