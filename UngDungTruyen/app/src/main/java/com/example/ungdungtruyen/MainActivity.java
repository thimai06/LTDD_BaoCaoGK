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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = getIntent();
                String user = intent.getStringExtra("gmail").trim();
                String pass = intent.getStringExtra("password").trim();
                String txt_user = txtUsername.getText().toString().trim();
                String txt_pass = txtPassword.getText().toString().trim();

                if (txt_user.isEmpty() || txt_pass.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    if ((txt_pass.equals(pass)) && (user.equals(txt_user))) {
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent listItem = new Intent(MainActivity.this, ListViewTruyenActivity.class);
                        startActivity(listItem);
                    } else
                        Toast.makeText(getApplicationContext(), "Mật khẩu hoặc pass sai", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }
}