/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.HDCTDomainModel;
import domainmodel.HoaDonModel2;
import domainmodel.KhachHangDomainModel;
import domainmodel.KhuyenMai;
import domainmodel.NhanVienModel;
import service.ChatLieuIplm;
import service.HDCTIplm;
import service.HDlmp;
import service.Interface.ChatLieuServices;
import service.Interface.HDCTService;
import service.Interface.HDSer;
import service.Interface.IKhuyenMaiService;
import service.Interface.IQlspService;
import service.Interface.ISanPhamService;
import service.Interface.KhachHangService;
import service.Interface.KichCoServices;
import service.Interface.LoaiHangServices;
import service.Interface.MauSacServices;
import service.KhachHangIplm;
import service.KhuyenMaiImpl;
import service.KichCoIplm;
import service.LoaiHangIplm;
import service.MauSacIplm;
import service.QlspImpl;
import service.SanPhamImpl;
import viewmodel.HdctView;
import viewmodel.Qlsp;
import viewmodel.hdview;
import java.awt.Font;
import java.awt.Frame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL 5570
 */
public class GiaoDienBanHang extends javax.swing.JPanel {

    private DefaultTableModel dtmSp = new DefaultTableModel();
    private DefaultTableModel dtmGh = new DefaultTableModel();
    private DefaultTableModel dtmHd = new DefaultTableModel();
    DefaultComboBoxModel dcmMucKm = new DefaultComboBoxModel();
    DefaultComboBoxModel dcmLoaiHangSerch;
    DefaultComboBoxModel dcmChatLieuSerch;
    DefaultComboBoxModel dcmSizeSearch;
    DefaultComboBoxModel dcmMauSerch;
    LoaiHangServices loaiHangServices = new LoaiHangIplm();
    MauSacServices mauSacServices = new MauSacIplm();
    ChatLieuServices chatLieuServices = new ChatLieuIplm();
    KichCoServices kichCoServices = new KichCoIplm();
    private IQlspService iQlspService = new QlspImpl();
    private HDSer HD = new HDlmp();
    KhachHangService serviceKH = new KhachHangIplm();
    IKhuyenMaiService iKhuyenMaiService = new KhuyenMaiImpl();
    HDCTService hDCTService = new HDCTIplm();

    NhanVienModel nvGdbh = new NhanVienModel();

    public GiaoDienBanHang() {
        initComponents();

        tbSanPham.setModel(dtmSp);
        String[] header = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá", "Mô Tả"};
        dtmSp.setColumnIdentifiers(header);
        tblGh.setModel(dtmGh);
        String[] header1 = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Số lượng", "Đơn giá"};
        dtmGh.setColumnIdentifiers(header1);
        tblHd.setModel(dtmHd);
        String[] header2 = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        dtmHd.setColumnIdentifiers(header2);

        loadTBSanPham(iQlspService.getAllSpGdbh());
        loadTBHoadon(HD.getAllHdGdbh());

    }

    public GiaoDienBanHang(NhanVienModel nvHome) {
        initComponents();
        txtChao.setText("^_^XIN CHÀO " + nvHome.getTenNV());
        if (nvHome.getTenNV() == null) {
            txtChao.setText("^_^XIN CHÀO QUẢN LÝ");
            btnTaoHD.setEnabled(false);
        }

        tbSanPham.setModel(dtmSp);
        String[] header = {"STT", "Mã SP", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá", "Mô Tả"};
        dtmSp.setColumnIdentifiers(header);
        tblGh.setModel(dtmGh);
        String[] header1 = {"STT", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá"};
        dtmGh.setColumnIdentifiers(header1);
        tblHd.setModel(dtmHd);
        String[] header2 = {"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        dtmHd.setColumnIdentifiers(header2);

        dcmMucKm = (DefaultComboBoxModel) cbMucKm.getModel();
        loadMucKm(iKhuyenMaiService.getListMucKm());

        nvGdbh = nvHome;

        loadTBSanPham(iQlspService.getAllSpGdbh());
        loadTBHoadon(HD.getAllHdGdbh());

        loadCbbLoaiHang(loaiHangServices.getListTenLoai());
        loadCbbChatLieu(chatLieuServices.getListTenCL());
        loadCbbSize(kichCoServices.getListTenKC());
        loadCbbMauSac(mauSacServices.getTenMS());

    }

    void loadCbbLoaiHang(ArrayList<String> list) {
        dcmLoaiHangSerch = (DefaultComboBoxModel) cbbSearchLoaiSP.getModel();
        dcmLoaiHangSerch.removeAllElements();
        dcmLoaiHangSerch.addElement("All");
        for (String s : list) {
            dcmLoaiHangSerch.addElement(s);
        }
    }

    void loadCbbChatLieu(ArrayList<String> list) {
        dcmChatLieuSerch = (DefaultComboBoxModel) cbbSearchChatLieu.getModel();
        dcmChatLieuSerch.removeAllElements();
        dcmChatLieuSerch.addElement("All");
        for (String s : list) {
            dcmChatLieuSerch.addElement(s);
        }

    }

    void loadCbbSize(ArrayList<String> list) {
        dcmSizeSearch = (DefaultComboBoxModel) cbbSearchSize.getModel();
        dcmSizeSearch.removeAllElements();
        dcmSizeSearch.addElement("All");
        for (String s : list) {
            dcmSizeSearch.addElement(s);
        }

    }

    void loadCbbMauSac(ArrayList<String> list) {
        dcmMauSerch = (DefaultComboBoxModel) cbbSearchMauSP.getModel();
        dcmMauSerch.removeAllElements();
        dcmMauSerch.addElement("All");
        for (String s : list) {
            dcmMauSerch.addElement(s);
        }

    }

    private void loadTBSanPham(ArrayList<Qlsp> list) {
        dtmSp.setRowCount(0);
        int i = 1;
        for (Qlsp qlsp : list) {
            dtmSp.addRow(new Object[]{
                i,
                qlsp.getMaSp(),
                qlsp.getMaCtsp(),
                qlsp.getTenSp(),
                qlsp.getTenMs(),
                qlsp.getTenLoai(),
                qlsp.getTenCl(),
                qlsp.getTenKc(),
                qlsp.getSoLuong(),
                qlsp.getDonGia(),
                qlsp.getMoTa()
            });
            i++;
        }
    }

    private void loadTBGioHang(ArrayList<HdctView> list) {
        dtmGh.setRowCount(0);
        int i = 1;
        for (HdctView hd : list) {
            dtmGh.addRow(new Object[]{
                i++,
                hd.getMactsp(),
                hd.getTenSp(),
                hd.getTenMs(),
                hd.getTenLoai(),
                hd.getTenCl(),
                hd.getTenKc(),
                hd.getSoLuong(),
                hd.getDonGia(),});
            //{"STT", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất Liệu", "Size", "Sl", "Giá"};
        }
    }

    private void loadTBHoadon(ArrayList<hdview> list) {
        dtmHd.setRowCount(0);
        int i = 1;
        for (hdview hdv : list) {
            dtmHd.addRow(new Object[]{
                i++,
                hdv.getMaHD(),
                hdv.getNgayTao(),
                hdv.getTenNv(),
                hdv.getTenKh(),
                hdv.getMucKm() + "%",
                hdv.hienTt()
            });
        }
//        {"STT", "Mã HĐ", "Ngày tạo", "Tên NV","Khách hàng","Mã Km", "Tình trạng"};
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSerachSp = new javax.swing.JTextField();
        btnLamMoi = new javax.swing.JButton();
        btnSearchSp = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        cbbSearchMauSP = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        cbbSearchLoaiSP = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        cbbSearchSize = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbbSearchChatLieu = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHd = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGh = new javax.swing.JTable();
        buttonCapNhat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnXoaSp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTb = new javax.swing.JLabel();
        txtMaHd = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JLabel();
        txtTenNv = new javax.swing.JLabel();
        txtTenKh = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtSearchKh = new javax.swing.JTextField();
        btnSerachKh = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtMaKh2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenKh2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtDiaChi2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSdt2 = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtNgaySinh2 = new javax.swing.JTextField();
        btnTaoHD = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnHuyDon = new javax.swing.JButton();
        cbMucKm = new javax.swing.JComboBox<>();
        txtMaKhThemHd = new javax.swing.JTextField();
        txtChao = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbSanPham);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("Tìm Kiếm");

        txtSerachSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerachSpActionPerformed(evt);
            }
        });
        txtSerachSp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerachSpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerachSpKeyReleased(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSearchSp.setText("Search");
        btnSearchSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSpActionPerformed(evt);
            }
        });

        lbl.setText("Màu SP");

        cbbSearchMauSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchMauSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchMauSPActionPerformed(evt);
            }
        });

        jLabel21.setText("Loại SP");

        cbbSearchLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel22.setText("Size");

        cbbSearchSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSearchSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSearchSizeActionPerformed(evt);
            }
        });

        jLabel23.setText("Chất liệu");

        cbbSearchChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchSp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLamMoi))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl)
                        .addGap(18, 18, 18)
                        .addComponent(cbbSearchMauSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSearchSize, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbbSearchLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSerachSp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSp)
                    .addComponent(btnLamMoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl)
                    .addComponent(cbbSearchMauSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(cbbSearchSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(cbbSearchLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbbSearchChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblHd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHdMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHd);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblGh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGh);

        buttonCapNhat.setText("Cập nhật số lượng");
        buttonCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCapNhatActionPerformed(evt);
            }
        });

        jLabel5.setText("GIỎ HÀNG");

        btnXoaSp.setText("Xóa sản phẩm");
        btnXoaSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnXoaSp)
                        .addGap(149, 149, 149)
                        .addComponent(buttonCapNhat))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCapNhat)
                    .addComponent(btnXoaSp))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("SẢN PHẨM");

        jLabel4.setText("Mã HD");

        jLabel7.setText("Ngày tạo");

        jLabel8.setText("Tên NV");

        jLabel9.setText("Tên KH");

        jLabel12.setText("Tổng tiền");

        jLabel2.setText("Tiền khách đưa");

        txtTienKhachDua.setEnabled(false);
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        jLabel10.setText("Tiền thừa");

        txtTb.setForeground(new java.awt.Color(255, 0, 51));
        txtTb.setText("Chọn hóa đơn và nhập tiền khách trả!");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTb, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHd)
                    .addComponent(txtNgayTao)
                    .addComponent(txtTenNv)
                    .addComponent(txtTenKh)
                    .addComponent(txtTienThua)
                    .addComponent(txtTongTien))
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHd))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayTao))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenNv))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKh))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTienThua))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtTongTien))
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel5);

        jLabel13.setText("Tìm KH");

        btnSerachKh.setText("Search");
        btnSerachKh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSerachKhActionPerformed(evt);
            }
        });

        jLabel14.setText("Mã KH");

        txtMaKh2.setEnabled(false);
        txtMaKh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKh2ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên KH");

        txtTenKh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKh2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Địa chỉ");

        txtDiaChi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChi2ActionPerformed(evt);
            }
        });

        jLabel17.setText("Sdt");

        txtSdt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdt2ActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel18.setText("Ngày sinh");

        txtNgaySinh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinh2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14))
                                .addGap(14, 14, 14))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(34, 34, 34))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(12, 12, 12)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txtSearchKh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTenKh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKh2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNgaySinh2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem)
                    .addComponent(btnSerachKh))
                .addGap(52, 52, 52))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSearchKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSerachKh))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaKh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenKh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtSdt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtNgaySinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách hàng", jPanel6);

        btnTaoHD.setText("Tạo hóa đơn");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnHuyDon.setText("Hủy đơn");
        btnHuyDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyDonActionPerformed(evt);
            }
        });

        cbMucKm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtMaKhThemHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhThemHdActionPerformed(evt);
            }
        });

        txtChao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtChao.setText(".");

        jLabel19.setText("Nhập mã KH");

        jLabel20.setText("Mức Km");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("HÓA ĐƠN CHỜ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtChao, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHuyDon)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaoHD)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(89, 89, 89)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnThanhToan))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKhThemHd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMucKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHD))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuyDon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThanhToan))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChao)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSerachSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerachSpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerachSpActionPerformed

    private void txtSerachSpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachSpKeyPressed

    }//GEN-LAST:event_txtSerachSpKeyPressed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadTBSanPham(iQlspService.getAllSpGdbh());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void txtMaKh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKh2ActionPerformed

    private void txtTenKh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKh2ActionPerformed

    private void txtDiaChi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChi2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChi2ActionPerformed

    private void txtSdt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdt2ActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        try {
            if (txtMaKhThemHd.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nhập mã khách hàng mua");
                return;
            }
            HoaDonModel2 hd = new HoaDonModel2();
            hd.setNgayTao(new Date());
            hd.setTrangThai(0);
            //
            KhachHangDomainModel kh = new KhachHangDomainModel();
            kh.setMaKH(Integer.parseInt(txtMaKhThemHd.getText()));
            hd.setKh(kh);
            //
            hd.setNv(nvGdbh);
            //
            KhuyenMai km = new KhuyenMai();
            int makm = Integer.parseInt(iKhuyenMaiService.getListMucKm().get(cbMucKm.getSelectedIndex()).split("-")[0]);
            km.setMaKm(makm);
            System.out.println(makm);

            hd.setKm(km);
            //
            if (HD.addByGdbh(hd)) {
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
                loadTBHoadon(HD.getAllHdGdbh());
            } else {
                JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnTaoHDActionPerformed

    public void loadMucKm(ArrayList<String> list) {
        dcmMucKm.removeAllElements();
        for (String s : list) {
            dcmMucKm.addElement(s.split("-")[1]);
        }
    }

    private void btnSerachKhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSerachKhActionPerformed
        String sdt = txtSearchKh.getText().trim();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập sdt khách hàng cần tìm");
            return;
        }
        List<KhachHangDomainModel> listKH = new ArrayList<>();
        listKH = serviceKH.Search(sdt);
        if (listKH.size() == 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
            return;
        }
        KhachHangDomainModel kh = listKH.get(0);
        txtMaKh2.setText(String.valueOf(kh.getMaKH()));
        txtTenKh2.setText(kh.getTenKH());
        txtDiaChi2.setText(kh.getDiaChi());
        txtSdt2.setText(kh.getSdt());
        txtNgaySinh2.setText(kh.getNgaySinh());
    }//GEN-LAST:event_btnSerachKhActionPerformed

    private void txtNgaySinh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinh2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinh2ActionPerformed

    private void txtMaKhThemHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhThemHdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhThemHdActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        String tenKH = txtTenKh2.getText().trim();
        String diaChi = txtDiaChi2.getText().trim();
        String sdt = txtSdt2.getText().trim();
        Date ngaySinhClone;
        if (tenKH.isEmpty() || diaChi.isEmpty() || sdt.isEmpty() || txtNgaySinh2.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thông tin không được để trống");
            return;
        }

        if (!sdt.matches("0+[0-9]{9}")) {
            JOptionPane.showMessageDialog(this, "Sdt phải có 10 chữ số bắt đầu từ 0");
            return;
        }

        try {
            ngaySinhClone = new SimpleDateFormat("yyyy-mm-dd").parse(txtNgaySinh2.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải có định dạng: yyyy-mm-dd");
            return;
        }
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        String ngaySinh = df.format(ngaySinhClone);
        KhachHangDomainModel kh = new KhachHangDomainModel(tenKH, diaChi, sdt, ngaySinh);
        JOptionPane.showMessageDialog(this, serviceKH.add(tenKH, sdt, sdt, ngaySinh));
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyDonActionPerformed
        try {
            if (tblHd.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần hủy");
                return;
            }
            int rowHd = tblHd.getSelectedRow();
            String maHd = tblHd.getValueAt(rowHd, 1).toString();
            if (hDCTService.demHdctByMaHd(tblHd.getValueAt(rowHd, 1).toString()) == 0) {
                if (HD.xoa(txtMaHd.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công");
                    loadTBHoadon(HD.getAllHdGdbh());
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa hóa đơn thất bại");
                }
            } else {
                for (HdctView hdctView : hDCTService.getAllHdctByMaHd(maHd)) {
                    iQlspService.sua_so_luong(hdctView.getSoLuong(), String.valueOf(hdctView.getMactsp()));
                    hDCTService.delete(String.valueOf(hdctView.getMahd()), String.valueOf(hdctView.getMactsp()));
                }
                if (HD.xoa(txtMaHd.getText())) {
                    JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công");
                    loadTBHoadon(HD.getAllHdGdbh());
                    loadTBGioHang(hDCTService.getAllHdctByMaHd(maHd));
                    loadTBSanPham(iQlspService.getAllSpGdbh());
                    clearForm();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        }
    }//GEN-LAST:event_btnHuyDonActionPerformed

    private void tblHdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHdMouseClicked
        //{"STT", "Mã HĐ", "Ngày tạo", "Tên NV", "Khách hàng", "Mức Km", "Tình trạng"};
        int rowHd = tblHd.getSelectedRow();
        txtMaHd.setText(tblHd.getValueAt(rowHd, 1).toString());
        txtNgayTao.setText(tblHd.getValueAt(rowHd, 2).toString());
        txtTenNv.setText(tblHd.getValueAt(rowHd, 3).toString());
        txtTenKh.setText(tblHd.getValueAt(rowHd, 4).toString());

        loadTBGioHang(hDCTService.getAllHdctByMaHd(tblHd.getValueAt(rowHd, 1).toString()));
        txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));

        tbNhapTien();
    }//GEN-LAST:event_tblHdMouseClicked

    void tbNhapTien() {
        try {
            btnThanhToan.setEnabled(false);
            if (tblHd.getSelectedRow() == -1) {
                txtTienKhachDua.setEnabled(false);
            } else {
                txtTienKhachDua.setEnabled(true);
                if (txtTienKhachDua.getText().trim().isEmpty()) {
                    txtTb.setText("Nhập tiền khách trả");
                } else {
                    int tien = Integer.parseInt(txtTienKhachDua.getText());
                    float canTt = Float.parseFloat(txtTongTien.getText());
                    if (tien <= 0) {
                        txtTb.setText("Tiền khách đưa phải là nguyên dương");
                    } else if (tien < canTt) {
                        txtTb.setText("Chưa đủ");
                        txtTienThua.setText("");
                    } else {
                        txtTienThua.setText(String.valueOf(tien - canTt));
                        txtTb.setText("Xin mời thanh toán");
                        btnThanhToan.setEnabled(true);
                    }
                }
            }
        } catch (Exception e) {
            txtTb.setText("Tiền khách đưa phải là số nguyên dương");
        }
    }

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int rowHd = tblHd.getSelectedRow();
        int rowSp = tbSanPham.getSelectedRow();
        if (rowHd == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần thêm sản phẩm");
            return;
        }

        int maHd = Integer.parseInt(tblHd.getValueAt(rowHd, 1).toString());
        int maCtsp = Integer.parseInt(tbSanPham.getValueAt(rowSp, 2).toString());
        String donGia = tbSanPham.getValueAt(rowSp, 9).toString();

        if (hDCTService.checkTonTaiHdct(String.valueOf(maHd), String.valueOf(maCtsp))) {
            JOptionPane.showMessageDialog(this, "Đã có sản phẩm trong giỏ hàng");
            return;
        }

        Qlsp qlsp = getQlsp();
        int sl;
        try {
            String slClone = JOptionPane.showInputDialog(this, "Nhập số lượng mua");
            if (slClone == null) {
                return;
            }
            sl = Integer.parseInt(slClone);
            if (sl <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
                return;
            }
            if (sl > iQlspService.dem_sl_ctsp(String.valueOf(maCtsp))) {
                JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, "---Thông tin sản phẩm---\n"
                + "\nMã Sp: " + qlsp.getMaSp()
                + "\nMã ctsp: " + qlsp.getMaCtsp()
                + "\nTên sp: " + qlsp.getTenSp()
                + "\nMàu:" + qlsp.getTenMs()
                + "\nLoại hàng: " + qlsp.getTenLoai()
                + "\nChất liệu:" + qlsp.getTenCl()
                + "\nSize: " + qlsp.getTenKc()
                + "\nĐơn giá:" + qlsp.getDonGia()
                + "\nMô tả:" + qlsp.getMoTa()
                + "\nSố lượng:" + sl, "Bạn chắc chắn mua sản phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            HDCTDomainModel hd = new HDCTDomainModel(
                    maHd,
                    maCtsp,
                    //                new SimpleDateFormat("yyyy-mm-dd").parse(tblHd.getValueAt(2, rowHd).toString()),
                    null,
                    sl,
                    donGia
            );

            try {
                JOptionPane.showMessageDialog(this, hDCTService.Add(hd));
                iQlspService.sua_so_luong(-sl, String.valueOf(maCtsp));
            } catch (Exception e) {
            }
            loadTBGioHang(hDCTService.getAllHdctByMaHd(String.valueOf(maHd)));
            loadTBSanPham(iQlspService.getAllSpGdbh());
            txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(String.valueOf(maHd))));
        }
        tbNhapTien();
    }//GEN-LAST:event_tbSanPhamMouseClicked

    void clearForm() {
        txtMaHd.setText("");
        txtNgayTao.setText("");
        txtTenNv.setText("");
        txtTenKh.setText("");
        txtTongTien.setText("0");
    }

    Qlsp getQlsp() {
        int rowSp = tbSanPham.getSelectedRow();
        Qlsp qlsp = new Qlsp();
        qlsp.setMaSp(Integer.parseInt(tbSanPham.getValueAt(rowSp, 1).toString()));
        qlsp.setMaCtsp(Integer.parseInt(tbSanPham.getValueAt(rowSp, 2).toString()));
        qlsp.setTenSp(tbSanPham.getValueAt(rowSp, 3).toString());
        qlsp.setTenMs(tbSanPham.getValueAt(rowSp, 4).toString());
        qlsp.setTenLoai(tbSanPham.getValueAt(rowSp, 5).toString());
        qlsp.setTenCl(tbSanPham.getValueAt(rowSp, 6).toString());
        qlsp.setTenKc(tbSanPham.getValueAt(rowSp, 7).toString());
        qlsp.setSoLuong(Integer.parseInt(tbSanPham.getValueAt(rowSp, 8).toString()));
        qlsp.setDonGia(Float.parseFloat(tbSanPham.getValueAt(rowSp, 9).toString()));
        qlsp.setMoTa(tbSanPham.getValueAt(rowSp, 10).toString());
        return qlsp;
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int rowHd = tblHd.getSelectedRow();
        if (rowHd == -1) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn cần thanh toán");
            return;
        }
        ArrayList<HdctView> list = hDCTService.getAllHdctByMaHd(tblHd.getValueAt(rowHd, 1).toString());
        String tb = String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n",
                "Mã ctsp ", "Tên sp", "Màu",
                "Loại", "Chất liệu", "Size",
                "Số lượng", "Đơn giá", "Tổng");
        for (HdctView hdct : list) {
            float tong = hdct.getDonGia() * hdct.getSoLuong();
            tb += String.format("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10.2f %-10.2f\n",
                    hdct.getMactsp(), hdct.getTenSp(), hdct.getTenMs(),
                    hdct.getTenLoai(), hdct.getTenCl(), hdct.getTenKc(),
                    hdct.getSoLuong(), hdct.getDonGia(), tong);
        }
        tb += "Phải trả: " + String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString()));
        JTextArea messageTextArea = new JTextArea(tb);
        messageTextArea.setFont(new Font("Consolas", Font.PLAIN, 20));
        messageTextArea.setEditable(false);
        messageTextArea.setOpaque(false);
        if (JOptionPane.showConfirmDialog(this,
                messageTextArea,
                "Bạn chắc chắn thanh toán không?", JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION) {
            try {
                if (HD.sua_tt_hd(tblHd.getValueAt(rowHd, 1).toString())) {
                    JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                    loadTBHoadon(HD.getAllHdGdbh());
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi thanh toán");
            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnXoaSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSpActionPerformed
        int rowGh = tblGh.getSelectedRow();
        int rowHd = tblHd.getSelectedRow();
        if (rowGh == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa");
            return;
        }
        String maHd = tblHd.getValueAt(rowHd, 1).toString();
        String maHdct = tblGh.getValueAt(rowGh, 1).toString();

        int sl = Integer.parseInt(tblGh.getValueAt(rowGh, 7).toString());
        try {
            iQlspService.sua_so_luong(sl, tblGh.getValueAt(rowGh, 1).toString());
            hDCTService.delete(maHd, maHdct);
            loadTBGioHang(hDCTService.getAllHdctByMaHd(maHd));
            loadTBSanPham(iQlspService.getAllSpGdbh());
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công");
        } catch (Exception e) {
        }
        txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));

        tbNhapTien();
    }//GEN-LAST:event_btnXoaSpActionPerformed

    private void buttonCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCapNhatActionPerformed
        int rowGh = tblGh.getSelectedRow();
        int rowHd = tblHd.getSelectedRow();
        if (rowGh == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cập nhật số lượng");
            return;
        }
        String maHd = tblHd.getValueAt(rowHd, 1).toString();
        String maHdct = tblGh.getValueAt(rowGh, 1).toString();

        int slMoi;
        try {
            String slClone = JOptionPane.showInputDialog(this, "Nhập số lượng");
            if (slClone == null) {
                return;
            }
            slMoi = Integer.parseInt(slClone);
            if (slMoi <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
                return;
            }
            if (slMoi > (iQlspService.dem_sl_ctsp(maHdct) + Integer.parseInt(tblGh.getValueAt(rowHd, 7).toString()))) {
                JOptionPane.showMessageDialog(this, "Số lượng trong kho không đủ ");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng nguyên dương");
            return;
        }
        int slCu = Integer.parseInt(tblGh.getValueAt(rowGh, 7).toString());
        try {
            hDCTService.update_so_luong(String.valueOf(slMoi), maHd, maHdct);
            iQlspService.sua_so_luong(slCu - slMoi, tblGh.getValueAt(rowGh, 1).toString());
            txtTongTien.setText(String.valueOf(hDCTService.tongTienHd(tblHd.getValueAt(rowHd, 1).toString())));
            loadTBGioHang(hDCTService.getAllHdctByMaHd(maHd));
            loadTBSanPham(iQlspService.getAllSpGdbh());
            JOptionPane.showMessageDialog(this, "Sửa số lượng thành công");
        } catch (Exception e) {
        }

        tbNhapTien();
    }//GEN-LAST:event_buttonCapNhatActionPerformed

    private void txtSerachSpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerachSpKeyReleased

    }//GEN-LAST:event_txtSerachSpKeyReleased

    private void btnSearchSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSpActionPerformed

        ArrayList<String> list = new ArrayList<>();
        if (txtSerachSp.getText().trim().isEmpty()
                && cbbSearchMauSP.getSelectedItem().toString().equalsIgnoreCase("All")
                && cbbSearchLoaiSP.getSelectedItem().toString().equalsIgnoreCase("All")
                && cbbSearchSize.getSelectedItem().toString().equalsIgnoreCase("All")
                && cbbSearchChatLieu.getSelectedItem().toString().equalsIgnoreCase("All")) {
            loadTBSanPham(iQlspService.getAll());
            return;
        }

        if (!txtSerachSp.getText().trim().isEmpty()) {
            list.add("sanpham.Masp=" + txtSerachSp.getText() + " ");
        }
        if (!cbbSearchMauSP.getSelectedItem().toString().equalsIgnoreCase("All")) {
            list.add(" Tenms=N'" + cbbSearchMauSP.getSelectedItem().toString() + "' ");
        }
        if (!cbbSearchLoaiSP.getSelectedItem().toString().equalsIgnoreCase("All")) {
            list.add(" tenloai=N'" + cbbSearchLoaiSP.getSelectedItem().toString() + "' ");
        }
        if (!cbbSearchSize.getSelectedItem().toString().equalsIgnoreCase("All")) {
            list.add(" tenkc=N'" + cbbSearchSize.getSelectedItem().toString() + "' ");
        }
        if (!cbbSearchChatLieu.getSelectedItem().toString().equalsIgnoreCase("All")) {
            list.add(" tencl=N'" + cbbSearchChatLieu.getSelectedItem().toString() + "' ");
        }
        ArrayList<Qlsp> listRs = iQlspService.boLoc(list);
        if (listRs.size() == 0) {
            JOptionPane.showMessageDialog(this, "Thông tin cần tìm không có");
            return;
        } else {
            loadTBSanPham(listRs);
        }    }//GEN-LAST:event_btnSearchSpActionPerformed

    private void tblGhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGhMouseClicked

    private void cbbSearchMauSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchMauSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchMauSPActionPerformed

    private void cbbSearchSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSearchSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSearchSizeActionPerformed

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        tbNhapTien();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuyDon;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSearchSp;
    private javax.swing.JButton btnSerachKh;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaSp;
    private javax.swing.JButton buttonCapNhat;
    private javax.swing.JComboBox<String> cbMucKm;
    private javax.swing.JComboBox<String> cbbSearchChatLieu;
    private javax.swing.JComboBox<String> cbbSearchLoaiSP;
    private javax.swing.JComboBox<String> cbbSearchMauSP;
    private javax.swing.JComboBox<String> cbbSearchSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTable tblGh;
    private javax.swing.JTable tblHd;
    private javax.swing.JLabel txtChao;
    private javax.swing.JTextField txtDiaChi2;
    private javax.swing.JLabel txtMaHd;
    private javax.swing.JTextField txtMaKh2;
    private javax.swing.JTextField txtMaKhThemHd;
    private javax.swing.JTextField txtNgaySinh2;
    private javax.swing.JLabel txtNgayTao;
    private javax.swing.JTextField txtSdt2;
    private javax.swing.JTextField txtSearchKh;
    private javax.swing.JTextField txtSerachSp;
    private javax.swing.JLabel txtTb;
    private javax.swing.JLabel txtTenKh;
    private javax.swing.JTextField txtTenKh2;
    private javax.swing.JLabel txtTenNv;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JLabel txtTienThua;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
