/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.HoaDonModel;
import service.HDCTIplm;
import service.HDlmp;
import service.Interface.HDCTService;
import service.Interface.HDSer;
import viewmodel.HdctView;
import viewmodel.hdview;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class HDForm extends javax.swing.JPanel {

    private DefaultTableModel dtmHd, dtmHdct;
    HDSer hdSer = new HDlmp();
    HDCTService hDCTService=new HDCTIplm();
    public HDForm() {
        initComponents();
        dtmHd = (DefaultTableModel) tblHd.getModel();
        dtmHdct = (DefaultTableModel) tblHdct.getModel();
        loadTblHd(hdSer.getAllQlhd());
    }

    void loadTblHd(ArrayList<hdview> list) {
        dtmHd.setRowCount(0);
        int i = 0;
        for (hdview hd : list) {
            dtmHd.addRow(new Object[]{
                ++i,
                hd.getMaHD(),
                hd.getTenNv(),
                hd.getTenKh(),
                hd.getNgayTao(),
                hd.getMucKm() + " %"
            });
        }
    }

    private void loadTblHdct(ArrayList<HdctView> list) {
        dtmHdct.setRowCount(0);
        int i = 1;
        for (HdctView hd : list) {
            dtmHdct.addRow(new Object[]{
                i++,
                hd.getMactsp(),
                hd.getTenSp(),
                hd.getTenMs(),
                hd.getTenLoai(),
                hd.getTenCl(),
                hd.getTenKc(),
                hd.getSoLuong(),
                hd.getDonGia(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHd = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHdct = new javax.swing.JTable();
        btnTim = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTenNv = new javax.swing.JTextField();

        tblHd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Tên Nv", "Tên Kh", "Ngày tạo", "Mức km"
            }
        ));
        tblHd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHd);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Numbered list.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        tblHdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Tên SP", "Màu", "Loại hàng", "Chất liệu", "Size", "Số lượng", "Đơn giá"
            }
        ));
        tblHdct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHdctMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHdct);

        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconresources (1)/search-icon-24.png"))); // NOI18N
        btnTim.setText("Tìm kiếm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/images/Refresh.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("BỘ LỌC");

        jLabel3.setText("Tên nv");

        jLabel4.setText("SDT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLamMoi)
                                    .addComponent(btnTim))))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLamMoi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHdMouseClicked
        int i = tblHd.getSelectedRow();
        String maHd = tblHd.getValueAt(i, 1).toString();
        loadTblHdct(hDCTService.getAllHdctByMaHd(maHd));
    }//GEN-LAST:event_tblHdMouseClicked

    private void tblHdctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHdctMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHdctMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        loadTblHd(hdSer.getAllQlhd());
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        ArrayList<String> list=new ArrayList<>();
        if(txtTenNv.getText().trim().isEmpty() && txtSdt.getText().trim().isEmpty()){
            loadTblHd(hdSer.getAllQlhd());
            return;
        }
        if(!txtTenNv.getText().trim().isEmpty()){
            list.add(" tennv like N'%"+txtTenNv.getText().trim()+"%' ");
        }
        if(!txtSdt.getText().trim().isEmpty()){
            list.add(" khachhang.sdt='"+txtSdt.getText().trim()+"' ");
        }
        
        ArrayList<hdview> listhd=hdSer.locHd(list);
        if(listhd.size()==0){
            JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn nào");
            return;
        }
        loadTblHd(listhd);
    }//GEN-LAST:event_btnTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHd;
    private javax.swing.JTable tblHdct;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNv;
    // End of variables declaration//GEN-END:variables
}
