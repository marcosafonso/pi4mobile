package com.example.marcos.vgo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marcos on 01/06/17.
 */

public interface VgoRotaService {

    @GET("{id}")
    Call<Rota> getRota(@Path("id") int idLocal);
}
