package br.com.devqa.planningtime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.devqa.planningtime.R;
import br.com.devqa.planningtime.model.Atividade;

/**
 * Created by Tatiane on 27/05/2017.
 */

public class AtividadesAdapter extends BaseAdapter {

    private List<Atividade> atividades;
    private Context context;

    public AtividadesAdapter(List<Atividade> atividades, Context context) {
        this.atividades = atividades;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.atividades.size();
    }

    @Override
    public Object getItem(int position) {
        return this.atividades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Atividade atividade = this.atividades.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.tarefa_adapter_activity, null);

        TextView txtNome = (TextView) view.findViewById(R.id.edtConteudoLista);
        txtNome.setText(atividade.getNome() + "                   " + "Duração: " + atividade.getDuracao() + " minutos");

        return view;
    }
}
