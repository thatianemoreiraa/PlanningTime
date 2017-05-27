package br.com.devqa.planningtime;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.devqa.planningtime.dao.AtividadeDAO;
import br.com.devqa.planningtime.model.Atividade;
import br.com.devqa.planningtime.model.Util;

public class FormularioAtividadeActivity extends Activity {

    private String nome;
    private String duracao;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_atividade);
        setTitle("Cadastro de Atividade");
        popularSpinner();
    }

    private void popularSpinner() {
        Spinner spnPrioridade = (Spinner) findViewById(R.id.spnPrioridade);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.niveis_prioridade, android.R.layout.simple_spinner_dropdown_item);
        spnPrioridade.setAdapter(adapter);
    }

    public void sair(View view) {
        finish();
    }

    public void salvar(View view) {
        if (validarCamposObrigatorios()) {
            String prioridade = ((Spinner) findViewById(R.id.spnPrioridade)).getSelectedItem().toString();
            AtividadeDAO dao = new AtividadeDAO(this);
            dao.inserirAtividade(new Atividade(nome, Integer.parseInt(duracao), prioridade, Util.stringToDate(data)));
            Toast.makeText(this, "Atividade cadastrada!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validarCamposObrigatorios() {
        nome = ((EditText) findViewById(R.id.edtNome)).getText().toString();
        duracao = ((EditText) findViewById(R.id.edtDuracao)).getText().toString();
        data = ((EditText) findViewById(R.id.edtData)).getText().toString();

        if (nome.isEmpty() || duracao.isEmpty() || data.isEmpty()) {
            Toast.makeText(this, "O preenchimento de todos os campos é obrigatório!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}