package gui;

import java.awt.HeadlessException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.NhanVien;
import entity.TaiKhoan;
import impl.NhanVienImpl;
import impl.TaiKhoanImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class FRMQuenMatKhau extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static TaiKhoanDao taiKhoanDao;
    static {
        try {
            taiKhoanDao = new TaiKhoanImpl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
    public static NhanVienDao nhanVienDao;

    static {
        try {
            nhanVienDao = new NhanVienImpl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public FRMQuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quên mật khẩu");
    }

    private void initComponents() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNhapTaiKhoan = new javax.swing.JTextField();
        jTextFieldNhapSDT = new javax.swing.JTextField();
        jTextFieldNhapMKM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldXacNhanMK = new javax.swing.JTextField();
        jButtonDongY = new javax.swing.JButton();
        jButtonQuayLai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tài khoản:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Nhập số điện thoại:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nhập mật khẩu mới:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Xác nhận lại:");

        jTextFieldNhapTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldNhapSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldNhapMKM.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUÊN MẬT KHẨU");

        jTextFieldXacNhanMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonDongY.setIcon(new javax.swing.ImageIcon("D:\\\\Desktop\\\\HocTap\\\\HocKi2_Nam 4_(2024_2025)\\\\LTPT_Java\\\\THNhom\\\\New folder\\\\BaiTapLonPhanTan\\\\iCon\\checked.png")); // NOI18N
        jButtonDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButtonDongYActionPerformed(evt);
				} catch (HeadlessException | RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jButtonQuayLai.setIcon(new javax.swing.ImageIcon("D:\\\\Desktop\\\\HocTap\\\\HocKi2_Nam 4_(2024_2025)\\\\LTPT_Java\\\\THNhom\\\\New folder\\\\BaiTapLonPhanTan\\\\iCon\\undo.png")); // NOI18N
        jButtonQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNhapSDT))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jTextFieldNhapTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNhapMKM)
                                    .addComponent(jTextFieldXacNhanMK)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButtonDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNhapTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldNhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNhapMKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldXacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDongY, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jButtonQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }

    public FRMDangNhap frmdn = new FRMDangNhap();

    public boolean kiemTraRong() {
        if (jTextFieldNhapTaiKhoan.getText().trim().length() == 0 || jTextFieldNhapSDT.getText().trim().length() == 0
                || jTextFieldNhapMKM.getText().trim().length() == 0
                || jTextFieldXacNhanMK.getText().trim().length() == 0) {
            return true;
        }
        return false;
    }

    public boolean regexMatKhau(JTextField pwMK) {
        String input = pwMK.getText().toString().trim();
        String regexMaNV = "^[A-Z][a-zA-Z0-9 ]{5,}$";
        if (!input.matches(regexMaNV)) {
            JOptionPane.showMessageDialog(null,
                    "Mật khẩu không hợp lệ\nMật khẩu hợp lệ:\n - Kí tự đầu tiên là chữ viết hoa.\n - Có ít nhất 6 kí tự, chỉ chứa chữ, số, và khoảng trắng.\nVí dụ: T123abc hoặc DangNhap123");
            pwMK.requestFocus();
            pwMK.selectAll();
            return false;
        }
        return true;
    }

    public void doiMK() throws HeadlessException, RemoteException {

        String maTK = jTextFieldNhapTaiKhoan.getText().toString().trim();
        String sdt = jTextFieldNhapSDT.getText().toString().trim();
        String mkMoi = jTextFieldNhapMKM.getText().toString().trim();
        String xacNhan = jTextFieldXacNhanMK.getText().toString().trim();

        TaiKhoan tk = taiKhoanDao.getTKTheoMa(maTK);

        if (!kiemTraRong()) {
            if (tk.getMaTK() == null) {
                JOptionPane.showMessageDialog(this, "Tài khoản không đúng!\nVui lòng kiểm tra lại.");
            } else {
                NhanVien nv = nhanVienDao.getNVTheoMa(maTK);
                if (!nv.getSdt().equalsIgnoreCase(sdt)) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại của nhân viên không đúng!\n Vui lòng kiểm tra lại");
                } else if (regexMatKhau(jTextFieldNhapMKM)) {
                    if (mkMoi.equalsIgnoreCase(xacNhan)) {
                        tk.setMatKhau(mkMoi);
                        if (taiKhoanDao.updateTaiKhoan(maTK, mkMoi) && nhanVienDao.capNhatNV(nv, maTK)) {
                            JOptionPane.showMessageDialog(this, "Mật khẩu đã được đổi thành công.\nVui lòng chọn quay lại để đăng nhập");

                            frmdn.setVisible(true);
                            this.setVisible(false);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Xác nhận mật khẩu không đúng!\n vui lòng kiểm tra lại.");
                        jTextFieldXacNhanMK.requestFocus();
                        jTextFieldXacNhanMK.selectAll();
                    }
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
    }

    private void jButtonDongYActionPerformed(java.awt.event.ActionEvent evt) throws HeadlessException, RemoteException {// GEN-FIRST:event_btnLamMoiDDPActionPerformed
        // TODO add your handling code here:
        doiMK();
    }

    private void jButtonQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLamMoiDDPActionPerformed
        FRMDangNhap quanLi = new FRMDangNhap();
        quanLi.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonDongY;
    private javax.swing.JButton jButtonQuayLai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldNhapMKM;
    private javax.swing.JTextField jTextFieldNhapSDT;
    private javax.swing.JTextField jTextFieldNhapTaiKhoan;
    private javax.swing.JTextField jTextFieldXacNhanMK;
    // End of variables declaration
}
