/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service.Interface;

import DomainModel.HDCTDomainModel;
import ViewModel.HdctView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public interface HDCTService {
    List<HDCTDomainModel> getAll();
    String Add(HDCTDomainModel hdct);
    String update(HDCTDomainModel hdct, String maHd,String maCtsp);
    String delete(String maHD, String maCTSP);
    ArrayList<HdctView> getAllHdctByMaHd(String mahd);
    Boolean checkTonTaiHdct(String mahd,String mactsp);
    float tongTienHd(String mahd);
    boolean update_so_luong(String sl, String maHd, String maCtsp);
    int demHdctByMaHd(String maHd);
}
