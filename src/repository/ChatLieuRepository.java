/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChatLieuDomainModel;
import domainmodel.KichCoDomainModel;
import ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuRepository {

    public List<ChatLieuDomainModel> getAll() {
        List<ChatLieuDomainModel> listCL = new ArrayList<>();
        String query = "SELECT [MaCL]\n"
                + "      ,[TenCL]\n"
                + "  FROM [dbo].[CHATLIEU]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCL.add(new ChatLieuDomainModel(rs.getInt(1), rs.getString(2)));
            }
            return listCL;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean Add(ChatLieuDomainModel cl) {
        int check = 0;
        String query = "insert chatlieu values(?)";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cl.getTenCL());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean update(ChatLieuDomainModel cl, String ma) {
        int check = 0;
        String query = "UPDATE [dbo].[CHATLIEU]\n"
                + "   SET [TenCL] = ?\n"
                + " WHERE MaCL = ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, cl.getTenCL());
            ps.setObject(2, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean delete(String ma) {
        int check = 0;
        String query = "DELETE FROM [dbo].[CHATLIEU]\n"
                + "      WHERE MaCL like ?";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    final String getListTenCl = "select TenCL from CHATLIEU";
    public ArrayList<String> getListTenCL(){
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(getListTenCl);
            while(rs.next()){
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    final String tim_macl_by_ten = "select macl from chatlieu where tencl=?";
    public int tim_macl_by_ten(String ten){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(tim_macl_by_ten,ten);  
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new ChatLieuRepository().tim_macl_by_ten("x"));
    }

}

