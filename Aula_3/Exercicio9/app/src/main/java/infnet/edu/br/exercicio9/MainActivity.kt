package infnet.edu.br.exercicio9

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import infnet.edu.br.exercicio9.Models.Contato
import infnet.edu.br.exercicio9.Models.Estado
import infnet.edu.br.exercicio9.adapters.AdapterUF
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var estados = ArrayList<Estado>()

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         estados.add(Estado("Rio Grande Do Sul","RS","Porto Alegre",R.drawable.rs,0))
         estados.add(Estado("Santa Cataria","SC","Floripa",R.drawable.sc,0))
         estados.add(Estado("Parana","PR","Curitiba",R.drawable.pr,0))

         lista_estados.adapter = AdapterUF(this,1,estados)

         lista_estados.setOnItemClickListener { adapterView, view, i, l ->

            var uf = estados.get(i)

         // var i = Intent( this ,ContatoActivity::class.java)
          //  i.putExtra("ct",c)
           // startActivity(i)
        }


    }
}
