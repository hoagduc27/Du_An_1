/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author TRUNG DUC
 */
public class Qlsp {

    int maCtsp;
    int maSp;
    String tenSp, tenMs, tenCl, tenKc, tenLoai;
    int soLuong;
    float donGia;
    String moTa;
    int trangThai;

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "Qlsp{" + "maCtsp=" + maCtsp + ", maSp=" + maSp + ", tenSp=" + tenSp + ", tenMs=" + tenMs + ", tenCl=" + tenCl + ", tenKc=" + tenKc + ", tenLoai=" + tenLoai + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }

    public Qlsp() {
    }

    public String hienThiTrangThai() {
        if (trangThai == 0) {
            return "Vô hiệu hóa";
        }
        return "Đang bán";
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public Qlsp(int maCtsp, int maSp, String tenSp, String tenMs, String tenCl, String tenKc, String tenLoai, int soLuong, float donGia, String moTa, int trangThai) {
        this.maCtsp = maCtsp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.tenMs = tenMs;
        this.tenCl = tenCl;
        this.tenKc = tenKc;
        this.tenLoai = tenLoai;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getMaCtsp() {
        return maCtsp;
    }

    public void setMaCtsp(int maCtsp) {
        this.maCtsp = maCtsp;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
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

    public String getTenCl() {
        return tenCl;
    }

    public void setTenCl(String tenCl) {
        this.tenCl = tenCl;
    }

    public String getTenKc() {
        return tenKc;
    }

    public void setTenKc(String tenKc) {
        this.tenKc = tenKc;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
