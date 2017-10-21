package br.com.dinizdev.exemploretrofit.interfaces;

import java.util.List;

import br.com.dinizdev.exemploretrofit.models.Pacote;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by eafdecision3 on 21/10/17.
 */

public interface PacoteService {

    @GET("/ofertas_busca.php")
    Call<List<Pacote>> getPacotes(@Query("q") String q, @Query("numprods") int qtdPacotes);


    @GET("/ofertas_busca.php")
    void getPacotes(@Query("q") String q, @Query("numprods") int qtdPacotes, Callback<Call<List<Pacote>>> callback);







}
