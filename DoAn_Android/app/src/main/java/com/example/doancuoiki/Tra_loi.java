package com.example.doancuoiki;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doancuoiki.Adapter.TienthuongAdapter;
import com.example.doancuoiki.Object.CauHoi;
import com.example.doancuoiki.Object.FaceData;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class Tra_loi extends AppCompatActivity {

    private TextView textView;
    TextView txtCauHoi, txtCauTL1, txtCauTL2, txtCauTL3, txtCauTL4, txtKetThuc;
    ArrayList<TextView> arrtxvCauTraLoi;
    ListView lsvTienThuong;
    TienthuongAdapter tienthuongAdapter;
    ArrayList<String> arrayTienThuong;
    RingProgressBar progressBar;
    Handler myHandler;
    int progress = 0;
    CauHoi cauHoi;
    String cauTraLoi;
    int soCauHoi = 0;
    int vtCauHoi = 1;
    View.OnClickListener listener;
    FaceData faceData;

    ImageView Goidien;
    ImageView DoiCauHoi;
    ImageView an2DA;
    ImageView khangia;
    ImageView nguoithan1;
    ImageView nguoithan2;
    ImageView nguoithan3;
    ImageView nguoithan4;
    TextView Goiy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_loi);
        //progressBar=findViewById(R.id.progress_bar_1);
        //ringProgress();
        // Countdown();
        Goidien= findViewById(R.id.imgGoiDien);
        khangia = findViewById(R.id.imageViewKhanGia);
        an2DA = findViewById(R.id.imageView5050);
        DoiCauHoi = findViewById(R.id.imageViewDoiCauhoi);
        init();
        anhxa();
        setUp();
        setClick();
    }

    //Khai báo hàm cho progress dạng ring
    public void ringProgress() {
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {
                Toast.makeText(Tra_loi.this, "Hết thời gian", Toast.LENGTH_LONG).show();
            }
        });
        myHandler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what == 0) {
                    if (progress < 100) {
                        progress++;
                        progressBar.setProgress(progress);
                    }
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++)
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
    }
    //Hàm đếm ngược
    /*public void Countdown(){
        textView=findViewById(R.id.txtTime);
        CountDownTimer w =new CountDownTimer(10000, 1000) {
            public void onTick(long mil) {
                textView.setText( mil/1000+" s");
            }
            public void onFinish() {
                textView.setText("0 s");
            }
        }.start();
    }*/

    public void init() {
        arrayTienThuong = new ArrayList<>();
        arrayTienThuong.add("1000000");
        arrayTienThuong.add("500000");
        arrayTienThuong.add("250000");
        arrayTienThuong.add("125000");
        arrayTienThuong.add("64000");
        arrayTienThuong.add("32000");
        arrayTienThuong.add("16000");
        arrayTienThuong.add("8000");
        arrayTienThuong.add("4000");
        arrayTienThuong.add("2000");
        arrayTienThuong.add("1000");
        arrayTienThuong.add("500");
        arrayTienThuong.add("300");
        arrayTienThuong.add("200");
        arrayTienThuong.add("100");

        tienthuongAdapter = new TienthuongAdapter(this, 0, arrayTienThuong);

        cauHoi = new CauHoi();

        arrtxvCauTraLoi = new ArrayList<>();

        faceData = new FaceData();

    }

    public void anhxa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
        txtCauHoi = findViewById(R.id.txtCauHoi);
        txtCauTL1 = findViewById(R.id.textviewDA1);
        txtCauTL2 = findViewById(R.id.textviewDA2);
        txtCauTL3 = findViewById(R.id.textviewDA3);
        txtCauTL4 = findViewById(R.id.textviewDA4);
        txtKetThuc = findViewById(R.id.txtKetthuc);

        arrtxvCauTraLoi.add(txtCauTL1);
        arrtxvCauTraLoi.add(txtCauTL2);
        arrtxvCauTraLoi.add(txtCauTL3);
        arrtxvCauTraLoi.add(txtCauTL4);


    }

    public void setUp() {
        //tạm ẩn màn hình kết thúc trò chơi
        txtKetThuc.setVisibility(View.GONE);

        lsvTienThuong.setAdapter(tienthuongAdapter);

        hienthiCauHoi();

    }


    public void setClick() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCauTraLoi((TextView) v);
                txtCauTL1.setEnabled(false);
                txtCauTL2.setEnabled(false);
                txtCauTL3.setEnabled(false);
                txtCauTL4.setEnabled(false);
                Goidien.setEnabled(false);
                DoiCauHoi.setEnabled(false);
                an2DA.setEnabled(false);
                khangia.setEnabled(false);
            }
        };
        for (TextView t : arrtxvCauTraLoi) {

            t.setOnClickListener(listener);


        }
    }

    public void checkCauTraLoi(TextView txv) {
        cauTraLoi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_cau_chon);

        new CountDownTimer(1000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrtxvCauTraLoi) {
                    String s = t.getText().toString();
                    if (s.equals(cauHoi.getDapAnDung())) {
                        t.setBackgroundResource(R.drawable.bg_cau_dung);
                        break;
                    }
                }
                new CountDownTimer(1000, 100) {
                    @NonNull
                    @Override
                    protected Object clone() throws CloneNotSupportedException {
                        return super.clone();
                    }

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (cauTraLoi.equals(cauHoi.getDapAnDung())) {
                            vtCauHoi++;
                            if (vtCauHoi > 15) {
                                vtCauHoi = 15;
                                txtKetThuc.setVisibility(View.VISIBLE);
                                txtKetThuc.setText("Bạn đã chiến thắngsố tiền \n" + arrayTienThuong.get(0) + "000 VND");
                                return;
                            }
                            hienthiCauHoi();
                        } else {
                            txtKetThuc.setVisibility(View.VISIBLE);
                            int VtTienThuong = (vtCauHoi / 5) * 5;
                            txtKetThuc.setText("Bạn sẽ ra về với số tiền \n" + arrayTienThuong.get(14 - VtTienThuong) + "000 VND");
                        }

                    }
                }.start();
            }
        }.start();
    }

    //Gán câu hỏi vào class câu hỏi
    public void setCauHoi() {
        cauHoi = faceData.taoCauHoi(vtCauHoi);
    }

    //Hàm hiển thị câu hỏi ra giao diện
    public void hienthiCauHoi() {
        txtCauTL1.setEnabled(true);
        txtCauTL2.setEnabled(true);
        txtCauTL3.setEnabled(true);
        txtCauTL4.setEnabled(true);
        Goidien.setEnabled(true);
        DoiCauHoi.setEnabled(true);
        an2DA.setEnabled(true);
        khangia.setEnabled(true);
        setCauHoi();
        txtCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int vt1 = r.nextInt(arrCauTraLoi.size());
            int vt2 = r.nextInt(arrCauTraLoi.size());
            String a = arrCauTraLoi.get(vt1);
            arrCauTraLoi.set(vt1, arrCauTraLoi.get(vt2));
            arrCauTraLoi.set(vt2, a);

        }

        for (int i = 0; i < arrtxvCauTraLoi.size(); i++) {
            arrtxvCauTraLoi.get(i).setOnClickListener(listener);
            arrtxvCauTraLoi.get(i).setVisibility(View.VISIBLE);
            arrtxvCauTraLoi.get(i).setBackgroundResource(R.drawable.bg_btn);
            arrtxvCauTraLoi.get(i).setText(arrCauTraLoi.get(i));
        }

        tienthuongAdapter.setVtCauHoi(vtCauHoi);
    }

    boolean trogiup5050 = true;

    public void trogiup5050(View view) {
        if (trogiup5050 == false) {
            return;
        }
        Random r = new Random();
        int soDA_An = 2;
        int vt_DA_An;
        do {
            vt_DA_An = r.nextInt(4);
            TextView t = arrtxvCauTraLoi.get(vt_DA_An);
            if (t.getText().toString().equals(cauHoi.getDapAnDung()) == false) {
                t.setVisibility(View.INVISIBLE);
                t.setOnClickListener(null);
                soDA_An--;
            }
        }
        while (vt_DA_An<=4 &&soDA_An > 0);
        //trogiup5050 = false;

        an2DA.setVisibility(View.INVISIBLE);
    }

    //Hàm xử lý trợ giúp khán giả
    boolean troGiupKhanGia = true;

    public void TrogiupKhangia(View view) {
        if (troGiupKhanGia == false) {
            return;
        }
        for (int i = 0; i < arrtxvCauTraLoi.size(); i++) {
            TextView t = arrtxvCauTraLoi.get(i);
            if (t.getText().toString().equals(cauHoi.getDapAnDung())) {
                new KhanGia_TraLoi(this, i + 1).show();
                break;

            }
        }
        troGiupKhanGia = false;

        khangia.setVisibility(View.INVISIBLE);
    }

    boolean TrogiupDoiCauhoi = true;

    public void DoiCauHoi(View view) {
        if (TrogiupDoiCauhoi == false) {
            return;
        }
        hienthiCauHoi();
        TrogiupDoiCauhoi = false;
        DoiCauHoi.setVisibility(View.INVISIBLE);
    }


    public void GoiDien(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_goi_dien);
        dialog.show();
        Goiy = dialog.findViewById(R.id.txtGoiY);
        nguoithan1 = dialog.findViewById(R.id.help1);
        nguoithan2 = dialog.findViewById(R.id.help2);
        nguoithan3 = dialog.findViewById(R.id.help3);
        nguoithan4 = dialog.findViewById(R.id.help4);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Goiy.setText("Tôi nghĩ đáp án đúng là "+cauHoi.getDapAnDung().toString());
                nguoithan1.setVisibility(View.INVISIBLE);
                nguoithan2.setVisibility(View.INVISIBLE);
                nguoithan3.setVisibility(View.INVISIBLE);
                nguoithan4.setVisibility(View.INVISIBLE);
                Goiy.setVisibility(View.VISIBLE);
                Goidien.setVisibility(View.INVISIBLE);

            }
        };
            nguoithan1.setOnClickListener(listener);
            nguoithan2.setOnClickListener(listener);
            nguoithan3.setOnClickListener(listener);
            nguoithan4.setOnClickListener(listener);


        }


    }
