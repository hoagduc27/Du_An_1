/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author TRUNG DUC
 */
public class SanPham {

    private int maSp;
    private String tenSp;
    private LoaiHangDomainModel loaiHang;

    private String tenLoai;
    private String ms;
    private String kc;
    private String cl;
    private int donGia;
    private int daBan;
    private int conLai;
    private int tongDoanhThu;

    public SanPham() {
    }

    public SanPham(int maSp, String tenSp, LoaiHangDomainModel loaiHang) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.loaiHang = loaiHang;
    }

    public SanPham(int maSp, String tenSp, String tenLoai, String ms, String kc, String cl, int donGia, int daBan, int conLai, int tongDoanhThu) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.tenLoai = tenLoai;
        this.ms = ms;
        this.kc = kc;
        this.cl = cl;
        this.donGia = donGia;
        this.daBan = daBan;
        this.conLai = conLai;
        this.tongDoanhThu = tongDoanhThu;
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

    public LoaiHangDomainModel getLoaiHang() {
        return loaiHang;
    }

    public void setLoaiHang(LoaiHangDomainModel loaiHang) {
        this.loaiHang = loaiHang;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getKc() {
        return kc;
    }

    public void setKc(String kc) {
        this.kc = kc;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDaBan() {
        return daBan;
    }

    public void setDaBan(int daBan) {
        this.daBan = daBan;
    }

    public int getConLai() {
        return conLai;
    }

    public void setConLai(int conLai) {
        this.conLai = conLai;
    }

    public int getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(int tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSp=" + maSp + ", tenSp=" + tenSp + ", loaiHang=" + loaiHang + ", tenLoai=" + tenLoai + ", ms=" + ms + ", kc=" + kc + ", cl=" + cl + ", donGia=" + donGia + ", daBan=" + daBan + ", conLai=" + conLai + ", tongDoanhThu=" + tongDoanhThu + '}';
    }

    public Object[] toRowData() {
        return new Object[]{maSp, tenSp, tenLoai, ms, kc, cl, donGia, daBan, conLai, tongDoanhThu};
    }
    public Object[] showdata(){
        return new Object[]{maSp,tenSp,loaiHang.getMaLoai()};
    }
}
