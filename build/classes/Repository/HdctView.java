/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author TRUNG DUC
 */
public class HdctView {
    int mactsp;
    String tenSp,tenMs,tenLoai,tenCl,tenKc;
    int soLuong;
    float donGia;
int mahd;
    public HdctView() {
    }

    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    }

    @Override
    public String toString() {
        return "HdctView{" + "mactsp=" + mactsp + ", tenSp=" + tenSp + ", tenMs=" + tenMs + ", tenLoai=" + tenLoai + ", tenKc=" + tenKc + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    public HdctView(int mactsp, String tenSp, String tenMs, String tenLoai, String tenCl, String tenKc, int soLuong, float donGia, int mahd) {
        this.mactsp = mactsp;
        this.tenSp = tenSp;
        this.tenMs = tenMs;
        this.tenLoai = tenLoai;
        this.tenCl = tenCl;
        this.tenKc = tenKc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.mahd = mahd;
    }

    public HdctView(int mactsp, String tenSp, String tenMs, String tenLoai, String tenCl, String tenKc, int soLuong, float donGia) {
        this.mactsp = mactsp;
        this.tenSp = tenSp;
        this.tenMs = tenMs;
        this.tenLoai = tenLoai;
        this.tenCl = tenCl;
        this.tenKc = tenKc;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getTenCl() {
        return tenCl;
    }

    public void setTenCl(String tenCl) {
        this.tenCl = tenCl;
    }

   

    public int getMactsp() {
        return mactsp;
    }

    public void setMactsp(int mactsp) {
        this.mactsp = mactsp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getTenMs() {
        return tenMs;
    }

    public void setTenMs(String tenMs) {
        this.tenMs = tenMs;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getTenKc() {
        return tenKc;
    }

    public void setTenKc(String tenKc) {
        this.tenKc = tenKc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
    
}
