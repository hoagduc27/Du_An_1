/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModel.NhanVienModel;
import DomainModel.TaiKhoan;
import ViewModel.TaiKhoanView;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

/**
 *
 * @author TRUNG DUC
 */
public class TrangChu extends javax.swing.JFrame {

    public TrangChu() {
        initComponents();
    }

    NhanVienModel nvHome = new NhanVienModel();

    public TrangChu(TaiKhoanView tkv, NhanVienModel nv) {
        initComponents();
        setLocationRelativeTo(null);
        if (tkv.getLoaiTk().equalsIgnoreCase("nhanvien")) {
            btnThongKe.setEnabled(false);
            btnNhanVien.setEnabled(false);

            crudChatLieu.setEnabled(false);
            crudKichCo.setEnabled(false);
            crudLoaiHang.setEnabled(false);
            crudMauSac.setEnabled(false);
            //
            nvHome = nv;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        btnQLSP = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnNhanVien = new javax.swing.JButton();
        btnDangXuat1 = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        crudChatLieu = new javax.swing.JMenuItem();
        crudKichCo = new javax.swing.JMenuItem();
        crudMauSac = new javax.swing.JMenuItem();
        crudLoaiHang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(255, 204, 204));
        panelMenu.setLayout(new java.awt.GridLayout(8, 0));

        btnQLSP.setBackground(new java.awt.Color(153, 255, 204));
        btnQLSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/List.png"))); // NOI18N
        btnQLSP.setText("Quản lý sản phẩm");
        btnQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSPActionPerformed(evt);
            }
        });
        panelMenu.add(btnQLSP);

        btnKhachHang.setBackground(new java.awt.Color(204, 255, 204));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Users.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        panelMenu.add(btnKhachHang);

        btnHoaDon.setBackground(new java.awt.Color(204, 255, 255));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Add to basket.png"))); // NOI18N
        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        panelMenu.add(btnHoaDon);

        btnThongKe.setBackground(new java.awt.Color(255, 255, 204));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Price list.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        panelMenu.add(btnThongKe);

        btnNhanVien.setBackground(new java.awt.Color(255, 153, 153));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/User.png"))); // NOI18N
        btnNhanVien.setText("Nhân Viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        panelMenu.add(btnNhanVien);

        btnDangXuat1.setBackground(new java.awt.Color(255, 204, 255));
        btnDangXuat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconresources (1)/new-icon-16.png"))); // NOI18N
        btnDangXuat1.setText("Khuyến mãi");
        btnDangXuat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuat1ActionPerformed(evt);
            }
        });
        panelMenu.add(btnDangXuat1);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconresources (1)/Home-icon-16.png"))); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        panelMenu.add(btnDangXuat);

        panel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        panel.add(jLabel2);

        jMenu1.setText("Quản lý");

        crudChatLieu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        crudChatLieu.setText("Quản lý chất liệu");
        crudChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudChatLieuActionPerformed(evt);
            }
        });
        jMenu1.add(crudChatLieu);

        crudKichCo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        crudKichCo.setText("Quản lý kích cỡ");
        crudKichCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudKichCoActionPerformed(evt);
            }
        });
        jMenu1.add(crudKichCo);

        crudMauSac.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        crudMauSac.setText("Quản lý màu sắc");
        crudMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudMauSacActionPerformed(evt);
            }
        });
        jMenu1.add(crudMauSac);

        crudLoaiHang.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        crudLoaiHang.setText("Quản lý loại hàng");
        crudLoaiHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crudLoaiHangActionPerformed(evt);
            }
        });
        jMenu1.add(crudLoaiHang);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        panel.removeAll();
        FormQLKH f = new FormQLKH();
        panel.add(f);
        panel.setLayout(new FlowLayout());
        this.pack();
        f.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSPActionPerformed
        panel.removeAll();
        QuanLySP f = new QuanLySP();
        panel.add(f);
        panel.setLayout(new FlowLayout());
        this.pack();
        f.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnQLSPActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        panel.removeAll();
        GiaoDienBanHang f = new GiaoDienBanHang(nvHome);
        panel.add(f);
        panel.setLayout(new FlowLayout());
        this.pack();
        f.setVisible(true);
        setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        panel.removeAll();
        HDForm f = new HDForm();
        panel.add(f);
        panel.setLayout(new FlowLayout());
        this.pack();
        f.setVisible(true);
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        this.dispose();
        new FormDangNhap().setVisible(true);
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void crudLoaiHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudLoaiHangActionPerformed
        new FormLoaiHang().setVisible(true);
    }//GEN-LAST:event_crudLoaiHangActionPerformed

    private void btnDangXuat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuat1ActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
        panel.removeAll();
        FormQLNhanVien f = new FormQLNhanVien();
        panel.add(f);
        panel.setLayout(new FlowLayout());
        this.pack();
        f.setVisible(true);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void crudMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudMauSacActionPerformed
        new FormMauSac().setVisible(true);
    }//GEN-LAST:event_crudMauSacActionPerformed

    private void crudKichCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudKichCoActionPerformed
        new FormKichCo().setVisible(true);
    }//GEN-LAST:event_crudKichCoActionPerformed

    private void crudChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crudChatLieuActionPerformed
        new FormChatLieu().setVisible(true);
    }//GEN-LAST:event_crudChatLieuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TaiKhoanView tkv = new TaiKhoanView();
                tkv.setLoaiTk("nhanvien");
                NhanVienModel nv = new NhanVienModel();
                nv.setMaNV(1);
                new TrangChu(tkv, nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDangXuat1;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JButton btnQLSP;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JMenuItem crudChatLieu;
    private javax.swing.JMenuItem crudKichCo;
    private javax.swing.JMenuItem crudLoaiHang;
    private javax.swing.JMenuItem crudMauSac;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
