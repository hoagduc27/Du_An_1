/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.MauSacDomainModel;
import repository.MauSacRepository;
import service.Interface.MauSacServices;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL 5570
 */
public class MauSacIplm implements MauSacServices {

    private MauSacRepository res = new MauSacRepository();

    @Override
    public List<MauSacDomainModel> getAll() {
        return res.getAll();
    }

    @Override
    public String add(MauSacDomainModel ms) {
        if (ms.getTenMau().trim().isEmpty()) {
            return "Không được để trống";
        }
        List<MauSacDomainModel> list = res.getAll();
        for (MauSacDomainModel x : list) {
            if (x.getTenMau().equalsIgnoreCase(ms.getTenMau())) {
                return "Màu đã tồn tại";
            }
        }
        boolean add = res.Add(ms);
        if (add) {
            return "add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String update(MauSacDomainModel ms, String ma) {
        boolean update = res.Update(ms, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = res.delete(ma);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public List<MauSacDomainModel> timkiem(String ten) {
        return res.timKiem(ten);
    }

    @Override
    public ArrayList<String> getTenMS() {
        return res.getTenMS();
    }

}
