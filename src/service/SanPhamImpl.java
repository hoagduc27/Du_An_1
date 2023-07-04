/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.SanPham;
import repository.SanPhamRepository;
import service.Interface.ISanPhamService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRUNG DUC
 */
public class SanPhamImpl implements ISanPhamService {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public ArrayList<String> getListMaSp() {
        return sanPhamRepository.getListMaSp();
    }

    public static void main(String[] args) {
        ISanPhamService sv = new SanPhamImpl();
        System.out.println(sv.getListMaSp());
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String them_sp(SanPham sp) {
        boolean add = sanPhamRepository.them_sp(sp);
        if (add) {
            return "Add thành công";
        } else {
            return "Add thất bại";
        }
    }

    @Override
    public String sua_sp(SanPham sp) {
        boolean sua = sanPhamRepository.sua_sp(sp);
        if (sua) {
            return "Sửa thành công";
        } else {
            return "Sửa thất bại";
        }
    }
}
