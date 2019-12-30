package com.example.doancuoiki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doancuoiki.Class.LichSu;
import com.example.doancuoiki.R;

import java.util.ArrayList;
import java.util.List;

public class LichSuAdapter extends ArrayAdapter<LichSu> {
    Context context;
    int layout;
    ArrayList<LichSu> arrayList;


    public LichSuAdapter(@NonNull Context context, int resource, @NonNull ArrayList<LichSu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.layout=resource;
        this.arrayList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);
        TextView txtID= (TextView)convertView.findViewById(R.id.textViewID);
        TextView txtTen= (TextView)convertView.findViewById(R.id.textViewTen);
        TextView txtDiem= (TextView)convertView.findViewById(R.id.textViewDiem);

        /*txtID.setText(arrayList.get(position).getId());
        txtTen.setText(arrayList.get(position).getName());
        txtDiem.setText(arrayList.get(position).getDiem());*/
        txtID.setText("0");
        txtTen.setText("1");
        txtDiem.setText("1000");
        return  convertView;
    }
}
