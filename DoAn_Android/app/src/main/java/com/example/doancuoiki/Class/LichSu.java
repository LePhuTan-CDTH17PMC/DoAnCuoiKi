package com.example.doancuoiki.Class;

import java.lang.ref.SoftReference;

public class LichSu {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }
    private int id;
    private int name;
    private String diem;
    public LichSu(int id, int name, String Diem){
        this.id = id;
        this.name= name;
        this.diem=Diem;
    }
}
