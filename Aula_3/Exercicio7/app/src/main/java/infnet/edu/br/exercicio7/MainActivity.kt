package infnet.edu.br.exercicio7

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    var planetList =  ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val array = listOf("Mercúrio","Vênus","Terra","Marte","Júpiter","Saturno","Urano","Netuno")

        planetList.addAll(array.toList())

        listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,planetList)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.manu2,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){
            R.id.mn_add -> addPlaneta()
            R.id.mn_delete -> deletPlaneja()

        }

        return super.onOptionsItemSelected(item)
    }

    private fun addPlaneta() {
        planetList.add("Novo1")
        (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }

    private fun deletPlaneja() {
        planetList.removeAt(0)
        (listView.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }




}
