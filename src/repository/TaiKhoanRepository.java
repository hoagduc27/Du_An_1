/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.TaiKhoan;
import ulities.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class TaiKhoanRepository {

    public TaiKhoanRepository() {
    }

    final String kiem_tra_tk = "select loaitk from taikhoan where username=? and password=?";

    public TaiKhoan dangNhap(TaiKhoan taiKhoan) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(kiem_tra_tk, taiKhoan.getUserName(), taiKhoan.getPassword());
            if (rs.next()) {
                TaiKhoan tk = new TaiKhoan(taiKhoan.getUserName(), taiKhoan.getPassword(), rs.getString(1));
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    final String check_ton_tai = "select password from taikhoan where username=?";

    public Boolean checkTonTai(TaiKhoan taiKhoan) {
        try {
            ResultSet rs = DBConnection.getDataFromQuery(check_ton_tai, taiKhoan.getUserName());
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    final String select_all = "select * from taikhoan";

    public ArrayList<TaiKhoan> getAll() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(select_all);
            while (rs.next()) {
                list.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String them = "insert taikhoan values(?,?,?)";

    public Boolean them(TaiKhoan taiKhoan) {
        try {
            if (DBConnection.ExcuteQuery(
                    them,
                    taiKhoan.getUserName(),
                    taiKhoan.getPassword(),
                    taiKhoan.getLoaiTk()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String sua = "update taikhoan set password=?,loaitk=? where username=?";

    public Boolean sua(TaiKhoan taiKhoan,String username) {
        try {
            if (DBConnection.ExcuteQuery(
                    sua,
                    taiKhoan.getPassword(),
                    taiKhoan.getLoaiTk(),
                    username) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String xoa = "delete taikhoan where username=?";

    public Boolean xoa(String username) {
        try {
            if (DBConnection.ExcuteQuery(
                    xoa,
                    username) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) {
        TaiKhoanRepository taiKhoanRepository=new TaiKhoanRepository();
        System.out.println(taiKhoanRepository.dangNhap(new TaiKhoan("duc11","11", "khachhang")).toString());
    }
}
