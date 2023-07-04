/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.Interface;

import domainmodel.NhanVienModel;
import java.util.List;

/**
 *
 * @author admin
 */
public interface NhanVienSer {

    List<NhanVienModel> getAll();

    String delete(String maNV);
    
    String add(NhanVienModel Nv);
    
    String Update(NhanVienModel Nv, String Ten);
    
    NhanVienModel timNvByUsername(String username);
}
