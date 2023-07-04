/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author TRUNG DUC
 */
public class Ctsp {
    int maCtsp;
    SanPham sp;
    MauSacDomainModel ms;
    LoaiHangDomainModel loai;
    ChatLieuDomainModel cl;
    KichCoDomainModel kc;
    int soLuong;
    float donGia;
    String moTa;
    int trangThai;

    public Ctsp() {
    }

    public Ctsp(int maCtsp, SanPham sp, MauSacDomainModel ms, LoaiHangDomainModel loai, ChatLieuDomainModel cl, KichCoDomainModel kc, int soLuong, float donGia, String moTa, int trangThai) {
        this.maCtsp = maCtsp;
        this.sp = sp;
        this.ms = ms;
        this.loai = loai;
        this.cl = cl;
        this.kc = kc;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String hienThiTrangThai(){
        if(trangThai==0){
            return "Vô hiệu hóa";
        }
        return "Đang bán";
    }
    
    public int getMaCtsp() {
        return maCtsp;
    }

    public void setMaCtsp(int maCtsp) {
        this.maCtsp = maCtsp;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public MauSacDomainModel getMs() {
        return ms;
    }

    public void setMs(MauSacDomainModel ms) {
        this.ms = ms;
    }

    public LoaiHangDomainModel getLoai() {
        return loai;
    }

    public void setLoai(LoaiHangDomainModel loai) {
        this.loai = loai;
    }

    public ChatLieuDomainModel getCl() {
        return cl;
    }

    public void setCl(ChatLieuDomainModel cl) {
        this.cl = cl;
    }

    public KichCoDomainModel getKc() {
        return kc;
    }

    public void setKc(KichCoDomainModel kc) {
        this.kc = kc;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "Ctsp{" + "maCtsp=" + maCtsp + ", sp=" + sp.getMaSp() + ", ms=" + ms + ", loai=" + loai + ", cl=" + cl + ", kc=" + kc + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + '}';
    }
    public Object[] showdata(){
        return new Object[]{maCtsp,sp.getMaSp(),loai.getMaLoai(),ms.getMaMau(),cl.getMaCL(),kc.getMaKC(),soLuong,donGia,moTa,trangThai};
    }
}
