/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRUNG DUC
 */
public interface ISanPhamService {
    ArrayList<String> getListMaSp();
    List<SanPham>getAll();
    String them_sp(SanPham sp);
    String sua_sp(SanPham sp);
}
