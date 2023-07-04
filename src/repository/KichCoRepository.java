/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KichCoDomainModel;
import ulities.DBConnection;
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
public class KichCoRepository {

    public List<KichCoDomainModel> getAll() {
        List<KichCoDomainModel> listKC = new ArrayList<>();
        String query = "SELECT [MaKC]\n"
                + "      ,[TenKC]\n"
                + "  FROM [dbo].[KICHCO]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listKC.add(new KichCoDomainModel(rs.getInt(1), rs.getString(2)));
            }
            return listKC;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(KichCoDomainModel kc) {
        int check = 0;
        String query = "INSERT kichco values(?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kc.getTenKC());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(KichCoDomainModel kc, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[KICHCO]\n"
                + "   SET [TenKC] = ?\n"
                + " WHERE MaKC = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, kc.getTenKC());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[KICHCO]\n"
                + "      WHERE MaKC like ?";
        try(Connection con = DBConnection.openDbConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check >0;
    }
    final String getListTenKc = "select TenKC from KICHCO";
    public ArrayList<String> getListTenKC(){
        ArrayList<String>list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(getListTenKc);
            
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            
        }
        return list;
    }
    
    final String tim_makc_by_ten = "select maKC from KICHCO where tenkc=?";
    public int tim_makc_by_ten(String ten){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(tim_makc_by_ten,ten);  
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new KichCoRepository().tim_makc_by_ten("Xl"));
    }

}
