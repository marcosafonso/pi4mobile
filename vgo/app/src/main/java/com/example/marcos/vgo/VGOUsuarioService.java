package com.example.marcos.vgo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by marcos on 03/06/17.
 */

public interface VGOUsuarioService {
    @GET("{user}/{pwd}")
    Call<Usuario> getUsuario(@Path("user") String idUsuario,
                             @Path("pwd") String idSenha);
}
