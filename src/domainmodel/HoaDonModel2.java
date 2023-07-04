/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Date;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author admin
 */
public class HoaDonModel2 {
    private int MaHD;
    private Date NgayTao;
    private int TrangThai;
    private NhanVienModel nv;
    private KhachHangDomainModel kh;
    private KhuyenMai km;
    


    public HoaDonModel2() {
    }

    @Override
    public String toString() {
        return "HoaDonModel2{" + "MaHD=" + MaHD + ", NgayTao=" + NgayTao + ", TrangThai=" + TrangThai + ", nv=" + nv + ", kh=" + kh + ", km=" + km + '}';
    }

   

    public HoaDonModel2(int MaHD, Date NgayTao, int TrangThai, NhanVienModel nv, KhachHangDomainModel kh, KhuyenMai km) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.nv = nv;
        this.kh = kh;
        this.km = km;
    }

    public KhachHangDomainModel getKh() {
        return kh;
    }

    public void setKh(KhachHangDomainModel kh) {
        this.kh = kh;
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

    public NhanVienModel getNv() {
        return nv;
    }

    public void setNv(NhanVienModel nv) {
        this.nv = nv;
    }

    public KhuyenMai getKm() {
        return km;
    }

    public void setKm(KhuyenMai km) {
        this.km = km;
    }
    
}
