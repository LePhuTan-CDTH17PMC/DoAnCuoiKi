package com.example.doancuoiki;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText tk;
    private EditText mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onBackPressed() {
        showDialog();
    }

    public void Dangnhap(View view){

        tk= findViewById(R.id.edtTendangnhap);
        mk = findViewById(R.id.edtMatKhau);
        String TK = tk.getText().toString();
        String MK = mk.getText().toString();
        if (TK.equals("admin") && MK.equals("admin"))
        {
            Intent intent = new Intent(this, Man_hinh_chinh.class);
            intent.putExtra("TenTK", TK);
            startActivity(intent);
        }
        else if (TK.equals("")) {
            Toast.makeText(this,"Tên tài khoản không được để trống",Toast.LENGTH_SHORT).show();
        }
        else if (MK.equals("")) {
            Toast.makeText(this,"Mật khẩu không được để trống",Toast.LENGTH_SHORT).show();
        }
        else if (!(TK.equals("admin")) && !(MK.equals("admin"))){
            Toast.makeText(this,"Tên tài khoản và mật khẩu không đúng",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Tên tài khoản và mật khẩu không đúng",Toast.LENGTH_SHORT).show();
        }
    }
    public void QuenMatKhau(View view){
        Intent intent= new Intent(MainActivity.this,Quen_mat_khau.class);
        startActivity(intent);
    }

    //Hiển thị hộp thoại đăng xuất
    public void showDialog(){
        AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle("Bạn có muốn thoát không?");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this,"Không thoát",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog= dialog.create();
        alertDialog.show();
    }
    public void dangki(View view){
        Intent intent= new Intent(MainActivity.this,Dang_Ky.class);
        startActivity(intent);
    }

}
