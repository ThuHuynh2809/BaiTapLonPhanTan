/*
 * @ (#) Test.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import dao.HoaDonDao;
import dao.LoaiMhDao;
import dao.MacHangDao;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import entity.HoaDon;
import entity.LoaiMH;
import entity.MatHang;
import entity.NhanVien;
import entity.TaiKhoan;
import impl.HoaDonImpl;
import impl.LoaiMhImpl;
import impl.MatHangImpl;
import impl.NhanVienImpl;
import impl.TaiKhoanImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Test {
	public static NhanVienDao nhanVienDao;

	static {
		try {
			nhanVienDao = new NhanVienImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	public static HoaDonDao hoaDonDao;

	static {
		try {
			hoaDonDao = new HoaDonImpl();
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
	public static LoaiMhDao  loaiMhDao;
	static {
		try {
			loaiMhDao = new LoaiMhImpl();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws RemoteException {
		 EntityManager entityManager =
		 Persistence.createEntityManagerFactory("maria").createEntityManager();

//        -----------------TEST NHANVIEN DAO ---------------------

//        NhanVien nhanVien = new NhanVien();
//        TaiKhoan taiKhoan = new TaiKhoan("NV003", "NV003");
//        nhanVien.setMaNhanVien("NV003");
//        nhanVien.setTaiKhoan(taiKhoan);
//        nhanVien.setTenNhanVien("Nguyễn Hoàng Thái");
//        nhanVien.setChucVu("Quản lý");
//        nhanVien.setGioiTinh("Nam");
//        nhanVien.setNgaySinh(Date.valueOf(LocalDate.of(2000, 4, 2)));
//        nhanVien.setDiaChi("46 Phan Văn Tri, p11, Q.Binh Thanh, TP.HCM");
//        nhanVien.setSdt("0352465972");
//        nhanVien.setCccd("079550113312");
//        nhanVien.setLuong(20000000);
//        nhanVien.setCaLamViec(2);
//        nhanVien.setTrangThaiLamViec("Đang làm việc");
//
//        nhanVienDao.themNhanVien(nhanVien, taiKhoan);

//        NhanVien nhanVien = new NhanVien();
//        TaiKhoan taiKhoan = new TaiKhoan("NV004", "NV004");
//        nhanVien.setMaNhanVien("NV004");
//        nhanVien.setTenNhanVien("Nguyễn Hoàng ");
//        nhanVien.setChucVu("Nhân viên");
//        nhanVien.setTaiKhoan(taiKhoan);
//        nhanVien.setGioiTinh("Nam");
//        nhanVien.setNgaySinh(Date.valueOf(LocalDate.of(2000, 4, 2)));
//        nhanVien.setDiaChi("46 Phan Văn Tri, p11, Q.Binh Thanh, TP.HCM");
//        nhanVien.setSdt("0352465972");
//        nhanVien.setCccd("079550113312");
//        nhanVien.setLuong(20000000);
//        nhanVien.setCaLamViec(2);
//        nhanVien.setTrangThaiLamViec("Đang làm việc");
//        nhanVienDao.themNhanVien(nhanVien, taiKhoan);
//        -----------------TEST huy Nhanvien ---------------------
//        boolean kqHuy = nhanVienDao.huyNV("NV004");
//        if (kqHuy) {
//            System.out.println("Hủy thành công");
//        } else {
//            System.out.println("Hủy thất bại");
//        }
//       -----------------TEST cap nhat Nhanvien ---------------------
//        NhanVien nhanVien = new NhanVien();
//        nhanVien.setTenNhanVien("Nguyen Thai");
//        nhanVien.setChucVu("Nhân viên");
//        nhanVien.setGioiTinh("Nam");
//        nhanVien.setNgaySinh(Date.valueOf(LocalDate.of(2002, 4, 2)));
//        nhanVien.setDiaChi("16 Phan Văn Tri, p11, Q.Binh Thanh, TP.HCM");
//        nhanVien.setSdt("0352465972");
//        nhanVien.setCccd("079550113312");
//        nhanVien.setLuong(20000000);
//        nhanVien.setCaLamViec(2);
//        nhanVien.setTrangThaiLamViec("Đang làm việc");
//        boolean kqCapNhat = nhanVienDao.capNhatNV(nhanVien, "NV003");
//        if (kqCapNhat) {
//            System.out.println("Cập nhật thành công");
//        } else {
//            System.out.println("Cập nhật thất bại");
//        }

//        System.out.println("Danh sách nhân viên: ");
//        ArrayList<NhanVien> nhanViens = nhanVienDao.getAllDanhSachNV();
//        for (NhanVien nv : nhanViens) {
//            System.out.println(nv);
//        }
//        System.out.println("Danh sách nhân viên đang làm việc: ");
//        ArrayList<NhanVien> nhanViens = nhanVienDao.getDanhSachNV();
//        for (NhanVien nv : nhanViens) {
//            System.out.println(nv);
//        }
//        NhanVien nhanVien = nhanVienDao.getMaVaSdtNVChoDDP("NV001");
//        System.out.println("Tim thay nhan vien co ma: "+nhanVien);
//        NhanVien nhanVien = nhanVienDao.getMaVaSdtNVChoDDP("0352465972");
//        System.out.println("Tim thay nhan vien co sdt: "+nhanVien);
//        NhanVien nhanVien = nhanVienDao.getNVTheoMa("NV001");
//        System.out.println("Tim thay nhan vien co ma: "+nhanVien);
//        ArrayList<NhanVien> nhanViens = nhanVienDao.getTenNV("Nguyen Thai");
//        System.out.println("Tim thay nhan vien co ten: "+nhanViens);

//        ArrayList<NhanVien> nhanViens = nhanVienDao.getChucVuNV("Nhân viên");
//        System.out.println("Tim thay nhan vien co chuc vu: "+nhanViens);

//        ArrayList<NhanVien> nhanViens = nhanVienDao.getCaNV("1");
//        System.out.println("Tim thay nhan vien co ca: "+nhanViens);

//        NhanVien nhanVien = nhanVienDao.getNVDaNghiViec("NV004");
//        System.out.println("Tim thay nhan vien da nghi viec: "+nhanVien);

//        NhanVien nhanVien = nhanVienDao.getNVTheoTK("NV001");
//        System.out.println("Tim thay nhan vien co tai khoan: "+nhanVien);

//        System.out.println("Sắp xếp nhân viên theo mã nhân viên: ");
//        ArrayList<NhanVien> nhanViens = nhanVienDao.sortMaNV("desc");
//        for (NhanVien nv : nhanViens) {
//            System.out.println(nv);
//        }

//        System.out.println("Sắp xếp nhân viên theo tên nhân viên: ");
//        ArrayList<NhanVien> nhanViens = nhanVienDao.sortTen("asc");
//        for (NhanVien nv : nhanViens) {
//            System.out.println(nv);
//        }

//        System.out.println("Sắp xếp nhân viên theo chức vụ: ");
//        ArrayList<NhanVien> nhanViens = nhanVienDao.sortCV("Nhân viên");
//        for (NhanVien nv : nhanViens) {
//            System.out.println(nv);
//        }

//        boolean kq = nhanVienDao.checkSdtNV("0352465972");
//        if (kq) {
//            System.out.println("Số điện thoại đã tồn tại");
//        } else {
//            System.out.println("Số điện thoại chưa tồn tại");
//        }

//        -----------------TEST HOADON DAO ---------------------

//        HoaDon hoaDonFind = hoaDonDao.getHDTheoMa("HD001");
//        ArrayList<HoaDon> hoaDonFind = hoaDonDao.getHDTheoTenKH("Ðoàn Ph?m Bích H?p");
//        ArrayList<HoaDon> hoaDonFind = hoaDonDao.getHDTheoNgay(Date.valueOf(LocalDate.of(2020, 10, 11)), Date.valueOf(LocalDate.of(2024, 4, 22)));
//        ArrayList<HoaDon> hoaDonFind = hoaDonDao.getHDTheoMaNV("NV001");
//        ArrayList<HoaDon> hoaDonFind = hoaDonDao.getHDtheoNgay(Date.valueOf(LocalDate.of(2020, 10, 11)));
//        System.out.println("Tìm được hoá đơn theo ngày 11/10/2020: "+hoaDonFind);
//        HoaDon hoaDon = new HoaDon();
//        hoaDon.setMaHoaDon("HD007");
//        hoaDon.setGiamGia(50);
//        hoaDon.setGioVao(Time.valueOf(LocalDateTime.now().toLocalTime()));
//        hoaDon.setGioRa(Time.valueOf(LocalDateTime.now().toLocalTime()));
//        hoaDon.setNgayLap(Date.valueOf(LocalDate.now()));
//        hoaDon.setPhuThu("Có");
//        hoaDon.setTrangThaiHD("Chưa thanh toán");
//        hoaDon.setKhachHang(hoaDonFind.get(0).getKhachHang());
//        hoaDon.setNhanVien(hoaDonFind.get(0).getNhanVien());
//        hoaDon.setPhong(hoaDonFind.get(0).getPhong());
//        hoaDonDao.themHoaDon(hoaDon);
//          long soKH = hoaDonDao.demSoKHTrongNgay(Date.valueOf(LocalDate.now()));
//            System.out.println("Số khách hàng trong ngày: "+soKH);
//        long soKH = hoaDonDao.demSoKHTrongThang("2024", "4");
//        System.out.println("Số khách hàng trong tháng 4/2024: "+soKH);
//        long soKH = hoaDonDao.demSoKHTrongNam("2024");
//        System.out.println("Số khách hàng trong năm 2024: "+soKH);
//        long soMH = hoaDonDao.demSoMHTrongNgay(Date.valueOf(LocalDate.now()));
//        System.out.println("Số mặt hàng trong ngày: "+soMH);
//        long soMH = hoaDonDao.demSoMHTrongThang("2020", "10");
//        System.out.println("Số mặt hàng trong tháng 10/2020: "+soMH);
//        long soMH = hoaDonDao.demSoMHTrongNam("2020");
//        System.out.println("Số mặt hàng trong năm 2020: "+soMH);
//        long soKH = hoaDonDao.demSoKH(Date.valueOf(LocalDate.of(2020, 10, 11)), Date.valueOf(LocalDate.of(2024, 4, 22)));
//        System.out.println("Số khách hàng từ 11/10/2020 đến 22/4/2024: "+soKH);
//        long soMH = hoaDonDao.demSoMH(Date.valueOf(LocalDate.of(2020, 10, 11)), Date.valueOf(LocalDate.of(2024, 4, 22)));
//        System.out.println("Số mặt hàng từ 11/10/2020 đến 22/4/2024: "+soMH);
//        long soLan = hoaDonDao.demSoLanKHDen("KH001", Date.valueOf(LocalDate.of(2020, 10, 11)), Date.valueOf(LocalDate.of(2024, 4, 22)));
//        System.out.println("Số lần khách hàng KH001 đến từ 11/10/2020 đến 22/4/2024: "+soLan);
	
//		-----------------TEST TaiKhoanDao ---------------------
		
//		 		TaiKhoan taiKhoan = new TaiKhoan();
//		 		taiKhoanDao.createTaiKhoan("NV005", "thu2809");
//		 		taiKhoan = taiKhoanDao.getTKTheoMa("NV005");
//		 		taiKhoanDao.updateTaiKhoan("NV005", "Thu123");
//		 		taiKhoan = taiKhoanDao.getMatKhauTheoMa("NV005");
//		 		taiKhoanDao.deleteTaiKhoan("NV005");
//		 		taiKhoan = taiKhoanDao.getTKTheoMa("NV005");
////		-----------------TEST MatHangDao, LoaiMhDao ---------------------
//		 		LoaiMH loaiMatHang = new LoaiMH("N05", "Thức uống giải khát");
//		 		loaiMhDao.themLoaiMatHang(loaiMatHang);
//		 		
//		 		MatHang matHang1 = new MatHang("N05", "Sting", 100, 25000, loaiMatHang);
////		 		MatHang matHang1 = new MatHang("MH003");
//		 		matHangDao.themMatHang(matHang1);
//		 		matHangDao.getMHTheoMa("N05");
//		 		
//		 		
//		 		MatHang matHang2 = new MatHang("N05", "Sting", 100, 25000, loaiMatHang);
//		 		matHangDao.updateMatHang(matHang2);
//		 		matHangDao.getMHTheoMa("N05");
//		 		
//		 		ArrayList<MatHang> matHangs = matHangDao.getAllMatHangs();
//		 		
//		 		
		 ArrayList<MatHang> matHangs = matHangDao.getAllMatHangs();
		 		System.out.println("Danh sách mặt hàng: ");
				for (MatHang mh : matHangs) {
					System.out.println(mh);
				}
	}

}
