/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author DELL 5570
 */
public class MauSacDomainModel {

    private int maMau;
    private String tenMau;

    public MauSacDomainModel() {
    }

    public MauSacDomainModel(int maMau, String tenMau) {
        this.maMau = maMau;
        this.tenMau = tenMau;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return "MauSacDomainModel{" + "maMau=" + maMau + ", tenMau=" + tenMau + '}';
    }

    public Object[] toRowMauSacData() {
        return new Object[]{maMau, tenMau};
    }

}
