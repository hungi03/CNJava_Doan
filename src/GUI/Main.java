/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.bus_ChiTietSanPham;
import BUS.bus_KhachHang;
import BUS.bus_NhanVien;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import BUS.bus_SanPham;
import DAO.dao_KhachHang;
import DAO.dao_LoaiSanPham;
import DAO.dao_MauSac;
import DAO.dao_NhanVien;
import DAO.dao_ThuongHieu;
import DTO.dto_KhachHang;
import DTO.dto_LoaiSanPham;
import DTO.dto_MauSac;
import DTO.dto_NhaCungCap;
import DTO.dto_NhanVien;
import DTO.dto_SanPham;
import DTO.dto_ThuongHieu;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phuc
 */
public class Main extends javax.swing.JFrame {

    private bus_SanPham busSanPham;
    private String imagePath;
    File f = null;
    private DefaultTableModel tableModelNnhaCungCap;
    private bus_KhachHang khachHangBUS = new bus_KhachHang();
    private DefaultTableModel tableModelKhachHang;
    private bus_NhanVien nhanVienBUS=new bus_NhanVien();
    private DefaultTableModel tableModelNhanVien;
    
  

    public Main() {
        initComponents();
        // sản phẩm
        busSanPham = new bus_SanPham();
        hienThiBangSanPham();
        hienThiBangSanPham_PX();
        loadComboBoxData();
        Login frlg = new Login();
        frlg.dispose();

        //khách hàng
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Khởi tạo bảng dữ liệu
        tableModelNnhaCungCap = new DefaultTableModel(new Object[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Địa Chỉ"}, 0);
        //init_tbNhaCungCap();
        tableModelKhachHang = new DefaultTableModel(new Object[]{"Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Địa Chỉ"}, 0);
        init_tbKhachHang();
        xuLyTimKiem();
    }

//    private void init_tbNhaCungCap() {
//        List<dto_NhaCungCap> DSNhaCungCap = nhaCungCapBUS.getAll();
//
//        // Xóa dữ liệu cũ trên bảng
//        tableModelNnhaCungCap.setRowCount(0);
//
//        // Thêm dữ liệu mới vào bảng
//        for (NhaCungCapDTO nhaCC : DSNhaCungCap) {
//            tableModelNnhaCungCap.addRow(new Object[]{nhaCC.getMaNhaCungCap(), nhaCC.getTenNhaCungCap(), nhaCC.getSoDienThoai(), nhaCC.getDiaChi()});
//        }
//
//        tbl_NhaCungCap.setModel(tableModelNnhaCungCap);
//    }

    private void init_tbKhachHang() {
        List<dto_KhachHang> DSKhachHang = khachHangBUS.getAll();

        // Xóa dữ liệu cũ trên bảng
        tableModelKhachHang.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        for (dto_KhachHang khachHang : DSKhachHang) {
            tableModelKhachHang.addRow(new Object[]{khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getSoDienThoai(), khachHang.getDiaChi()});
        }

        tbl_KhachHang.setModel(tableModelKhachHang);
    }
      private void init_tbNhanVien() {
        List<dto_NhanVien> DSNhanVien = nhanVienBUS.getAll();

        // Xóa dữ liệu cũ trên bảng
        tableModelNhanVien.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        for (dto_NhanVien nhanVien : DSNhanVien) {
//            tbl_taikhoan.addRow(new Object[]{nhanVien.getMaNhanVien(), nhanVien.getHoTen(), 
//                nhanVien.getGioiTinh(), nhanVien.getSoDienThoai(),nhanVien.getEmail(),nhanVien.getMatKhau(),nhanVien.getPhanQuyen()});
        }

        tbl_KhachHang1.setModel(tableModelNhanVien);
    }

    private void xuLyTimKiem() {
        // Thêm DocumentListener vào JTextField
        txt_TimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChanged();
            }

            // Phương thức xử lý khi nội dung của JTextField thay đổi
            private void onTextChanged() {
                System.out.println("Text changed: " + txt_TimKiem.getText());
                List<dto_KhachHang> DSKhachHangBySearch = khachHangBUS.search(txt_TimKiem.getText());

                // Xóa dữ liệu cũ trên bảng
                tableModelNnhaCungCap.setRowCount(0);

                // Thêm dữ liệu mới vào bảng
                for (dto_KhachHang khachHang : DSKhachHangBySearch) {
                    tableModelNnhaCungCap.addRow(new Object[]{khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getSoDienThoai(), khachHang.getDiaChi()});
                }

                tbl_KhachHang.setModel(tableModelKhachHang);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        roundPanel1 = new jpanel.RoundPanel();
        btn_trangchu = new jpanel.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btn_nhacungcap = new jpanel.RoundPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_phieuxuat = new jpanel.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btn_thuoctinh = new jpanel.RoundPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btn_khachhang = new jpanel.RoundPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_taikhoan = new jpanel.RoundPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_dangxuat = new jpanel.RoundPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btn_thongke = new jpanel.RoundPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        roundPanel2 = new jpanel.RoundPanel();
        imageAvatar1 = new jpanel.ImageAvatar();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpanel_trangchu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txt_TimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_SanPham = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btn_XoaSanPham = new javax.swing.JButton();
        btn_ThemSanPham = new javax.swing.JButton();
        btn_SuaSanPham = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_TenSanPham = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txt_GiaBan = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_MoTa = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txt_Size = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txt_LoaiSanPham = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        txt_MaSanPham = new javax.swing.JTextField();
        label_HinhAnh = new javax.swing.JLabel();
        txt_SoLuong = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        cb_MauSac = new javax.swing.JComboBox<>();
        cb_ThuongHieu = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cb_Loai = new javax.swing.JComboBox<>();
        jpanel_nhacungcap = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jpanel_phieuxuat = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbl_SanPham_PX = new javax.swing.JTable();
        btn_ThemSP = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtxt_masp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtxt_Tensp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxt_giaBan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jtxt_SoLuong = new javax.swing.JTextField();
        jtxt_Loai = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jtxt_mausac = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        btn_SuaSP = new javax.swing.JButton();
        btn_xoaSP = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        roundPanel7 = new jpanel.RoundPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jcbo_KH = new javax.swing.JComboBox<>();
        jcb_NhanVien = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jtxt_ThuongHieu = new javax.swing.JTextField();
        jpanel_thuoctinh = new javax.swing.JPanel();
        roundPanel3 = new jpanel.RoundPanel();
        jLabel2 = new javax.swing.JLabel();
        roundPanel4 = new jpanel.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        roundPanel5 = new jpanel.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        roundPanel6 = new jpanel.RoundPanel();
        jLabel11 = new javax.swing.JLabel();
        jpanel_khachhang = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btn_XoaKH = new javax.swing.JButton();
        btn_ThemKH = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        jpanel_taikhoan = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btn_XoaKH1 = new javax.swing.JButton();
        btn_ThemKH1 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_KhachHang1 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        btn_XoaKH2 = new javax.swing.JButton();
        btn_ThemKH2 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl_taikhoan = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jpanel_thongke = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        roundPanel1.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel1.setRoundBottomLeft(10);
        roundPanel1.setRoundBottomRight(10);
        roundPanel1.setRoundTopLeft(10);
        roundPanel1.setRoundTopRight(10);

        btn_trangchu.setBackground(new java.awt.Color(51, 51, 51));
        btn_trangchu.setRoundBottomLeft(20);
        btn_trangchu.setRoundBottomRight(20);
        btn_trangchu.setRoundTopLeft(20);
        btn_trangchu.setRoundTopRight(20);
        btn_trangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_trangchuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_trangchuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_trangchuMouseExited(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Trang chủ");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_home.png"))); // NOI18N

        javax.swing.GroupLayout btn_trangchuLayout = new javax.swing.GroupLayout(btn_trangchu);
        btn_trangchu.setLayout(btn_trangchuLayout);
        btn_trangchuLayout.setHorizontalGroup(
            btn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_trangchuLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_trangchuLayout.setVerticalGroup(
            btn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_trangchuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel14))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_nhacungcap.setBackground(new java.awt.Color(51, 51, 51));
        btn_nhacungcap.setRoundBottomLeft(20);
        btn_nhacungcap.setRoundBottomRight(20);
        btn_nhacungcap.setRoundTopLeft(20);
        btn_nhacungcap.setRoundTopRight(20);
        btn_nhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhacungcapMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nhacungcapMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nhacungcapMouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_supplier.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nhà cung cấp");

        javax.swing.GroupLayout btn_nhacungcapLayout = new javax.swing.GroupLayout(btn_nhacungcap);
        btn_nhacungcap.setLayout(btn_nhacungcapLayout);
        btn_nhacungcapLayout.setHorizontalGroup(
            btn_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhacungcapLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_nhacungcapLayout.setVerticalGroup(
            btn_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhacungcapLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(btn_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btn_phieuxuat.setBackground(new java.awt.Color(51, 51, 51));
        btn_phieuxuat.setRoundBottomLeft(20);
        btn_phieuxuat.setRoundBottomRight(20);
        btn_phieuxuat.setRoundTopLeft(20);
        btn_phieuxuat.setRoundTopRight(20);
        btn_phieuxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_phieuxuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_phieuxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_phieuxuatMouseExited(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phiếu xuất");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_bill.png"))); // NOI18N

        javax.swing.GroupLayout btn_phieuxuatLayout = new javax.swing.GroupLayout(btn_phieuxuat);
        btn_phieuxuat.setLayout(btn_phieuxuatLayout);
        btn_phieuxuatLayout.setHorizontalGroup(
            btn_phieuxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_phieuxuatLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_phieuxuatLayout.setVerticalGroup(
            btn_phieuxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_phieuxuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_phieuxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel10))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_thuoctinh.setBackground(new java.awt.Color(51, 51, 51));
        btn_thuoctinh.setRoundBottomLeft(20);
        btn_thuoctinh.setRoundBottomRight(20);
        btn_thuoctinh.setRoundTopLeft(20);
        btn_thuoctinh.setRoundTopRight(20);
        btn_thuoctinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thuoctinhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_thuoctinhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_thuoctinhMouseExited(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Thuộc Tính");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_attribute.png"))); // NOI18N

        javax.swing.GroupLayout btn_thuoctinhLayout = new javax.swing.GroupLayout(btn_thuoctinh);
        btn_thuoctinh.setLayout(btn_thuoctinhLayout);
        btn_thuoctinhLayout.setHorizontalGroup(
            btn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_thuoctinhLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_thuoctinhLayout.setVerticalGroup(
            btn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_thuoctinhLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_khachhang.setBackground(new java.awt.Color(51, 51, 51));
        btn_khachhang.setRoundBottomLeft(20);
        btn_khachhang.setRoundBottomRight(20);
        btn_khachhang.setRoundTopLeft(20);
        btn_khachhang.setRoundTopRight(20);
        btn_khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_khachhangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_khachhangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_khachhangMouseExited(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(204, 204, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Khách hàng");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_customer.png"))); // NOI18N

        javax.swing.GroupLayout btn_khachhangLayout = new javax.swing.GroupLayout(btn_khachhang);
        btn_khachhang.setLayout(btn_khachhangLayout);
        btn_khachhangLayout.setHorizontalGroup(
            btn_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_khachhangLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_khachhangLayout.setVerticalGroup(
            btn_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_khachhangLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(btn_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_khachhangLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(16, 16, 16))))
        );

        btn_taikhoan.setBackground(new java.awt.Color(51, 51, 51));
        btn_taikhoan.setRoundBottomLeft(20);
        btn_taikhoan.setRoundBottomRight(20);
        btn_taikhoan.setRoundTopLeft(20);
        btn_taikhoan.setRoundTopRight(20);
        btn_taikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_taikhoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_taikhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_taikhoanMouseExited(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tài khoản");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_account.png"))); // NOI18N

        javax.swing.GroupLayout btn_taikhoanLayout = new javax.swing.GroupLayout(btn_taikhoan);
        btn_taikhoan.setLayout(btn_taikhoanLayout);
        btn_taikhoanLayout.setHorizontalGroup(
            btn_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_taikhoanLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_taikhoanLayout.setVerticalGroup(
            btn_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_taikhoanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btn_dangxuat.setBackground(new java.awt.Color(51, 51, 51));
        btn_dangxuat.setRoundBottomLeft(20);
        btn_dangxuat.setRoundBottomRight(20);
        btn_dangxuat.setRoundTopLeft(20);
        btn_dangxuat.setRoundTopRight(20);
        btn_dangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dangxuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dangxuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dangxuatMouseExited(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(204, 204, 204));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Đăng xuất");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_logout.png"))); // NOI18N

        javax.swing.GroupLayout btn_dangxuatLayout = new javax.swing.GroupLayout(btn_dangxuat);
        btn_dangxuat.setLayout(btn_dangxuatLayout);
        btn_dangxuatLayout.setHorizontalGroup(
            btn_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dangxuatLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_dangxuatLayout.setVerticalGroup(
            btn_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dangxuatLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_dangxuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_thongke.setBackground(new java.awt.Color(51, 51, 51));
        btn_thongke.setRoundBottomLeft(20);
        btn_thongke.setRoundBottomRight(20);
        btn_thongke.setRoundTopLeft(20);
        btn_thongke.setRoundTopRight(20);
        btn_thongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_thongkeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_thongkeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_thongkeMouseExited(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Thống kê");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_statistical.png"))); // NOI18N

        javax.swing.GroupLayout btn_thongkeLayout = new javax.swing.GroupLayout(btn_thongke);
        btn_thongke.setLayout(btn_thongkeLayout);
        btn_thongkeLayout.setHorizontalGroup(
            btn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_thongkeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        btn_thongkeLayout.setVerticalGroup(
            btn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_thongkeLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(btn_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_trangchu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nhacungcap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_phieuxuat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thuoctinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_taikhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_dangxuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_khachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_thongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_trangchu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thuoctinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_phieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_khachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_taikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btn_dangxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        roundPanel2.setBackground(new java.awt.Color(51, 51, 51));
        roundPanel2.setRoundBottomLeft(10);
        roundPanel2.setRoundBottomRight(10);
        roundPanel2.setRoundTopLeft(10);
        roundPanel2.setRoundTopRight(10);

        imageAvatar1.setForeground(new java.awt.Color(102, 204, 255));
        imageAvatar1.setBorderSize(3);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/image_example.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 750));

        jTabbedPane1.setOpaque(true);

        jpanel_trangchu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton2.setText("Làm mới");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_TimKiem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_TimKiem.setToolTipText("");
        txt_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_TimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        table_SanPham.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        table_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thương Hiệu", "Loại Sản phẩm", "Màu Sắc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_SanPham.setGridColor(new java.awt.Color(0, 0, 0));
        table_SanPham.setRowHeight(40);
        table_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_SanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_SanPham);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel4.setAlignmentX(0.0F);
        jPanel4.setAlignmentY(0.0F);

        btn_XoaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_XoaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        btn_XoaSanPham.setText("Xóa");
        btn_XoaSanPham.setBorderPainted(false);
        btn_XoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaSanPhamActionPerformed(evt);
            }
        });

        btn_ThemSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ThemSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        btn_ThemSanPham.setText("Thêm");
        btn_ThemSanPham.setBorderPainted(false);
        btn_ThemSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSanPhamActionPerformed(evt);
            }
        });

        btn_SuaSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_SuaSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_repair.png"))); // NOI18N
        btn_SuaSanPham.setText("Sửa");
        btn_SuaSanPham.setBorderPainted(false);
        btn_SuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XoaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_SuaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XoaSanPham)
                    .addComponent(btn_ThemSanPham)
                    .addComponent(btn_SuaSanPham))
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi Tiết Sản Phẩm"));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Mã Sản Phẩm");
        jPanel8.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 211, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Tên Sản Phẩm");
        jPanel8.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 211, -1));

        txt_TenSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_TenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 211, 38));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Giá Bán");
        jPanel8.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 211, -1));

        txt_GiaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_GiaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 211, 38));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Mô Tả");
        jPanel8.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 211, -1));

        txt_MoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_MoTa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 210, 60));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Loại Sản Phẩm");
        jPanel8.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 211, -1));

        txt_Size.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 211, 38));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setText("Hình Ảnh");
        jPanel8.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 211, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setText("Loại Sản Phẩm");
        jPanel8.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 211, -1));

        txt_LoaiSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_LoaiSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 376, 211, 38));

        jButton4.setBackground(new java.awt.Color(0, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Xác nhận");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 172, 56));
        jPanel8.add(txt_MaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 210, 40));

        label_HinhAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        label_HinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_HinhAnhMouseClicked(evt);
            }
        });
        jPanel8.add(label_HinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 220, 210));

        txt_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel8.add(txt_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 211, 38));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setText("Số Lượng");
        jPanel8.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 211, -1));

        cb_MauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cb_MauSac, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 210, 40));

        cb_ThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cb_ThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 210, 40));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setText("Size");
        jPanel8.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 211, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setText("Màu Sắc");
        jPanel8.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 211, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setText("Thương Hiệu");
        jPanel8.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 211, -1));

        cb_Loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel8.add(cb_Loai, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 210, 40));

        javax.swing.GroupLayout jpanel_trangchuLayout = new javax.swing.GroupLayout(jpanel_trangchu);
        jpanel_trangchu.setLayout(jpanel_trangchuLayout);
        jpanel_trangchuLayout.setHorizontalGroup(
            jpanel_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_trangchuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_trangchuLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpanel_trangchuLayout.setVerticalGroup(
            jpanel_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_trangchuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_trangchuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jpanel_trangchu);

        jpanel_nhacungcap.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.setBorderPainted(false);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        jButton5.setText("Thêm");
        jButton5.setBorderPainted(false);

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_info.png"))); // NOI18N
        jButton8.setText("Xem chi tiết");
        jButton8.setBorderPainted(false);

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_repair.png"))); // NOI18N
        jButton9.setText("Sửa");
        jButton9.setBorderPainted(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton10.setText("Làm mới");
        jButton10.setBorderPainted(false);

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setText("Nhập để tìm kiếm sản phẩm");
        jTextField2.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jpanel_nhacungcapLayout = new javax.swing.GroupLayout(jpanel_nhacungcap);
        jpanel_nhacungcap.setLayout(jpanel_nhacungcapLayout);
        jpanel_nhacungcapLayout.setHorizontalGroup(
            jpanel_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_nhacungcapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(jpanel_nhacungcapLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanel_nhacungcapLayout.setVerticalGroup(
            jpanel_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_nhacungcapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_nhacungcapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jpanel_nhacungcap);

        jpanel_phieuxuat.setBackground(new java.awt.Color(255, 255, 255));
        jpanel_phieuxuat.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton15.setText("Làm mới");
        jButton15.setBorderPainted(false);

        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Nhập để tìm kiếm sản phẩm");
        jTextField3.setToolTipText("");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jpanel_phieuxuat.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 440, -1));

        jtbl_SanPham_PX.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng", "Size", "Màu Sắc", "Thương Hiệu", "Loại"
            }
        ));
        jtbl_SanPham_PX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbl_SanPham_PXMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtbl_SanPham_PX);

        jpanel_phieuxuat.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 141, 441, 270));

        btn_ThemSP.setBackground(new java.awt.Color(0, 153, 0));
        btn_ThemSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ThemSP.setForeground(new java.awt.Color(255, 255, 255));
        btn_ThemSP.setText("Thêm Sản Phẩm");
        btn_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSPActionPerformed(evt);
            }
        });
        jpanel_phieuxuat.add(btn_ThemSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 417, 171, 45));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mã Sản Phẩm");
        jpanel_phieuxuat.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 17, 155, -1));

        jtxt_masp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_masp.setEnabled(false);
        jpanel_phieuxuat.add(jtxt_masp, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 43, 155, 38));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tên Sản Phẩm");
        jpanel_phieuxuat.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 17, 155, -1));

        jtxt_Tensp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_Tensp.setEnabled(false);
        jpanel_phieuxuat.add(jtxt_Tensp, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 43, 155, 38));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Giá Bán");
        jpanel_phieuxuat.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 87, 155, -1));

        jtxt_giaBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_giaBan.setEnabled(false);
        jpanel_phieuxuat.add(jtxt_giaBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 113, 155, 38));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Số Lượng");
        jpanel_phieuxuat.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 87, 155, -1));

        jtxt_SoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpanel_phieuxuat.add(jtxt_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 113, 155, 38));

        jtxt_Loai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_Loai.setEnabled(false);
        jpanel_phieuxuat.add(jtxt_Loai, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 155, 38));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Màu Sắc");
        jpanel_phieuxuat.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 157, 155, -1));

        jtxt_mausac.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_mausac.setEnabled(false);
        jtxt_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_mausacActionPerformed(evt);
            }
        });
        jpanel_phieuxuat.add(jtxt_mausac, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 183, 155, 38));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Thương Hiệu");
        jpanel_phieuxuat.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 155, -1));

        btn_SuaSP.setBackground(new java.awt.Color(51, 0, 204));
        btn_SuaSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_SuaSP.setForeground(new java.awt.Color(255, 255, 255));
        btn_SuaSP.setText("Sửa Sản Phẩm");
        btn_SuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSPActionPerformed(evt);
            }
        });
        jpanel_phieuxuat.add(btn_SuaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 417, 171, 45));

        btn_xoaSP.setBackground(new java.awt.Color(255, 0, 0));
        btn_xoaSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_xoaSP.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoaSP.setText("Xóa Sản Phẩm");
        btn_xoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaSPActionPerformed(evt);
            }
        });
        jpanel_phieuxuat.add(btn_xoaSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 417, 171, 45));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Loại Sản Phẩm");
        jpanel_phieuxuat.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 227, 155, -1));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Bán", "Số Lượng", "Size", "Màu Sắc", "Thương Hiệu", "Loại"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        jpanel_phieuxuat.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 468, 795, 281));

        roundPanel7.setRoundBottomLeft(50);
        roundPanel7.setRoundBottomRight(50);
        roundPanel7.setRoundTopLeft(50);
        roundPanel7.setRoundTopRight(50);

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Mã Phiếu Xuất");

        jTextField11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Nhân Viên Xuất");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Khách Hàng");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("TỔNG TIỀN :");

        jButton14.setBackground(new java.awt.Color(0, 153, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Xuất Hàng");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel7Layout = new javax.swing.GroupLayout(roundPanel7);
        roundPanel7.setLayout(roundPanel7Layout);
        roundPanel7Layout.setHorizontalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbo_KH, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField11)
                            .addGroup(roundPanel7Layout.createSequentialGroup()
                                .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addComponent(jcb_NhanVien, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        roundPanel7Layout.setVerticalGroup(
            roundPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcb_NhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbo_KH, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 419, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jpanel_phieuxuat.add(roundPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 7, -1, 740));

        jtxt_ThuongHieu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxt_ThuongHieu.setEnabled(false);
        jpanel_phieuxuat.add(jtxt_ThuongHieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 155, 38));

        jTabbedPane1.addTab("tab4", jpanel_phieuxuat);

        jpanel_thuoctinh.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel3.setBackground(new java.awt.Color(0, 102, 153));
        roundPanel3.setForeground(new java.awt.Color(255, 255, 255));
        roundPanel3.setRoundBottomLeft(100);
        roundPanel3.setRoundBottomRight(100);
        roundPanel3.setRoundTopLeft(100);
        roundPanel3.setRoundTopRight(100);
        roundPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel3MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/brand-image.png"))); // NOI18N
        jLabel2.setText("Thương Hiệu");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel4.setBackground(new java.awt.Color(0, 102, 153));
        roundPanel4.setRoundBottomLeft(100);
        roundPanel4.setRoundBottomRight(100);
        roundPanel4.setRoundTopLeft(100);
        roundPanel4.setRoundTopRight(100);
        roundPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel4MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/colour_image.png"))); // NOI18N
        jLabel4.setText("Màu sắc");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        roundPanel5.setBackground(new java.awt.Color(0, 102, 153));
        roundPanel5.setRoundBottomLeft(100);
        roundPanel5.setRoundBottomRight(100);
        roundPanel5.setRoundTopLeft(100);
        roundPanel5.setRoundTopRight(100);
        roundPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel5MouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Categories_image.png"))); // NOI18N
        jLabel7.setText("Loại Giày");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundPanel6.setBackground(new java.awt.Color(0, 102, 153));
        roundPanel6.setRoundBottomLeft(100);
        roundPanel6.setRoundBottomRight(100);
        roundPanel6.setRoundTopLeft(100);
        roundPanel6.setRoundTopRight(100);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Đang cập nhật");

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel11)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_thuoctinhLayout = new javax.swing.GroupLayout(jpanel_thuoctinh);
        jpanel_thuoctinh.setLayout(jpanel_thuoctinhLayout);
        jpanel_thuoctinhLayout.setHorizontalGroup(
            jpanel_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_thuoctinhLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jpanel_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanel_thuoctinhLayout.createSequentialGroup()
                        .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanel_thuoctinhLayout.createSequentialGroup()
                        .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jpanel_thuoctinhLayout.setVerticalGroup(
            jpanel_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_thuoctinhLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jpanel_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addGroup(jpanel_thuoctinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", jpanel_thuoctinh);

        jpanel_khachhang.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel10.setAlignmentX(0.0F);
        jPanel10.setAlignmentY(0.0F);

        btn_XoaKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_XoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        btn_XoaKH.setText("Xóa");
        btn_XoaKH.setBorderPainted(false);
        btn_XoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKHActionPerformed(evt);
            }
        });

        btn_ThemKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        btn_ThemKH.setText("Thêm");
        btn_ThemKH.setBorderPainted(false);
        btn_ThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKHActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_info.png"))); // NOI18N
        jButton18.setText("Xem chi tiết");
        jButton18.setBorderPainted(false);

        jButton19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_repair.png"))); // NOI18N
        jButton19.setText("Sửa");
        jButton19.setBorderPainted(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ThemKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XoaKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XoaKH)
                    .addComponent(btn_ThemKH)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton20.setText("Làm mới");
        jButton20.setBorderPainted(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField6.setText("Nhập để tìm kiếm sản phẩm");
        jTextField6.setToolTipText("");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton20)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField6)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tbl_KhachHang.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_KhachHang.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_KhachHang.setRowHeight(40);
        jScrollPane4.setViewportView(tbl_KhachHang);

        javax.swing.GroupLayout jpanel_khachhangLayout = new javax.swing.GroupLayout(jpanel_khachhang);
        jpanel_khachhang.setLayout(jpanel_khachhangLayout);
        jpanel_khachhangLayout.setHorizontalGroup(
            jpanel_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_khachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jpanel_khachhangLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpanel_khachhangLayout.setVerticalGroup(
            jpanel_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_khachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanel_khachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab6", jpanel_khachhang);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel12.setAlignmentX(0.0F);
        jPanel12.setAlignmentY(0.0F);

        btn_XoaKH1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_XoaKH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        btn_XoaKH1.setText("Xóa");
        btn_XoaKH1.setBorderPainted(false);
        btn_XoaKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKH1ActionPerformed(evt);
            }
        });

        btn_ThemKH1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ThemKH1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        btn_ThemKH1.setText("Thêm");
        btn_ThemKH1.setBorderPainted(false);
        btn_ThemKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKH1ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_info.png"))); // NOI18N
        jButton21.setText("Xem chi tiết");
        jButton21.setBorderPainted(false);

        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_repair.png"))); // NOI18N
        jButton22.setText("Sửa");
        jButton22.setBorderPainted(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ThemKH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XoaKH1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XoaKH1)
                    .addComponent(btn_ThemKH1)
                    .addComponent(jButton21)
                    .addComponent(jButton22))
                .addContainerGap())
        );

        tbl_KhachHang1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tbl_KhachHang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_KhachHang1.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_KhachHang1.setRowHeight(40);
        jScrollPane7.setViewportView(tbl_KhachHang1);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton23.setText("Làm mới");
        jButton23.setBorderPainted(false);
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField7.setText("Nhập để tìm kiếm sản phẩm");
        jTextField7.setToolTipText("");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton23)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField7)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel14.setAlignmentX(0.0F);
        jPanel14.setAlignmentY(0.0F);

        btn_XoaKH2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_XoaKH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_delete.png"))); // NOI18N
        btn_XoaKH2.setText("Xóa");
        btn_XoaKH2.setBorderPainted(false);
        btn_XoaKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaKH2ActionPerformed(evt);
            }
        });

        btn_ThemKH2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ThemKH2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_add.png"))); // NOI18N
        btn_ThemKH2.setText("Thêm");
        btn_ThemKH2.setBorderPainted(false);
        btn_ThemKH2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemKH2ActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_info.png"))); // NOI18N
        jButton24.setText("Xem chi tiết");
        jButton24.setBorderPainted(false);

        jButton25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_repair.png"))); // NOI18N
        jButton25.setText("Sửa");
        jButton25.setBorderPainted(false);
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_ThemKH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_XoaKH2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton24)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XoaKH2)
                    .addComponent(btn_ThemKH2)
                    .addComponent(jButton24)
                    .addComponent(jButton25))
                .addContainerGap())
        );

        tbl_taikhoan.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        tbl_taikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_taikhoan.setGridColor(new java.awt.Color(0, 0, 0));
        tbl_taikhoan.setRowHeight(40);
        jScrollPane8.setViewportView(tbl_taikhoan);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jButton26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon_refresh.png"))); // NOI18N
        jButton26.setText("Làm mới");
        jButton26.setBorderPainted(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField8.setText("Nhập để tìm kiếm sản phẩm");
        jTextField8.setToolTipText("");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButton26)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton26)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField8)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpanel_taikhoanLayout = new javax.swing.GroupLayout(jpanel_taikhoan);
        jpanel_taikhoan.setLayout(jpanel_taikhoanLayout);
        jpanel_taikhoanLayout.setHorizontalGroup(
            jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
            .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane7)
                        .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
            .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane8)
                        .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jpanel_taikhoanLayout.setVerticalGroup(
            jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpanel_taikhoanLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpanel_taikhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("tab7", jpanel_taikhoan);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel28.setText("Thong ke");

        javax.swing.GroupLayout jpanel_thongkeLayout = new javax.swing.GroupLayout(jpanel_thongke);
        jpanel_thongke.setLayout(jpanel_thongkeLayout);
        jpanel_thongkeLayout.setHorizontalGroup(
            jpanel_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_thongkeLayout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(522, Short.MAX_VALUE))
        );
        jpanel_thongkeLayout.setVerticalGroup(
            jpanel_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel_thongkeLayout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        jTabbedPane1.addTab("tab8", jpanel_thongke);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -40, 1100, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    boolean click_item_menu = true;
    private void btn_trangchuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_trangchuMouseEntered
        // TODO add your handling code here:
        btn_trangchu.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
        hienThiBangSanPham();
    }//GEN-LAST:event_btn_trangchuMouseEntered


    private void btn_trangchuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_trangchuMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_trangchu.setBackground(new Color(51, 51, 51));
        }
    }//GEN-LAST:event_btn_trangchuMouseExited

    private void btn_nhacungcapMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhacungcapMouseEntered
        // TODO add your handling code here:
        btn_nhacungcap.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_nhacungcapMouseEntered

    private void btn_nhacungcapMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhacungcapMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_nhacungcap.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_nhacungcapMouseExited

    private void btn_trangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_trangchuMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_trangchu.setBackground(new Color(52, 125, 252));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));

            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));
            btn_thongke.setBackground(new Color(51, 51, 51));

        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_trangchuMouseClicked

    private void btn_nhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhacungcapMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_nhacungcap.setBackground(new Color(52, 125, 252));
            btn_trangchu.setBackground(new Color(51, 51, 51));

            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));
            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_nhacungcapMouseClicked

    private void btn_phieuxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieuxuatMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_phieuxuat.setBackground(new Color(52, 125, 252));
            btn_trangchu.setBackground(new Color(51, 51, 51));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));

            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));
            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_phieuxuatMouseClicked

    private void btn_thuoctinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuoctinhMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_thuoctinh.setBackground(new Color(52, 125, 252));
            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_trangchu.setBackground(new Color(51, 51, 51));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));
            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_thuoctinhMouseClicked

    private void btn_phieuxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieuxuatMouseEntered
        // TODO add your handling code here:
        btn_phieuxuat.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_phieuxuatMouseEntered

    private void btn_thuoctinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuoctinhMouseEntered
        // TODO add your handling code here:
        btn_thuoctinh.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_thuoctinhMouseEntered

    private void btn_phieuxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_phieuxuatMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_phieuxuat.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_phieuxuatMouseExited

    private void btn_thuoctinhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thuoctinhMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_thuoctinhMouseExited

    private void btn_khachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachhangMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);

        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_khachhang.setBackground(new Color(52, 125, 252));

            btn_trangchu.setBackground(new Color(51, 51, 51));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));
            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));
            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_khachhangMouseClicked

    private void btn_khachhangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachhangMouseEntered
        // TODO add your handling code here:
        btn_khachhang.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_khachhangMouseEntered

    private void btn_khachhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_khachhangMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_khachhang.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_khachhangMouseExited

    private void btn_taikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taikhoanMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_taikhoan.setBackground(new Color(52, 125, 252));

            btn_trangchu.setBackground(new Color(51, 51, 51));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));
            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));

            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_taikhoanMouseClicked

    private void btn_taikhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taikhoanMouseEntered
        // TODO add your handling code here:
        btn_taikhoan.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_taikhoanMouseEntered

    private void btn_taikhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_taikhoanMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_taikhoan.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_taikhoanMouseExited

    private void btn_thongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongkeMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
        click_item_menu = true;
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_thongke.setBackground(new Color(52, 125, 252));

            btn_trangchu.setBackground(new Color(51, 51, 51));
            btn_nhacungcap.setBackground(new Color(51, 51, 51));
            btn_phieuxuat.setBackground(new Color(51, 51, 51));
            btn_thuoctinh.setBackground(new Color(51, 51, 51));
            btn_khachhang.setBackground(new Color(51, 51, 51));
            btn_taikhoan.setBackground(new Color(51, 51, 51));

        }
        click_item_menu = false;
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_thongkeMouseClicked

    private void btn_thongkeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongkeMouseEntered
        // TODO add your handling code here:
        btn_thongke.setBackground(new Color(52, 125, 252));
        click_item_menu = true;
    }//GEN-LAST:event_btn_thongkeMouseEntered

    private void btn_thongkeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_thongkeMouseExited
        // TODO add your handling code here:
        System.out.println(click_item_menu);
        if (click_item_menu) {
            btn_thongke.setBackground(new Color(51, 51, 51));
        }
        System.out.println(click_item_menu);
    }//GEN-LAST:event_btn_thongkeMouseExited

    private void btn_dangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangxuatMouseClicked
//        // TODO add your handling code here:
//        jTabbedPane1.setSelectedIndex(7);
//
//        btn_phieuxuat.setBackground(new Color(52, 125, 252));
//        btn_trangchu.setBackground(new Color(51, 51, 51));
//        btn_nhacungcap.setBackground(new Color(51, 51, 51));
//
//        btn_thuoctinh.setBackground(new Color(51, 51, 51));
//        btn_khachhang.setBackground(new Color(51, 51, 51));
//        btn_taikhoan.setBackground(new Color(51, 51, 51));
//        btn_thongke.setBackground(new Color(51, 51, 51));

        this.dispose();
        Login frm = new Login();
        frm.setVisible(true);

    }//GEN-LAST:event_btn_dangxuatMouseClicked

    private void btn_dangxuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangxuatMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dangxuatMouseEntered

    private void btn_dangxuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangxuatMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_dangxuatMouseExited

    private void btn_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemSPActionPerformed

    private void jtxt_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_mausacActionPerformed

    private void btn_SuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_SuaSPActionPerformed

    private void btn_xoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaSPActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

/////////////////////////////////////
    // sự kiện chọn hàng trong bảng sản phẩm
    private void table_SanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_SanPhamMouseClicked
        // TODO add your handling code here:
        int selectedRow = table_SanPham.getSelectedRow();
        String msSPSelected = (String) table_SanPham.getValueAt(selectedRow, 0);

        bus_ChiTietSanPham bus = new bus_ChiTietSanPham();
        bus.hienThiChiTietSanPham(msSPSelected);

        imagePath = "C:/Users/Tran Viet Phuc/Desktop/JAVA/DoAn_Java/DoAn_Java/src/images_SanPham/" + bus.HinhAnh;
        // Tạo ImageIcon từ đường dẫn của tệp hình ảnh
        ImageIcon imageIcon = new ImageIcon(imagePath);

        // Tải ảnh từ đường dẫn
        Image img = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        label_HinhAnh.setIcon(new ImageIcon(img));

        txt_MaSanPham.setText(bus.MaSanPham);
        txt_TenSanPham.setText(bus.TenSanPham);
        txt_GiaBan.setText(bus.GiaBan);
        txt_LoaiSanPham.setText(bus.LoaiSanPham);
        txt_SoLuong.setText(bus.SoLuong);
        txt_Size.setText(bus.Size);
        txt_MoTa.setText(bus.MoTa);

        // Xóa tất cả các mục trong các JComboBox trước khi thêm mới
        cb_Loai.removeAllItems();
        cb_MauSac.removeAllItems();
        cb_ThuongHieu.removeAllItems();

        // Thêm dữ liệu vào các JComboBox
        loadComboBoxData(); // Đảm bảo phương thức này chỉ thêm dữ liệu vào JComboBox

        // Thiết lập mục được chọn
        cb_Loai.setSelectedItem(bus.LoaiSanPham);
        cb_MauSac.setSelectedItem(bus.MauSac);
        cb_ThuongHieu.setSelectedItem(bus.ThuongHieu);
    }//GEN-LAST:event_table_SanPhamMouseClicked

    // nút thêm sản phẩm
    private void btn_ThemSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSanPhamActionPerformed
        // Lấy dữ liệu từ các trường nhập liệu
        String maSanPham = txt_MaSanPham.getText();
        String tenSanPham = txt_TenSanPham.getText();
        double giaBan = Double.parseDouble(txt_GiaBan.getText());
        int soLuong = Integer.parseInt(txt_SoLuong.getText());
        int size = Integer.parseInt(txt_Size.getText());
        String moTa = txt_MoTa.getText();

        // Lấy thông tin mã màu sắc từ combobox
        String selectedMauSac = (String) cb_MauSac.getSelectedItem();
        String maMauSac = timMaMauSacTheoTen(selectedMauSac);

        // Lấy thông tin mã loại sản phẩm từ combobox
        String selectedLoaiSanPham = (String) cb_Loai.getSelectedItem();
        String maLoai = timMaLoaiSanPhamTheoTen(selectedLoaiSanPham);

        // Lấy thông tin mã thương hiệu từ combobox
        String selectedThuongHieu = (String) cb_ThuongHieu.getSelectedItem();
        String maThuongHieu = timMaThuongHieuTheoTen(selectedThuongHieu);

        // Lấy ImageIcon từ label_HinhAnh
        ImageIcon imageIcon = (ImageIcon) label_HinhAnh.getIcon();
        String hinhAnh = null;
        if (imageIcon != null) {
            if (imagePath != null) {
                // Chuyển đổi đường dẫn thành đối tượng File
                File imageFile = new File(imagePath);
                // Lấy tên tệp từ đối tượng File
                hinhAnh = imageFile.getName();
            }
        }

        // Tạo đối tượng sản phẩm DTO
        dto_SanPham sanPham = new dto_SanPham();
        sanPham.setMaSanPham(maSanPham);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setGiaBan(giaBan);
        sanPham.setSoLuong(soLuong);
        sanPham.setMoTa(moTa);
        sanPham.setMaLoaiSanPham(maLoai);
        sanPham.setSize(size);
        sanPham.setMaMauSac(maMauSac);
        sanPham.setMaThuongHieu(maThuongHieu);
        sanPham.setHinhAnh(hinhAnh);

        // Gọi phương thức thêm sản phẩm từ BUS
        bus_SanPham bus = new bus_SanPham();
        bus.themSanPham(sanPham);

        hienThiBangSanPham();
        downloadImage("C:\\Users\\Tran Viet Phuc\\Desktop\\JAVA\\DoAn_Java\\DoAn_Java\\src\\images_SanPham");
        // Thông báo thành công
        JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!");
    }

    // load dữ liệu lên combobox
    private void loadComboBoxData() {

        // Xóa tất cả các mục trong các combobox
        cb_Loai.removeAllItems();
        cb_MauSac.removeAllItems();
        cb_ThuongHieu.removeAllItems();

        // Thêm một mục rỗng vào đầu tiên của mỗi combobox
        cb_Loai.addItem("");
        cb_MauSac.addItem("");
        cb_ThuongHieu.addItem("");

        // Load data cho cb_Loai
        Map<String, String> loaiSanPhamMap = new HashMap<>();
        dao_LoaiSanPham loaiSanPhamDAO = new dao_LoaiSanPham();
        ArrayList<dto_LoaiSanPham> loaiSanPhamList = loaiSanPhamDAO.getListLoaiSanPham();
        for (dto_LoaiSanPham loaiSanPham : loaiSanPhamList) {
            loaiSanPhamMap.put(loaiSanPham.getMaLoaiSanPham(), loaiSanPham.getTenLoaiSanPham());
            cb_Loai.addItem(loaiSanPham.getTenLoaiSanPham());
        }

        // Lưu trữ thông tin mã và tên của loại sản phẩm vào combobox
        cb_Loai.putClientProperty("dataMap", loaiSanPhamMap);

        // Tương tự cho cb_MauSac và cb_ThuongHieu
        // (lưu ý thêm mã và tên vào các Map tương ứng và lưu Map vào combobox)
        // Load data cho cb_MauSac
        Map<String, String> mauSacMap = new HashMap<>();
        dao_MauSac mauSacDAO = new dao_MauSac();
        ArrayList<dto_MauSac> mauSacList = mauSacDAO.getListMauSac();
        for (dto_MauSac mauSac : mauSacList) {
            mauSacMap.put(mauSac.getMaMauSac(), mauSac.getTenMauSac());
            cb_MauSac.addItem(mauSac.getTenMauSac());
        }
        cb_MauSac.putClientProperty("dataMap", mauSacMap);

        // Load data cho cb_ThuongHieu
        Map<String, String> thuongHieuMap = new HashMap<>();
        dao_ThuongHieu thuongHieuDAO = new dao_ThuongHieu();
        ArrayList<dto_ThuongHieu> thuongHieuList = thuongHieuDAO.getListThuongHieu();
        for (dto_ThuongHieu thuongHieu : thuongHieuList) {
            thuongHieuMap.put(thuongHieu.getMaThuongHieu(), thuongHieu.getTenThuongHieu());
            cb_ThuongHieu.addItem(thuongHieu.getTenThuongHieu());
        }
        cb_ThuongHieu.putClientProperty("dataMap", thuongHieuMap);
        
        Map<String, String> NhanVienMap = new HashMap<>();
        dao_NhanVien daoNhanVien = new dao_NhanVien();
        ArrayList<dto_NhanVien> nhanVienList = daoNhanVien.getListNhanVien();
        for (dto_NhanVien thuongHieu : nhanVienList) {
            NhanVienMap.put(thuongHieu.getMaNhanVien(), thuongHieu.getHoTen());
            jcb_NhanVien.addItem(thuongHieu.getHoTen());
        }
        jcb_NhanVien.putClientProperty("dataMap", NhanVienMap);
        
         Map<String, String> KhachHangMap = new HashMap<>();
        dao_KhachHang dao_KhachHang1 = new dao_KhachHang();
        ArrayList<dto_KhachHang> khachHangList = (ArrayList<dto_KhachHang>) dao_KhachHang1.getAll();
        for (dto_KhachHang thuongHieu : khachHangList) {
            NhanVienMap.put(thuongHieu.getMaKhachHang(), thuongHieu.getTenKhachHang());
            jcbo_KH.addItem(thuongHieu.getTenKhachHang());
        }
        jcbo_KH.putClientProperty("dataMap", KhachHangMap);

    }

    // Phương thức để tìm mã màu sắc dựa trên tên màu sắc
    private String timMaMauSacTheoTen(String tenMauSac) {
        dao_MauSac mauSacDAO = new dao_MauSac();
        ArrayList<dto_MauSac> mauSacList = mauSacDAO.getListMauSac();
        for (dto_MauSac mauSac : mauSacList) {
            if (mauSac.getTenMauSac().equals(tenMauSac)) {
                return mauSac.getMaMauSac();
            }
        }
        return null; // Hoặc giá trị mặc định khác tùy thuộc vào yêu cầu của bạn
    }//GEN-LAST:event_btn_ThemSanPhamActionPerformed

    // Phương thức để tìm mã thương hiệu dựa trên tên thương hiệu
    private String timMaThuongHieuTheoTen(String tenThuongHieu) {
        dao_ThuongHieu thuongHieuDAO = new dao_ThuongHieu();
        ArrayList<dto_ThuongHieu> thuongHieuList = thuongHieuDAO.getListThuongHieu();
        for (dto_ThuongHieu thuongHieu : thuongHieuList) {
            if (thuongHieu.getTenThuongHieu().equals(tenThuongHieu)) {
                return thuongHieu.getMaThuongHieu();
            }
        }
        return null; // Hoặc giá trị mặc định khác tùy thuộc vào yêu cầu của bạn
    }

    // Phương thức để tìm mã loại sản phẩm dựa trên tên loại sản phẩm
    private String timMaLoaiSanPhamTheoTen(String tenLoaiSanPham) {
        dao_LoaiSanPham loaiSanPhamDAO = new dao_LoaiSanPham();
        ArrayList<dto_LoaiSanPham> loaiSanPhamList = loaiSanPhamDAO.getListLoaiSanPham();
        for (dto_LoaiSanPham loaiSanPham : loaiSanPhamList) {
            if (loaiSanPham.getTenLoaiSanPham().equals(tenLoaiSanPham)) {
                return loaiSanPham.getMaLoaiSanPham();
            }
        }
        return null; // Hoặc giá trị mặc định khác tùy thuộc vào yêu cầu của bạn
    }

    // nút cập nhật
    private void btn_SuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSanPhamActionPerformed
        // Lấy dữ liệu từ các trường nhập liệu
        String maSanPham = txt_MaSanPham.getText();
        String tenSanPham = txt_TenSanPham.getText();
        double giaBan = Double.parseDouble(txt_GiaBan.getText());
        int soLuong = Integer.parseInt(txt_SoLuong.getText());
        int size = Integer.parseInt(txt_Size.getText());
        String moTa = txt_MoTa.getText();

        // Lấy thông tin mã màu sắc từ combobox
        String selectedMauSac = (String) cb_MauSac.getSelectedItem();
        String maMauSac = timMaMauSacTheoTen(selectedMauSac);

        // Lấy thông tin mã loại sản phẩm từ combobox
        String selectedLoaiSanPham = (String) cb_Loai.getSelectedItem();
        String maLoai = timMaLoaiSanPhamTheoTen(selectedLoaiSanPham);

        // Lấy thông tin mã thương hiệu từ combobox
        String selectedThuongHieu = (String) cb_ThuongHieu.getSelectedItem();
        String maThuongHieu = timMaThuongHieuTheoTen(selectedThuongHieu);

        // Lấy ImageIcon từ label_HinhAnh
        ImageIcon imageIcon = (ImageIcon) label_HinhAnh.getIcon();
        String hinhAnh = null;
        if (imageIcon != null) {
            if (imagePath != null) {
                // Chuyển đổi đường dẫn thành đối tượng File
                File imageFile = new File(imagePath);
                // Lấy tên tệp từ đối tượng File
                hinhAnh = imageFile.getName();
            }
        }

        // Tạo đối tượng sản phẩm DTO
        dto_SanPham sanPham = new dto_SanPham();
        sanPham.setMaSanPham(maSanPham);
        sanPham.setTenSanPham(tenSanPham);
        sanPham.setGiaBan(giaBan);
        sanPham.setSoLuong(soLuong);
        sanPham.setMoTa(moTa);
        sanPham.setMaLoaiSanPham(maLoai);
        sanPham.setSize(size);
        sanPham.setMaMauSac(maMauSac);
        sanPham.setMaThuongHieu(maThuongHieu);
        sanPham.setHinhAnh(hinhAnh);

        // Gọi phương thức cập nhật sản phẩm từ lớp bus để thực hiện cập nhật
        bus_SanPham bus = new bus_SanPham();
        bus.capNhatSanPham(sanPham);

        hienThiBangSanPham();
    }//GEN-LAST:event_btn_SuaSanPhamActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_XoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaSanPhamActionPerformed
        // Lấy mã sản phẩm từ trường nhập liệu hoặc từ bảng
        String maSanPham = txt_MaSanPham.getText(); // hoặc từ bảng, tùy thuộc vào cách bạn cài đặt giao diện

        // Gọi phương thức xóa sản phẩm từ BUS
        bus_SanPham bus = new bus_SanPham();
        boolean result = bus.xoaSanPham(maSanPham);

        // Kiểm tra kết quả của việc xóa
        if (result) {
            // Nếu xóa thành công, cập nhật lại bảng hiển thị
            hienThiBangSanPham();
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Xóa sản phẩm thất bại!");
        }
    }//GEN-LAST:event_btn_XoaSanPhamActionPerformed

    private void label_HinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_HinhAnhMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChoooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JREG", "png", "jpg", "jreg");
        int load = fileChoooser.showOpenDialog(null);

        if (load == fileChoooser.APPROVE_OPTION) {
            f = fileChoooser.getSelectedFile();
            imagePath = f.getAbsolutePath();

            // Tạo ImageIcon từ đường dẫn của tệp hình ảnh
            ImageIcon imageIcon = new ImageIcon(imagePath);

            // Tải ảnh từ đường dẫn
            Image img = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            label_HinhAnh.setIcon(new ImageIcon(img));

        }
    }//GEN-LAST:event_label_HinhAnhMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txt_TimKiem.setText("");
        hienThiBangSanPham();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemKeyReleased
        // TODO add your handling code here:
        DefaultTableModel obj = (DefaultTableModel) table_SanPham.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<>(obj);
        table_SanPham.setRowSorter(obj1);
        obj1.setRowFilter(RowFilter.regexFilter(txt_TimKiem.getText()));
    }//GEN-LAST:event_txt_TimKiemKeyReleased

    private void roundPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel3MouseClicked
        // TODO add your handling code here:
        ThuongHieu fr = new ThuongHieu();
        fr.setVisible(true);
    }//GEN-LAST:event_roundPanel3MouseClicked

    private void roundPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel4MouseClicked
        // TODO add your handling code here:
        MauSac fr = new MauSac();
        fr.setVisible(true);
    }//GEN-LAST:event_roundPanel4MouseClicked

    private void roundPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel5MouseClicked
        // TODO add your handling code here:
        LoaiSanPham fr = new LoaiSanPham();
        fr.setVisible(true);
    }//GEN-LAST:event_roundPanel5MouseClicked

    private void btn_ThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKHActionPerformed
        // TODO add your handling code here:
        ThemKhachHang themKhachHang = new ThemKhachHang();
        themKhachHang.setVisible(true);
    }//GEN-LAST:event_btn_ThemKHActionPerformed

    private void btn_XoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKHActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
         int selectedIndexRowRemove = tbl_KhachHang.getSelectedRow();
        if(selectedIndexRowRemove == -1) {
            JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn Khách Hàng cần xóa!");
        }
        else {
            // Lấy giá trị của ô tại hàng và cột đã xác định
            String maKH = tbl_KhachHang.getValueAt(selectedIndexRowRemove, 0).toString();
            if(!maKH.isEmpty()) {
                khachHangBUS.delete(maKH);
                JOptionPane.showMessageDialog(rootPane,"Xóa Khách Hàng thành công!");
            }
            init_tbKhachHang();
        }
    }//GEN-LAST:event_btn_XoaKHActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedIndexRow = tbl_KhachHang.getSelectedRow();
        if(selectedIndexRow == -1) {
            JOptionPane.showMessageDialog(rootPane,"Bạn chưa chọn chọn Khách Hàng cần sửa!");
        }else {
            // Lấy giá trị của ô tại hàng và cột đã xác định
            String maKH = tbl_KhachHang.getValueAt(selectedIndexRow, 0).toString();
            SuaKhachHang suaKhachHang = new SuaKhachHang(maKH);
            suaKhachHang.setVisible(true);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        init_tbKhachHang();
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jtbl_SanPham_PXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbl_SanPham_PXMouseClicked
        // TODO add your handling code here:
         int selectedRow=jtbl_SanPham_PX.getSelectedRow();
        jtxt_masp.setText(jtbl_SanPham_PX.getValueAt(selectedRow,0).toString());
         jtxt_Tensp.setText(jtbl_SanPham_PX.getValueAt(selectedRow,1).toString());
         jtxt_giaBan.setText(jtbl_SanPham_PX.getValueAt(selectedRow,2).toString());
         jtxt_SoLuong.setText(1+"");
         jtxt_ThuongHieu.setText(jtbl_SanPham_PX.getValueAt(selectedRow,4).toString());
         jtxt_mausac.setText(jtbl_SanPham_PX.getValueAt(selectedRow,5).toString());
         jtxt_Loai.setText(jtbl_SanPham_PX.getValueAt(selectedRow,6).toString());
        
    }//GEN-LAST:event_jtbl_SanPham_PXMouseClicked

    private void btn_XoaKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XoaKH1ActionPerformed

    private void btn_ThemKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemKH1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void btn_XoaKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaKH2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XoaKH2ActionPerformed

    private void btn_ThemKH2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemKH2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ThemKH2ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void hienThiBangSanPham() {
        DefaultTableModel dtm = new DefaultTableModel();
        busSanPham.hienThiBangSanPham(dtm, table_SanPham);
    }
    private void hienThiBangSanPham_PX() {
        DefaultTableModel dtm = new DefaultTableModel();
        busSanPham.hienThiBangSanPham(dtm, jtbl_SanPham_PX);
    }
   

    public void downloadImage(String destinationFolder) {
        File imageFile = new File(imagePath);
        Path sourcePath = imageFile.toPath();
        Path destinationPath = Paths.get(destinationFolder, imageFile.getName());

        try {
            // Sao chép tệp hình ảnh từ đường dẫn nguồn đến thư mục đích
            Files.copy(sourcePath, destinationPath);
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi tải hình ảnh.");
            e.printStackTrace();
        }
    }

/////////////////////////////////////
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SuaSP;
    private javax.swing.JButton btn_SuaSanPham;
    private javax.swing.JButton btn_ThemKH;
    private javax.swing.JButton btn_ThemKH1;
    private javax.swing.JButton btn_ThemKH2;
    private javax.swing.JButton btn_ThemSP;
    private javax.swing.JButton btn_ThemSanPham;
    private javax.swing.JButton btn_XoaKH;
    private javax.swing.JButton btn_XoaKH1;
    private javax.swing.JButton btn_XoaKH2;
    private javax.swing.JButton btn_XoaSanPham;
    private jpanel.RoundPanel btn_dangxuat;
    private jpanel.RoundPanel btn_khachhang;
    private jpanel.RoundPanel btn_nhacungcap;
    private jpanel.RoundPanel btn_phieuxuat;
    private jpanel.RoundPanel btn_taikhoan;
    private jpanel.RoundPanel btn_thongke;
    private jpanel.RoundPanel btn_thuoctinh;
    private jpanel.RoundPanel btn_trangchu;
    private javax.swing.JButton btn_xoaSP;
    private javax.swing.JComboBox<String> cb_Loai;
    private javax.swing.JComboBox<String> cb_MauSac;
    private javax.swing.JComboBox<String> cb_ThuongHieu;
    private jpanel.ImageAvatar imageAvatar1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JComboBox<String> jcb_NhanVien;
    private javax.swing.JComboBox<String> jcbo_KH;
    private javax.swing.JPanel jpanel_khachhang;
    private javax.swing.JPanel jpanel_nhacungcap;
    private javax.swing.JPanel jpanel_phieuxuat;
    private javax.swing.JPanel jpanel_taikhoan;
    private javax.swing.JPanel jpanel_thongke;
    private javax.swing.JPanel jpanel_thuoctinh;
    private javax.swing.JPanel jpanel_trangchu;
    private javax.swing.JTable jtbl_SanPham_PX;
    private javax.swing.JTextField jtxt_Loai;
    private javax.swing.JTextField jtxt_SoLuong;
    private javax.swing.JTextField jtxt_Tensp;
    private javax.swing.JTextField jtxt_ThuongHieu;
    private javax.swing.JTextField jtxt_giaBan;
    private javax.swing.JTextField jtxt_masp;
    private javax.swing.JTextField jtxt_mausac;
    private javax.swing.JLabel label_HinhAnh;
    private jpanel.RoundPanel roundPanel1;
    private jpanel.RoundPanel roundPanel2;
    private jpanel.RoundPanel roundPanel3;
    private jpanel.RoundPanel roundPanel4;
    private jpanel.RoundPanel roundPanel5;
    private jpanel.RoundPanel roundPanel6;
    private jpanel.RoundPanel roundPanel7;
    private javax.swing.JTable table_SanPham;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTable tbl_KhachHang1;
    private javax.swing.JTable tbl_taikhoan;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_LoaiSanPham;
    private javax.swing.JTextField txt_MaSanPham;
    private javax.swing.JTextField txt_MoTa;
    private javax.swing.JTextField txt_Size;
    private javax.swing.JTextField txt_SoLuong;
    private javax.swing.JTextField txt_TenSanPham;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
}
