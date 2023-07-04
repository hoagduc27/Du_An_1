/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;

/**
 *
 * @author nhatc
 */
public class KhachHangDomainModel {

    private int maKH;
    private String tenKH;
    private String diaChi;
    private String sdt;
    private String ngaySinh;

    public KhachHangDomainModel() {
    }

    public KhachHangDomainModel(int maKH, String tenKH, String diaChi, String sdt, String ngaySinh) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public KhachHangDomainModel(String tenKH, String diaChi, String sdt, String ngaySinh) {
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Object[] toRowData() {
        return new Object[]{maKH, tenKH, diaChi, sdt, ngaySinh};
    }

    @Override
    public String toString() {
        return "KhachHangDomainModel{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + '}';
    }

}
