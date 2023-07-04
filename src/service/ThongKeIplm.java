/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.SanPham;
import repository.ThongKeRepository;
import service.Interface.ThongKeService;
import viewmodel.DoanhThuView;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class ThongKeIplm implements ThongKeService{
    private ThongKeRepository rp = new ThongKeRepository();

    @Override
    public DoanhThuView getThongKe(String conditions) {
        return rp.getThongKe(conditions);
    }

    @Override
    public List<SanPham> getSanPham(String conditions) {
        return rp.getSanPham(conditions);
    }
    
}
