package gui;

import com.toedter.calendar.JDateChooser;
import dao.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import impl.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FRMQuanLiDatPhong extends javax.swing.JFrame implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public FRMQuanLiDatPhong() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public static PhongDao daoPhong;
    public static LoaiPhongDao daoLoaiPhong;
    public static DatPhongDao daoDonDatPhong;
    public static KhachHangDao daoKhachHang;
    public static NhanVienDao daoNhanVien;

    static {
        try {
            daoPhong = new PhongImpl();
            daoLoaiPhong = new LoaiPhongImpl();
            daoDonDatPhong = new DatPhongImpl();
            daoKhachHang = new KhachHangImpl();
            daoNhanVien = new NhanVienImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    private void initComponents() {

        EntityManager em = Persistence.createEntityManagerFactory("maria").createEntityManager();

        NhanVienDao daoNhanVien;
        PhongDao daoPhong;
        LoaiPhongDao daoLoaiPhong;
        DatPhongDao daoDonDatPhong;
        KhachHangDao daoKhachHang;


        daoSinhMa = new DAOSinhMaTuDong();
        ddp = new DonDatPhong();

        dfNgay = new SimpleDateFormat("dd/MM/yyyy");
        dfHienGio = new SimpleDateFormat("HH:mm");

        jPanel1 = new javax.swing.JPanel();
        jPanelThongTinDDP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxLoaiKH = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTrangThaiPhong = new javax.swing.JComboBox<>();
        txtSDTKH = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxTrangThaiPhong1 = new javax.swing.JComboBox<>();
        btnPhong = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtPhong = new javax.swing.JTextField();
        txtNgayDen = new javax.swing.JTextField();
        jComboBoxGio = new javax.swing.JComboBox<>();
        jComboBoxPhut = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTimDDP = new JTextField("Nháº­p mÃ£ Ä‘Æ¡n Ä‘áº·t phÃ²ng");
        jbTimDDP = new javax.swing.JButton();
        btnThemDDP = new javax.swing.JButton();
        btnSuaDDP = new javax.swing.JButton();
        btnXoaDDP = new javax.swing.JButton();
        btnLamMoiDDP = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quáº£n lÃ­ Ä‘áº·t phÃ²ng");

        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new Dimension(1202, 422));

        jPanelThongTinDDP.setBackground(new Color(255, 255, 255));
        jPanelThongTinDDP.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(51, 255, 255)));

        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("       ThÃ´ng tin Ä‘Æ¡n Ä‘áº·t phÃ²ng");

        jLabel2.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Loáº¡i khÃ¡ch hÃ ng:");

        jLabel3.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("TÃªn khÃ¡ch hÃ ng: ");

        jLabel4.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("SÄT:");

        jComboBoxLoaiKH.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"KhÃ¡ch hÃ ng thÆ°á»ng", "ThÃ nh viÃªn thÆ°á»ng", "ThÃ nh viÃªn VIP"}));

        jLabel5.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("TÃªn nhÃ¢n viÃªn:");

        jLabel6.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("NgÃ y Ä‘áº¿n: ");

        chooseNgayDen = new JDateChooser();
        chooseNgayDen.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        chooseNgayDen.setBounds(110, 213, 191, 25);
        chooseNgayDen.setDateFormatString("dd/MM/yyyy");
        chooseNgayDen.setDate(dNgayHienTai);
        chooseNgayDen.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
        chooseNgayDen.setFont(new Font("SansSerif", Font.PLAIN, 15));
        chooseNgayDen.getCalendarButton().setPreferredSize(new Dimension(30, 24));
        chooseNgayDen.getCalendarButton().setBackground(new Color(102, 0, 153));
        chooseNgayDen.getCalendarButton().setToolTipText("Chá»n ngÃ y sinh");

        jLabel7.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giá» Ä‘áº¿n:");

        jLabel8.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText(":");

        jLabel9.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tráº¡ng thÃ¡i DDP:");

        jComboBoxTrangThaiPhong.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTrangThaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"ThÆ°á»ng", "VIP"}));

        txtTenKH.setToolTipText("loaiKH");


        jLabel11.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Loáº¡i phÃ²ng:");

        jComboBoxTrangThaiPhong1.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxTrangThaiPhong1
                .setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Chá» xÃ¡c nháº­n", "ÄÃ£ xÃ¡c nháº­n", "ÄÃ£ tráº£ phÃ²ng"}));

        btnPhong.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

        jLabel13.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("PhÃ²ng:");

        jComboBoxGio.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19", "20", "21", "22", "23"}));

        jComboBoxPhut.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14",
                        "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                        "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46",
                        "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));


        javax.swing.GroupLayout jPanelThongTinDDPLayout = new javax.swing.GroupLayout(jPanelThongTinDDP);
        jPanelThongTinDDP.setLayout(jPanelThongTinDDPLayout);
        jPanelThongTinDDPLayout.setHorizontalGroup(jPanelThongTinDDPLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup().addContainerGap()
                        .addGroup(jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                        jPanelThongTinDDPLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 61,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57).addComponent(txtPhong))
                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtTenNV, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtSDTKH)
                                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                                        .addComponent(jComboBoxTrangThaiPhong1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(chooseNgayDen))
                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBoxTrangThaiPhong,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18).addComponent(btnPhong,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(57, 57, 57)
                                                        .addComponent(jComboBoxGio,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBoxPhut,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap()));
        jPanelThongTinDDPLayout.setVerticalGroup(jPanelThongTinDDPLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup().addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelThongTinDDPLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelThongTinDDPLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(
                                jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSDTKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(
                                jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelThongTinDDPLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelThongTinDDPLayout.createSequentialGroup()
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chooseNgayDen, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel8)
                                                .addComponent(jComboBoxGio, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBoxPhut, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9).addComponent(jComboBoxTrangThaiPhong1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanelThongTinDDPLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jComboBoxTrangThaiPhong).addComponent(jLabel11,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(btnPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(
                                jPanelThongTinDDPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap()));

        // TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE TABLE
        // TABLE TABLE TABLE TABLE
        // String colDDP[] = { "MÃ£ DDP", "TÃªn khÃ¡ch hÃ ng", "MÃ£ phÃ²ng", "Loáº¡i phÃ²ng",
        // "SÄT", "Giá» Ä‘áº¿n", "NgÃ y Ä‘áº¿n",
        // "TÃªn nhÃ¢n viÃªn", "NgÃ y láº­p", "Tráº¡ng thÃ¡i" };
        // modelDDP = new DefaultTableModel(colDDP, 0);
        // jTable1 = new JTable(modelDDP);
        // jTable1.setDefaultEditor(Object.class, null);
        // jTable1.setToolTipText("");
        // jScrollPane1.setViewportView(jTable1);
        // if (jTable1.getColumnModel().getColumnCount() > 0) {
        // jTable1.getColumnModel().getColumn(0).setResizable(false);
        // }

        jLabel12.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("ThÃ´ng tin Ä‘Æ¡n:");

        jLabel10.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("TÃ¬m kiáº¿m:");

        jbTimDDP.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

        btnThemDDP.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        btnThemDDP.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\add.png")); // NOI18N
        btnThemDDP.setText("ThÃªm");
        btnThemDDP.setPreferredSize(new Dimension(121, 39));

        btnSuaDDP.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        btnSuaDDP.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\service.png")); // NOI18N
        btnSuaDDP.setText("Sá»­a");
        btnSuaDDP.setPreferredSize(new Dimension(121, 39));

        btnXoaDDP.setFont(new Font("Segoe UI", 0, 13)); // NOI18N
        btnXoaDDP.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\sorting.png")); // NOI18N
        btnXoaDDP.setText("Lá»c");
        btnXoaDDP.setPreferredSize(new Dimension(121, 39));

        btnLamMoiDDP.setFont(new Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoiDDP.setIcon(
                new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\iCon\\refresh.png")); // NOI18N
        btnLamMoiDDP.setText("LÃ m Má»›i");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42)
                        .addComponent(btnThemDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnSuaDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLamMoiDDP).addGap(112, 112, 112)
                        .addComponent(btnXoaDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 108,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 549,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jbTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 72,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                .addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(jLabel12,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 891, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(64, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbTimDDP, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThemDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSuaDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLamMoiDDP).addComponent(btnXoaDDP,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanelThongTinDDP, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
                        .addComponent(jPanelThongTinDDP, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING,
                        javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1227,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addComponent(jPanel1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
//
//        pack();
//        jTextFieldTimDDP.setText("Nháº­p mÃ£ Ä‘Æ¡n Ä‘áº·t phÃ²ng");
////        txtTenNV.setText(daoNhanVien.getNVTheoMa(maTK).getTenNhanVien());
//        txtTenNV.setText(daoNhanVien.getNVTheoMa(maTK).getTenNhanVien());
//        //
//        chooseNgayDen.setDate(new java.util.Date());
////		txtTenKH.setEditable(false);
//        txtTenNV.setEditable(false);
//        txtPhong.setEditable(false);
//        chooseNgayDen.getDateEditor().setEnabled(false);
////        loadDS();
//        // add event
//        jTable1.addMouseListener(this);
//        btnSuaDDP.addActionListener(this);
//        btnLamMoiDDP.addActionListener(this);
//        btnThemDDP.addActionListener(this);
//        btnXoaDDP.addActionListener(this);
//        btnPhong.addActionListener(this);
//        jbTimDDP.addActionListener(this);
//        jTextFieldTimDDP.addActionListener(this);
//        jTextFieldTimDDP.addKeyListener(this);
//        txtSDTKH.addKeyListener(this);

    }

    public JPanel getFRMDDP() {
        return jPanel1;
    }

    private void loadDanhSachDDP(DonDatPhong ddp) throws RemoteException {
        List<DonDatPhong> lstDDP = daoDonDatPhong.getAllDDP();


        for (DonDatPhong infoDDP : lstDDP) {
            KhachHang kh = daoKhachHang.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
            NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
            LoaiPhong loaiPhong = daoLoaiPhong.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

            modelDDP.addRow(new Object[]{infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
                    loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
                    dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
                    infoDDP.getTrangThaiDDP()});
        }

    }

    private void loadDS() throws RemoteException {
        // removeDanhSachDDP(modelDDP);
        modelDDP = new DefaultTableModel(colDDP, 0);
        jTable1.setModel(modelDDP);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }
        List<DonDatPhong> lstDDP = daoDonDatPhong.getAllDDP();
        //

        //
        for (DonDatPhong infoDDP : lstDDP) {
            KhachHang kh = daoKhachHang.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
            NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
            LoaiPhong loaiPhong = daoLoaiPhong.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

            modelDDP.addRow(new Object[]{infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
                    loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
                    dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
                    infoDDP.getTrangThaiDDP()});
        }

    }

    private void loadDSPhong() throws RemoteException {
        // removeDanhSachDDP(modelDDP);
        modelPhong = new DefaultTableModel(colPhong, 0);
        jTable1.setModel(modelPhong);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }
        List<Phong> dsPhong = new ArrayList<Phong>();
        if (jComboBoxTrangThaiPhong.getSelectedItem().toString().matches("VIP")) {// load phong vip
            dsPhong = daoPhong.getPhongVipTrong();

        } else {
            dsPhong = daoPhong.getPhongThuongTrong();

        }
        if (dsPhong != null) {
            for (Phong p : dsPhong)
                modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
                        p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
        }

    }

    private void loadDSPhongTrong() throws RemoteException {
        // removeDanhSachDDP(modelDDP);
        modelPhong = new DefaultTableModel(colPhong, 0);
        jTable1.setModel(modelPhong);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }
        List<Phong> dsPhong = daoPhong.getPhongThuongTrong();
        if (dsPhong != null) {
            for (Phong p : dsPhong)
                modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
                        p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
        }
        dsPhong = daoPhong.getPhongVipTrong();
        if (dsPhong != null) {
            for (Phong p : dsPhong)
                modelPhong.addRow(new Object[]{p.getMaPhong(), p.getLoaiPhong().getTenLoaiPhong(), p.getSucChua(),
                        p.getGiaPhong(), p.getMoTa(), p.getTinhTrangPhong()});
        }

    }

    @SuppressWarnings({ "deprecation", "unused" })
    private boolean regExThem()  throws RemoteException {
        // Kiá»ƒm tra tÃªn khÃ¡ch hÃ ng
//		String tenkh = "^[A-Za-z][A-Za-z\\s]+";
        String tenkh = "[a-zA-ZÃ€ÃÃ‚ÃƒÃˆÃ‰ÃŠÃŒÃÃ’Ã“Ã”Ã•Ã™ÃšÄ‚ÄÄ¨Å¨Æ Ã Ã¡Ã¢Ã£Ã¨Ã©ÃªÃ¬Ã­Ã²Ã³Ã´ÃµÃ¹ÃºÄƒÄ‘Ä©Å©Æ¡Æ¯Ä‚áº áº¢áº¤áº¦áº¨áºªáº¬áº®áº°áº²áº´áº¶áº¸áººáº¼á»€á»€á»‚áº¾Æ°Äƒáº¡áº£áº¥áº§áº©áº«áº­áº¯áº±áº³áºµáº·áº¹áº»áº½á»á»á»ƒáº¿á»„á»†á»ˆá»Šá»Œá»Žá»á»’á»”á»–á»˜á»šá»œá»žá» á»¢á»¤á»¦á»¨á»ªá»…á»‡á»‰á»‹á»á»á»‘á»“á»•á»—á»™á»›á»á»Ÿá»¡á»£á»¥á»§á»©á»«á»¬á»®á»°á»²á»´Ãá»¶á»¸á»­á»¯á»±á»³á»µá»·á»¹\\s]+";
        if (!txtTenKH.getText().matches(tenkh)) {
            JOptionPane.showMessageDialog(this, "TÃªn khÃ¡ch hÃ ng khÃ´ng há»£p lá»‡\nChá»‰ chá»©a chá»¯ cÃ¡i vÃ  khoáº£ng tráº¯ng!");
            return false;
        }
        // Kiá»ƒm tra sá»‘ Ä‘iá»‡n thoáº¡i nháº­p Ä‘Ãºng 10 chá»¯ sá»‘
        String sdt = "[0-9]{10}";
        if (!txtSDTKH.getText().matches(sdt)) {
            JOptionPane.showMessageDialog(this, "Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng há»£p lá»‡\nNháº­p Ä‘Ãºng 10 chá»¯ sá»‘!");
            return false;
        }
        // RÃ ng buá»™c nháº­p ngÃ y Ä‘áº¿n lá»›n hÆ¡n ngÃ y hiá»‡n táº¡i
        java.util.Date ngayGioDen = new java.util.Date(chooseNgayDen.getDate().getYear(),
                chooseNgayDen.getDate().getMonth(), chooseNgayDen.getDate().getDate(),
                Integer.parseInt(jComboBoxGio.getSelectedItem().toString()),
                Integer.parseInt(jComboBoxPhut.getSelectedItem().toString()));
        java.util.Date ngayGioHienTai = new java.util.Date();
        if (ngayGioDen.getTime() + 60000 < ngayGioHienTai.getTime()) {
            JOptionPane.showMessageDialog(this, "NgÃ y giá» khÃ´ng há»£p lá»‡!");
            return false;
        }
        if (txtPhong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lÃ²ng chá»n phÃ²ng!");
            return false;
        }
        String str = daoPhong.getPhongTheoMa(txtPhong.getText()).getTinhTrangPhong();
        if (str.equals("Äang hoáº¡t Ä‘á»™ng") || str.equals("Äáº·t trÆ°á»›c")) {
            JOptionPane.showMessageDialog(this, "PhÃ²ng hiá»‡n táº¡i khÃ´ng trá»‘ng!");
            return false;
        }
        return true;
    }
    @SuppressWarnings("deprecation")
    private void themDDP() {
        try {
            if (regExThem()) {
                try {
                    Object[] options = { "CÃ³", "KhÃ´ng" };
                    int n = JOptionPane.showOptionDialog(this, "Báº¡n cÃ³ muá»‘n thÃªm?", "ThÃªm máº·t hÃ ng",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
                            options, // the titles of buttons
                            options[0]); // default button title
                    if (n == JOptionPane.YES_OPTION) {
    //                    ddp.setMaDDP(daoSinhMa.getMaDDP());
    //                    ddp.setKhachHang(daoKhachHang.getKHTheoSDT(txtSDTKH.getText()));
    //                    ddp.setNhanVien(daoNhanVien.getNVTheoTK(maTK));
    //                    ddp.setPhong(daoPhong.getPhongTheoMa(txtPhong.getText()));
    //                    ddp.setTrangThaiDDP(jComboBoxTrangThaiPhong1.getSelectedItem().toString());
    //                    java.util.Date date = chooseNgayDen.getDate();
    //                    ddp.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));
    //
    //                    Time gioDen = new Time(dfHienGio.parse(jComboBoxGio.getSelectedItem().toString() + ":"
    //                            + jComboBoxPhut.getSelectedItem().toString()).getTime());
    //                    ddp.setGioDen(gioDen);
    //                    java.util.Date date1 = new java.util.Date();
    //                    ddp.setNgayLap(new Date(date1.getYear(), date1.getMonth(), date1.getDate()));
                        DonDatPhong ddp = new DonDatPhong();
    //                    ddp.setMaDDP(daoSinhMa.sinhMaTuDong());
                        ddp.setNhanVien(daoNhanVien.getNVTheoTK(maTK));
                        ddp.setKhachHang(daoKhachHang.getKHTheoSDT(txtSDTKH.getText()));
                        ddp.setPhong(daoPhong.getPhongTheoMa(txtPhong.getText()));
                        ddp.setTrangThaiDDP(jComboBoxTrangThaiPhong1.getSelectedItem().toString());
                        java.util.Date date = chooseNgayDen.getDate();
                        ddp.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));
                        Time gioDen = new Time(dfHienGio.parse(jComboBoxGio.getSelectedItem().toString() + ":"
                                + jComboBoxPhut.getSelectedItem().toString()).getTime());
                        ddp.setGioDen(gioDen);
                        java.util.Date date1 = new java.util.Date();
                        ddp.setNgayLap(new Date(date1.getYear(), date1.getMonth(), date1.getDate()));

                        daoDonDatPhong.themDDP(ddp);

                        if (daoDonDatPhong.themDDP(ddp)) {
                            // cap nhat trang thai phong khi them thanh cong
                            if (jComboBoxTrangThaiPhong1.getSelectedItem().toString().matches("ÄÃ£ xÃ¡c nháº­n")) {
                                daoPhong.capNhatTrangThaiPhong(ddp.getPhong().getMaPhong(), "Äang hoáº¡t Ä‘á»™ng");
                            }
                            JOptionPane.showMessageDialog(this, "ThÃªm thÃ nh cÃ´ng!");
                        } else
                            JOptionPane.showMessageDialog(this, " ThÃªm tháº¥t báº¡i");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({ "deprecation", "unused" })
    private boolean regExSua() {
        // RÃ ng buá»™c chá»‰ Ä‘Æ°á»£c phÃ©p sá»­a tráº¡ng thÃ¡i Ä‘Æ¡n Ä‘áº·t phÃ²ng chá» xÃ¡c nháº­n thÃ nh Ä‘Ã£
        // xÃ¡c nháº­n
        String ddpSelect = ddp.getTrangThaiDDP();
        String jcbTrangThai = jComboBoxTrangThaiPhong1.getSelectedItem().toString();
        if (ddpSelect.equals("ÄÃ£ xÃ¡c nháº­n") || ddpSelect.equals("Huá»·")) {
            JOptionPane.showMessageDialog(this, "KhÃ´ng thá»ƒ cáº­p nháº­p Ä‘Æ¡n Ä‘áº·t phÃ²ng 'ÄÃ£ xÃ¡c nháº­n' hoáº·c 'Huá»·'");
            return false;
        }
        // RÃ ng buá»™c nháº­p ngÃ y Ä‘áº¿n lá»›n hÆ¡n ngÃ y hiá»‡n táº¡i
        java.util.Date ngayGioDen = new java.util.Date(chooseNgayDen.getDate().getYear(),
                chooseNgayDen.getDate().getMonth(), chooseNgayDen.getDate().getDate(),
                Integer.parseInt(jComboBoxGio.getSelectedItem().toString()),
                Integer.parseInt(jComboBoxPhut.getSelectedItem().toString()));
        java.util.Date ngayGioHienTai = new java.util.Date();
        if (ngayGioDen.getTime() + 60000 < ngayGioHienTai.getTime()) {
            JOptionPane.showMessageDialog(this, "NgÃ y giá» khÃ´ng há»£p lá»‡!");
            return false;
        }
        return true;
    }

    private void suaDDP() {// update phÃ²ng,ngÃ y giá» Ä‘áº¿n.
        if (regExSua()) {
            try {
//                this.ddp.setPhong(daoPhong.getPhongTheoMa(txtPhong.getText())); // update
//                ddp.setTrangThaiDDP(jComboBoxTrangThaiPhong1.getSelectedItem().toString());// update
//
//                java.util.Date date = chooseNgayDen.getDate();
//                ddp.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));// update
//
//                Time gioDen = new Time(dfHienGio.parse(
//                                jComboBoxGio.getSelectedItem().toString() + ":" + jComboBoxPhut.getSelectedItem().toString())
//                        .getTime());
//                ddp.setGioDen(gioDen);// update
                DonDatPhong ddp = new DonDatPhong();
                ddp.setMaDDP(this.ddp.getMaDDP());
                ddp.setNhanVien(daoNhanVien.getNVTheoTK(maTK));
                ddp.setKhachHang(daoKhachHang.getKHTheoSDT(txtSDTKH.getText()));
                ddp.setPhong(daoPhong.getPhongTheoMa(txtPhong.getText()));
                ddp.setTrangThaiDDP(jComboBoxTrangThaiPhong1.getSelectedItem().toString());
                java.util.Date date = chooseNgayDen.getDate();
                ddp.setNgayDen(new Date(date.getYear(), date.getMonth(), date.getDate()));
                Time gioDen = new Time(dfHienGio.parse(jComboBoxGio.getSelectedItem().toString() + ":"
                        + jComboBoxPhut.getSelectedItem().toString()).getTime());
                ddp.setGioDen(gioDen);

                daoDonDatPhong.capNhatDDP(ddp, this.ddp.getMaDDP());

                boolean update = daoDonDatPhong.capNhatDDP(this.ddp, this.ddp.getMaDDP());
                if (update && jComboBoxTrangThaiPhong1.getSelectedItem().toString().matches("ÄÃ£ xÃ¡c nháº­n")) {
                    daoPhong.capNhatTrangThaiPhong(ddp.getPhong().getMaPhong(), "Äang hoáº¡t Ä‘á»™ng");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @SuppressWarnings("deprecation")
    private void lamMoi() {
        txtTenKH.setText("");
        txtTenNV.setText("");
        txtSDTKH.setText("");
        txtPhong.setText("");
        jTextFieldTimDDP.setText("Nháº­p mÃ£ Ä‘Æ¡n Ä‘áº·t phÃ²ng");
        chooseNgayDen.setDate(new java.util.Date());
        jComboBoxGio.setSelectedItem(new java.util.Date().getHours() + "");
        jComboBoxPhut.setSelectedItem(new java.util.Date().getMinutes() + "");
        jComboBoxLoaiKH.setSelectedItem(0);
        jComboBoxTrangThaiPhong1.setSelectedIndex(0);
        ddp = null;

    }

    private void timDDP() throws RemoteException {
        List<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
        lstDDP = daoDonDatPhong.getDDPTheoMaDDP(jTextFieldTimDDP.getText());
        modelDDP = new DefaultTableModel(colDDP, 0);
        jTable1.setModel(modelDDP);
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }
        for (DonDatPhong infoDDP : lstDDP) {
            KhachHang kh = daoKhachHang.getKHTheoMa(infoDDP.getKhachHang().getMaKhangHang());
            NhanVien nv = daoNhanVien.getMaVaSdtNVChoDDP(infoDDP.getNhanVien().getMaNhanVien());
            LoaiPhong loaiPhong = daoLoaiPhong.getLoaiPhongTheoMa(infoDDP.getPhong().getLoaiPhong().getMaLoaiPhong());

            modelDDP.addRow(new Object[] { infoDDP.getMaDDP(), kh.getTenKH(), infoDDP.getPhong().getMaPhong(),
                    loaiPhong.getTenLoaiPhong(), infoDDP.getKhachHang().getSdt(), dfHienGio.format(infoDDP.getGioDen()),
                    dfNgay.format(infoDDP.getNgayDen()), nv.getTenNhanVien(), dfNgay.format(infoDDP.getNgayLap()),
                    infoDDP.getTrangThaiDDP() });
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoiDDP;
    private javax.swing.JButton btnSuaDDP;
    private javax.swing.JButton btnThemDDP;
    private javax.swing.JButton btnXoaDDP;
    private javax.swing.JComboBox<String> jComboBoxGio;
    private javax.swing.JComboBox<String> jComboBoxLoaiKH;
    private javax.swing.JComboBox<String> jComboBoxPhut;
    private javax.swing.JComboBox<String> jComboBoxTrangThaiPhong;
    private javax.swing.JComboBox<String> jComboBoxTrangThaiPhong1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelThongTinDDP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldTimDDP;
    private javax.swing.JButton jbTimDDP;
    private javax.swing.JButton btnPhong;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtNgayDen;
    private JDateChooser chooseNgayDen;
    private javax.swing.JTextField txtPhong;
    private javax.swing.JTextField txtSDTKH;
    private javax.swing.JTextField txtTenKH;
    private SimpleDateFormat dfNgay, dfHienGio;
    private DefaultTableModel modelDDP;
    private DefaultTableModel modelPhong;
    @SuppressWarnings("unused")
    private Date dNgayHienTai;
    // KHAI BAO DAO
    //    private DAOLoaiKH daoLoaiKH;
    private DAOSinhMaTuDong daoSinhMa;
    private NhanVien nhanvien;
    // private LoaiPhong loaiPhong;
    private DonDatPhong ddp;
    private static String maTK;
    private String colDDP[] = {"MÃ£ DDP", "TÃªn khÃ¡ch hÃ ng", "MÃ£ phÃ²ng", "Loáº¡i phÃ²ng", "SÄT", "Giá» Ä‘áº¿n", "NgÃ y Ä‘áº¿n",
            "TÃªn nhÃ¢n viÃªn", "NgÃ y láº­p", "Tráº¡ng thÃ¡i"};
    private String colPhong[] = {"MÃ£ phÃ²ng", "Loáº¡i PhÃ²ng", "Sá»©c chá»©a", "GiÃ¡", "MÃ´ táº£", "Tráº¡ng thÃ¡i"};


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRMQuanLiDatPhong().setVisible(true);
            }
        });
    }
}
