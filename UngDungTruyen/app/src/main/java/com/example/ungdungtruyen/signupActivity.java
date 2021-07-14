package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class signupActivity extends AppCompatActivity {

    private EditText txtPassdky,txtGmaildky,txtconfimPass;
    private TextView txtDnh;
    private Button btndky;
    String txtPass,txtMail;

    private final int SIGNUPSUCCESS =0;
    private final int GMAIL_EXISTS =1;
    private final int WRONG_CONFIRM_PASSWORDS =2;

    private int checkSignUp(String gmail,String passwords,String confirmpasswords){
        if(!passwords.equals(confirmpasswords)){
            return WRONG_CONFIRM_PASSWORDS;
        }
        for (User user:MainActivity.listUsers) {
            if(user.getEmail().equals(gmail)){
                return GMAIL_EXISTS;
            }
        }
        return SIGNUPSUCCESS;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtDnh = findViewById(R.id.dnh);
        txtGmaildky =findViewById(R.id.gmail);
        txtPassdky =findViewById(R.id.pass);
        txtconfimPass = findViewById(R.id.pass1);


        btndky =findViewById(R.id.btndky);
        btndky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String pass= txtPassdky.getText().toString().trim();
                String confimpass = txtconfimPass.getText().toString().trim();
                String gmail=txtGmaildky.getText().toString();
                int resultSignUp= checkSignUp(gmail,pass,confimpass);
                if(resultSignUp == SIGNUPSUCCESS){
                    Toast.makeText(getApplicationContext(),"Đăng ky thành công",Toast.LENGTH_SHORT).show();
                    MainActivity.listUsers.add(new User(pass,gmail));
                    Intent intent = new Intent(signupActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else if(resultSignUp == GMAIL_EXISTS){
                    Toast.makeText(getApplicationContext(),"Tài khoản đã tồn tại",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Xác nhận mật khẩu không đúng",Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtDnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signupActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}