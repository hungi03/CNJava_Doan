package BUS;

import DAO.dao_SanPham;
import DTO.dto_SanPham;
import DAO.dao_LoaiSanPham;
import DTO.dto_LoaiSanPham;
import DAO.dao_MauSac;
import DTO.dto_MauSac;
import DAO.dao_ThuongHieu;
import DTO.dto_ThuongHieu;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class bus_SanPham {

    public void hienThiBangSanPham(DefaultTableModel dtm, JTable table) {
        ArrayList<dto_SanPham> listSanPham = dao_SanPham.getListSanPham();
        ArrayList<dto_LoaiSanPham> listLoaiSanPham = dao_LoaiSanPham.getListLoaiSanPham();
        ArrayList<dto_ThuongHieu> listThuongHieu = dao_ThuongHieu.getListThuongHieu();
        ArrayList<dto_MauSac> listMauSac = dao_MauSac.getListMauSac();

        dtm.addColumn("Mã sản phẩm");
        dtm.addColumn("Tên sản phẩm");
        dtm.addColumn("Giá bán");
        dtm.addColumn("Số lượng");
        dtm.addColumn("Thương hiệu");
        dtm.addColumn("Loại sản phẩm");
        dtm.addColumn("Màu sắc");

        dtm.setNumRows(listSanPham.size());
        dtm.setRowCount(0);

        for (dto_SanPham sanPham : listSanPham) {
            String maLoaiSanPham = sanPham.getMaLoaiSanPham();
            String maThuongHieu = sanPham.getMaThuongHieu();
            String maMauSac = sanPham.getMaMauSac();

            // Tìm loại sản phẩm theo mã
            String tenLoaiSanPham = listLoaiSanPham.stream()
                    .filter(lsp -> lsp.getMaLoaiSanPham().equals(maLoaiSanPham))
                    .map(dto_LoaiSanPham::getTenLoaiSanPham)
                    .findFirst()
                    .orElse("Không xác định");

            // Tìm thương hiệu theo mã
            String tenThuongHieu = listThuongHieu.stream()
                    .filter(th -> th.getMaThuongHieu().equals(maThuongHieu))
                    .map(dto_ThuongHieu::getTenThuongHieu)
                    .findFirst()
                    .orElse("Không xác định");

            // Tìm màu sắc theo mã
            String tenMauSac = listMauSac.stream()
                    .filter(ms -> ms.getMaMauSac().equals(maMauSac))
                    .map(dto_MauSac::getTenMauSac)
                    .findFirst()
                    .orElse("Không xác định");

            // Thêm hàng mới vào model
            dtm.addRow(new Object[]{
                sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getGiaBan(), sanPham.getSoLuong(),
                tenThuongHieu, tenLoaiSanPham, tenMauSac
            });
        }
        table.setModel(dtm);
    }

    public void themSanPham(dto_SanPham sanPham) {
        dao_SanPham dao = new dao_SanPham();
        dao.themSanPham(sanPham);
    }

    public boolean xoaSanPham(String maSanPham) {
        dao_SanPham sanPhamDAO = new dao_SanPham();

        // Gọi phương thức xóa sản phẩm từ DAO và nhận kết quả trả về
        boolean result = sanPhamDAO.xoaSanPham(maSanPham);

        return result;
    }

    public void capNhatSanPham(dto_SanPham sanPham) {
        dao_SanPham dao = new dao_SanPham();
        dao.capNhatSanPham(sanPham);
    }
    

}
