package com.example.polokomohotsi.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class FruitAdapter extends ArrayAdapter {
    private List list = new ArrayList();

    public FruitAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(FruitClass object) {
        list.add(object);
        super.add(object);
    }

    static class img_holder {
        ImageView IMG;
        TextView NAME;
        TextView QTY;
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row;
        row = convertView;
        img_holder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new img_holder();
            holder.IMG = row.findViewById(R.id.fruit_img);
            holder.NAME = row.findViewById(R.id.fruitName);
            holder.QTY = row.findViewById(R.id.fruit_qty);
            row.setTag(holder);
          //  return row;
        } else {
            holder = (img_holder) row.getTag();

        }
        FruitClass FR = (FruitClass) getItem(position);
        holder.IMG.setImageResource(FR.getFruit_resource());
        holder.NAME.setText(FR.getFruit_name());
        holder.QTY.setText(FR.getFruit_qty());

        return row;
    }
}


