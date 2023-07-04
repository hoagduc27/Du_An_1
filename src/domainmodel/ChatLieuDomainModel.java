/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author DELL 5570
 */
public class ChatLieuDomainModel {
    private int maCL;
    private String tenCL;

    public ChatLieuDomainModel() {
    }

    public ChatLieuDomainModel(String tenCL) {
        this.tenCL = tenCL;
    }

    public ChatLieuDomainModel(int maCL, String tenCL) {
        this.maCL = maCL;
        this.tenCL = tenCL;
    }

    public int getMaCL() {
        return maCL;
    }

    public void setMaCL(int maCL) {
        this.maCL = maCL;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    @Override
    public String toString() {
        return "ChatLieuDomainModel{" + "maCL=" + maCL + ", tenCL=" + tenCL + '}';
    }
    public Object[] toRowDataCL(){
        return new Object[]{maCL, tenCL};
    }
    
}
