package br.edu.decision.exercicio14.utils.conexao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by crist on 07/10/2017.
 */

public class NetworkState {

    public static boolean isNetworkAvailable(Object systemService){
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
