package infnet.edu.br.exercicio13

import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityKotlin: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val task = ProgressAsyncTask()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR)
        } else {
            task.execute()
        }
    }

    internal inner class ProgressAsyncTask : AsyncTask<Void, Int, Void>() {


        override fun doInBackground(vararg voids: Void): Void? {
            for (i in 0..100) {
                try {
                    Thread.sleep(100)
                    publishProgress(i)
                } catch (e: InterruptedException) {
                    publishProgress(i)
                }

            }

            return null
        }

        protected override fun onProgressUpdate(vararg values: Int?) {
            var i = values[0]
            contador.text = i.toString()
            progressBar.progress = i!!

            super.onProgressUpdate(*values)
        }
    }



}
