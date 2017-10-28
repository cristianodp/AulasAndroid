package br.com.dinizdev.exemplorecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import br.com.dinizdev.exemplorecycleview.Model.Pais
import br.com.dinizdev.exemplorecycleview.adapters.PaisAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter:PaisAdapter
    lateinit var paises:ArrayList<Pais>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createListaPaises();
        adapter = PaisAdapter(this,paises);

        recycleView.adapter = adapter;
        recycleView.itemAnimator = DefaultItemAnimator ()
        recycleView.layoutManager = LinearLayoutManager(this)


        //recycleView.layoutManager = ConstraintLayoutMan LayoutManager(this)
    }

    fun createListaPaises(){
        paises = ArrayList<Pais>()

        paises.add(Pais("Brasil",R.drawable.br,R.drawable.chapada))
        paises.add(Pais("Brasil",R.drawable.br,R.drawable.chapada))
        paises.add(Pais("Brasil",R.drawable.br,R.drawable.rio))
        paises.add(Pais("Canada",R.drawable.ca,R.drawable.chapada))
        paises.add(Pais("Reino Unido",R.drawable.uk,R.drawable.campos_soldado))


    }
}
