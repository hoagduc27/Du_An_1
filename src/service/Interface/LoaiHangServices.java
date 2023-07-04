/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.LoaiHangDomainModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhatc
 */
public interface LoaiHangServices {

    List<LoaiHangDomainModel> getAll();

    String add(LoaiHangDomainModel lh);

    String update(LoaiHangDomainModel lh, String ma);

    String delete(String ma);

    ArrayList<String> getListTenLoai();
}
