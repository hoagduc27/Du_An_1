/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;


import viewmodel.TaiKhoanView;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public interface ITaiKhoanService {

    TaiKhoanView dangNhap(TaiKhoanView taiKhoanView);

    Boolean checkTonTai(TaiKhoanView taiKhoanView);
    
    ArrayList<TaiKhoanView> getAll();
    
    Boolean them(TaiKhoanView taiKhoanView);
    
    Boolean sua(TaiKhoanView taiKhoanView,String username);
    
    Boolean xoa(String username);
}
