/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhachHangDomainModel;
import ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class KhachHangRepository {

    public List<KhachHangDomainModel> getAll() {
        String query = "SELECT [MaKH]\n"
                + "      ,[TenKH]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[NgaySinh]\n"
                + "  FROM [dbo].[KHACHHANG]";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<KhachHangDomainModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new KhachHangDomainModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(KhachHangDomainModel kh) {
        String query = "INSERT INTO [dbo].[KHACHHANG]\n"
                + "           ([TenKH]\n"
                + "           ,[DiaChi]\n"
                + "           ,[SDT]\n"
                + "           ,[NgaySinh])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, kh.getTenKH());
            ps.setObject(2, kh.getDiaChi());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getNgaySinh());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<KhachHangDomainModel> Search(String sdt) {
        String query = "SELECT [MaKH]\n"
                + "      ,[TenKH]\n"
                + "      ,[DiaChi]\n"
                + "      ,[SDT]\n"
                + "      ,[NgaySinh]\n"
                + "  FROM [dbo].[KHACHHANG]\n"
                + "  where SDT = ?";
        List<KhachHangDomainModel> list = new ArrayList<>();
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sdt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHangDomainModel kh = new KhachHangDomainModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(kh);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
    
    public static void main(String[] args) {
        new KhachHangRepository().getAll().forEach(x -> System.out.println(x.toString()));
    }
}
