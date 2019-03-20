package com.example.masroufi;

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

public class masroufadapter extends ArrayAdapter<masrouf> {
    private ArrayList<masrouf> arrayList;
    private Context ctx;
    private int item;

    public masroufadapter(Context context, int ressource, ArrayList<masrouf> arrayList) {
        super(context, ressource, arrayList);
        this.arrayList = arrayList;
        this.ctx = context;
        this.item = ressource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(ctx).inflate(item, parent, false);
        TextView date = convertView.findViewById(R.id.date);
        TextView thing = convertView.findViewById(R.id.truc);
        TextView som = convertView.findViewById(R.id.argent);

        date.setText(arrayList.get(position).getDate());
        thing.setText(arrayList.get(position).getThing());
        som.setText(Integer.toString(arrayList.get(position).getCost()));
        return  convertView;
    }

}
