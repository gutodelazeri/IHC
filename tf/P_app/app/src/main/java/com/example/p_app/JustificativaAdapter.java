package com.example.p_app;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class JustificativaAdapter extends ArrayAdapter<Justificativa> {

    private Context mContext;
    private int mResource;

    public JustificativaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Justificativa> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.icon);

        TextView txtWeek = convertView.findViewById(R.id.txtWeek);

        TextView txtDays = convertView.findViewById(R.id.txtDays);

        TextView txtStatus = convertView.findViewById(R.id.txtStatus);

        imageView.setImageResource(getItem(position).getIcon());

        txtWeek.setText(getItem(position).getWeek());

        txtDays.setText(getItem(position).getDays());

        txtStatus.setText(getItem(position).getStatus());

        return convertView;
    }

}
