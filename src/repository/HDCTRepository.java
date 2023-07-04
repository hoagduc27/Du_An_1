/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HDCTDomainModel;
import ulities.DBConnection;
import viewmodel.HdctView;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL 5570
 */
public class HDCTRepository {

    public List<HDCTDomainModel> getAll() {
        List<HDCTDomainModel> listHDCT = new ArrayList<>();
        String query = "SELECT [MaHD]\n"
                + "      ,[MaCTSP]\n"
                + "      ,[NgayTao]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "  FROM [dbo].[HDCT]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listHDCT.add(new HDCTDomainModel(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getString(5)));
            }
            return listHDCT;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listHDCT;
    }

    public boolean Add(HDCTDomainModel hdct) {
        int check = 0;
        String query = "INSERT INTO [dbo].[HDCT]\n"
                + "           ([MaHD]\n"
                + "           ,[MaCTSP]\n"
                + "           ,[NgayTao]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           (?, ?, ?,?,?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getMaHD());
            ps.setObject(2, hdct.getMaCTSP());
            ps.setObject(3, null);
            ps.setObject(4, hdct.getSoLuong());
            ps.setObject(5, hdct.getDonGia());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(HDCTDomainModel hdct, String maHd, String maCtsp) {
        int check = 0;
        String query = "UPDATE [dbo].[HDCT]\n"
                + "   SET [SoLuong] = ?\n"
                + "      ,[DonGia] = ?\n"
                + " WHERE MaHD = ? and mactsp=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, hdct.getSoLuong());
            ps.setObject(2, hdct.getDonGia());
            ps.setObject(3, maHd);
            ps.setObject(4, maCtsp);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String maHD, String maCTSP) {
        int check = 0;
        String query = "DELETE FROM [dbo].[HDCT]\n"
                + "      WHERE MaHD = ? and MaCTSP = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maHD);
            ps.setObject(2, maCTSP);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public ArrayList<HdctView> getAllHdctByMaHd(String mahd) {
        ArrayList<HdctView> list = new ArrayList<>();
        String query = "SELECT hdct.MaCTSP,tensp,tenms,tenloai,tencl,tenkc,hdct.[SoLuong],hdct.[DonGia],mahd\n"
                + "                  FROM hdct \n"
                + "				  join CHITIETSP on hdct.MaCTSP = chitietsp.MaCTSP \n"
                + "				  join sanpham on sanpham.masp=CHITIETSP.MaSP\n"
                + "				  join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
                + "				  join CHATLIEU on CHATLIEU.macl = CHITIETSP.Macl\n"
                + "           		  join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
                + "            	  join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai\n"
                + "				  where mahd=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, mahd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new HdctView(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getFloat(8),rs.getInt(9)));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public Boolean checkTonTaiHdct(String mahd, String mactsp) {
        String query = "select * from hdct where mahd=? and mactsp=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, mahd);
            ps.setObject(2, mactsp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public float tongTienHd(String mahd) {
        String query = "select sum(dongia*soluong-dongia*soluong*muckm/100) from hdct"
                + " join hoadon on hdct.mahd = hoadon.mahd"
                + " join khuyenmai on khuyenmai.makm = hoadon.makm where hdct.mahd=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, mahd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return -1;
    }

    public boolean update_so_luong(String sl, String maHd, String maCtsp) {
        int check = 0;
        String query = "UPDATE [dbo].[HDCT]\n"
                + "   SET [SoLuong] = ?"
                + " WHERE MaHD = ? and mactsp=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, sl);
            ps.setObject(2, maHd);
            ps.setObject(3, maCtsp);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    public int demHdctByMaHd(String maHd) {
        String query = "select count(mahd) from hdct where mahd=?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, maHd);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return -1;
    }
}
