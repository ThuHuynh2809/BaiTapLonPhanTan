package dao;

import entity.Phong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface PhongDao extends Remote {
    public boolean themPhong(Phong p) throws RemoteException;

    public boolean huyPhong(String ma) throws RemoteException;

    public boolean capNhatPhong(Phong phong) throws RemoteException;

    public boolean capNhatTrangThaiPhong(String ma, String tinhTrang) throws RemoteException;

    public List<Phong> getPhongTrongVaDaDat() throws RemoteException;

    public Phong getPhongTheoMa(String ma) throws RemoteException;

    public List<Phong> getPhongDangHoatDong(Date ngayDen) throws RemoteException;

    public List<Phong> getPhongDangHoatDongTheo1() throws RemoteException;

    public List<Phong> getDanhSachPhong() throws RemoteException;

    public Phong getPhongDangHoatDongTheoMa(String ma) throws RemoteException;

    public List<Phong> getPhongTheoMaLoaiPhong(String maLoaiPhong) throws RemoteException;

    public Phong getGiaPhongTheoMa(String ma) throws RemoteException;

    public List<Phong> getPhongTheoLoai(String maLoaiPhong) throws RemoteException;

    public List<Phong> getPhongThuongTrong() throws RemoteException;

    public List<Phong> getPhongVipTrong() throws RemoteException;

    public List<Phong> sortTheoGiaPhong(String kieuSapXep) throws RemoteException;

    public List<Phong> sortTheoMaPhong(String kieuSapXep) throws RemoteException;

    public List<Phong> sortTheoMaPhong() throws RemoteException;

    public Phong getThongTinPhong(String maPhong) throws RemoteException;

    public List<Phong> getPhongTheoTinhTrang(String tinhTrang) throws RemoteException;

    public List<Phong> getPhongTheoMaP(String maPhong) throws RemoteException;

    public Phong getPhongTheoMaPhong(String maPhong) throws RemoteException;
}
