/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.KhuyenMai;
import repository.KhuyenMaiRepository;
import service.Interface.IKhuyenMaiService;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class KhuyenMaiImpl implements IKhuyenMaiService {

    KhuyenMaiRepository khuyenMaiRepository;

    public KhuyenMaiImpl() {
        khuyenMaiRepository = new KhuyenMaiRepository();
    }

    @Override
    public ArrayList<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();
    }

    @Override
    public Boolean them(KhuyenMai km) {
        return khuyenMaiRepository.them(km);
    }

    @Override
    public Boolean sua(KhuyenMai km, String ma) {
        return khuyenMaiRepository.sua(km, ma);
    }

    @Override
    public Boolean xoa(String ma) {
        return khuyenMaiRepository.xoa(ma);
    }

    @Override
    public ArrayList<String> getListMucKm() {
        return khuyenMaiRepository.getListMucKm();
    }

    @Override
    public int tim_makm_by_muckm(String muckm) {
        return khuyenMaiRepository.tim_makm_by_muckm(muckm);
    }

}
