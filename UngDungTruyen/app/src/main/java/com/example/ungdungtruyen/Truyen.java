package com.example.ungdungtruyen;

import java.io.Serializable;

public class Truyen  implements Serializable {
    private String Ten;
    private  String TacGia;
    private  String TheLoai;
    private String GioiThieu;
    private int Hinhanh;

    public Truyen(){

    }

    public Truyen(String ten, String tacGia, String theLoai, String gioiThieu, int hinhanh) {
        Ten = ten;
        TacGia = tacGia;
        TheLoai = theLoai;
        GioiThieu = gioiThieu;
        Hinhanh = hinhanh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        TacGia = tacGia;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String theLoai) {
        TheLoai = theLoai;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        GioiThieu = gioiThieu;
    }

    public int getHinhanh() {
        return Hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        Hinhanh = hinhanh;
    }

    //public String NoiDung;




}
