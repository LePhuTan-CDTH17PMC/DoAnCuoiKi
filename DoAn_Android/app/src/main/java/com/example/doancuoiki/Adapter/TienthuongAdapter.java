package com.example.doancuoiki.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.doancuoiki.R;

import java.util.ArrayList;
import java.util.List;

public class TienthuongAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> arrayList;
    int vtCauHoi=1;


    public TienthuongAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context=context;
        this.arrayList= new ArrayList<>(objects);
    }
    public void  setVtCauHoi(int vt){
        this.vtCauHoi= vt;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         if (convertView ==null){
             LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(R.layout.item_tien_thuong,null);
         }
         if (arrayList.size()>0){
             int pos=15-position;
             TextView textView= convertView.findViewById(R.id.textviewTienthuong);
             if ((position)%5==0){
                 textView.setTextColor(Color.parseColor("#FFFFFF"));
             }
             else
             {
                 textView.setTextColor(Color.parseColor("#FFEB3B"));
             }
             String khoangTrang;
             if (pos/10>0){
                 khoangTrang="      ";
             }
             else
             {
                 khoangTrang="        ";
             }
             String textHienThi= pos+khoangTrang+"$ "+ arrayList.get(position);
             textView.setText(textHienThi);


             if (pos==vtCauHoi){
                 textView.setBackgroundColor(Color.parseColor("#FF8B94"));
                 textView.setTextColor(Color.parseColor("#9C27B0"));
              }
              else {
                 textView.setBackgroundColor(Color.parseColor("#FF9800"));

              }
         }
        return convertView;
    }
}
