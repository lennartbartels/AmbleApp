package com.example.bartelsl.photowalk;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by meyernic on 09.10.2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    Context context;
    String[] names;
    int[] images;

    public CustomAdapter(@NonNull Context context, String[] names, int[] images) {
        super(context, R.layout.spinner_item, names);
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, null);
        TextView t1 = (TextView)row.findViewById(R.id.textView);
        ImageView i1 = (ImageView)row.findViewById(R.id.imageView);

        t1.setText(names[position]);
        i1.setImageResource(images[position]);

        return row;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_item, null);
        TextView t1 = (TextView)row.findViewById(R.id.textView);
        ImageView i1 = (ImageView)row.findViewById(R.id.imageView);

        t1.setText(names[position]);
        i1.setImageResource(images[position]);

        return row;
    }
}


