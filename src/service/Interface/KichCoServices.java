/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.Interface;

import domainmodel.KichCoDomainModel;
import service.KichCoIplm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5570
 */
public interface KichCoServices {
    List<KichCoDomainModel> getAll();
    String add(KichCoDomainModel kc);
    String update(KichCoDomainModel kc, String ma);
    String delete(String ma);
    ArrayList<String>getListTenKC();
     public static void main(String[] args) {
         KichCoServices kcsv = new KichCoIplm();
         System.out.println(kcsv.getListTenKC());
     }
}

