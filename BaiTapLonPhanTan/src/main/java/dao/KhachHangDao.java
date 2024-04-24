/*
 * @ (#) KhachHangDao.java     1     22
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 22
 * @version: 18
 */


import entity.KhachHang;
import entity.LoaiKH;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface KhachHangDao extends Remote {
    // them khach hang
    public boolean themKhachHang(KhachHang khachHang) throws RemoteException;

    // huá»· khach hang
    public boolean huyKH(String maKH) throws RemoteException;
    // cap nhat khach hang
    public boolean capNhatKH(KhachHang khachHang) throws RemoteException;

    // Load tat ca khach hang
    public ArrayList<KhachHang> getAllDanhSachKH() throws RemoteException;

    // Load 1 khach hang theo ma
    public KhachHang getKHTheoMa(String ma) throws RemoteException;

    // Load danh sÃ¡ch khach hang theo ten
    public ArrayList<KhachHang> getTenKH(String info) throws RemoteException;

    // Load danh sÃ¡ch khach hang theo sdt hoáº·c mÃ£ khÃ¡ch hÃ ng
    public ArrayList<KhachHang> getMaVaSDTKH(String info) throws RemoteException;

    // Load danh sÃ¡ch khÃ¡ch hÃ ng theo mÃ£ giáº£m dáº§n
    public ArrayList<KhachHang> sortMaKH() throws RemoteException;

    // Load danh sÃ¡ch khÃ¡ch hÃ ng theo mÃ£ loáº¡i khÃ¡ch hÃ ng
    public ArrayList<KhachHang> getKHTheoLoai(String maLoaiKH) throws RemoteException;

    // thÃªm khÃ¡ch hÃ ng theo Ä‘Æ¡n Ä‘áº·t phÃ²ng
    public boolean themKHTheoDDP(KhachHang kh) throws RemoteException;

    // Loáº¡i khÃ¡ch hÃ ng tá»« tÃªn khÃ¡ch hÃ ng
    public LoaiKH getMaLoaiKHFromTen(String tenLoaiKH) throws RemoteException;

    // kiá»ƒm tra sá»‘ Ä‘iá»‡n thoáº¡i Ä‘Ã£ tá»“n táº¡i chÆ°a
    public boolean checkSdtKH(String sdt) throws RemoteException;

    // Load khÃ¡ch hÃ ng theo tÃªn
    public KhachHang getKHTheoTen(String info) throws RemoteException;

	KhachHang getKHTheoSDT(String sdt) throws RemoteException;

}
