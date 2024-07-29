package BUS;

import DAO.dao_SanPham;
import DTO.dto_SanPham;
import DAO.dao_LoaiSanPham;
import DTO.dto_LoaiSanPham;
import DAO.dao_MauSac;
import DTO.dto_MauSac;
import DAO.dao_ThuongHieu;
import DTO.dto_ThuongHieu;

public class bus_ChiTietSanPham {

    public String MaSanPham;
    public String TenSanPham;
    public String GiaBan;
    public String LoaiSanPham;
    public String SoLuong;
    public String Size;
    public String ThuongHieu;
    public String HinhAnh;
    public String MoTa;
    public String MauSac;

    public void hienThiChiTietSanPham(String maSanPham) {
        // Tạo đối tượng DAO
        dao_SanPham sanPhamDAO = new dao_SanPham();
        dao_LoaiSanPham loaiSanPhamDAO = new dao_LoaiSanPham();
        dao_MauSac mauSacDAO = new dao_MauSac();
        dao_ThuongHieu thuongHieuDAO = new dao_ThuongHieu();

        // Lấy thông tin sản phẩm từ DAO
        dto_SanPham sanPham = sanPhamDAO.getSanPhamById(maSanPham);

        if (sanPham != null) {
            // Gán thông tin sản phẩm vào các thuộc tính của lớp
            MaSanPham = sanPham.getMaSanPham();
            TenSanPham = sanPham.getTenSanPham();
            GiaBan = String.valueOf(sanPham.getGiaBan());
            SoLuong = String.valueOf(sanPham.getSoLuong());
            Size = String.valueOf(sanPham.getSize());
            HinhAnh = String.valueOf(sanPham.getHinhAnh());
            MoTa = String.valueOf(sanPham.getMoTa());

            // Lấy thông tin loại sản phẩm
            dto_LoaiSanPham loaiSanPham = loaiSanPhamDAO.getLoaiSanPhamById(sanPham.getMaLoaiSanPham());
            LoaiSanPham = loaiSanPham != null ? loaiSanPham.getTenLoaiSanPham() : "Không xác định";

            // Lấy thông tin thương hiệu
            dto_ThuongHieu thuongHieu = thuongHieuDAO.getThuongHieuById(sanPham.getMaThuongHieu());
            ThuongHieu = thuongHieu != null ? thuongHieu.getTenThuongHieu() : "Không xác định";

            // Lấy thông tin màu sắc
            dto_MauSac mauSac = mauSacDAO.getMauSacById(sanPham.getMaMauSac());
            MauSac = mauSac != null ? mauSac.getTenMauSac() : "Không xác định";
        } else {
            System.out.println("Không tìm thấy sản phẩm với mã: " + maSanPham);
        }
    }
    
    
}
