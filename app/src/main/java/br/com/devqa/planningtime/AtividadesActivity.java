package br.com.devqa.planningtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.devqa.planningtime.dao.AtividadeDAO;
import br.com.devqa.planningtime.model.Atividade;

public class TarefasActivity extends Activity implements AdapterView.OnItemClickListener {

    private List<String> conteudo = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefas);
        setTitle("Minhas atividades");
        obterAtividades(getIntent().getStringExtra("idUsuario"));
    }

    private void obterAtividades(String idUsuario) {
        AtividadeDAO dao = new AtividadeDAO(this);
        List<Atividade> list = dao.listar(idUsuario);
        for (Atividade atv : list) {
            String descricao = atv.getNome() + "                   " + "Duração: " + atv.getDuracao() + " minutos";
            conteudo.add(descricao);
        }
        inserirAdapter();
    }

    private void inserirAdapter() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, conteudo);
        ListView list = (ListView) findViewById(R.id.lstTarefa);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("idTarefa" ,2);
        intent.setClass(TarefasActivity.this, FormularioAtividadeActivity.class);
        startActivity(intent);
    }
}
