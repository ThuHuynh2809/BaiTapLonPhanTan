/*
 * @ (#) NhanVienDao.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import entity.NhanVien;
import entity.TaiKhoan;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface NhanVienDao extends Remote {
    // thÃªm nhÃ¢n viÃªn
    public boolean themNhanVien(NhanVien nv, TaiKhoan tk) throws RemoteException;
    //huy NV set trang thai da nghi viec
    public boolean huyNV(String ma) throws RemoteException;
    //capnhat-sua NV
    public boolean capNhatNV(NhanVien nv, String ma) throws RemoteException;
    //Load tat ca sd NV
    public ArrayList<NhanVien> getAllDanhSachNV() throws RemoteException;
    //Load ds NV dang lam viec
    public ArrayList<NhanVien> getDanhSachNV() throws RemoteException;
    //Load 1 NV dang lam viec theo manv, sdt
    public ArrayList<NhanVien> getMaVaSdtNVChoDDP1(String info) throws RemoteException;
    public NhanVien getNVTheoMa(String ma) throws RemoteException;
    //Load 1 NV dang lam viec theo tenNV
    public ArrayList<NhanVien> getTenNV(String info) throws RemoteException;
    //Load 1 NV dang lam viec theo chucvu
    public ArrayList<NhanVien> getChucVuNV(String info) throws RemoteException;
    //Load 1 NV dang lam viec theo ca
    public ArrayList<NhanVien> getCaNV(String info) throws RemoteException;
    //Load 1 NV da nghi viec theo manv
    public NhanVien getNVDaNghiViec(String ma) throws RemoteException;
    public NhanVien getNVTheoTK(String maTK) throws RemoteException;
    //sapxep maNV cua nv dang lam viec
    public ArrayList<NhanVien> sortMaNV(String kieuSapXep) throws RemoteException;
//    /**
//     * Sáº¯p xáº¿p tÃªn nv theo kiá»ƒu tÄƒng dáº§n/ giáº£m dáº§n thÃ´ng qua chuá»—i truyá»n vÃ o trong báº£ng máº·t hÃ ng tá»« SQL Server
//     * @param ksx
//     * @return ArrayList<NhanVien> lstNV
//     */
    public ArrayList<NhanVien> sortTen(String kieuSapXep) throws RemoteException;
    //sapxep chucvu cua nv dang lam viec
    public ArrayList<NhanVien> sortCV(String tenChucVu) throws RemoteException;
    public boolean checkSdtNV(String sdt) throws RemoteException;
    public boolean checkCccdNV(String cccd) throws RemoteException;
	NhanVien getMaVaSdtNVChoDDP(String info) throws RemoteException;
}
