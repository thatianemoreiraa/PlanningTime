package br.com.devqa.planningtime.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Tatiane on 27/05/2017.
 */

public class AtividadesArrayAdapter extends ArrayAdapter {

    private List<String> nome;
    private List<String> duracao;
    private LayoutInflater inflater;


    public AtividadesArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
