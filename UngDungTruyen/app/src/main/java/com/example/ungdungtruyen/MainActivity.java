package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername,txtPassword,txtCreate;
    private Button btnLogin;

    public static ArrayList<User> listUsers = new ArrayList<>();

    private final int LOGINSUCCESS =0;
    private final int WRONG_PASSWORDS =1;
    private final int GMAIL_NOT_EXISTS =2;

    private int checkLogin(String gmail,String passwords){
        for (User user:listUsers) {
            if(user.getEmail().equals(gmail)){
                if (user.getPassword().equals(passwords)){
                    return LOGINSUCCESS;
                }else{
                    return WRONG_PASSWORDS;
                }
            }
        }
        return GMAIL_NOT_EXISTS;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listUsers.add(new User("1806","thimai"));
        txtUsername = findViewById(R.id.gmail);
        txtPassword = findViewById(R.id.pass);
        txtCreate = findViewById(R.id.dky);
        btnLogin = findViewById(R.id.btnLogin);
        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent( MainActivity.this, signupActivity.class));
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gmail = txtUsername.getText().toString().trim();
                String pass = txtPassword.getText().toString().trim();

                int resultLogin = checkLogin(gmail,pass);
                if(resultLogin == LOGINSUCCESS){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,ListViewTruyenActivity.class);
                    startActivity(intent);
                    finish();
                }else if(resultLogin == WRONG_PASSWORDS){
                    Toast.makeText(getApplicationContext(),"Sai mật khẩu",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Tài khoản không tồn tại",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}