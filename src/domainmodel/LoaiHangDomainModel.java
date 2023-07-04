/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author nhatc
 */
public class LoaiHangDomainModel {

    private int maLoai;
    private String tenLoai;

    public LoaiHangDomainModel() {
    }

    public LoaiHangDomainModel(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    public LoaiHangDomainModel(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public Object[] toRowDataLoaiHang() {
        return new Object[]{maLoai, tenLoai};
    }

    @Override
    public String toString() {
        return "LoaiHangDomainModel{" + "maLoai=" + maLoai + ", tenLoai=" + tenLoai + '}';
    }

}
