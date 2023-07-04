/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.TaiKhoan;
import repository.TaiKhoanRepository;
import service.Interface.ITaiKhoanService;
import viewmodel.TaiKhoanView;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class TaiKhoanService implements ITaiKhoanService {

    TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanService() {
        taiKhoanRepository = new TaiKhoanRepository();
    }

    @Override
    public TaiKhoanView dangNhap(TaiKhoanView taiKhoanView) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUserName(taiKhoanView.getUserName());
        taiKhoan.setPassword(taiKhoanView.getPassword());
        TaiKhoan tk = taiKhoanRepository.dangNhap(taiKhoan);
        TaiKhoanView tkv = new TaiKhoanView(tk.getUserName(), tk.getPassword(), tk.getLoaiTk());
        return tkv;
    }

    @Override
    public Boolean checkTonTai(TaiKhoanView taiKhoanView) {
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setUserName(taiKhoanView.getUserName());
        return taiKhoanRepository.checkTonTai(taiKhoan);
    }

    @Override
    public ArrayList<TaiKhoanView> getAll() {
        ArrayList<TaiKhoanView> listView = new ArrayList<>();
        ArrayList<TaiKhoan> list = taiKhoanRepository.getAll();

        for (TaiKhoan taiKhoan : list) {
            listView.add(new TaiKhoanView(
                    taiKhoan.getUserName(),
                    taiKhoan.getPassword(),
                    taiKhoan.getLoaiTk()));
        }

        return listView;
    }

    @Override
    public Boolean them(TaiKhoanView taiKhoanView) {
        TaiKhoan taiKhoan = new TaiKhoan(
                taiKhoanView.getUserName(),
                taiKhoanView.getPassword(),
                taiKhoanView.getLoaiTk());
        return taiKhoanRepository.them(taiKhoan);
    }

    @Override
    public Boolean sua(TaiKhoanView taiKhoanView, String username) {
        TaiKhoan taiKhoan = new TaiKhoan(
                taiKhoanView.getUserName(),
                taiKhoanView.getPassword(),
                taiKhoanView.getLoaiTk());
        System.out.println(taiKhoan.toString());
        return taiKhoanRepository.sua(taiKhoan, username);
    }

    @Override
    public Boolean xoa(String username) {
        return taiKhoanRepository.xoa(username);
    }

}
