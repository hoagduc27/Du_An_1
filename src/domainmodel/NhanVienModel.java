/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author admin
 */
public class NhanVienModel {

    private int MaNV;
    private String TenNV;
    private String Sdt;
    private String UseName;
    private String NgaySinh;
    //Contructor

    public NhanVienModel() {
    }

    public NhanVienModel(String TenNV, String Sdt, String UseName, String NgaySinh) {
        this.TenNV = TenNV;
        this.Sdt = Sdt;
        this.UseName = UseName;
        this.NgaySinh = NgaySinh;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getUseName() {
        return UseName;
    }

    public void setUseName(String UseName) {
        this.UseName = UseName;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public NhanVienModel(int MaNV, String TenNV, String Sdt, String UseName, String NgaySinh) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Sdt = Sdt;
        this.UseName = UseName;
        this.NgaySinh = NgaySinh;
    }

    public Object[] toDataRow() {
        return new Object[]{MaNV, TenNV, Sdt, UseName, NgaySinh};
    }

    //To String
    @Override
    public String toString() {
        return "NhanVienModel{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", Sdt=" + Sdt + ", UseName=" + UseName + ", NgaySinh=" + NgaySinh + '}';
    }
}
