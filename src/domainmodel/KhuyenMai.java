/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;

/**
 *
 * @author TRUNG DUC
 */
public class KhuyenMai {
    private int maKm;
    private int mucKm;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhuyenMai() {
    }

    public KhuyenMai(int maKm, int mucKm, Date ngayBatDau, Date ngayKetThuc) {
        this.maKm = maKm;
        this.mucKm = mucKm;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getMaKm() {
        return maKm;
    }

    public void setMaKm(int maKm) {
        this.maKm = maKm;
    }

    public int getMucKm() {
        return mucKm;
    }

    public void setMucKm(int mucKm) {
        this.mucKm = mucKm;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKm=" + maKm + ", mucKm=" + mucKm + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + '}';
    }
    
}
