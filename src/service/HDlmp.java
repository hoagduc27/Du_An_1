/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.HoaDonModel;
import domainmodel.HoaDonModel2;
import repository.HDRepos;
import service.Interface.HDSer;
import viewmodel.hdview;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class HDlmp implements HDSer {

    private HDRepos HDr = new HDRepos();

    @Override
    public List<HoaDonModel> getAll() {
        return HDr.getAll();
    }

    @Override
    public String suaHD(HoaDonModel Hd, String ma) {
        boolean update = HDr.suaHD(Hd, ma);
        if (update) {
            return "Update Nv ✔️";
        } else {
            return "Update NV False !";
        }
    }

    @Override
    public String add(HoaDonModel Hd) {
        if (Hd.getNgayTao().isEmpty()) {
            return "Đang có trường để trống";
        }
        boolean add = HDr.add(Hd);
        if (add) {
            return "Thêm HD thành công !";
        } else {
            return "Thêm HD thất bại Hoặc mã HD đã tồn tại !";
        }
    }

    @Override
    public ArrayList<hdview> getAllHdGdbh() {
        ArrayList<hdview> listView = new ArrayList<>();
        ArrayList<HoaDonModel2> list = HDr.getAllHdGdbh();
        for (HoaDonModel2 hd : list) {
            listView.add(new hdview(hd.getMaHD(), hd.getNgayTao(), hd.getTrangThai(), hd.getNv().getTenNV(), hd.getKh().getTenKH(), hd.getKm().getMucKm()));
        }
        return listView;
    }

    @Override
    public boolean addByGdbh(HoaDonModel2 Hd) {
        return HDr.addByGdbh(Hd);
    }

    @Override
    public Boolean xoa(String mahd) {
        return HDr.xoa(mahd);
    }

    @Override
    public Boolean sua_tt_hd(String maHd) {
        return HDr.sua_tt_hd(maHd);
    }

    @Override
    public ArrayList<hdview> getAllQlhd() {
        ArrayList<hdview> listView = new ArrayList<>();
        ArrayList<HoaDonModel2> list = HDr.getAllQlhd();
        for (HoaDonModel2 hd : list) {
            listView.add(new hdview(hd.getMaHD(), hd.getNgayTao(), hd.getTrangThai(), hd.getNv().getTenNV(), hd.getKh().getTenKH(), hd.getKm().getMucKm()));
        }
        return listView;
    }

    @Override
    public ArrayList<hdview> locHd(ArrayList<String> listdk) {
        ArrayList<hdview> listView = new ArrayList<>();
        ArrayList<HoaDonModel2> list = HDr.locHd(listdk);
        for (HoaDonModel2 hd : list) {
            listView.add(new hdview(hd.getMaHD(), hd.getNgayTao(), hd.getTrangThai(), hd.getNv().getTenNV(), hd.getKh().getTenKH(), hd.getKm().getMucKm()));
        }
        return listView;
    }

}
