/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.KhuyenMai;
import ulities.DBConnection;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author TRUNG DUC
 */
public class KhuyenMaiRepository {

    final String getAll = "select * from khuyenmai";
    final String them = "insert khuyenmai values(?,?,?)";
    final String sua = "update khuyenmai set muckm=?,ngaybatdau=?,ngayketthuc=? where makm=?";
    final String xoa = "delete khuyenmai where makm=?";

    public ArrayList<KhuyenMai> getAll() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(getAll);
            while (rs.next()) {
                list.add(new KhuyenMai(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getDate(3),
                        rs.getDate(4)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean them(KhuyenMai km) {
        try {
            if (DBConnection.ExcuteQuery(
                    them,
                    km.getMucKm(),
                    new java.sql.Date(km.getNgayBatDau().getTime()),
                    new java.sql.Date(km.getNgayKetThuc().getTime())) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean sua(KhuyenMai km, String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    sua,
                    km.getMucKm(),
                    new java.sql.Date(km.getNgayBatDau().getTime()),
                    new java.sql.Date(km.getNgayKetThuc().getTime()),
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean xoa(String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    xoa, ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    
    final String getListMucKm="select makm,muckm from khuyenmai where GETDATE() <= ngayketthuc and GETDATE() >=ngaybatdau";
    public ArrayList<String> getListMucKm() {
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(getListMucKm);
            while (rs.next()) {                
                list.add(rs.getString(1)+"-"+rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    final String tim_makm_by_muckm="select makm from khuyenmai where muckm=?";
    public int tim_makm_by_muckm(String muckm) {
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs=DBConnection.getDataFromQuery(tim_makm_by_muckm,muckm);
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void main(String[] args) {
        for (String s : new KhuyenMaiRepository().getListMucKm()) {
            System.out.println(s);
        }
    }
}
