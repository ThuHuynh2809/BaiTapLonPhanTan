///*
// * @ (#) $NAME.java         4/24/2024
// *
// * Copyright (c) 2024 IUH.
// *
// */
//
//package gui;
//
//import com.toedter.calendar.JDateChooser;
//import dao.*;
//import entity.*;
//import impl.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Persistence;
//
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.rmi.RemoteException;
//import java.sql.Date;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//
///*
// * @description: ...
// * @author: Vinh Trung Pham
// * @studentID: 20119821
// * @date: 4/24/2024
// */
//public class FRMDanhSachHoaDon extends javax.swing.JFrame implements ActionListener {
//    private static JFrame frm;
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//
//    public static KhachHangDao khachHangDao;
//    public static NhanVienDao nhanVienDao;
//    public static HoaDonDao hoaDonDao;
//    public static PhongDao phongDao;
//    public static MacHangDao macHangDao;
//    public static LoaiMhDao loaiMhDao;
//
//    public static CTHDDao cthdDao;
//
//    static {
//        try {
//            khachHangDao = new KhachHangImpl();
//            nhanVienDao = new NhanVienImpl();
//            hoaDonDao = new HoaDonImpl();
//            phongDao = new PhongImpl();
//            macHangDao = new MatHangImpl();
//            loaiMhDao = new LoaiMhImpl();
//            cthdDao = new CTHDImpl();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public FRMDanhSachHoaDon() {
//        initComponents();
//        setLocationRelativeTo(null);
//    }
//
//
//    private void initComponents() {
//        EntityManager em = Persistence.createEntityManagerFactory("maria").createEntityManager();
//
//        NhanVienDao daoNhanVien;
//        KhachHangDao daoKhachHang;
//        HoaDonDao daoHoaDon;
//        PhongDao daoPhong;
//        MacHangDao daoMatHang;
//        LoaiMhDao daoLoaiMatHang;
//        CTHDDao daoCTHD;
//
//        LocalDate now = LocalDate.now();
//        int ngay = now.getDayOfMonth();
//        int thang = now.getMonthValue() - 1;
//        int nam = now.getYear() - 1900;
//        Date dNow = new Date(nam, thang, ngay);
//
//        sf = new SimpleDateFormat("dd/MM/yyyy");
//        dfTable = new DecimalFormat("###,###");
//        df = new DecimalFormat("###,### VNĐ");
//
//        jPanel1 = new javax.swing.JPanel();
//        jLabel1 = new javax.swing.JLabel();
//        jLabel2 = new javax.swing.JLabel();
//        jTextFTimKiem = new javax.swing.JTextField();
//        jButTimKiem = new javax.swing.JButton();
//        jButLamMoi = new javax.swing.JButton();
//        jScrollPane2 = new javax.swing.JScrollPane();
//        jTable2 = new javax.swing.JTable();
//        jButQuayLai = new javax.swing.JButton();
//        jScrollPane1 = new javax.swing.JScrollPane();
//        jTable1 = new javax.swing.JTable();
//        jLabel3 = new javax.swing.JLabel();
//        jLabel4 = new javax.swing.JLabel();
//        jLabel5 = new javax.swing.JLabel();
//        jLabel6 = new javax.swing.JLabel();
//        jLabel7 = new javax.swing.JLabel();
//        jLabel8 = new javax.swing.JLabel();
//        jTextFieldTuNgay = new javax.swing.JTextField();
//        jTextFieldDenNgay = new javax.swing.JTextField();
//        jButton1 = new javax.swing.JButton();
//        jTextFieldPhong = new javax.swing.JTextField();
//        jTextFieldGioVao = new javax.swing.JTextField();
//        jTextFieldGioRa = new javax.swing.JTextField();
//        jTextFieldTrangThai = new javax.swing.JTextField();
//        jLabel9 = new javax.swing.JLabel();
//        jLabel10 = new javax.swing.JLabel();
//        jLabel11 = new javax.swing.JLabel();
//        jTextFieldPhuThu = new javax.swing.JTextField();
//        jTextFieldGiaPhong = new javax.swing.JTextField();
//        jTextFieldThoiGian = new javax.swing.JTextField();
//        jTextFieldTienQuanThoiGian = new javax.swing.JTextField();
//        jLabel12 = new javax.swing.JLabel();
//        jTextFieldTongTienThanhToan = new javax.swing.JTextField();
//
//        chooserTuNgay = new JDateChooser();
//        chooserTuNgay.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        chooserTuNgay.setBounds(110, 213, 191, 25);
//        chooserTuNgay.setDateFormatString("dd/MM/yyyy");
//        chooserTuNgay.setDate(dNgayHienTai);
//        chooserTuNgay.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
//        chooserTuNgay.setFont(new Font("SansSerif", Font.PLAIN, 15));
//        chooserTuNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
//        chooserTuNgay.getCalendarButton().setBackground(new Color(102, 0, 153));
//        chooserTuNgay.getCalendarButton().setToolTipText("Chọn ngày bắt đầu");
//
//        chooserDenNgay = new JDateChooser();
//        chooserDenNgay.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        chooserDenNgay.setBounds(110, 213, 191, 25);
//        chooserDenNgay.setDateFormatString("dd/MM/yyyy");
//        chooserDenNgay.setDate(dNgayHienTai);
//        chooserDenNgay.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
//        chooserDenNgay.setFont(new Font("SansSerif", Font.PLAIN, 15));
//        chooserDenNgay.getCalendarButton().setPreferredSize(new Dimension(30, 24));
//        chooserDenNgay.getCalendarButton().setBackground(new Color(102, 0, 153));
//        chooserDenNgay.getCalendarButton().setToolTipText("Chọn ngày kết thúc");
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//
//        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
//        jLabel1.setText("DANH SÁCH HÓA ĐƠN");
//
//        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        jLabel2.setText("Tìm kiếm :");
//
//        jButTimKiem.setIcon(new javax.swing.ImageIcon("D:\\\\PhatTrienUngDung\\\\PTUD_2022_Nhom24_DHKTPM16A\\\\SourceCode\\\\PTUD_Nhom24_2022\\\\iCons\\iCon\\search.png")); // NOI18N
//
//        jButLamMoi.setIcon(new javax.swing.ImageIcon("D:\\\\PhatTrienUngDung\\\\PTUD_2022_Nhom24_DHKTPM16A\\\\SourceCode\\\\PTUD_Nhom24_2022\\\\iCons\\iCon\\refresh.png")); // NOI18N
//
//
//        String col1[] = {
//                "Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã nhân viên", "Tên nhân viên", "Ngày lập", "Phụ thu"
//        };
//        moldeHD = new DefaultTableModel(col1, 0);
//        jTable2 = new JTable(moldeHD);
//        jScrollPane2.setViewportView(jTable2);
//
//        jButQuayLai.setIcon(new javax.swing.ImageIcon("D:\\\\PhatTrienUngDung\\\\PTUD_2022_Nhom24_DHKTPM16A\\\\SourceCode\\\\PTUD_Nhom24_2022\\\\iCons\\iCon\\undo.png")); // NOI18N
//        jButQuayLai.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButQuayLaiActionPerformed(evt);
//            }
//        });
//
//
//        String col2[] = {
//                "Mã mặt hàng", "Tên mặt hàng", "Loại mặt hàng", "Số lượng", "Đơn giá", "Thành tiền"
//        };
//        modelMH = new DefaultTableModel(col2, 0);
//        jTable1 = new JTable(modelMH);
//        jScrollPane1.setViewportView(jTable1);
//
//        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel3.setText("Phòng:");
//
//        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel4.setText("Giờ vào: ");
//
//        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel5.setText("Giờ ra:");
//
//        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel6.setText("Trạng thái hóa đơn:");
//
//        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        jLabel7.setText("Đến ngày");
//
//        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        jLabel8.setText("Từ ngày");
//
//        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        jButton1.setIcon(new javax.swing.ImageIcon("D:\\\\PhatTrienUngDung\\\\PTUD_2022_Nhom24_DHKTPM16A\\\\SourceCode\\\\PTUD_Nhom24_2022\\\\iCons\\iCon\\swatches.png")); // NOI18N
//        jButton1.setText("Xem");
//
//        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel9.setText("Phụ thu:");
//
//        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel10.setText("Giá phòng:");
//
//        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//        jLabel11.setText("Thời gian:");
//
//        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
//        jLabel12.setText("Thành tiền:");
//
//        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
//        jPanel1.setLayout(jPanel1Layout);
//        jPanel1Layout.setHorizontalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGap(16, 16, 16)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(59, 59, 59)
//                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                                .addComponent(jTextFTimKiem))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jButQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(99, 99, 99)
//                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(chooserTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                .addComponent(jLabel7)
//                                                .addGap(18, 18, 18)
//                                                .addComponent(chooserDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                .addGap(26, 26, 26)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jButTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(37, 37, 37)
//                                                .addComponent(jButLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//                                .addGap(28, 28, 28))
//                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                                .addContainerGap()
//                                                .addComponent(jScrollPane1))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(85, 85, 85)
//                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jTextFieldPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(35, 35, 35)
//                                                .addComponent(jLabel4)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jTextFieldGioVao, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(48, 48, 48)
//                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jTextFieldGioRa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(55, 55, 55)
//                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jTextFieldTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(0, 0, Short.MAX_VALUE))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addContainerGap()
//                                                .addComponent(jScrollPane2)))
//                                .addContainerGap())
//                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(0, 0, Short.MAX_VALUE)
//                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                .addComponent(jTextFieldPhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                .addComponent(jLabel10)
//                                                .addGap(26, 26, 26)
//                                                .addComponent(jTextFieldGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(49, 49, 49)
//                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addComponent(jTextFieldThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addGap(18, 18, 18)
//                                                .addComponent(jTextFieldTienQuanThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addComponent(jTextFieldTongTienThanhToan))
//                                .addContainerGap())
//        );
//        jPanel1Layout.setVerticalGroup(
//                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                .addContainerGap()
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jTextFTimKiem)
//                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                                .addGap(3, 3, 3)
//                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addComponent(jButTimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addComponent(jButLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                                .addGap(6, 6, 6)
//                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                                .addGap(0, 0, Short.MAX_VALUE)))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
//                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                        .addComponent(chooserTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
//                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                .addComponent(chooserDenNgay, javax.swing.GroupLayout.Alignment.LEADING))
//                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jButQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addComponent(jTextFieldGioVao)
//                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
//                                                .addGap(0, 0, Short.MAX_VALUE)
//                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addComponent(jTextFieldGioRa)
//                                        .addComponent(jTextFieldTrangThai)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                                .addComponent(jTextFieldPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                                .addGap(0, 0, Short.MAX_VALUE)))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addComponent(jTextFieldThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addComponent(jTextFieldTienQuanThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                .addComponent(jTextFieldGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                        .addComponent(jTextFieldPhuThu))
//                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(9, 9, 9)
//                                                .addComponent(jLabel12))
//                                        .addGroup(jPanel1Layout.createSequentialGroup()
//                                                .addGap(6, 6, 6)
//                                                .addComponent(jTextFieldTongTienThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                                .addGap(12, 12, 12))
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(0, 0, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addGap(0, 0, Short.MAX_VALUE))
//        );
//        // ad sự kiênk
//        jButton1.addActionListener(this);
//        jButTimKiem.addActionListener(this);
//        jTable2.addMouseListener(this);
//        jButLamMoi.addActionListener(this);
//
//        chooserTuNgay.setDate(dNow);
//        chooserDenNgay.setDate(dNow);
//
//        jTextFieldDenNgay.setEditable(false);
//        jTextFieldGioRa.setEditable(false);
//        jTextFieldGioVao.setEditable(false);
//        jTextFieldPhong.setEditable(false);
//        jTextFieldPhuThu.setEditable(false);
//        jTextFieldTrangThai.setEditable(false);
//        jTextFieldGiaPhong.setEditable(false);
//        jTextFieldThoiGian.setEditable(false);
//        jTextFieldTongTienThanhToan.setEditable(false);
//        jTextFieldTienQuanThoiGian.setEditable(false);
//
//
//        pack();
//    }
//
//    public void clearTable() {
//        while (jTable2.getRowCount() > 0) {
//            moldeHD.removeRow(0);
//        }
//    }
//
//    public void clearTableCTHD() {
//        while (jTable1.getRowCount() > 0) {
//            modelMH.removeRow(0);
//        }
//    }
//
//    // reset all
//    private void resetALL() {
//        clearTable();
//        clearTableCTHD();
//    }
//
//    /// load danh sach hoa dơn lên table
//    public void loadTableHoaDon(ArrayList<HoaDon> lsHD) throws RemoteException {
//        clearTable();
//        clearTableCTHD();
//        for (HoaDon hd : lsHD) {
//            KhachHang kh = daoKhachHang.getKHTheoMa(hd.getKhachHang().getMaKhangHang());
//            NhanVien nv = daoNhanVien.getNVTheoMa(hd.getNhanVien().getMaNhanVien());
//            moldeHD.addRow(new Object[]{
//                    hd.getMaHoaDon(), kh.getMaKhangHang(), kh.getTenKH(), nv.getMaNhanVien(), nv.getTenNhanVien(), sf.format(hd.getNgayLap()), hd.getPhuThu()
//            });
//
//        }
//
//    }
//
//    public double tongTienCTHD(double tongTienThue, HoaDon hd) throws RemoteException {
//        double tong = tongTienThue;
//
//        ArrayList<ChiTietHD> lsCTHD = daoCTHD.getCTHDTheoMaHD(hd.getMaHoaDon());
//        for (ChiTietHD ct : lsCTHD) {
//            MatHang mh = daoMatHang.getMHTheoMa(ct.getMatHang().getMaMatHang());
//            tong += mh.getGiaMatHang() * ct.getSoLuong();
//        }
//
//        return tong;
//    }
//
//    public void loadHoaDon() throws RemoteException {
//        jTextFTimKiem.setFont(new Font("SansSerif", Font.ITALIC, 14));
//        jTextFTimKiem.setText("Nhập tên khách hàng, mã nhân viên.");
//        jTextFTimKiem.setForeground(Color.lightGray);
//
//        java.util.Date utilngayBD = chooserTuNgay.getDate();
//        java.util.Date utilngayKT = chooserDenNgay.getDate();
//
//        @SuppressWarnings("deprecation")
//        Date ngayBatDau = new Date(utilngayBD.getYear(), utilngayBD.getMonth(), utilngayBD.getDate());
//        @SuppressWarnings("deprecation")
//        Date ngayKetThuc = new Date(utilngayKT.getYear(), utilngayKT.getMonth(), utilngayKT.getDate());
//        if (ngayBatDau.before(ngayKetThuc) || ngayBatDau.equals(ngayKetThuc)) {
//
//            ArrayList<HoaDon> lsHD = daoHD.getHDTheoNgay(ngayBatDau, ngayKetThuc);
//            loadTableHoaDon(lsHD);
//
//        } else JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn hoặc bằng ngày kết thúc!");
//
//
//    }
//
//    @SuppressWarnings("deprecation")
//    public double tinhTienThue(double giaPhong, HoaDon hd) {
//        int gioVao = hd.getGioVao().getHours(),
//                phutVao = hd.getGioVao().getMinutes();
//        int gioRa = hd.getGioRa().getHours(),
//                phutRa = hd.getGioRa().getMinutes();
//
//        int tongThoiGian = (gioRa * 60 + phutRa) - (gioVao * 60 + phutVao);
//        double tongTienThuePhong = 0;
//        if (tongThoiGian > 0) {
//            if (tongThoiGian <= 60) {
//                tongTienThuePhong = giaPhong;
//                return tongTienThuePhong;
//            } else {
//                tongTienThuePhong = (tongThoiGian * giaPhong) / 60;
//                return tongTienThuePhong;
//            }
//        }
//
//        return -1;
//    }
//
//    public void loadThanhTien(HoaDon hd) throws RemoteException {
//        int row = jTable2.getSelectedRow();
//        String phuThu = moldeHD.getValueAt(row, 6).toString();
//        Phong p = daoPhong.getPhongTheoMa(jTextFieldPhong.getText());
//        double giaPhong = p.getGiaPhong();
//
//        double giaPhuThu = 0;
//        if (phuThu.equalsIgnoreCase("Ngày thường")) {
//            giaPhuThu = 10000;
//
//        }
//
//        if (phuThu.equalsIgnoreCase("Ngày lễ")) {
//            giaPhuThu = 30000;
//
//        }
//        if (phuThu.equalsIgnoreCase("Đêm")) {
//            giaPhuThu = 20000;
//        }
//        giaPhong = giaPhuThu + giaPhong;
//
//        double tongTienThue = tinhTienThue(giaPhong, hd);
//
//        int tongGioThue = (int) ((tongTienThue) / giaPhong);
//        int tongPhutThue = (int) (((tongTienThue * 60) / giaPhong) % 60);
//
//        jTextFieldPhuThu.setText(phuThu + ": " + df.format(giaPhuThu));
//        jTextFieldGiaPhong.setText(df.format(giaPhong));
////		jTextFieldThoiGian.setText(tongGioThue+"h : "+tongPhutThue +"'  "+ df.format(tongTienThue));
//        jTextFieldThoiGian.setText(tongGioThue + "h : " + tongPhutThue + "p ");
//        jTextFieldTienQuanThoiGian.setText("Tiền phòng: " + df.format(tongTienThue));
//
//        double thanhTien = tongTienCTHD(tongTienThue, hd);
//
////			lblGiamGia.setText("- "+df.format(hd.getGiamGia()));
//        thanhTien = thanhTien - hd.getGiamGia();
//
//
//        jTextFieldTongTienThanhToan.setText(df.format(thanhTien));
//
//    }
//
//    //tìm kiếm
//    public void loadTimKiem() throws RemoteException {
//        Regex regexDao = new Regex();
//        String thongTin = jTextFTimKiem.getText().trim();        // lấy chuỗi tìm kiếm ra, trim() để xóa kí tự rỗng 2 đầu
//        thongTin = thongTin.toUpperCase();                // chuyển toàn bộ chuỗi thành chữ in hoa hết để tìm, tránh trường hợp người dùng nhập chữ thường chữ hoa
//        String regexMaNV = "^((NV|nv)[0-9]{3})$";        // regex ma
//        String regexTenKH = "^[ A-Za-za-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$";
//        ArrayList<HoaDon> lsHD = null;                    // khởi tạo danh sách hóa đơn
//        if (regexDao.regexTimDSHD(jTextFTimKiem)) {                // nếu check thông tin nhập vô, thỏa điều kiện là mã hoặc tên
//            // ngang đây đã thỏa mãn điều kiện nó là mã hoặc tên
//            if (thongTin.matches(regexMaNV)) {            //regex check lần nữa để phân biệt đc nó là mã, nếu là mã thì lấy danh sách hóa đơn theo mã
//                lsHD = daoHD.getHDTheoMaNV(thongTin);
//
//            } else if (thongTin.matches(regexTenKH)) {            // nếu check ko phải là mã thì nó check có phải tên hay ko,nếu là tên thì get dsHD theo tên
//                lsHD = daoHD.getHDTheoTenKH(thongTin);
//            }
//            if (lsHD.size() == 0)    //vì ds hóa đơn lấy về có thể bị rỗng, nên phải kiểm tra lại, kích thước nó = 0 thì xuất thông báo ko tìm thấy
//                JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin tìm kiếm phù hợp!");
//            loadTableHoaDon(lsHD);
//
//        }
//
//    }
//
//    private void jButQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButQuayLaiActionPerformed
//        // TODO add your handling code here:
//        setVisible(false);
//        frm.setVisible(true);
//
//
//    }
//
//    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FRMDanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FRMDanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FRMDanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FRMDanhSachHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                frm.setVisible(true);
//            }
//        });
//    }
//
//
//    private javax.swing.JButton jButLamMoi;
//    private javax.swing.JButton jButQuayLai;
//    private javax.swing.JButton jButTimKiem;
//    private javax.swing.JButton jButton1;
//    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel10;
//    private javax.swing.JLabel jLabel11;
//    private javax.swing.JLabel jLabel12;
//    private javax.swing.JLabel jLabel2;
//    private javax.swing.JLabel jLabel3;
//    private javax.swing.JLabel jLabel4;
//    private javax.swing.JLabel jLabel5;
//    private javax.swing.JLabel jLabel6;
//    private javax.swing.JLabel jLabel7;
//    private javax.swing.JLabel jLabel8;
//    private javax.swing.JLabel jLabel9;
//    private javax.swing.JPanel jPanel1;
//    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JScrollPane jScrollPane2;
//    private javax.swing.JTable jTable1;
//    private javax.swing.JTable jTable2;
//    private javax.swing.JTextField jTextFTimKiem;
//    private javax.swing.JTextField jTextFieldDenNgay;
//    private javax.swing.JTextField jTextFieldGiaPhong;
//    private javax.swing.JTextField jTextFieldGioRa;
//    private javax.swing.JTextField jTextFieldGioVao;
//    private javax.swing.JTextField jTextFieldPhong;
//    private javax.swing.JTextField jTextFieldPhuThu;
//    private javax.swing.JTextField jTextFieldThoiGian;
//    private javax.swing.JTextField jTextFieldTienQuanThoiGian;
//    private javax.swing.JTextField jTextFieldTongTienThanhToan;
//    private javax.swing.JTextField jTextFieldTrangThai;
//    private javax.swing.JTextField jTextFieldTuNgay;
//    private JDateChooser chooserTuNgay;
//    private JDateChooser chooserDenNgay;
//    private Date dNgayHienTai;
//    private SimpleDateFormat sf;
//    private DecimalFormat dfTable;
//    private DecimalFormat df;
//    ///
//    private DefaultTableModel modelMH;
//    private DefaultTableModel moldeHD;
//
//
//    //dao
//    private KhachHangDao daoKhachHang;
//    private NhanVienDao daoNhanVien;
//    private CTHDDao daoCTHD;
//    private HoaDonDao daoHD;
//    private MacHangDao daoMatHang;
//    private PhongDao daoPhong;
//    private LoaiMhDao daoLoaiMH;
//
//    // End of variables declaration//GEN-END:variables
//    ///
//
//
//    private void reset() {
//        jTextFieldDenNgay.setText("");
//        jTextFieldGioRa.setText("");
//        jTextFieldGioVao.setText("");
//        jTextFieldPhong.setText("");
//        jTextFieldPhuThu.setText("");
//        jTextFieldTrangThai.setText("");
//        jTextFieldGiaPhong.setText("");
//        jTextFieldThoiGian.setText("");
//        jTextFieldTongTienThanhToan.setText("");
//        jTextFieldTienQuanThoiGian.setText("");
//    }
//
//
//}
