package com.example.doancuoiki.Object;

import java.util.ArrayList;
import java.util.Random;

//Dùng để hiển thị câu hỏi
public class FaceData {

    public CauHoi taoCauHoi(int capDo) {
        Random r = new Random();
        int so1 = r.nextInt(100);
        int so2 = r.nextInt(100);
        int tong = so1 + so2;
        String noiDungCauHoi =  "Câu hỏi " + capDo + ": "+so1 + " + " + so2 + " = ?" ;
        CauHoi cauHoi = new CauHoi();
        cauHoi.setNoiDung(noiDungCauHoi);
        cauHoi.setDapAnDung("" + tong);
        ArrayList<String> arrDapAnSai = new ArrayList<>();
        do {
            int tongFace = r.nextInt(200);
            if (tongFace != tong) {
                arrDapAnSai.add(""+tongFace);
            }
        }
            while (arrDapAnSai.size() != 3) ;
            cauHoi.setArrDapAnSai(arrDapAnSai);
            return cauHoi;
    }
}
