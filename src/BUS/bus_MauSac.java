/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.dao_MauSac;
import DTO.dto_MauSac;
import DTO.dto_ThuongHieu;
import java.util.List;

/**
 *
 * @author HUNG
 */
public class bus_MauSac {

    private dao_MauSac mauSacDAO = new dao_MauSac();

    public List<dto_MauSac> getAll() {
        return mauSacDAO.getAll();
    }

    public void add(dto_MauSac mauSacDTO) {
        mauSacDAO.add(mauSacDTO);
    }

    public void update(dto_MauSac mauSacDTO) {
        mauSacDAO.update(mauSacDTO);
    }

    public void delete(String maMauSac) {
        mauSacDAO.delete(maMauSac);
    }
    public boolean isDuplicateMaMauSac(String maMau) {
        return mauSacDAO.kiemTraMaMauSac(maMau);
    }
}
