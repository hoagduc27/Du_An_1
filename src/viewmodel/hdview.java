/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class hdview {

    private int MaHD;
    private Date NgayTao;
    private int TrangThai;
    private String tenNv;
    private String tenKh;
    private int mucKm;

    @Override
    public String toString() {
        return "hdview{" + "MaHD=" + MaHD + ", NgayTao=" + NgayTao + ", TrangThai=" + TrangThai + ", tenNv=" + tenNv + ", mucKm=" + mucKm + '}';
    }

    public hdview() {
    }

    public hdview(int MaHD, Date NgayTao, int TrangThai, String tenNv, String tenKh, int mucKm) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.tenNv = tenNv;
        this.tenKh = tenKh;
        this.mucKm = mucKm;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public int getMucKm() {
        return mucKm;
    }

    public void setMucKm(int mucKm) {
        this.mucKm = mucKm;
    }

    public String hienTt() {
        if (TrangThai == 0) {
            return "Đang chờ";
        }
        return "Đã thanh toán";
    }

}
