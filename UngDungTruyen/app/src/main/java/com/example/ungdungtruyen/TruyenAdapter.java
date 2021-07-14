package com.example.ungdungtruyen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class TruyenAdapter extends BaseAdapter {

    Context myContext;
    List<Truyen> arrayTruyen;
    int myLayout;

    public TruyenAdapter(Context context,int layout, List<Truyen> truyenList){
        myContext =context;
        arrayTruyen =truyenList;
        myLayout = layout;
    }
    @Override
    public int getCount() {
        return arrayTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) myContext.getSystemService(myContext.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(myLayout,null);
        ImageView image=(ImageView) convertView.findViewById(R.id.im_avata);
        TextView txttacgia=(TextView) convertView.findViewById(R.id.tacgia);
        TextView txtTen=(TextView) convertView.findViewById(R.id.tv_name);
        TextView txttl=(TextView) convertView.findViewById(R.id.theloai);

        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myContext, TruyenDetailsActivity.class);

                intent.putExtra("position",position);
                myContext.startActivity(intent);
            }

        });
        Truyen truyen=arrayTruyen.get(position);
        txtTen.setText(truyen.getTen());
        txttacgia.setText("Tác Giả:"+truyen.getTacGia());
        txttl.setText("Thể Loại:"+truyen.getTheLoai());
        image.setImageResource(truyen.getHinhanh());
        return convertView;
    }


}
