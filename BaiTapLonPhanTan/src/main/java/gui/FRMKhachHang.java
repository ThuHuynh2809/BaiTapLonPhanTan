
package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.*;
import entity.*;
import impl.KhachHangImpl;
import impl.LoaiKHDaoImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

/**
 *
 * @author Asus
 */
public class FRMKhachHang extends javax.swing.JFrame implements MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form NewJFrame
	 * 
	 * @throws RemoteException
	 */
	public FRMKhachHang() throws RemoteException {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() throws RemoteException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
		LocalDate now = LocalDate.now();
		ngay = now.getDayOfMonth();
		thang = now.getMonthValue() - 1;
		nam = now.getYear() - 1900;
		dNow = new Date(nam, thang, ngay);
		// new dao
		daoMaKH = new DAOSinhMaTuDong();
		daoKhachHang = new KhachHangImpl();
		daoLoaiKH = new LoaiKHDaoImpl();
		regex = new Regex();
		// format ngay
		dfNgaySinh = new SimpleDateFormat("dd/MM/yyyy");
		chooserNgaySinh = new JDateChooser();
		dateChooserNgayDangKy = new JDateChooser();

		kh = new KhachHang();
		////
		jPanel5 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		jcboGtinh = new javax.swing.JComboBox<>();
		jLabel12 = new javax.swing.JLabel();
		jcboLoaiKH = new javax.swing.JComboBox<>();
		txtHoTen = new javax.swing.JTextField();
		txtSDT = new javax.swing.JTextField();
		txtDiaChi = new javax.swing.JTextField();
		txtCCCD = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		txtMaKH = new javax.swing.JTextField();
		txtNgaySinh = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jPanel4 = new javax.swing.JPanel();
		jLabel14 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jpnSapXep1 = new javax.swing.JPanel();
		jLabel17 = new javax.swing.JLabel();
		jRadioButton4 = new javax.swing.JRadioButton();
		jRadioButton5 = new javax.swing.JRadioButton();
		jRadioButton6 = new javax.swing.JRadioButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		btnThemNV = new javax.swing.JButton();
		btnSuaNV = new javax.swing.JButton();
		btnLamMoi = new javax.swing.JButton();
		btnXoaNV = new javax.swing.JButton();
		jbTimKH = new javax.swing.JButton();
		jbLocKH = new javax.swing.JButton();

//		now = LocalDate.now();
//		ngay = now.getDayOfMonth(); 
//		thang = now.getMonthValue()-1;
//		nam = now.getYear()-1900;
//		dNow = new Date(nam, thang, ngay);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel5.setPreferredSize(new java.awt.Dimension(1202, 422));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
		jPanel3.setPreferredSize(new java.awt.Dimension(360, 512));

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel6.setText("Họ và tên: ");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel7.setText("SDT: ");

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel8.setText("Địa chỉ: ");

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel9.setText("CCCD: ");

		jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel10.setText("Ngày Sinh: ");

		chooserNgaySinh = new JDateChooser();
		chooserNgaySinh.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chooserNgaySinh.setBounds(110, 213, 191, 25);
		chooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		chooserNgaySinh.setDate(dNgayHienTai);
		chooserNgaySinh.setBorder(new LineBorder(new Color(114, 23, 153), 1, true));
		chooserNgaySinh.setFont(new Font("SansSerif", Font.PLAIN, 15));
		chooserNgaySinh.getCalendarButton().setPreferredSize(new Dimension(30, 24));
		chooserNgaySinh.getCalendarButton().setBackground(new Color(102, 0, 153));
		chooserNgaySinh.getCalendarButton().setToolTipText("Chá»n ngÃ y sinh");

		jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel11.setText("Giới tính:");

		jcboGtinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ¯" }));

		jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel12.setText("Loại khách hàng:");

		jcboLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(
				new String[] { "Khách hàng thường", "Thành viên thường", "Thành viên VIP" }));

		txtHoTen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtHoTenActionPerformed(evt);
			}
		});

		jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel16.setText("Mã KH: ");

		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel5.setText("THÔNG TIN KHÁCH HÀNG");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(23, 23, 23)
										.addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel16).addComponent(jLabel8).addComponent(jLabel9)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel6,
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel7))
												.addGroup(
														jPanel3Layout.createSequentialGroup().addGap(1, 1, 1)
																.addComponent(jLabel12)))
										.addGap(11, 11, 11))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														jPanel3Layout.createSequentialGroup().addComponent(jLabel11)
																.addGap(25, 25, 25))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout
														.createSequentialGroup().addComponent(jLabel10).addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
								.addGroup(jPanel3Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jcboGtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 104,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
										.addComponent(txtDiaChi).addComponent(txtMaKH).addComponent(txtSDT)
										.addComponent(txtHoTen).addComponent(chooserNgaySinh).addComponent(jcboLoaiKH,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(66, 66, 66).addComponent(jLabel5)))
						.addContainerGap(20, Short.MAX_VALUE)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(chooserNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel10))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jcboGtinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel11))
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
										jcboLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel3Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(
										jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(195, 195, 195)));

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel14.setText("Tìm kiếm");

		jpnSapXep1.setBackground(new java.awt.Color(255, 255, 255));
		jpnSapXep1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

		jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel17.setText("Sắp xếp");

		jRadioButton4.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton4.setText("Theo Mã");

		jRadioButton5.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton5.setText("Theo tên");

		jRadioButton6.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton6.setText("Loại khách hàng");

		javax.swing.GroupLayout jpnSapXep1Layout = new javax.swing.GroupLayout(jpnSapXep1);
		jpnSapXep1.setLayout(jpnSapXep1Layout);
		jpnSapXep1Layout
				.setHorizontalGroup(jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jpnSapXep1Layout.createSequentialGroup().addGap(32, 32, 32)
								.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 73,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(61, 61, 61)
								.addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(86, 86, 86).addComponent(jRadioButton5).addGap(84, 84, 84)
								.addComponent(jRadioButton6)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jpnSapXep1Layout.setVerticalGroup(jpnSapXep1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpnSapXep1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButton4).addComponent(jRadioButton5).addComponent(jRadioButton6)
								.addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		btnGr = new ButtonGroup();
		btnGr.add(jRadioButton4);
		btnGr.add(jRadioButton5);
		btnGr.add(jRadioButton6);

//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null},
//                {null, null, null, null, null, null, null, null}
//            },
//            new String [] {
//                "MÃ£ NV", "Há» tÃªn", "SÄT", "Äá»‹a chá»‰", "CCCD", "NgÃ y sinh", "Giá»›i tÃ­nh", "Loáº¡i khÃ¡ch hÃ ng"
//            }
//        ));
		String[] col = { "Mã KH", "Họ và tên KH", "Loại KH", "Giới tính", "Ngày sinh", "Địa chỉ", "Sđt", "CCCD",
				"Ngày đăng ký", "Điểm tích lũy" };
		modelKH = new DefaultTableModel(col, 0);
		jTable1 = new JTable(modelKH);
		jScrollPane1.setViewportView(jTable1);
		loadDanhSachKH();
		// do dai cua tung cot trong table
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
		jTable1.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTable1.getColumnModel().getColumn(4).setPreferredWidth(130);
		jTable1.getColumnModel().getColumn(5).setPreferredWidth(250);
		jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
		jTable1.getColumnModel().getColumn(7).setPreferredWidth(150);
		jTable1.getColumnModel().getColumn(8).setPreferredWidth(200);
		jTable1.getColumnModel().getColumn(9).setPreferredWidth(150);

		btnThemNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnThemNV.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\add.png")); // NOI18N
		btnThemNV.setText("Thêm");

		btnSuaNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSuaNV.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\service.png")); // NOI18N
		btnSuaNV.setText("Sữa");

		btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		btnLamMoi.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\refresh.png")); // NOI18N
		btnLamMoi.setText("Làm mới");
		btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnLamMoiActionPerformed(evt);
			}
		});

		btnXoaNV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
		btnXoaNV.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\delete.png")); // NOI18N
		btnXoaNV.setText("Xóa");

		jbTimKH.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\search.png")); // NOI18N

		jbLocKH.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\New folder\\BaiTapLonPhanTan\\iCon\\sorting.png")); // NOI18N

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(34, 34, 34).addGroup(jPanel4Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6)
										.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 621,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jpnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(jPanel4Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
												jbLocKH, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
										.addGroup(jPanel4Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
												jbTimKH, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(84, 84, 84).addComponent(btnThemNV)
						.addGap(101, 101, 101)
						.addComponent(btnSuaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLamMoi).addGap(86, 86, 86).addComponent(btnXoaNV,
								javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(34, 34, 34)));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jbTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(16, 16, 16)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jbLocKH).addComponent(jpnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThemNV).addComponent(btnSuaNV).addComponent(btnLamMoi)
								.addComponent(btnXoaNV))
						.addContainerGap(17, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 397,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1208, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1208,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 425, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap()
										.addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 413,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));
		dateChooserNgayDangKy.setDate(dNow);
		// add event
		jTable1.addMouseListener(this);
		btnXoaNV.addActionListener(this);
		jRadioButton4.addActionListener(this);
		jRadioButton5.addActionListener(this);
		jRadioButton6.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThemNV.addActionListener(this);
		jbTimKH.addActionListener(this);
		btnSuaNV.addActionListener(this);
		pack();
		// mÃ£ khÃ¡ch hÃ ng tá»± Ä‘á»™ng sinh k cáº§n nháº­p
		txtMaKH.setEnabled(false);
	}// </editor-fold>//GEN-END:initComponents
		////////////////////////////
		// lÃ m trá»‘ng báº£ng nháº­p thÃ´ng tin khÃ¡ch hÃ ng

	private void reset() {
		txtMaKH.setText("");
		txtCCCD.setText("");
		txtNgaySinh.setText("");
		txtHoTen.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		chooserNgaySinh.setDate(dNow);
		dateChooserNgayDangKy.setDate(dNow);
		jcboGtinh.setSelectedIndex(1);
		jcboLoaiKH.setSelectedIndex(0);
	}

	public void loadDanhSachKH() throws RemoteException {
		clearTable();
		ArrayList<KhachHang> lsKH = daoKhachHang.getAllDanhSachKH();
		for (KhachHang kh : lsKH) {
			if( kh.getLoaiKH() != null) {
				LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(kh.getLoaiKH().getMaLoaiKH());

				String ngaySinh = "";
				String ngayDK = "";
				if (kh.getNgaySinh() != null)
					ngaySinh = dfNgaySinh.format(kh.getNgaySinh());
				if (kh.getNgayDangKy() != null)
					ngayDK = dfNgaySinh.format(kh.getNgayDangKy());

				modelKH.addRow(new Object[] { kh.getMaKhangHang(), kh.getTenKH(), loaiKH.getTenLoaiKH(), kh.getGioiTinh(),
						ngaySinh, kh.getDiaChi(), kh.getSdt(), kh.getCccd(), ngayDK, kh.getDiemTichLuy() });


			}

		}
	}

	// load thong tin 1 nguoi
	public void loadThongTin(KhachHang kh) throws RemoteException {
		LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(kh.getLoaiKH().getMaLoaiKH());
		String ngaySinh = "";
		String ngayDK = "";
		if (kh.getNgaySinh() != null)
			ngaySinh = dfNgaySinh.format(kh.getNgaySinh());
		if (kh.getNgayDangKy() != null)
			ngayDK = dfNgaySinh.format(kh.getNgayDangKy());

		modelKH.addRow(new Object[] { kh.getMaKhangHang(), kh.getTenKH(), loaiKH.getTenLoaiKH(), kh.getGioiTinh(),
				ngaySinh, kh.getDiaChi(), kh.getSdt(), kh.getCccd(), ngayDK, kh.getDiemTichLuy() });
	}

	// lÃ m trá»‘ng báº£ng
	private void clearTable() {
		while (jTable1.getRowCount() > 0) {
			modelKH.removeRow(0);
		}
	}

	public void resetAll() throws RemoteException {
		txtHoTen.setText("");
		txtSDT.setText("");
		txtCCCD.setText("");
		txtDiaChi.setText("");
		chooserNgaySinh.setDate(dNow);
		dateChooserNgayDangKy.setDate(dNow);
		loadDanhSachKH();
	}

	// thÃªm khÃ¡ch hÃ ng
	// chÆ°a xong
	private void themKH() {
	    try {
	    	KhachHang kh = new KhachHang();
	        DAOSinhMaTuDong daoSinhMaTuDong = new DAOSinhMaTuDong();
	        
	        String maKH = daoSinhMaTuDong.getMaKH();
	        kh.setMaKhangHang(maKH);
	        kh.setTenKH(txtHoTen.getText());
	        kh.setSdt(txtSDT.getText());
	        kh.setDiaChi(txtDiaChi.getText());
	        kh.setCccd(txtCCCD.getText());
	        kh.setNgaySinh(chooserNgaySinh.getDate());
	        kh.setNgayDangKy(dateChooserNgayDangKy.getDate());
	        kh.setGioiTinh(jcboGtinh.getSelectedItem().toString());
	        kh.setDiemTichLuy(0);
	        kh.setLoaiKH(daoLoaiKH.getMaLoaiKHTheoTen(jcboLoaiKH.getSelectedItem().toString()));
	        

	        LocalDate ngaySinh = chooserNgaySinh.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        LocalDate ngayDangKy = dateChooserNgayDangKy.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	        
	        int tuoi = Period.between(ngaySinh, LocalDate.now()).getYears();

	        if (regex.regexTen(txtHoTen) && regex.regexSDT(txtSDT) && regex.regexCCCD(txtCCCD)
	                && regex.regexDiaChi(txtDiaChi)) {
	            if (tuoi >= 13) {
	                if (!daoKhachHang.checkSdtKH(kh.getSdt())) {
	                    daoKhachHang.themKhachHang(kh);
//	                    loadThongTin(kh);
//	                    reset();
	                    JOptionPane.showMessageDialog(this, "Them khach hang thanh cong", "Thong bao",
	                            JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                    JOptionPane.showMessageDialog(this, "So dien thoai da ton tai", "Thong bao",
	                            JOptionPane.ERROR_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Khach hang chua du 13 tuoi", "Thong bao",
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        }

	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập số điện thoại hợp lệ", "Lỗi",
	                JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
	                JOptionPane.WARNING_MESSAGE);
	    }
	}

	// sá»­a khÃ¡ch hÃ ng
	@SuppressWarnings("deprecation")
	public void suaThongTin() throws RemoteException {
		int row = jTable1.getSelectedRow();
		if (row >= 0) {
			int update = JOptionPane.showConfirmDialog(this, "Bạn muốn sửa thông tin khách hàng này?",
					getTitle(), JOptionPane.YES_NO_OPTION);
			if (update == JOptionPane.YES_OPTION) {
				java.util.Date date = chooserNgaySinh.getDate();
				Date ngaySinh = new Date(date.getYear(), date.getMonth(), date.getDate());
//				java.util.Date date1 = chooserNgayDangKy.getDate();
//				Date ngayDangKy=new Date(date1.getYear(), date1.getMonth(), date1.getDate());
				int tuoi = nam - ngaySinh.getYear();
				// System.out.println(tuoi);
				String maKH = modelKH.getValueAt(row, 0).toString();
				String tenKH = txtHoTen.getText();
				String sdt = txtSDT.getText();
				String diaChi = txtDiaChi.getText();
				String cccd = txtCCCD.getText();
				String gioiTinh = jcboGtinh.getSelectedItem().toString();
				LoaiKH loaiKH = daoLoaiKH.getMaLoaiKHTheoTen(jcboLoaiKH.getSelectedItem().toString());

				int diemTichLuy = kh.getDiemTichLuy();
				if (regex.regexTen(txtHoTen) && regex.regexSDT(txtSDT) && regex.regexCCCD(txtCCCD)
						&& regex.regexDiaChi(txtDiaChi)) {
					if (tuoi >= 13) {
						try {
							KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, cccd, ngaySinh, gioiTinh,
									diemTichLuy, dNow, loaiKH);
							daoKhachHang.capNhatKH(kh);
							reset();
							loadDanhSachKH();
							JOptionPane.showMessageDialog(this, "Thông tin khách hàng đã sửa!", "Thông báo",
									JOptionPane.OK_OPTION);

						} catch (Exception e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(null, "Chỉnh sửa thông tin thất bại!", "Thông báo",
									JOptionPane.ERROR_MESSAGE);
						}

					} else {
						JOptionPane.showMessageDialog(null, "Khách hàng chưa đủ 13 tuổi", "Thông báo",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng muốn sửa", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// xoÃ¡ khÃ¡ch hÃ ng
	private boolean deleteKH() throws RemoteException, HeadlessException {
		int row = jTable1.getSelectedRow();
		if (row >= 0) {
			int choose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (choose == JOptionPane.YES_OPTION)
				try {
					{
						// lay maKH Ä‘á»ƒ xoÃ¡
						String maKH = jTable1.getValueAt(row, 0).toString();
						// xoÃ¡ khÃ¡ch hÃ ng khá»i báº£ng
						modelKH.removeRow(row);

						// xoÃ¡ khÃ¡ch hÃ ng khá»i database
						daoKhachHang.huyKH(maKH);
						JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công", "Thông báo", JOptionPane.OK_OPTION);
						reset();

					}
				} catch (HeadlessException | RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} else {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn khách hàng muốn xóa", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}

	// sap xep loaiKH tang dan
	public void sortLoaiKH(KhachHang kh) throws RemoteException {
		clearTable();
		ArrayList<KhachHang> lsKhachHang = daoKhachHang
				.getKHTheoLoai(String.valueOf(daoLoaiKH.getMaLoaiKHTheoTen("Khách hàng thường")));
		for (KhachHang khs : lsKhachHang) {
			LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(khs.getLoaiKH().getMaLoaiKH());
			String ngaySinh = "";
			String ngayDK = "";
			if (khs.getNgaySinh() != null)
				ngaySinh = dfNgaySinh.format(khs.getNgaySinh());
			if (khs.getNgayDangKy() != null)
				ngayDK = dfNgaySinh.format(khs.getNgayDangKy());

			modelKH.addRow(
					new Object[] { khs.getMaKhangHang(), khs.getTenKH(), loaiKH.getTenLoaiKH(), khs.getGioiTinh(),
							ngaySinh, khs.getDiaChi(), khs.getSdt(), khs.getCccd(), ngayDK, khs.getDiemTichLuy() });
		}

		ArrayList<KhachHang> lsThanhVien = daoKhachHang
				.getKHTheoLoai(String.valueOf(daoLoaiKH.getMaLoaiKHTheoTen("Thành viên thường")));
		for (KhachHang khs : lsThanhVien) {
			LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(khs.getLoaiKH().getMaLoaiKH());
			String ngaySinh = "";
			String ngayDK = "";
			if (khs.getNgaySinh() != null)
				ngaySinh = dfNgaySinh.format(khs.getNgaySinh());
			if (khs.getNgayDangKy() != null)
				ngayDK = dfNgaySinh.format(khs.getNgayDangKy());

			modelKH.addRow(
					new Object[] { khs.getMaKhangHang(), khs.getTenKH(), loaiKH.getTenLoaiKH(), khs.getGioiTinh(),
							ngaySinh, khs.getDiaChi(), khs.getSdt(), khs.getCccd(), ngayDK, khs.getDiemTichLuy() });
		}

		ArrayList<KhachHang> lsVip = daoKhachHang.getKHTheoLoai(String.valueOf(daoLoaiKH.getMaLoaiKHTheoTen("Thành viên VIP")));
		for (KhachHang khs : lsVip) {
			LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(khs.getLoaiKH().getMaLoaiKH());
			String ngaySinh = "";
			String ngayDK = "";
			if (khs.getNgaySinh() != null)
				ngaySinh = dfNgaySinh.format(khs.getNgaySinh());
			if (khs.getNgayDangKy() != null)
				ngayDK = dfNgaySinh.format(khs.getNgayDangKy());

			modelKH.addRow(
					new Object[] { khs.getMaKhangHang(), khs.getTenKH(), loaiKH.getTenLoaiKH(), khs.getGioiTinh(),
							ngaySinh, khs.getDiaChi(), khs.getSdt(), khs.getCccd(), ngayDK, khs.getDiemTichLuy() });
		}
	}

	private void loadDanhSachMaVaSoKH(ArrayList<KhachHang> kh1) throws RemoteException {
		clearTable();
		ArrayList<KhachHang> lstName = daoKhachHang.getMaVaSDTKH(jTextField1.getText().toLowerCase().trim());
		for (KhachHang lskh : lstName) {
			LoaiKH loaiKH = daoLoaiKH.getLoaiKHTheoMaLoai(lskh.getLoaiKH().getMaLoaiKH());
			String ngaySinh = "";
			String ngayDK = "";
			if (lskh.getNgaySinh() != null)
				ngaySinh = dfNgaySinh.format(lskh.getNgaySinh());
			if (lskh.getNgayDangKy() != null)
				ngayDK = dfNgaySinh.format(lskh.getNgayDangKy());

			modelKH.addRow(
					new Object[] { lskh.getMaKhangHang(), lskh.getTenKH(), loaiKH.getTenLoaiKH(), lskh.getGioiTinh(),
							ngaySinh, lskh.getDiaChi(), lskh.getSdt(), lskh.getCccd(), ngayDK, lskh.getDiemTichLuy() });
		}
	}

	private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtHoTenActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtHoTenActionPerformed

	private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLamMoiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnLamMoiActionPerformed

	public JPanel getFRMKhachHang() {
		return jPanel5;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FRMKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FRMKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FRMKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FRMKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FRMKhachHang().setVisible(true);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLamMoi;
	private javax.swing.JButton btnSuaNV;
	private javax.swing.JButton btnThemNV;
	private javax.swing.JButton btnXoaNV;
	private javax.swing.JLabel jLabel10;
	@SuppressWarnings("unused")
	private Date dNgayHienTai;
	private LocalDate now;
	private Date dNow;
	private int nam, thang, ngay;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton5;
	private javax.swing.JRadioButton jRadioButton6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton jbLocKH;
	private javax.swing.JButton jbTimKH;
	private javax.swing.JComboBox<String> jcboLoaiKH;
	private javax.swing.JComboBox<String> jcboGtinh;
	private javax.swing.JPanel jpnSapXep1;
	private javax.swing.JTextField txtCCCD;
	private JDateChooser chooserNgaySinh;
	private JDateChooser dateChooserNgayDangKy;
	private javax.swing.JTextField txtNgaySinh;
	private javax.swing.JTextField txtDiaChi;
	private javax.swing.JTextField txtHoTen;
	private javax.swing.JTextField txtMaKH;
	private javax.swing.JTextField txtSDT;
	private Format dfNgaySinh;
	private DefaultTableModel modelKH;
	private KhachHang kh;
	private ButtonGroup btnGr;
	// DAO
	private DAOSinhMaTuDong daoMaKH;
	private LoaiKHDao daoLoaiKH;
	private KhachHangDao daoKhachHang;
	private Regex regex;

	// End of variables declaration//GEN-END:variables
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(jTable1)) {
			int row = jTable1.getSelectedRow();

			if (row > -1) {
				String maKH = (String) jTable1.getValueAt(row, 0);
				ArrayList<KhachHang> lstKH = null;
				try {
					lstKH = daoKhachHang.getAllDanhSachKH();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (KhachHang kh : lstKH) {
					if (maKH.equals(kh.getMaKhangHang())) {
						txtMaKH.setText(kh.getMaKhangHang());
						txtHoTen.setText(kh.getTenKH());
						txtSDT.setText(kh.getSdt());
						txtDiaChi.setText(kh.getDiaChi());
						txtCCCD.setText(kh.getCccd());
						jcboGtinh.setSelectedItem(kh.getGioiTinh());
						chooserNgaySinh.setDate(kh.getNgaySinh());
						jcboLoaiKH.setSelectedItem(kh.getLoaiKH());
						break;
					}
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnXoaNV)) {
			try {
				deleteKH();
			} catch (HeadlessException | RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnThemNV)) {
			
			try {
				themKH();
				clearTable();
				loadDanhSachKH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(jRadioButton4)) {
			try {
				loadDanhSachKH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(jRadioButton6)) {
			try {
				sortLoaiKH(kh);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(jRadioButton5)) {
			// sortTenKH(kh);
		}
		if (o.equals(btnLamMoi))
			reset();
		if (o.equals(jbTimKH)) {
			// findKH();
		}
		if (o.equals(btnSuaNV)) {
			try {
				suaThongTin();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
