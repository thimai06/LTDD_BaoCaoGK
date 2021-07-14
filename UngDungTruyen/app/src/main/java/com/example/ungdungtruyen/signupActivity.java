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
    ArrayList<User> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtDnh = findViewById(R.id.dnh);
        txtGmaildky =findViewById(R.id.gmail);
        txtPassdky =findViewById(R.id.pass);
        txtconfimPass = findViewById(R.id.pass1);

        arrayList = new ArrayList<>();
        btndky =findViewById(R.id.btndky);
        btndky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                String pass= txtPassdky.getText().toString().trim();
                String confimpass = txtconfimPass.getText().toString().trim();
                if(pass.equals(confimpass)){
                    txtPass = txtPassdky.getText().toString().trim();
                    txtMail=txtGmaildky.getText().toString();
                    User user=new User(txtMail,txtPass);
                    arrayList.add(user);

                    Toast.makeText(getApplicationContext(),"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new  Intent(signupActivity.this, MainActivity.class);
                    intent.putExtra("gmail",arrayList.get(arrayList.size()-1).getEmail());
                    intent.putExtra("password",arrayList.get(arrayList.size()-1).getPassword());
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
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