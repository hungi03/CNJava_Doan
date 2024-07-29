/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.dao_ThuongHieu;
import DTO.dto_ThuongHieu;
import java.util.List;

/**
 *
 * @author VAN_DAO
 */
public class bus_ThuongHieu {
    private dao_ThuongHieu dao_ThuongHieu = new dao_ThuongHieu();
    
    public List<dto_ThuongHieu> getAll() {
        return dao_ThuongHieu.getAll();
    }
    public void add(dto_ThuongHieu nhaCungCap) {
        dao_ThuongHieu.add(nhaCungCap);
    }

    public void update(dto_ThuongHieu nhaCungCap) {
        dao_ThuongHieu.update(nhaCungCap);
    }

    public void delete(String maNhaCungCap) {
        dao_ThuongHieu.delete(maNhaCungCap);
    }
    public boolean isDuplicateMaThuongHieu(String maThuongHieu) {
        return dao_ThuongHieu.kiemTraMaThuongHieu(maThuongHieu);
    }
}
