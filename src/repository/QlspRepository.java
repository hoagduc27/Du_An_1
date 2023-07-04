/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChatLieuDomainModel;
import domainmodel.Ctsp;
import domainmodel.KichCoDomainModel;
import domainmodel.LoaiHangDomainModel;
import domainmodel.MauSacDomainModel;
import domainmodel.SanPham;
import ulities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author TRUNG DUC
 */
public class QlspRepository {

    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    final String get_all = "select MaCTSP, CHITIETSP.MaSP, SANPHAM.TenSP, MAUSAC.TenMS, CHATLIEU.TenCL, KICHCO.TenKC, LOAIHANG.TenLoai, Soluong, DonGia, MoTa, TrangThai from CHITIETSP\n"
            + "	join SANPHAM on SANPHAM.MAsp = CHITIETSP.MaSP\n"
            + "	join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
            + "	join CHATLIEU on CHATLIEU.macl = CHITIETSP.Macl\n"
            + "	join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
            + "	join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai";

    public ArrayList<Ctsp> getAll() {
        ArrayList<Ctsp> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(get_all);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getInt(2));
                sp.setTenSp(rs.getString(3));
                MauSacDomainModel ms = new MauSacDomainModel(0, rs.getString(4));
                ChatLieuDomainModel cl = new ChatLieuDomainModel(0, rs.getString(5));
                KichCoDomainModel kc = new KichCoDomainModel(0, rs.getString(6));
                LoaiHangDomainModel lh = new LoaiHangDomainModel(0, rs.getString(7));
                list.add(new Ctsp(
                        rs.getInt(1),
                        sp,
                        ms,
                        lh,
                        cl,
                        kc,
                        rs.getInt(8),
                        rs.getFloat(9),
                        rs.getString(10),
                        rs.getInt(11)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String count_ctsp = "select count(mactsp) from chitietsp join sanpham on chitietsp.masp = sanpham.masp where tensp=? ";

    public int count_ctsp(String ten) {
        ArrayList<Ctsp> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(count_ctsp, ten);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    final String check_ton_tai_ctsp = "select mactsp from CHITIETSP \n"
            + " join sanpham on sanpham.masp = chitietsp.masp"
            + "	join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
            + "	join CHATLIEU on CHATLIEU.macl = CHITIETSP.Macl\n"
            + "	join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
            + "	join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai "
            + " where tensp=? and tenms=? and tencl=? and tenkc=? and tenloai=?";

    public Boolean check_ton_tai_ctsp(Ctsp ctsp) {
        ArrayList<Ctsp> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(
                    check_ton_tai_ctsp,
                    ctsp.getSp().getTenSp(),
                    ctsp.getMs().getTenMau(),
                    ctsp.getCl().getTenCL(),
                    ctsp.getKc().getTenKC(),
                    ctsp.getLoai().getTenLoai());
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    final String them_ctsp = "insert chitietsp values(?,?,?,?,?,?,?,?,?)";

    public Boolean them_ctsp(Ctsp ctsp) {
        try {
            if (DBConnection.ExcuteQuery(them_ctsp,
                    ctsp.getSp().getMaSp(),
                    ctsp.getMs().getMaMau(),
                    ctsp.getLoai().getMaLoai(),
                    ctsp.getCl().getMaCL(),
                    ctsp.getKc().getMaKC(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa(),
                    ctsp.getTrangThai()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    final String sua_ctsp = "update chitietsp set mams=?,maloai=?,macl=?,makc=?,"
            + "soluong=?,dongia=?,mota=?,trangthai=? where mactsp=?";

    public Boolean sua_ctsp(Ctsp ctsp) {
        try {
            if (DBConnection.ExcuteQuery(sua_ctsp,
                    ctsp.getMs().getMaMau(),
                    ctsp.getLoai().getMaLoai(),
                    ctsp.getCl().getMaCL(),
                    ctsp.getKc().getMaKC(),
                    ctsp.getSoLuong(),
                    ctsp.getDonGia(),
                    ctsp.getMoTa(),
                    ctsp.getTrangThai(),
                    ctsp.getMaCtsp()) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean them_sp_ctsp(SanPham sp, Ctsp ctsp) {
        try {
            if (new SanPhamRepository().them_sp(sp) && them_ctsp(ctsp)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    final String xoa = "delete chitietsp where mactsp=?";
    final String xoa2 = "delete chitietsp where mactsp=? "
            + " delete sanpham where tensp=?";

    public Boolean xoa(Ctsp ctsp) {
        try {
            int kq = count_ctsp(ctsp.getSp().getTenSp());
            if (kq == 1) {
                if (DBConnection.ExcuteQuery(xoa2, ctsp.getMaCtsp(), ctsp.getSp().getTenSp()) == 0) {
                    return false;
                }
                return true;
            }
            if (kq > 1) {
                if (DBConnection.ExcuteQuery(xoa, ctsp.getMaCtsp()) == 0) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Ctsp> boLoc(ArrayList<String> list) {
        ArrayList<Ctsp> ctsps = new ArrayList<>();
        String query = "select MaCTSP, CHITIETSP.MaSP, SANPHAM.TenSP, MAUSAC.TenMS, CHATLIEU.TenCL, KICHCO.TenKC, LOAIHANG.TenLoai, SoLuong, DonGia, MoTa, TrangThai from CHITIETSP \n"
                + "	join SANPHAM on SANPHAM.MaSP = CHITIETSP.MaSP\n"
                + "	join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
                + "	join CHATLIEU on CHATLIEU.MaCL = CHITIETSP.MaCL\n"
                + "	join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
                + "	join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai where " + list.get(0);
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                query += " and " + list.get(i);
            }
        }
        System.out.println(query);
        try {
            ResultSet rs = DBConnection.getDataFromQuery(query);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getInt(2));
                sp.setTenSp(rs.getString(3));
                MauSacDomainModel ms = new MauSacDomainModel(0, rs.getString(4));
                ChatLieuDomainModel cl = new ChatLieuDomainModel(0, rs.getString(5));
                KichCoDomainModel kc = new KichCoDomainModel(0, rs.getString(6));
                LoaiHangDomainModel lh = new LoaiHangDomainModel(0, rs.getString(7));
                ctsps.add(new Ctsp(
                        rs.getInt(1),
                        sp,
                        ms,
                        lh,
                        cl,
                        kc,
                        rs.getInt(8),
                        rs.getFloat(9),
                        rs.getString(10),
                        rs.getInt(11)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ctsps;
    }

    final String get_allsp_gdbh = "select MaCTSP, CHITIETSP.MaSP, SANPHAM.TenSP, MAUSAC.TenMS, CHATLIEU.TenCL, KICHCO.TenKC, LOAIHANG.TenLoai, soluong, DonGia, MoTa, TrangThai from CHITIETSP\n"
            + " join SANPHAM on SANPHAM.MaSP = CHITIETSP.MaSP\n"
            + " join MAUSAC on MAUSAC.MaMS = CHITIETSP.MaMS\n"
            + " join CHATLIEU on CHATLIEU.MaCL = CHITIETSP.MaCL\n"
            + " join KICHCO on KICHCO.MaKC = CHITIETSP.MaKC\n"
            + " join LOAIHANG on LOAIHANG.MaLoai = CHITIETSP.MaLoai "
            + " where TrangThai=1";

    public ArrayList<Ctsp> getAllSpGdbh() {
        ArrayList<Ctsp> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getDataFromQuery(get_allsp_gdbh);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getInt(2));
                sp.setTenSp(rs.getString(3));
                MauSacDomainModel ms = new MauSacDomainModel(0, rs.getString(4));
                ChatLieuDomainModel cl = new ChatLieuDomainModel(0, rs.getString(5));
                KichCoDomainModel kc = new KichCoDomainModel(0, rs.getString(6));
                LoaiHangDomainModel lh = new LoaiHangDomainModel(0, rs.getString(7));
                list.add(new Ctsp(
                        rs.getInt(1),
                        sp,
                        ms,
                        lh,
                        cl,
                        kc,
                        rs.getInt(8),
                        rs.getFloat(9),
                        rs.getString(10),
                        rs.getInt(11)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    final String sua_so_luong = "update chitietsp set soluong=soluong+? where mactsp=?";

    public Boolean sua_so_luong(int sl, String mactsp) {
        try {
            if (DBConnection.ExcuteQuery(sua_so_luong, sl, mactsp) == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
    
    
    final String dem_sl_ctsp = "select soluong  from CHITIETSP where mactsp=?";

    public int dem_sl_ctsp(String mactsp) {
        try {
            ResultSet rs=DBConnection.getDataFromQuery(dem_sl_ctsp,mactsp);
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
    
    public List<Ctsp> getAllload() {
        List<Ctsp> listct = new ArrayList<>();
        String query = "SELECT [MaCTSP]\n"
                + "      ,[MaSP]\n"
                + "      ,[MaMS]\n"
                + "      ,[MaLoai]\n"
                + "      ,[MaCL]\n"
                + "      ,[MaKC]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "      ,[MoTa]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[CHITIETSP]";
        try ( Connection con = DBConnection.openDbConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ctsp ct = new Ctsp();
                ct.setMaCtsp(rs.getInt(1));
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getInt(2));
                ct.setSp(sp);
                LoaiHangDomainModel loai = new LoaiHangDomainModel();
                loai.setMaLoai(rs.getInt(4));
                ct.setLoai(loai);
                MauSacDomainModel ms = new MauSacDomainModel();
                ms.setMaMau(rs.getInt(3));
                ct.setMs(ms);
                ChatLieuDomainModel cl = new ChatLieuDomainModel();
                cl.setMaCL(rs.getInt(5));
                ct.setCl(cl);
                KichCoDomainModel kc = new KichCoDomainModel();
                kc.setMaKC(rs.getInt(6));
                ct.setKc(kc);
                ct.setSoLuong(rs.getInt(7));
                ct.setDonGia(rs.getFloat(8));
                ct.setMoTa(rs.getString(9));
                ct.setTrangThai(rs.getInt(10));
                listct.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listct;
    }
}
