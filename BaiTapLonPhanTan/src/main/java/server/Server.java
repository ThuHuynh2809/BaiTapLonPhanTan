package server;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;


import dao.HoaDonDao;
import dao.LoaiMhDao;
import dao.MacHangDao;
import dao.NhanVienDao;
import dao.TaiKhoanDao;
import impl.HoaDonImpl;
import impl.LoaiMhImpl;
import impl.MatHangImpl;
import impl.NhanVienImpl;
import impl.TaiKhoanImpl;

public class Server {
	private static final String URL = "rmi://localhost:1099/";

	public static void main(String[] args) {
		try {
			
			Context context = new InitialContext();
			
			HoaDonDao hoaDonDao = new HoaDonImpl(); // Remote Object
//			KhachHangDao khachHangDao = new KhachHangImpl(); // Remote Object
			LoaiMhDao loaiMhDao = new LoaiMhImpl(); // Remote Object
			MacHangDao matHangDao = new MatHangImpl(); // Remote Object
			NhanVienDao nhanVienDao = new NhanVienImpl(); // Remote Object
			TaiKhoanDao taiKhoanDao = new TaiKhoanImpl(); // Remote Object
			
			LocateRegistry.createRegistry(1099);
			
			context.bind(URL + "hoaDonDao", hoaDonDao);
			//			context.bind(URL + "khachHangDao", khachHangDao);
			context.bind(URL + "loaiMhDao", loaiMhDao);
			context.bind(URL + "matHangDao", matHangDao);
			context.bind(URL + "nhanVienDao", nhanVienDao);
			context.bind(URL + "taiKhoanDao", taiKhoanDao);
			
			
			
			
			System.out.println("Server is running..."	);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
