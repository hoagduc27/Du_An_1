/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author nhatc
 */
public class DoanhThuView {

    private int tongDoanhThu;
    private int tongSanPham;
    private int soHoaDon;

    public DoanhThuView() {
    }

    public DoanhThuView(int tongDoanhThu, int tongSanPham, int soHoaDon) {
        this.tongDoanhThu = tongDoanhThu;
        this.tongSanPham = tongSanPham;
        this.soHoaDon = soHoaDon;
    }

    public int getTongDoanhThu() {
        return tongDoanhThu;
    }

    public void setTongDoanhThu(int tongDoanhThu) {
        this.tongDoanhThu = tongDoanhThu;
    }

    public int getTongSanPham() {
        return tongSanPham;
    }

    public void setTongSanPham(int tongSanPham) {
        this.tongSanPham = tongSanPham;
    }

    public int getSoHoaDon() {
        return soHoaDon;
    }

    public void setSoHoaDon(int soHoaDon) {
        this.soHoaDon = soHoaDon;
    }

    @Override
    public String toString() {
        return "DoanhThuView{" + "tongDoanhThu=" + tongDoanhThu + ", tongSanPham=" + tongSanPham + ", soHoaDon=" + soHoaDon + '}';
    }

    public Object[] toData() {
        return new Object[]{tongDoanhThu, tongSanPham, soHoaDon};
    }
}
