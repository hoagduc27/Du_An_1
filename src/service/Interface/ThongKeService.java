/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.SanPham;
import viewmodel.DoanhThuView;
import java.util.List;

/**
 *
 * @author nhatc
 */
public interface ThongKeService {
    DoanhThuView getThongKe(String conditions);
    
    List<SanPham> getSanPham(String conditions);
}
