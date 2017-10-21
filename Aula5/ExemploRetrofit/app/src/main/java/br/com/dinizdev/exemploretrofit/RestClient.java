package br.com.dinizdev.exemploretrofit;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.dinizdev.exemploretrofit.interfaces.PacoteService;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by eafdecision3 on 21/10/17.
 */

public class RestClient {

    private static  final String BASE_URL = "http://infnet.000webhostapp.com";
    private static PacoteService pacoteService;

    public static PacoteService getInstance(){

        if (pacoteService == null){
            Gson gson = new GsonBuilder().create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();



            pacoteService = retrofit.create(PacoteService.class);

        }

        return  pacoteService;
    }

}
