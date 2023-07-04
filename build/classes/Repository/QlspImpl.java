/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModel.ChatLieuDomainModel;
import DomainModel.Ctsp;
import DomainModel.KichCoDomainModel;
import DomainModel.LoaiHangDomainModel;
import DomainModel.MauSacDomainModel;
import DomainModel.SanPham;
import Repository.ChatLieuRepository;
import Repository.KichCoRepository;
import Repository.LoaiHangRepository;
import Repository.MauSacRepository;
import Repository.QlspRepository;
import Repository.SanPhamRepository;
import Service.Interface.IQlspService;
import ViewModel.Qlsp;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public class QlspImpl implements IQlspService {

    QlspRepository qlspRepository;
    ChatLieuRepository chatLieuRepository;
    KichCoRepository kichCoRepository;
    LoaiHangRepository loaiHangRepository;
    MauSacRepository mauSacRepository;
    SanPhamRepository sanPhamRepository;

    public QlspImpl() {
        qlspRepository = new QlspRepository();
        chatLieuRepository = new ChatLieuRepository();
        kichCoRepository = new KichCoRepository();
        loaiHangRepository = new LoaiHangRepository();
        mauSacRepository = new MauSacRepository();
        sanPhamRepository = new SanPhamRepository();
    }

    @Override
    public ArrayList<Qlsp> getAll() {
        ArrayList<Qlsp> listView = new ArrayList<>();
        ArrayList<Ctsp> list = qlspRepository.getAll();
        for (Ctsp ctsp : list) {
            listView.add(new Qlsp(
                    ctsp.getMaCtsp(),
                    ctsp.getSp().getMaSp(),
                    ctsp.getSp().getTenSp(),
                    ctsp.getMs().getTenMau(),
                    ctsp.getCl().getTenCL(),
                    ctsp.getKc().getTenKC(),
                    ctsp.getLoai().getTenLoai(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa(),
                    ctsp.getTrangThai()
            ));
        }
        return listView;
    }

    @Override
    public Boolean them(Qlsp qlsp) {
        if (sanPhamRepository.check_ton_tai_sp(qlsp.getTenSp())) {
            Ctsp ctsp = new Ctsp();
            //
            SanPham sp = new SanPham();
            sp.setMaSp(sanPhamRepository.tim_idsp_by_ten(qlsp.getTenSp()));
            //
            MauSacDomainModel ms = new MauSacDomainModel(mauSacRepository.tim_mams_by_ten(qlsp.getTenMs()), "");
            ChatLieuDomainModel cl = new ChatLieuDomainModel(chatLieuRepository.tim_macl_by_ten(qlsp.getTenCl()), "");
            KichCoDomainModel kc = new KichCoDomainModel(kichCoRepository.tim_makc_by_ten(qlsp.getTenKc()), "");
            LoaiHangDomainModel lh = new LoaiHangDomainModel(loaiHangRepository.tim_malh_by_ten(qlsp.getTenLoai()), "");
            //
            ctsp.setSp(sp);
            ctsp.setMs(ms);
            ctsp.setCl(cl);
            ctsp.setKc(kc);
            ctsp.setLoai(lh);
            ctsp.setSoLuong(qlsp.getSoLuong());
            ctsp.setDonGia(qlsp.getDonGia());
            ctsp.setMoTa(qlsp.getMoTa());
            ctsp.setTrangThai(qlsp.getTrangThai());
            System.out.println("sv  " + ctsp.toString());
            if (qlspRepository.them_ctsp(ctsp)) {
                return true;
            } else {
                return false;
            }
        } else {
            SanPham sp = new SanPham();
            sp.setTenSp(qlsp.getTenSp());
            //
            LoaiHangDomainModel lh = new LoaiHangDomainModel();
            lh.setMaLoai(loaiHangRepository.tim_malh_by_ten(qlsp.getTenLoai()));
            //
            sp.setLoaiHang(lh);
            //
            Ctsp ctsp = new Ctsp();
            //
            if (sanPhamRepository.them_sp(sp)) {
                SanPham sp2 = new SanPham();
                sp2.setMaSp(sanPhamRepository.tim_idsp_by_ten(qlsp.getTenSp()));
                System.out.println("masp sv " + sp2.getMaSp());
                //
                MauSacDomainModel ms = new MauSacDomainModel(mauSacRepository.tim_mams_by_ten(qlsp.getTenMs()), "");
                ChatLieuDomainModel cl = new ChatLieuDomainModel(chatLieuRepository.tim_macl_by_ten(qlsp.getTenCl()), "");
                KichCoDomainModel kc = new KichCoDomainModel(kichCoRepository.tim_makc_by_ten(qlsp.getTenKc()), "");
                LoaiHangDomainModel lh2 = new LoaiHangDomainModel(loaiHangRepository.tim_malh_by_ten(qlsp.getTenLoai()), "");
                //
                ctsp.setSp(sp2);
                ctsp.setMs(ms);
                ctsp.setCl(cl);
                ctsp.setKc(kc);
                ctsp.setLoai(lh2);
                ctsp.setSoLuong(qlsp.getSoLuong());
                ctsp.setDonGia(qlsp.getDonGia());
                ctsp.setMoTa(qlsp.getMoTa());
                ctsp.setTrangThai(qlsp.getTrangThai());
                System.out.println("sv  " + ctsp.toString());
                if (qlspRepository.them_ctsp(ctsp)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean sua(Qlsp qlsp) {
        Ctsp ctsp = new Ctsp();
        //
        MauSacDomainModel ms = new MauSacDomainModel(mauSacRepository.tim_mams_by_ten(qlsp.getTenMs()), "");
        ChatLieuDomainModel cl = new ChatLieuDomainModel(chatLieuRepository.tim_macl_by_ten(qlsp.getTenCl()), "");
        KichCoDomainModel kc = new KichCoDomainModel(kichCoRepository.tim_makc_by_ten(qlsp.getTenKc()), "");
        LoaiHangDomainModel lh = new LoaiHangDomainModel(loaiHangRepository.tim_malh_by_ten(qlsp.getTenLoai()), "");
        SanPham sp = new SanPham();
        sp.setMaSp(qlsp.getMaSp());
        ctsp.setSp(sp);
        ctsp.setMs(ms);
        ctsp.setCl(cl);
        ctsp.setKc(kc);
        ctsp.setLoai(lh);
        ctsp.setSoLuong(qlsp.getSoLuong());
        ctsp.setDonGia(qlsp.getDonGia());
        ctsp.setMoTa(qlsp.getMoTa());
        ctsp.setMaCtsp(qlsp.getMaCtsp());
        ctsp.setTrangThai(qlsp.getTrangThai());
        return qlspRepository.sua_ctsp(ctsp);
    }

    @Override
    public Boolean xoa(Qlsp qlsp) {
        Ctsp ctsp = new Ctsp();
        ctsp.setMaCtsp(qlsp.getMaCtsp());
        SanPham sp = new SanPham();
        sp.setTenSp(qlsp.getTenSp());
        ctsp.setSp(sp);
        return qlspRepository.xoa(ctsp);
    }

    @Override
    public Boolean check_ton_tai_ctsp(Qlsp qlsp) {
        Ctsp ctsp = new Ctsp();
        //
        SanPham sp = new SanPham();
        sp.setTenSp(qlsp.getTenSp());
        ctsp.setSp(sp);
        //
        MauSacDomainModel ms = new MauSacDomainModel();
        ms.setTenMau(qlsp.getTenMs());
        ctsp.setMs(ms);
        //
        ChatLieuDomainModel cl = new ChatLieuDomainModel();
        cl.setTenCL(qlsp.getTenCl());
        ctsp.setCl(cl);
        //
        KichCoDomainModel kc = new KichCoDomainModel();
        kc.setTenKC(qlsp.getTenKc());
        ctsp.setKc(kc);
        //
        LoaiHangDomainModel lh = new LoaiHangDomainModel();
        lh.setTenLoai(qlsp.getTenLoai());
        ctsp.setLoai(lh);
        return qlspRepository.check_ton_tai_ctsp(ctsp);
    }

    @Override
    public ArrayList<Qlsp> boLoc(ArrayList<String> list) {
        ArrayList<Qlsp> listView = new ArrayList<>();
        ArrayList<Ctsp> ctsps = qlspRepository.boLoc(list);
        for (Ctsp ctsp : ctsps) {
            listView.add(new Qlsp(
                    ctsp.getMaCtsp(),
                    ctsp.getSp().getMaSp(),
                    ctsp.getSp().getTenSp(),
                    ctsp.getMs().getTenMau(),
                    ctsp.getCl().getTenCL(),
                    ctsp.getKc().getTenKC(),
                    ctsp.getLoai().getTenLoai(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa(),
                    ctsp.getTrangThai()
            ));
        }
        return listView;
    }

    @Override
    public ArrayList<Qlsp> getAllSpGdbh() {
        ArrayList<Qlsp> listView = new ArrayList<>();
        ArrayList<Ctsp> list = qlspRepository.getAllSpGdbh();
        for (Ctsp ctsp : list) {
            listView.add(new Qlsp(
                    ctsp.getMaCtsp(),
                    ctsp.getSp().getMaSp(),
                    ctsp.getSp().getTenSp(),
                    ctsp.getMs().getTenMau(),
                    ctsp.getCl().getTenCL(),
                    ctsp.getKc().getTenKC(),
                    ctsp.getLoai().getTenLoai(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa(),
                    ctsp.getTrangThai()
            ));
        }
        return listView;
    }

    @Override
    public Boolean sua_so_luong(int sl, String mactsp) {
        return qlspRepository.sua_so_luong(sl, mactsp);
    }

    @Override
    public int dem_sl_ctsp(String mactsp) {
        return qlspRepository.dem_sl_ctsp(mactsp);
    }
}
