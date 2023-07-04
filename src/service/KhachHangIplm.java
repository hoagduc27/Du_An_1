/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.KhachHangDomainModel;
import repository.KhachHangRepository;
import service.Interface.KhachHangService;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author nhatc
 */
public class KhachHangIplm implements KhachHangService {

    private KhachHangRepository rp = new KhachHangRepository();

    @Override
    public List<KhachHangDomainModel> getAll() {
        return rp.getAll();
    }

    @Override
    public String add(String ten, String dc, String sdt, String ngay) {
        if (ten.isBlank() || dc.isBlank() || sdt.isBlank() || ngay.isBlank()) {
            return "Data input is blank <!>";
        } else if (ten.matches("[0-9]+") || sdt.matches("[0-9]+") == false) {
            return "Ten phai la chu\n" + "Sdt phai la so";
        } else {
            KhachHangDomainModel kh = new KhachHangDomainModel(ten, dc, sdt, ngay);
            if (rp.add(kh)) {
                return "Them khach hang thanh cong!";
            } else {
                return "Them khach hang that bai!";
            }
        }
    }

    @Override
    public List<KhachHangDomainModel> Search(String sdt) {
        return rp.Search(sdt);
    }

}
