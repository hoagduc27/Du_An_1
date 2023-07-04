/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDonModel;
import domainmodel.HoaDonModel2;
import domainmodel.KhachHangDomainModel;
import domainmodel.KhuyenMai;
import domainmodel.NhanVienModel;
import ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HDRepos {

    public List<HoaDonModel> getAll() {
        String query = "SELECT [MaHD]\n"
                + "      ,[NgayTao]\n"
                + "      ,[TrangThai]\n"
                + "      ,[MaNV]\n"
                + "      ,[MaKH]\n"
                + "      ,[MaKM]\n"
                + "  FROM [dbo].[HOADON]";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new HoaDonModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(HoaDonModel Hd) {
        String query = "INSERT INTO HOADON values (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Hd.getNgayTao());
            ps.setObject(2, Hd.getTrangThai());
            ps.setObject(3, Hd.getMaNV());
            ps.setObject(4, Hd.getMaKH());
            ps.setObject(5, Hd.getMaKM());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    final String suaHD = "UPDATE [dbo].[HOADON]\n"
            + "   SET [NgayTao] = ?\n"
            + "      ,[TrangThai] = ?\n"
            + "      ,[MaNV] = ?\n"
            + "      ,[MaKH] = ?\n"
            + "      ,[MaKM] = ?\n"
            + " WHERE MaHD = ?";

    public Boolean suaHD(HoaDonModel Hd, String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    suaHD,
                    Hd.getMaHD(),
                    Hd.getNgayTao(),
                    Hd.getTrangThai(),
                    Hd.getMaNV(),
                    Hd.getMaKH(),
                    Hd.getMaKM(),
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<HoaDonModel2> getAllHdGdbh() {
        String query = "select MaHD, NgayTao, TenNV, TenKH, MucKM, TrangThai from HOADON\n"
                + "join KHACHHANG on HOADON.MaKH = KHACHHANG.MaKH\n"
                + "join NHANVIEN on HOADON.MaNV = NHANVIEN.MaNV\n"
                + "join KHUYENMAI on HOADON.MaKM = KHUYENMAI.MaKM where trangthai=0";
        ArrayList<HoaDonModel2> list = new ArrayList<>();
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setTenNV(rs.getString(3));
                KhuyenMai km = new KhuyenMai();
                km.setMucKm(rs.getInt(5));
                KhachHangDomainModel kh = new KhachHangDomainModel();
                kh.setTenKH(rs.getString(4));
                HoaDonModel2 hd = new HoaDonModel2(
                        rs.getInt(1), rs.getDate(2), rs.getInt(6), nv, kh, km);
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public boolean addByGdbh(HoaDonModel2 Hd) {
        String query = "INSERT INTO HOADON values (?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, new java.sql.Date(Hd.getNgayTao().getTime()));
            ps.setObject(2, Hd.getTrangThai());
            ps.setObject(3, Hd.getNv().getMaNV());
            ps.setObject(4, Hd.getKh().getMaKH());
            ps.setObject(5, Hd.getKm().getMaKm());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean xoa(String mahd) {
        String query = "delete hoadon where mahd=?";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, mahd);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    final String sua_tt_hd = "UPDATE [dbo].[HOADON]\n"
            + "   SET trangthai=? "
            + " WHERE MaHD = ?";

    public Boolean sua_tt_hd(String maHd) {
        try {
            if (DBConnection.ExcuteQuery(
                    sua_tt_hd,
                    1,
                    maHd) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<HoaDonModel2> getAllQlhd() {
        String query = "select MaHD, NgayTao, TenNV, TenKH, MucKM, TrangThai from HOADON\n"
                + "join KHACHHANG on HOADON.MaKH = KHACHHANG.MaKH\n"
                + "join NHANVIEN on HOADON.MaNV = NHANVIEN.MaNV\n"
                + "join KHUYENMAI on HOADON.MaKM = KHUYENMAI.MaKM where trangthai=1";
        ArrayList<HoaDonModel2> list = new ArrayList<>();
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setTenNV(rs.getString(3));
                KhuyenMai km = new KhuyenMai();
                km.setMucKm(rs.getInt(5));
                KhachHangDomainModel kh = new KhachHangDomainModel();
                kh.setTenKH(rs.getString(4));
                HoaDonModel2 hd = new HoaDonModel2(
                        rs.getInt(1), rs.getDate(2), rs.getInt(6), nv, kh, km);
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public ArrayList<HoaDonModel2> locHd(ArrayList<String> listdk) {
        String query = "select MaHD, NgayTao, TenNV, TenKH, MucKM, TrangThai from HOADON\n"
                + "join KHACHHANG on HOADON.MaKH = KHACHHANG.MaKH\n"
                + "join NHANVIEN on HOADON.MaNV = NHANVIEN.MaNV\n"
                + "join KHUYENMAI on HOADON.MaKM = KHUYENMAI.MaKM where trangthai=1 and ";
        query+=listdk.get(0);
        for (int i = 1; i < listdk.size(); i++) {
            query+=" and "+listdk.get(i);        
        }
        System.out.println(query);
        ArrayList<HoaDonModel2> list = new ArrayList<>();
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienModel nv = new NhanVienModel();
                nv.setTenNV(rs.getString(3));
                KhuyenMai km = new KhuyenMai();
                km.setMucKm(rs.getInt(5));
                KhachHangDomainModel kh = new KhachHangDomainModel();
                kh.setTenKH(rs.getString(4));
                HoaDonModel2 hd = new HoaDonModel2(
                        rs.getInt(1), rs.getDate(2), rs.getInt(6), nv, kh, km);
                list.add(hd);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public static void main(String[] args) {
        new HDRepos().getAllHdGdbh().forEach(s -> System.out.println(s.toString()));
    }
}
