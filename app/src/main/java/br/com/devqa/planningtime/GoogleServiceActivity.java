package br.com.devqa.planningtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import br.com.devqa.planningtime.service.GoogleService;

public class GoogleServiceActivity extends AppCompatActivity {

    private EditText txtOrigem;
    private EditText txtDestino;

    private ProgressBar pgbBuscaEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_service);
    }

    public void buscarDistancia(View view) {
        txtOrigem = (EditText) findViewById(R.id.txtOrigem);
        txtDestino = (EditText) findViewById(R.id.txtDestino);

        String origem = txtOrigem.getText().toString();
        String destino = txtDestino.getText().toString();

        pgbBuscaEndereco = (ProgressBar) findViewById(R.id.pgbDuracao);
        pgbBuscaEndereco.setVisibility(View.VISIBLE);
        acessarGoogleService(origem, destino);
    }

    private void acessarGoogleService(final String origem, final String destino) {
        new Thread() {
            @Override
            public void run() {
                try {
                    preencherDistancia(GoogleService.obterJson(origem, destino));
                } catch (IOException e) {
                    preencherDistancia(null);
                }
            }
        }.start();
    }

    private void preencherDistancia(final String retorno) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pgbBuscaEndereco.setVisibility(View.INVISIBLE);
                if (retorno == null) {
                    Toast.makeText(GoogleServiceActivity.this, "Erro ao acessar o serviço!", Toast.LENGTH_SHORT).show();
                } else {
                    EditText txtDuracao = (EditText) findViewById(R.id.txtDuracao);
                    Log.d("FALHA", retorno);
                    String duracao = null;
                    try {
                        duracao = new JSONObject(retorno)
                                .getJSONArray("rows")
                                .getJSONObject(0)
                                .getJSONArray("elements")
                                .getJSONObject(0)
                                .getJSONObject("duration")
                                .get("text")
                                .toString();
                        txtDuracao.setText(duracao);
                    } catch (JSONException e) {
                        Toast.makeText(GoogleServiceActivity.this, "Erro ao busca a informação!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
