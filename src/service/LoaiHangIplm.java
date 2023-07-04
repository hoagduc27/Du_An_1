/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.LoaiHangDomainModel;
import repository.LoaiHangRepository;
import service.Interface.LoaiHangServices;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class LoaiHangIplm implements LoaiHangServices {

    private LoaiHangRepository rep = new LoaiHangRepository();

    @Override
    public List<LoaiHangDomainModel> getAll() {
        return rep.getAll();
    }

    @Override
    public String add(LoaiHangDomainModel lh) {
        if(lh.getTenLoai().trim().isEmpty()){
            return "Loại hàng không được để trống";
        }
        List<LoaiHangDomainModel>list = rep.getAll();
        for (LoaiHangDomainModel x : list) {
            if(x.getTenLoai().equalsIgnoreCase(lh.getTenLoai())){
                return "trùng mã";
            }
        }
        boolean add = rep.add(lh);
        if (add) {
            return "Them thong tin loai hang thanh cong";
        } else {
            return "Them thong tin loai hang that bai";
        }
    }

    @Override
    public String update(LoaiHangDomainModel lh, String ma) {
        boolean update = rep.update(lh, ma);
        if (update) {
            return "Cap nhat thong tin loai hang thanh cong";
        } else {
            return "Cap nhat thong tin loai hang that bai";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = rep.delete(ma);
        if (delete) {
            return "Xoa thong tin loai hang thanh cong";
        } else {
            return "Xoa thong tin loai hang that bai";
        }
    }

    @Override
    public ArrayList<String> getListTenLoai() {
        return rep.getListTenLoaiHang();
    }

}
