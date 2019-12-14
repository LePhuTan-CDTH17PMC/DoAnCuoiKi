package com.example.doancuoiki;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Random;

public class KhanGia_TraLoi extends Dialog {
    TextView txvCauA,txvCauB,txvCauC,txvCauD;
    public KhanGia_TraLoi(@NonNull Context context, int vt_Dung) {
        super(context);
        setContentView(R.layout.dialog_tro_giup_khan_gia);
        txvCauA=findViewById(R.id.txvKhanGiaA);
        txvCauB=findViewById(R.id.txvKhanGiaB);
        txvCauC=findViewById(R.id.txvKhanGiaC);
        txvCauD=findViewById(R.id.txvKhanGiaD);
        int arr[]= new int[]{0,0,0,0};
        int max=25;
        for (int i=0;i<arr.length;i++){
            arr[i]=arr[i]+max;
            if(i==vt_Dung-1){
                arr[1]=arr[i]+25;
            }
            max=max+25;

        }
        arr[vt_Dung]= arr[vt_Dung]+25;
        int tong=125;
        int arrPhanTram[]= new int[]{0,0,0,0};
        int soKhanGia=200;
        Random r= new Random();
        for (int i=0;i<soKhanGia;i++) {
            int chon = r.nextInt(tong);
            if (chon >= 0 && chon < arr[0]) {
                arrPhanTram[0]++;
            } else if (chon >= arr[0] && chon < arr[1]) {
                arrPhanTram[1]++;
            } else if (chon >= arr[1] && chon < arr[2]) {
                arrPhanTram[2]++;
            } else {
                arrPhanTram[3]++;
            }
        }

            txvCauA.setText("A : " + (int) arrPhanTram[0] * 100.0f / soKhanGia + " %");
            txvCauB.setText("B : " + (int) arrPhanTram[1] * 100.0f / soKhanGia + " %");
            txvCauC.setText("C : " + (int) arrPhanTram[2] * 100.0f / soKhanGia + " %");
            txvCauD.setText("D : " + (int) arrPhanTram[3] * 100.0f / soKhanGia + " %");
    }
}
