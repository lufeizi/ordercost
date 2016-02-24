package com.example.jcs.orderassistant.ui;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    List<String> items;
    Context context;

    public MyAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(
                com.example.jcs.orderassistant.R.layout.list_item_layout, null);
        TextView tv = (TextView) view.findViewById(com.example.jcs.orderassistant.R.id.tv);
        tv.setText(items.get(position));
        return view;
    }

}