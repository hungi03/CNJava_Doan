/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.dao_LoaiSanPham;
import DTO.dto_LoaiSanPham;
import DTO.dto_ThuongHieu;
import java.util.List;

/**
 *
 * @author HUNG
 */
public class bus_LoaiSanPham {
    private dao_LoaiSanPham loaiSanPhamDAO = new dao_LoaiSanPham();
    
    public List<dto_LoaiSanPham> getAll() {
        return loaiSanPhamDAO.getAll();
    }
      public void add(dto_LoaiSanPham loaiSanPhamDTO) {
        loaiSanPhamDAO.add(loaiSanPhamDTO);
    }

    public void update(dto_LoaiSanPham loaiSanPhamDTO) {
        loaiSanPhamDAO.update(loaiSanPhamDTO);
    }

    public void delete(String maLoai) {
        loaiSanPhamDAO.delete(maLoai);
    }
     public boolean isDuplicateMaLoai(String maLoai) {
        return loaiSanPhamDAO.kiemTraMaLoai(maLoai);
    }

}
