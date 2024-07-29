/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.dao_KhachHang;
import DTO.dto_KhachHang;
import java.util.List;

/**
 *
 * @author AI NHI
 */
public class bus_KhachHang {
    private dao_KhachHang khachHangDAO = new dao_KhachHang();
    
    public List<dto_KhachHang> getAll() {
        return khachHangDAO.getAll();
    }

    public void add(dto_KhachHang KH) {
        khachHangDAO.add(KH);
    }

    public dto_KhachHang getOne(String maKH) {
        return khachHangDAO.getOne(maKH);
    }

    public void update(dto_KhachHang KH) {
        khachHangDAO.update(KH);
    }

    public void delete(String maKH) {
        khachHangDAO.delete(maKH);
    }

    public List<dto_KhachHang> search(String text) {
        return khachHangDAO.search(text);
    }
}
