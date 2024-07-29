/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Tran Viet Phuc
 */
public class dto_ThuongHieu {

    private String maThuongHieu;
    private String tenThuongHieu;

    public dto_ThuongHieu(String maThuongHieu, String tenThuongHieu) {
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public dto_ThuongHieu() {
    }

    @Override
    public String toString() {
        return tenThuongHieu; // Hiển thị tên thương hiệu trong combobox
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }
}
