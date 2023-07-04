/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author admin
 */
public class HoaDonModel {
    private int MaHD;
    private String NgayTao;
    private int TrangThai;
    private int MaNV;
    private int MaKH;
    private int MaKM;
    
    //Contructor

    public HoaDonModel() {
    }

    public HoaDonModel(String NgayTao, int TrangThai, int MaNV, int MaKH, int MaKM) {
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
    }

    public HoaDonModel(int MaHD, String NgayTao, int TrangThai, int MaNV, int MaKH, int MaKM) {
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.TrangThai = TrangThai;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.MaKM = MaKM;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public int getMaKM() {
        return MaKM;
    }

    public void setMaKM(int MaKM) {
        this.MaKM = MaKM;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "  Mã HĐ =" + MaHD + "  Ngày Tạo =" + NgayTao + "  Trạng Thái =" + TrangThai + "  MãNV =" + MaNV + "  MãKH =" + MaKH + "  Mã KM =" + MaKM + '}';
    }
    
    public Object[] toDataRow(){
    
    return new Object[]{MaHD,NgayTao,TrangThai,MaNV,MaKH,MaKM};
    }
}
