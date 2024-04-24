package gui;

import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

import dao.DAOSinhMaTuDong;
import dao.LoaiMhDao;
import dao.MacHangDao;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.LoaiMH;
import entity.MatHang;
import impl.LoaiMhImpl;
import impl.MatHangImpl;
import impl.NhanVienImpl;
import impl.TaiKhoanImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FRMQuanLiMatHang extends javax.swing.JFrame implements ActionListener, MouseListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates new form FRMQuanLiMatHang
	 * 
	 * @throws RemoteException
	 */
	public FRMQuanLiMatHang() throws RemoteException {
		initComponents();
	}

	public JPanel getFRMMatHang() {
		return jPanel5;
	}

	public static NhanVienDao nhanVienDao;

	static {
		try {
			nhanVienDao = new NhanVienImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	public static TaiKhoanDao taiKhoanDao;
	static {
		try {
			taiKhoanDao = new TaiKhoanImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	public static MacHangDao matHangDao;
	static {
		try {
			matHangDao = new MatHangImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	public static LoaiMhDao loaiMhDao;
	static {
		try {
			loaiMhDao = new LoaiMhImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })

	private void initComponents() throws RemoteException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();

		jLabel13 = new javax.swing.JLabel();
		txtCCCD2 = new javax.swing.JTextField();
		jLabel18 = new javax.swing.JLabel();
		jcboGtinh1 = new javax.swing.JComboBox<>();
		jcboChucVu1 = new javax.swing.JComboBox<>();
		jLabel15 = new javax.swing.JLabel();
		txtCCCD3 = new javax.swing.JTextField();
		jLabel19 = new javax.swing.JLabel();
		jPanel5 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		txtTenMH = new javax.swing.JTextField();
		txtSoLuong = new javax.swing.JTextField();
		jLabel16 = new javax.swing.JLabel();
		txtMaMH = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		txtGiaBan = new javax.swing.JTextField();
		btnThemMH = new javax.swing.JButton();
		btnSuaMH = new javax.swing.JButton();
		btnLamMoiMH = new javax.swing.JButton();
		btnXoaMH = new javax.swing.JButton();
		jComboLoaiMatHang = new javax.swing.JComboBox<>();
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
		btnTimMH = new javax.swing.JButton();
		btnLocMH = new javax.swing.JButton();

//	 	new dao
		MacHangDao matHangDao;
		LoaiMhDao loaiMhDao;

//		daoPhatSinhMa = new DAOPhatSinhMa();
		txtMaMH.setEnabled(false);


		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel5.setPreferredSize(new java.awt.Dimension(1202, 422));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 255)));
		jPanel3.setPreferredSize(new java.awt.Dimension(329, 512));

		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel6.setText("Tên MH :");

		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel7.setText("Số lượng:");

		jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel8.setText("Loại MH:");


		jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel16.setText("Mã MH:");
		jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jLabel5.setText("THÔNG TIN MẶT HÀNG");

		jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		jLabel9.setText("Giá bán:");

		btnThemMH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnThemMH.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\baiTapLonCKPTUD\\iCon\\add.png")); // NOI18N
		btnThemMH.setText("Thêm");

		btnSuaMH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnSuaMH.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\baiTapLonCKPTUD\\iCon\\service.png")); // NOI18N
		btnSuaMH.setText("Sửa");

		btnLamMoiMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
		btnLamMoiMH.setIcon(
				new javax.swing.ImageIcon("D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\baiTapLonCKPTUD\\iCon\\refresh.png")); // NOI18N
		btnLamMoiMH.setText("Làm mới");
//		btnLamMoiMH.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnLamMoiMHActionPerformed(evt);
//			}
//		});

		btnXoaMH.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
		btnXoaMH.setIcon(
				new javax.swing.ImageIcon("\\delete.png")); // NOI18N
		btnXoaMH.setText("Xóa");
		listLMH = FRMQuanLiMatHang.loaiMhDao.getAllLoaiMatHang();
		for (LoaiMH lmh : listLMH)
			jComboLoaiMatHang.addItem(lmh.getTenLoaiMatHang());
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(66, 66, 66).addComponent(jLabel5))
						.addGroup(jPanel3Layout.createSequentialGroup().addGap(22, 22, 22)
								.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel16).addComponent(jLabel6).addComponent(jLabel8)
												.addComponent(jLabel9)).addGap(11, 11, 11)
												.addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtGiaBan)
														.addGroup(jPanel3Layout.createSequentialGroup()
																.addComponent(jComboLoaiMatHang,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0, 0, Short.MAX_VALUE))
														.addComponent(txtMaMH)
														.addComponent(txtTenMH).addComponent(txtSoLuong)))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(btnLamMoiMH, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(
																btnThemMH, javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45,
																Short.MAX_VALUE)
														.addGroup(jPanel3Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING,
																		false)
																.addComponent(btnXoaMH,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(btnSuaMH,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE))))))
						.addGap(31, 31, 31)));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtMaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jComboLoaiMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel8))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnThemMH).addComponent(btnSuaMH))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnLamMoiMH).addComponent(btnXoaMH))
						.addContainerGap(15, Short.MAX_VALUE)));

		jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel14.setText("Tìm kiếm");

		jpnSapXep1.setBackground(new java.awt.Color(255, 255, 255));
		jpnSapXep1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

		jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
		jLabel17.setText("Sắp Xếp");

		jRadioButton4.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton4.setText("Theo Mã");

		jRadioButton5.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton5.setText("Theo tên");

		jRadioButton6.setBackground(new java.awt.Color(255, 153, 204));
		jRadioButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
		jRadioButton6.setText("Loại mặt hàng");

//		jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				jRadioButton6ActionPerformed(evt);
//			}
//		});

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
								.addGap(86, 86, 86).addComponent(jRadioButton5).addGap(78, 78, 78)
								.addComponent(jRadioButton6)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jpnSapXep1Layout.setVerticalGroup(jpnSapXep1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jpnSapXep1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jpnSapXep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jRadioButton4).addComponent(jRadioButton5).addComponent(jRadioButton6)
								.addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		// Load Table
		String[] col = { "Mã mặt hàng", "Tên mặt hàng", "Số lượng", "Loại mặt hàng", "Giá bán" };

		modelMH = new DefaultTableModel(col, 0);
		jTable1 = new JTable(modelMH);
		jScrollPane1.setViewportView(jTable1);
//		loadDsMH();
		loadDsMH();

		btnTimMH.setIcon(new javax.swing.ImageIcon(
				"D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\baiTapLonCKPTUD\\iCon\\search.png")); // NOI18N

		btnLocMH.setIcon(new javax.swing.ImageIcon(
				"D:\\Desktop\\HocTap\\HocKi2_Nam 4_(2024_2025)\\LTPT_Java\\THNhom\\baiTapLonCKPTUD\\iCon\\sorting.png")); // NOI18N

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGap(34, 34, 34)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addGroup(jPanel4Layout.createSequentialGroup()
										.addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 621,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jpnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(btnTimMH, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLocMH, javax.swing.GroupLayout.PREFERRED_SIZE, 75,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(21, Short.MAX_VALUE))
				.addComponent(jScrollPane1));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel4Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(jLabel14,
								javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel4Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnTimMH, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(15, 15, 15)
						.addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnLocMH, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jpnSapXep1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(15, Short.MAX_VALUE)));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 317,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 399,
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

		pack();
		// Button Group Radio
		
		bgRadio = new ButtonGroup();
		bgRadio.add(jRadioButton4);
		bgRadio.add(jRadioButton5);
		bgRadio.add(jRadioButton6);
		// add ActionListener Button
		btnLamMoiMH.addActionListener(this);
		btnSuaMH.addActionListener(this);
		btnThemMH.addActionListener(this);
		btnXoaMH.addActionListener(this);
		btnTimMH.addActionListener(this);
		btnLocMH.addActionListener(this);
		jRadioButton4.addActionListener(this);
		jRadioButton5.addActionListener(this);
		jRadioButton6.addActionListener(this);
		// MouseListener
		jTable1.addMouseListener(this);
		// add key
		jTextField1.addKeyListener(this);
	}// </editor-fold>//GEN-END:initComponents

	private void loadDsMH() throws RemoteException {
		ArrayList<MatHang> dsMH = matHangDao.getAllMatHangs();
		for (MatHang mh : dsMH) {
			LoaiMH loaiMH = loaiMhDao.getLMHTheoMa(mh.getLoaiMatHang().getMaLoaiMatHang());
			modelMH.addRow(new Object[] { mh.getMaMatHang(), mh.getTenMatHang(), mh.getSoLuongMatHang(),
					loaiMH.getMaLoaiMatHang(), mh.getGiaMatHang() });
			modelMH.fireTableDataChanged();
			System.out.println(mh);
		}

	}

	private void loadDsMH(ArrayList<MatHang> list) throws RemoteException {
		LoaiMH loaiMH = new LoaiMH();
		for (MatHang mh : list) {
			loaiMH = loaiMhDao.getLMHTheoMa(mh.getLoaiMatHang().getMaLoaiMatHang());
			modelMH.addRow(new Object[] { mh.getMaMatHang(), mh.getTenMatHang(), mh.getSoLuongMatHang(),
					loaiMH.getMaLoaiMatHang(), mh.getGiaMatHang() });
			modelMH.fireTableDataChanged();

		}

	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(jRadioButton4)) {
			clearTable();
			try {
//				loadDsMH(matHangDao.sortLoaiMH("ASC"));
				loadDsMH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			;
		} else if (o.equals(jRadioButton5)) {
			clearTable();
			try {
//				ArrayList<MatHang> list = matHangDao.sortMaMatHang("ASC");
//				loadDsMH(list);
				loadDsMH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(jRadioButton6)) {
			clearTable();
			try {
//				ArrayList<MatHang> list1 = matHangDao.sortLoaiMH("ASC");
//				loadDsMH(list1);
				loadDsMH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(btnLamMoiMH)) {
			try {
				clearTable();
				lamMoi();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (o.equals(btnSuaMH)) {
			try {
				suaMH();
				clearTable();
				loadDsMH();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (o.equals(btnThemMH)) {
			try {
				themMH();
				clearTable();
				loadDsMH();
				
			} catch (HeadlessException | RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(btnXoaMH)) {
			try {
				xoaMH();
				clearTable();
				loadDsMH();
			} catch (HeadlessException | RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(btnTimMH)) {
			try {
				clearTable();
				String tenMH = jTextField1.getText();
				ArrayList<MatHang> mhTim = matHangDao.getTenMH(tenMH);
				loadDsMH(mhTim);
				System.out.println(mhTim);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (o.equals(btnLocMH)) {
			JOptionPane.showMessageDialog(this, "Lỗi rồi ông ơi", "Lỗi!", JOptionPane.WARNING_MESSAGE);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int key = e.getKeyCode();
		if (o.equals(jTextField1) && key == KeyEvent.VK_ENTER)
			btnTimMH.doClick();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(jTable1)) {
			int index = jTable1.getSelectedRow();
			txtMaMH.setText(modelMH.getValueAt(index, 0).toString());
			txtTenMH.setText(modelMH.getValueAt(index, 1).toString());
			txtSoLuong.setText(modelMH.getValueAt(index, 2).toString());
			jComboLoaiMatHang.setSelectedItem(modelMH.getValueAt(index, 3));
			txtGiaBan.setText(modelMH.getValueAt(index, 4).toString());
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

	/**
	 * @param args the command line arguments
	 */
	// Clear table
	private void clearTable() {
		int rowCount = modelMH.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modelMH.removeRow(i);
		}
	}

	private void lamMoi() throws RemoteException {
		txtMaMH.setText("");
		txtTenMH.setText("");
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		loadDsMH();
		bgRadio.clearSelection();
	}


	private void themMH() throws HeadlessException, RemoteException {
	    if (regEx()) {
	        MatHang mh = new MatHang();
	        DAOSinhMaTuDong daoSinhMaTuDong = new DAOSinhMaTuDong();
	        String maMH = daoSinhMaTuDong.getMaMH(); // Phát sinh mã tự động
	        mh.setMaMatHang(maMH);
	        mh.setTenMatHang(txtTenMH.getText());
	        mh.setSoLuongMatHang(Integer.parseInt(txtSoLuong.getText()));
	        mh.setGiaMatHang(Double.parseDouble(txtGiaBan.getText()));
	        mh.setLoaiMatHang(loaiMhDao.getLMHTheoTen(jComboLoaiMatHang.getSelectedItem().toString()));

	        Object[] options = { "Có", "Không" };
	        int n = JOptionPane.showOptionDialog(this, "Bạn có muốn thêm?", "Thêm mặt hàng", JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
	                options, // the titles of buttons
	                options[0]); // default button title

	        if (n == JOptionPane.YES_OPTION) {
	            if (matHangDao.themMatHang(mh)) {
	                JOptionPane.showMessageDialog(this, "Thêm thành công!");
	            } else {
	                JOptionPane.showMessageDialog(this, "Thêm thất bại");
	            }
	        }
	    }
	}

	private void suaMH() {
	    if (jTable1.getSelectedRow() > -1) {
	        if (regEx()) {
	            try {
	                // Lấy thông tin mặt hàng từ giao diện người dùng
	                String maMatHang = txtMaMH.getText();
	                String tenMatHang = txtTenMH.getText();
	                int soLuongMatHang = Integer.parseInt(txtSoLuong.getText());
	                double giaMatHang = Double.parseDouble(txtGiaBan.getText());
	                
	                // Không cần thiết lập mã mặt hàng vì nó được phát sinh tự động

	                MatHang mh = new MatHang();
	                mh.setMaMatHang(maMatHang);
	                mh.setTenMatHang(tenMatHang);
	                mh.setSoLuongMatHang(soLuongMatHang);
	                mh.setGiaMatHang(giaMatHang);
	                
	                // Không cần thiết lập loại mặt hàng vì thông tin loại mặt hàng được lấy từ đâu đó

	                Object[] options = { "Có", "Không" };
	                int n = JOptionPane.showOptionDialog(this, "Bạn có muốn cập nhật?", "Sửa mặt hàng",
	                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
	                        options, // the titles of buttons
	                        options[0]); // default button title
	                if (n == JOptionPane.YES_OPTION) {
	                    System.out.println(mh); // Kiểm tra thông tin mặt hàng trước khi cập nhật
	                }

	                // Thực hiện cập nhật mặt hàng
	                if (matHangDao.updateMatHang(mh)) {
	                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
	                } else {
	                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
	                }
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng và giá bán hợp lệ!");
	            } catch (Exception e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Có lỗi xảy ra khi cập nhật mặt hàng!");
	            }
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Chưa chọn mặt hàng cần cập nhật!");
	    }
	}


	private void xoaMH() throws HeadlessException, RemoteException {
		if (jTable1.getSelectedRow() > -1) {
			if (regEx()) {
				MatHang mh = new MatHang();
				mh.setMaMatHang(txtMaMH.getText());
				mh.setTenMatHang(txtTenMH.getText());
				mh.setSoLuongMatHang(Integer.parseInt(txtSoLuong.getText()));
				mh.setGiaMatHang(Double.parseDouble(txtGiaBan.getText()));
				mh.setLoaiMatHang(loaiMhDao.getLMHTheoMa("LMH004"));
				Object[] options = { "Có", "Không" };
				int n = JOptionPane.showOptionDialog(this,
						"Sau khi xoá sản phẩm sẽ thuộc loại ngừng kinh doanh.Bạn có muốn xoá?", "Sửa mặt hàng",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // do not use a custom Icon
						options, // the titles of buttons
						options[0]); // default button title
				if (n == JOptionPane.YES_OPTION)
					if (matHangDao.deleteMatHang(mh))
						JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
					else
						JOptionPane.showMessageDialog(this, " Cập nhật thất bại");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chưa chọn mặt hàng cần nhập nhật!");
		}
	}

	private boolean regEx() {
		String regTen = "[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂẾưăạảấầẩẫậắằẳẵặẹẻẽềềểếỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+";
		String regSL = "[\\d]+";
		String regGia = "[\\d.]+";
		if ((txtTenMH.getText().equals("")) || (txtSoLuong.getText().equals("")) || (txtGiaBan.getText().equals(""))) {
			JOptionPane.showMessageDialog(this, "Điền đầy đủ thông tin!");
			return false;
		}
		if (!(txtTenMH.getText().matches(regTen))) {
			JOptionPane.showMessageDialog(this, "Tên mặt hàng chỉ được chứa chữ cái!");
			return false;
		}
		if (!(txtSoLuong.getText().matches(regSL))) {
			JOptionPane.showMessageDialog(this, "Số lượng nhập sai!");
			return false;
		}
		if (!(txtGiaBan.getText().matches(regGia))) {
			JOptionPane.showMessageDialog(this, "Giá bán không hợp lệ!");
			return false;
		}
		return true;
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiMatHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiMatHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiMatHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FRMQuanLiMatHang.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FRMQuanLiMatHang().setVisible(true);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnLamMoiMH;
	private javax.swing.JButton btnSuaMH;
	private javax.swing.JButton btnThemMH;
	private javax.swing.JButton btnXoaMH;
	private javax.swing.JComboBox<String> jComboLoaiMatHang;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel15;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private ButtonGroup bgRadio;
	private javax.swing.JRadioButton jRadioButton4;
	private javax.swing.JRadioButton jRadioButton5;
	private javax.swing.JRadioButton jRadioButton6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JButton btnLocMH;
	private javax.swing.JButton btnTimMH;
	private javax.swing.JComboBox<String> jcboChucVu1;
	private javax.swing.JComboBox<String> jcboGtinh1;
	private javax.swing.JPanel jpnSapXep1;
	private javax.swing.JTextField txtCCCD2;
	private javax.swing.JTextField txtCCCD3;
	private javax.swing.JTextField txtGiaBan;
	private javax.swing.JTextField txtTenMH;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtMaMH;
	private DefaultTableModel modelMH;

	private List<LoaiMH> listLMH;
//	private DAOPhatSinhMa daoPhatSinhMa;

	// End of variables declaration//GEN-END:variables

}
