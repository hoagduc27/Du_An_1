/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;



/**
 *
 * @author DELL 5570
 */
public class HDCTDomainModel {
    private int maHD;
    private int maCTSP;
    private Date ngayTao;
    private int soLuong;
    private String donGia;

    public HDCTDomainModel() {
    }

    public HDCTDomainModel(int maHD, int maCTSP, Date ngayTao, int soLuong, String donGia) {
        this.maHD = maHD;
        this.maCTSP = maCTSP;
        this.ngayTao = ngayTao;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(int maCTSP) {
        this.maCTSP = maCTSP;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonGia() {
        return donGia;
    }

    public void setDonGia(String donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "HDCTDomainModel{" + "maHD=" + maHD + ", maCTSP=" + maCTSP + ", ngayTao=" + ngayTao + ", soLuong=" + soLuong + ", donGia=" + donGia + '}';
    }

    
    public Object[] toRowDataHDCT(){
        return new Object[]{maHD, maCTSP, ngayTao, soLuong, donGia};
    }
}
