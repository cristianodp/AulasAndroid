package infnet.edu.br.exercicio14.Utils.conexao;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.style.BackgroundColorSpan;

/**
 * Created by eafdecision3 on 07/10/17.
 */

public class NetworkState {

    public static boolean isNetworkAvilable(Object systemservice){
        ConnectivityManager connectivityManager = (ConnectivityManager) systemservice;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isConnected();

    }
}
