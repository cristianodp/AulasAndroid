package infnet.edu.br.exercicio4_intents

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView

/**
 * Created by eafdecision3 on 23/09/17.
 */
fun AppCompatActivity.setOnClickView(resId:Int,click: View.OnClickListener){

    var vw = this.findViewById(resId)

    vw.setOnClickListener(click)

}