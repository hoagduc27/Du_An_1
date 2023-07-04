/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.ChatLieuDomainModel;
import repository.ChatLieuRepository;
import service.Interface.ChatLieuServices;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuIplm implements ChatLieuServices {

    private ChatLieuRepository res = new ChatLieuRepository();

    @Override
    public List<ChatLieuDomainModel> getAll() {
        return res.getAll();
    }
    
    @Override
    public String add(ChatLieuDomainModel cl) {
        if(cl.getTenCL().trim().isEmpty()){
            return "Chất liệu không được để trống";
        }
        List<ChatLieuDomainModel>list = res.getAll();
        for (ChatLieuDomainModel x : list) {
            if(x.getTenCL().equalsIgnoreCase(cl.getTenCL())){
                return "trùng mã";
            }
        }
        boolean add = res.Add(cl);
        if (add) {
            return "Add thành công";
        } else {
            return "add thất bại";
        }
    }

    @Override
    public String update(ChatLieuDomainModel cl, String ma) {
        boolean update = res.update(cl, ma);
        if (update) {
            return "update thành công";
        } else {
            return "update thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        boolean delete = res.delete(ma);
        if (delete) {
            return "delete thành công";
        } else {
            return "delete thất bại";
        }
    }

    @Override
    public ArrayList<String> getListTenCL() {
        return res.getListTenCL();
    }
     public static void main(String[] args){
        ChatLieuServices sv = new ChatLieuIplm();
        System.out.println(sv.getListTenCL());
     }
}
