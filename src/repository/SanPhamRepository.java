/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ctsp;
import domainmodel.LoaiHangDomainModel;
import domainmodel.SanPham;
import ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author TRUNG DUC
 */
public class SanPhamRepository {

    final String get_list_masp = "select masp from sanpham";

    public ArrayList<String> getListMaSp() {
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(get_list_masp);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String check_ton_tai_sp = "select * from sanpham where tensp=?";

    public Boolean check_ton_tai_sp(String ten) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(check_ton_tai_sp, ten);
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    final String them_sp = "insert sanpham values(?,?)";

    public Boolean them_sp(SanPham sp) {
        try {
            if (DBConnection.ExcuteQuery(them_sp, sp.getTenSp(), sp.getLoaiHang().getMaLoai()) == 0) {
                return false;
            }
            System.out.println("repo sp"+sp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String xoa_sp = "delete sanpham where tensp=?";

    public Boolean xoa_sp(SanPham sp) {
        try {
            if (DBConnection.ExcuteQuery(xoa_sp, sp.getTenSp()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String tim_idsp_by_ten = "select masp from sanpham where tensp=?";

    public int tim_idsp_by_ten(String ten) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(tim_idsp_by_ten, ten);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    final String count_sp = "select count(masp) from sanpham";

    public int count_sp() {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(count_sp);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<SanPham> getAll() {
        List<SanPham> listsp = new ArrayList<>();
        String query = "SELECT [MaSP]\n"
                + "      ,[TenSP]\n"
                + "      ,[MALOAI]\n"
                + "  FROM [dbo].[SANPHAM]";
        try(Connection con = DBConnection.openDbConnection();PreparedStatement ps = con.prepareStatement(query) ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiHangDomainModel lh = new LoaiHangDomainModel();
                lh.setMaLoai(rs.getInt(3));
                listsp.add(new SanPham(rs.getInt(1), rs.getString(2), lh));
            }
            
        } catch (Exception e) {
            
        }
        return listsp;
    }

     final String sua_sanpham = "update SanPham set TenSP =?,MaLoai = ? where MaSP = ?";

    public Boolean sua_sp(SanPham sp) {
        try {
            if (DBConnection.ExcuteQuery(sua_sanpham, sp.getTenSp(),sp.getLoaiHang().getMaLoai(),sp.getMaSp()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public static void main(String[] args) {
        SanPhamRepository sp = new SanPhamRepository();
        ArrayList<String> list = sp.getListMaSp();
        System.out.println(sp.count_sp());
    }
}
