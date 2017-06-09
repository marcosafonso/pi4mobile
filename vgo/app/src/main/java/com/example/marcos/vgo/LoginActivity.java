package com.example.marcos.vgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUser;
    private EditText edtPassword;
    private Button btLogin;
    private Retrofit retrofitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = (EditText) findViewById(R.id.editUser);
        edtPassword = (EditText) findViewById(R.id.editPassword);
        btLogin = (Button) findViewById(R.id.btnLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v){
                final String user = edtUser.getText().toString();

                final String password = edtPassword.getText().toString();

                VGOUsuarioService service = retrofitLogin.create(VGOUsuarioService.class);

                Call<Usuario> call = service.getUsuario(user, password);

                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if (response.isSuccessful()) {
                            Usuario usuario = response.body();
                            //valida Login
//                            if(usuario.getUsuario().equals(user) && usuario.getSenha().equals(password)) {
                                startSegundaActivity(v);
//                            }else
//                            {
//                                Toast.makeText(LoginActivity.this, "Login não existente!", Toast.LENGTH_SHORT).show();
//                            }
                        }
                    }
                    //            @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Falha na requisição!", Toast.LENGTH_SHORT).show();
                    }
                });


//                if(user.equals("admin") && password.equals("admin")){
//                    startSegundaActivity(v);
//                }else{
//                    Toast.makeText(LoginActivity.this, "Login não aprovado!", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        retrofitLogin = new Retrofit.Builder()
                .baseUrl("http://heaven.edgar.systems/api/usuarios/login/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    //solicitar usuario
    //metodo que inicia segunda activity
    public void startSegundaActivity(View view) {
        Intent secondActivity = new Intent(this, MainActivity.class);
        startActivity(secondActivity);
    }

    private void solicitarUsuario() {
        final String idUsuario = edtUser.getText().toString();
        final String idSenha = edtPassword.getText().toString();

        VGOUsuarioService service = retrofitLogin.create(VGOUsuarioService.class);

        Call<Usuario> call = service.getUsuario(idUsuario, idSenha);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Usuario usuario = response.body();

                    //valida Login
                    if(usuario.getUsuario().equals(idUsuario)) {
                        if (usuario.getSenha().equals(idSenha)) {

                        }
                    }
                }
            }

            //            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login não aprovado!", Toast.LENGTH_SHORT).show();
            }
        });
        //
    }//fim solicitarUsuario







}
