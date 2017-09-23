package infnet.edu.br.exercicio4_intents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Toast
import android.content.pm.PackageManager
import android.support.annotation.NonNull
import android.support.v4.app.ActivityCompat
import android.os.Build
import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo




class MainActivity : AppCompatActivity() {
    val mContext = this

    val REQUEST = 112

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setOnClickView(R.id.btBrowser, View.OnClickListener {

            val uri = Uri.parse("https://www.google.com")
            val i = Intent(Intent.ACTION_VIEW, uri)
            startActivity(i)
        })

        setOnClickView(R.id.btContato, View.OnClickListener {

            val uri = Uri.parse("content://com.android.contacts/contacts/1")
            val i = Intent(Intent.ACTION_VIEW, uri)
            startActivity(i)
        })

        setOnClickView(R.id.btMaps , View.OnClickListener {

            val uri = Uri.parse("geo://38.899533,-77.036476")
            val i = Intent(Intent.ACTION_VIEW, uri)
            startActivity(i)

        })

        setOnClickView(R.id.btDial  , View.OnClickListener {

            val uri = Uri.parse("tel://05492026223")
            val i = Intent(Intent.ACTION_DIAL , uri)
            startActivity(i)

        })


        setOnClickView(R.id.btcall , View.OnClickListener {

            if (Build.VERSION.SDK_INT >= 23) {
                val PERMISSIONS = arrayOf(android.Manifest.permission.CALL_PHONE)
                if (!hasPermissions(mContext, *PERMISSIONS)) {
                    ActivityCompat.requestPermissions(mContext as Activity, PERMISSIONS, REQUEST)
                } else {
                    val uri = Uri.parse("tel://05492026223")
                    val i = Intent(Intent.ACTION_CALL , uri)
                    startActivity(i)
                }
            } else {
                val uri = Uri.parse("tel://05492026223")
                val i = Intent(Intent.ACTION_CALL , uri)
                startActivity(i)
            }


        })


        setOnClickView(R.id.btSendWhatsapp,View.OnClickListener {
            val pm = packageManager
            try {

                val waIntent = Intent(Intent.ACTION_SEND)
                waIntent.type = "text/plain"
                val text = "YOUR TEXT HERE"

                val info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA)
                //Check if package exists or not. If not then code
                //in catch block will be called
                waIntent.`package` = "com.whatsapp"

                waIntent.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(waIntent, "Share with"))

            } catch (e: Exception) {
                Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                        .show()
            }

        })



    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    val uri = Uri.parse("tel://05492026223")
                    val i = Intent(Intent.ACTION_CALL , uri)
                    startActivity(i)
                } else {
                    Toast.makeText(mContext, "The app was not allowed to call.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun hasPermissions(context: Context?, vararg permissions: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(context!!, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
        }
        return true
    }

}
