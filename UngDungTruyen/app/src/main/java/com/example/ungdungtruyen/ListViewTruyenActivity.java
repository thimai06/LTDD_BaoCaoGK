package com.example.ungdungtruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewTruyenActivity extends AppCompatActivity {
    private ListView lvtruyen;
    public static ArrayList<Truyen> truyenArrayList = new ArrayList<>();
    public static TruyenAdapter truyenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_truyen);
        Context context = this;
        lvtruyen =  findViewById(R.id.listviewtruyen);

        Truyen truyen = new Truyen("Yêu anh hơn cả tử thần","Tào Đình","Truyện Màu","Nếu có một ngày , mặt trời biến mất , nhân gian một vùng tăm tối , sẽ là đang gì thế giới đâu ? Biến đổi lớn bên trong Địa Cầu lâm vào hắc ám , từ đâu không có ánh nắng , không có tinh không , chỉ có vô tận rét lạnh cùng đêm tối , nhân Loại từ đầu tiến vào hắc ám màu cùng sắc thời đại ! Chạy nạn trong đội ngũ , Sau lưng người đại thúc có lẽ chính là ngày xưa tài phủ trên bảng quát tháo phong Vân ( thiên hạ cụ phủ ) ; Đói khát trong đám người , khẩn cầu người cho rằng của khối bánh mì có lẽ chính là ngày xưa chói lọi ( non mô hình nữ tinh )",
                R.drawable.hacam);
        Truyen truyen1= new Truyen("Đan Hoàng Võ Đế","Đang Cập Nhât","Truyện Chữ","Ngàn năm trước, một đời Thần Hoàng tại Bách Tộc chiến trường huyết chiến xưng bá, khai phách vạn thế thần triều, trùng kích vô thượng đế vị, muốn thành liền Đế tộc thứ chín. Nhưng quần hùng ngăn cản, bách tộc nghịch hành, Thần Hoàng xưng đế thời khắc chiến tử Đăng Thiên Kiều",R.drawable.danhoang);
        Truyen truyen2 = new Truyen("Liệp Thiên Tranh Phong","Thụy Thu","Huyền Huyễn","Chuyện kể về mấy chục năm trước, khi Thương Vũ luyện võ, Thương Linh luyện huyết hai thế giới thôn phệ lẫn nhau, hình thành năm cái bí cảnh khổng lồ với vô số tài nguyên được dựng dục bên trong. Hai bên siêu phàm giả thế giới tranh nắm giữ lợi ích nơi đây, cũng như mở rộng ảnh hưởng của thế giới bên mình, chờ tương lai thế giới dung hợp nắm quyền chủ động",R.drawable.liepthien);
        Truyen truyen3 = new Truyen("Thập Phương Võ Thánh","Cổn Khai","Huyền Huyễn","Trung ương hoàng triều tan vỡ, các nơi quần hùng cắt cứ, môn phái độc lập. Ma môn yêu đảng giấu ở chỗ tối làm loạn, bang phái lẫn nhau chinh phạt, hỗn loạn không chịu nổi.",R.drawable.danhoang);
        Truyen truyen4 = new Truyen("Yêu anh hơn cả tử thần","Tào Đình","Truyện Màu","Nếu có một ngày , mặt trời biến mất , nhân gian một vùng tăm tối , sẽ là đang gì thế giới đâu ? Biến đổi lớn bên trong Địa Cầu lâm vào hắc ám , từ đâu không có ánh nắng , không có tinh không , chỉ có vô tận rét lạnh cùng đêm tối , nhân Loại từ đầu tiến vào hắc ám màu cùng sắc thời đại ! Chạy nạn trong đội ngũ , Sau lưng người đại thúc có lẽ chính là ngày xưa tài phủ trên bảng quát tháo phong Vân ( thiên hạ cụ phủ ) ; Đói khát trong đám người , khẩn cầu người cho rằng của khối bánh mì có lẽ chính là ngày xưa chói lọi ( non mô hình nữ tinh )",
                R.drawable.hacam);
        Truyen truyen5= new Truyen("Đan Hoàng Võ Đế","Đang Cập Nhât","Truyện Chữ","Ngàn năm trước, một đời Thần Hoàng tại Bách Tộc chiến trường huyết chiến xưng bá, khai phách vạn thế thần triều, trùng kích vô thượng đế vị, muốn thành liền Đế tộc thứ chín. Nhưng quần hùng ngăn cản, bách tộc nghịch hành, Thần Hoàng xưng đế thời khắc chiến tử Đăng Thiên Kiều",R.drawable.danhoang);
        Truyen truyen6 = new Truyen("Liệp Thiên Tranh Phong","Thụy Thu","Huyền Huyễn","Chuyện kể về mấy chục năm trước, khi Thương Vũ luyện võ, Thương Linh luyện huyết hai thế giới thôn phệ lẫn nhau, hình thành năm cái bí cảnh khổng lồ với vô số tài nguyên được dựng dục bên trong. Hai bên siêu phàm giả thế giới tranh nắm giữ lợi ích nơi đây, cũng như mở rộng ảnh hưởng của thế giới bên mình, chờ tương lai thế giới dung hợp nắm quyền chủ động",R.drawable.liepthien);
        Truyen truyen7 = new Truyen("Thập Phương Võ Thánh","Cổn Khai","Huyền Huyễn","Trung ương hoàng triều tan vỡ, các nơi quần hùng cắt cứ, môn phái độc lập. Ma môn yêu đảng giấu ở chỗ tối làm loạn, bang phái lẫn nhau chinh phạt, hỗn loạn không chịu nổi.",R.drawable.danhoang);


        truyenArrayList.add(truyen);
        truyenArrayList.add(truyen1);
        truyenArrayList.add(truyen2);
        truyenArrayList.add(truyen3);
        truyenArrayList.add(truyen4);
        truyenArrayList.add(truyen5);
        truyenArrayList.add(truyen6);
        truyenArrayList.add(truyen7);


        truyenAdapter = new TruyenAdapter(this,R.layout.row_item_truyen,truyenArrayList);

        lvtruyen.setAdapter(truyenAdapter);


        Button button = findViewById(R.id.listviewactivity_btn_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InsertActitvity.class);
                //new Intent(actitity1,activity2) chuyển từ activity1 sang activity 2
                context.startActivity(intent);
            }
        });





    }

}