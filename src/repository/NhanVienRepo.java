 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

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
public class NhanVienRepo {

    public List<NhanVienModel> getAll() {
        String query = "SELECT [MaNV]\n"
                + "      ,[TenNV]\n"
                + "      ,[SDT]\n"
                + "      ,[Username]\n"
                + "      ,[NgaySinh]\n"
                + "  FROM [dbo].[NHANVIEN]";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<NhanVienModel> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new NhanVienModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean add(NhanVienModel Nv) {
        String query = "INSERT INTO [dbo].[NHANVIEN]\n"
                + "           ([TenNV]\n"
                + "           ,[SDT]\n"
                + "           ,[Username]\n"
                + "           ,[NgaySinh])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Nv.getTenNV());
            ps.setObject(2, Nv.getSdt());
            ps.setObject(3, Nv.getUseName());
            ps.setObject(4, Nv.getNgaySinh());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String TenNV) {
        int check = 0;
        String query = "DELETE FROM [dbo].[NHANVIEN]\n"
                + "      WHERE TenNV = ?";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, TenNV);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean Update(NhanVienModel Nv, String Ma) {
        String query = "UPDATE [dbo].[NHANVIEN]\n"
                + "   SET [TenNV] = ?\n"
                + "      ,[SDT] = ?\n"
                + "      ,[Username] = ?\n"
                + "      ,[NgaySinh] = ?\n"
                + " WHERE TenNV = ?";

        int check = 0;
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, Nv.getTenNV());
            ps.setObject(2, Nv.getSdt());
            ps.setObject(3, Nv.getUseName());
            ps.setObject(4, Nv.getNgaySinh());
            ps.setObject(5, Nv.getTenNV());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public NhanVienModel timNvByUsername(String username) {
        String query = "SELECT * from nhanvien where username=?";
        try ( Connection cn = DBConnection.openDbConnection();  PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setObject(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new NhanVienModel(rs.getInt(1), rs.getString(2), rs.getString(3), username, rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(new NhanVienRepo().timNvByUsername("phu").toString());
    }
}
