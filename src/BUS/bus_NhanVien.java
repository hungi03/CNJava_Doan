/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.dao_KhachHang;
import DAO.dao_NhanVien;
import DTO.dto_KhachHang;
import DTO.dto_NhanVien;
import java.util.List;

/**
 *
 * @author Tran Viet Phuc
 */
public class bus_NhanVien {

     private dao_NhanVien daoNhanVien = new dao_NhanVien();
     public List<dto_NhanVien> getAll() {
        return daoNhanVien.getListNhanVien();
    }
    public dto_NhanVien dangNhap(String maNhanVien, String matKhau) {
        dao_NhanVien dao = new dao_NhanVien();
        dao.dangNhap(maNhanVien, matKhau);
        return null;
    }
    
    public void themNhanVien(dto_NhanVien nhanVien) {
        dao_NhanVien dao = new dao_NhanVien();
        dao.themNhanVien(nhanVien);
    }
}
