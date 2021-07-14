
package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent intent = getIntent();

        int position = intent.getIntExtra("position",0);
        Truyen truyen = ListViewTruyenActivity.truyenArrayList.get(position);

        TextView name = findViewById(R.id.updateactivity_textview_nameofbook);
        EditText author = findViewById(R.id.updateactivity_edittext_author);
        EditText category = findViewById(R.id.updateactivity_edittext_category);
        EditText shortdescription = findViewById(R.id.updateactivity_edittext_shortdescription);
        ImageView image = findViewById(R.id.updateactivity_imageview);

        name.setText(truyen.getTen());
        author.setText(truyen.getTacGia());
        category.setText(truyen.getTheLoai());
        shortdescription.setText(truyen.getGioiThieu());
        image.setImageResource(truyen.getHinhanh());

        Button button_save = findViewById(R.id.updateactivity_btn_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen truyen1 = ListViewTruyenActivity.truyenArrayList.get(position);
                truyen1.setTacGia(author.getText().toString().trim());
                truyen1.setGioiThieu(shortdescription.getText().toString().trim());
                truyen1.setTheLoai(category.getText().toString().trim());

                Context context = getApplicationContext();
                CharSequence text = "Cập nhật thành công thành công!!!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                ListViewTruyenActivity.truyenAdapter.notifyDataSetChanged();

                Intent intent = new Intent(UpdateActivity.this, ListViewTruyenActivity.class);
                startActivity(intent);
            }
        });

    }
}