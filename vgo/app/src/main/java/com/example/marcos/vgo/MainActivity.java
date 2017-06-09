package com.example.marcos.vgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class MainActivity extends AppCompatActivity {

    private EditText edtIdUsuario;
    private Button btnEnviar;
    private TextView resultado;
    private Retrofit retrofit;
    private Retrofit retrofitRota;
    private ImageView mapa;

    private List<String> locais = new ArrayList<String>();
    private String local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = (TextView) findViewById(R.id.resultado);
        mapa = (ImageView) findViewById(R.id.imageView1);

        //controle giratorio
        final Spinner spinner = (Spinner) findViewById(R.id.locais_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locais_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //button para pegar valor spinner e enviar pro json
        Button ok = (Button) findViewById(R.id.btnOk);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //String item = spinner.getSelectedItem().toString();
                int item = spinner.getSelectedItemPosition();
                Toast.makeText(getApplicationContext(), "Item escolhido: "+item, Toast.LENGTH_SHORT).show();
                solicitarRota(item);

                if (item ==1) {
                    mapa.setImageResource(R.drawable.local1);
                }
                else if(item ==2 ){
                    mapa.setImageResource(R.drawable.local2);
                }
                else if(item==3){
                    mapa.setImageResource(R.drawable.local3);
                }
            }
        });

//        btnEnviar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                solicitarUsuario();
//            }
//        });

        retrofit = new Retrofit.Builder()
                .baseUrl("http://heaven.edgar.systems/api/usuarios/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitRota = new Retrofit.Builder()
                .baseUrl("http://heaven.edgar.systems/api/rotas/listar/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    //solicitar Rota
    private void solicitarRota(int idLocal) {

        VgoRotaService service = retrofitRota.create(VgoRotaService.class);

        Call<Rota> call = service.getRota(idLocal);

        call.enqueue(new Callback<Rota>() {
            @Override
            public void onResponse(Call<Rota> call, Response<Rota> response) {
                if (response.isSuccessful()) {
                    Rota rota = response.body();

                    String strRota = "Nome: " + rota.getNome() + "\n" +
                            "Descrição Rota: " + rota.getDescricao();

                    resultado.setText(strRota);
                }
            }

            //            @Override
            public void onFailure(Call<Rota> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Falha na requisição", Toast.LENGTH_SHORT).show();
            }
        });
        //
    }

}

