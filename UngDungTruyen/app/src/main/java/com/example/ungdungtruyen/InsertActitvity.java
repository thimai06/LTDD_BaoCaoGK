package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InsertActitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_actitvity);

        EditText name = findViewById(R.id.insertactivity_edittext_nameofbook);
        EditText author = findViewById(R.id.insertactivity_edittext_author);
        EditText category = findViewById(R.id.insertactivity_edittext_category);
        EditText shortdescription = findViewById(R.id.insertactivity_edittext_shortdescription);
        ImageView image = findViewById(R.id.insertactivity_imageview);

        Button button_save = findViewById(R.id.insertactivity_btn_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen truyen = new Truyen();
                truyen.setTen(name.getText().toString().trim());
                truyen.setTacGia(author.getText().toString().trim());
                truyen.setTheLoai(category.getText().toString().trim());
                truyen.setGioiThieu(shortdescription.getText().toString().trim());
                truyen.setHinhanh(R.drawable.liepthien);
                ListViewTruyenActivity.truyenArrayList.add(truyen);

                Context context = getApplicationContext();
                CharSequence text = "Thêm thành công!!!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                ListViewTruyenActivity.truyenAdapter.notifyDataSetChanged();
                finish();
            }
        });

        Button button_clear = findViewById(R.id.insertactivity_btn_clear);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                author.setText("");
                category.setText("");
                shortdescription.setText("");
            }
        });
    }
}