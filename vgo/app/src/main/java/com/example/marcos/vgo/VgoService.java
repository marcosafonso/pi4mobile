package com.example.marcos.vgo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by marcos on 31/05/17.
 */

public interface VgoService {

    @GET("{id}")
    Call<Usuario> getUsuario(@Path("id") String idUsuario);
}
