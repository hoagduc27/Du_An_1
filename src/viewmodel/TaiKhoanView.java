/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author TRUNG DUC
 */
public class TaiKhoanView {

    public String userName, password, loaiTk;

    public TaiKhoanView() {
    }

    public TaiKhoanView(String userName, String password, String loaiTk) {
        this.userName = userName;
        this.password = password;
        this.loaiTk = loaiTk;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoaiTk() {
        return loaiTk;
    }

    public void setLoaiTk(String loaiTk) {
        this.loaiTk = loaiTk;
    }

    @Override
    public String toString() {
        return "TaiKhoanView{" + "userName=" + userName + ", password=" + password + ", loaiTk=" + loaiTk + '}';
    }

}
