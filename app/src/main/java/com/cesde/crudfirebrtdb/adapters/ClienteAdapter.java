package com.cesde.crudfirebrtdb.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cesde.crudfirebrtdb.R;
import com.cesde.crudfirebrtdb.models.ClienteModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ClienteAdapter extends BaseAdapter {

    private ArrayList<ClienteModel> list;
    private ClienteModel model;
    private Context context;

    public ClienteAdapter(ArrayList<ClienteModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemcito = view;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemcito = inflater.inflate(R.layout.item_cliente, viewGroup, false);
        }

        TextView tv_item_cliente_nombre = itemcito.findViewById(R.id.tv_item_cliente_nombre);
        TextView tv_item_cliente_valor = itemcito.findViewById(R.id.tv_item_cliente_valor);

        model = list.get(i);

        tv_item_cliente_nombre.setText(model.get_nombre());
        tv_item_cliente_valor.setText(model.get_valor());

        return itemcito;

    }
}
