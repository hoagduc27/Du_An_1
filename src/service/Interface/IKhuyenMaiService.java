/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.KhuyenMai;
import java.util.ArrayList;

/**
 *
 * @author TRUNG DUC
 */
public interface IKhuyenMaiService {

    ArrayList<KhuyenMai> getAll();

    Boolean them(KhuyenMai km);

    Boolean sua(KhuyenMai km, String ma);

    Boolean xoa(String ma);

    ArrayList<String> getListMucKm();

    int tim_makm_by_muckm(String muckm);
}
