/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.Ctsp;
import viewmodel.Qlsp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRUNG DUC
 */
public interface IQlspService {
    ArrayList<Qlsp> getAll();
    ArrayList<Qlsp> getAllSpGdbh();
    Boolean them(Qlsp qlsp);
    Boolean sua(Qlsp qlsp);
    Boolean xoa(Qlsp qlsp);
    Boolean check_ton_tai_ctsp(Qlsp qlsp);
    ArrayList<Qlsp> boLoc(ArrayList<String> list);
    Boolean sua_so_luong(int sl, String mactsp);
    int dem_sl_ctsp(String mactsp);
    List<Ctsp>getAllload();
    String them_ctsp(Ctsp ctsp);
    String sua_ctsp(Ctsp ctsp);
}
