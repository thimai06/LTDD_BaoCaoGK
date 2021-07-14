package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TruyenDetailsActivity extends AppCompatActivity {
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen_details);
        Intent intent = getIntent();

        int position = intent.getIntExtra("position",0); //lay vi tri
        Truyen truyen = ListViewTruyenActivity.truyenArrayList.get(position);

        TextView txttacgia=(TextView) this.findViewById(R.id.tacgia);
        ImageView image=(ImageView) this.findViewById(R.id.im_avata);
        TextView gioithieu = (TextView) this.findViewById(R.id.gioithieu);
        TextView txtTen=(TextView) this.findViewById(R.id.tv_name);
        TextView txttl=(TextView) this.findViewById(R.id.theloai);

        txttacgia.setText("Tác Giả:  "+truyen.getTacGia());
        txtTen.setText("Tên Truyện:  "+truyen.getTen());
        txttl.setText("Thể Loại:  "+truyen.getTheLoai());
        image.setImageResource(truyen.getHinhanh());
        gioithieu.setText(truyen.getGioiThieu());

        Button btupdate= findViewById(R.id.button_update);
        btupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });

        Button btn_delete = findViewById(R.id.button_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                ListViewTruyenActivity.truyenArrayList.remove(position);
                ListViewTruyenActivity.truyenAdapter.notifyDataSetChanged();    // load lai Adapter
                finish();
            }
        });


    }
}