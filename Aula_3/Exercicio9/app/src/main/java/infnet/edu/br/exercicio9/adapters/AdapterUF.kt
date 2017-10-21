package infnet.edu.br.exercicio9.adapters

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import infnet.edu.br.exercicio9.Models.Estado
import infnet.edu.br.exercicio9.R


/**
 * Created by eafdecision3 on 30/09/17.
 */


class AdapterUF(context: Context, resource: Int, var estados: ArrayList<Estado>) :
        ArrayAdapter<Estado>(context, resource, estados) {

    private val mInflator: LayoutInflater
    /*
    constructor( context: Context, estados:ArrayList<Estado>) : this(){

    }


    */
    init {
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getItem(i: Int):Estado {
        return estados.get(i)
    }

    override fun getItemId(i: Int): Long {

        return i.toLong();
    }

    override fun getCount(): Int {

        return estados.size
    }

    override fun getView(i: Int, convertView: View?, parent: ViewGroup?): View {
        //val view: View

        val view: View = this.mInflator.inflate(R.layout.row_uf, parent, false)

        var img = view.findViewById<ImageView>(R.id.imageViewUF)
        var nome = view.findViewById<TextView>(R.id.tvNome)
        var uf = view.findViewById<TextView>(R.id.tvUF)
        var captal = view.findViewById<TextView>(R.id.tvCapital)
        var ddd = view.findViewById<TextView>(R.id.tvDDD)

        var ct = estados.get(i)

        img.setImageResource(ct.bandeira)
        nome.text = ct.nome
        uf.text = ct.uf
        captal.text = ct.capital
        //ddd.text = ct.area.toString()

        return view

    }


}
