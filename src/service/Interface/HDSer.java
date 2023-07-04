/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service.Interface;

import domainmodel.HoaDonModel;
import domainmodel.HoaDonModel2;
import viewmodel.hdview;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public interface HDSer {

    List<HoaDonModel> getAll();

    String suaHD(HoaDonModel Hd, String ma);

    String add(HoaDonModel Hd);

    ArrayList<hdview> getAllHdGdbh();

    boolean addByGdbh(HoaDonModel2 Hd);

    Boolean xoa(String mahd);

    Boolean sua_tt_hd(String maHd);

    ArrayList<hdview> getAllQlhd();

    ArrayList<hdview> locHd(ArrayList<String> listdk);
}
