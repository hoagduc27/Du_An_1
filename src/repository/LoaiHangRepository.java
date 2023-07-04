/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.LoaiHangDomainModel;
import ulities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nhatc
 */
public class LoaiHangRepository {

    final String select_all = "select * from LOAIHANG";

    public ArrayList<LoaiHangDomainModel> getAll() {
        ArrayList<LoaiHangDomainModel> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(select_all);
            while (rs.next()) {
                list.add(new LoaiHangDomainModel(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String add = "insert LOAIHANG values(?)";

    public Boolean add(LoaiHangDomainModel lh) {
        try {
            if (DBConnection.ExcuteQuery(
                    add,
                    lh.getTenLoai()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String update = "update LOAIHANG set TenLoai=? where MaLoai=?";

    public Boolean update(LoaiHangDomainModel lh, String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    update,
                    lh.getTenLoai(),
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String delete = "delete LOAIHANG where MaLoai=?";

    public Boolean delete(String ma) {
        try {
            if (DBConnection.ExcuteQuery(
                    delete,
                    ma) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String get_list_ten_loai = "select tenloai from loaihang";

    public ArrayList<String> getListTenLoaiHang() {
        ArrayList<String> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(get_list_ten_loai);
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String tim_malh_by_ten = "select maloai from loaihang where tenloai=?";
    public int tim_malh_by_ten(String ten){
        try {
            ResultSet rs = DBConnection.getDataFromQuery(tim_malh_by_ten,ten);  
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new LoaiHangRepository().tim_malh_by_ten("a"));
    }
}
