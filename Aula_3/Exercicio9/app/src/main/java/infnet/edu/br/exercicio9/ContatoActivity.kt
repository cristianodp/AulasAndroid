package infnet.edu.br.exercicio9

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import infnet.edu.br.exercicio9.Models.Contato
import kotlinx.android.synthetic.main.activity_contato.*

class ContatoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)

        val ct = intent.getSerializableExtra("ct") as Contato

        tvNome.text = ct.nome
        tvFone.text = ct.telefone
        tvEmail.text = ct.email


    }
}
