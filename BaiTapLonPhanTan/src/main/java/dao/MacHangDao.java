package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.MatHang;

public interface MacHangDao extends Remote{

	boolean themMatHang(MatHang matHang) throws RemoteException;

	boolean updateMatHang(MatHang matHang) throws RemoteException;

	ArrayList<MatHang> getAllMatHangs() throws RemoteException;

	MatHang getMHTheoMa(String ma) throws RemoteException;

	MatHang getMHTheoTen(String ten) throws RemoteException;

	ArrayList<MatHang> getMHTheoLoai(String loai) throws RemoteException;

	MatHang getMHTheoTenMHVaLoaiMH(String tenMH, String loaiMH) throws RemoteException;

	ArrayList<MatHang> sortMaMatHang(String kieuSapXep) throws RemoteException;

	ArrayList<MatHang> sortLoaiMH(String kieuSapXep) throws RemoteException;

	ArrayList<MatHang> getTenMH(String tenMH) throws RemoteException;

	ArrayList<MatHang> getLoaiMH(String loaiMH) throws RemoteException;

	boolean deleteMatHang(MatHang matHang) throws RemoteException;

//	boolean themMatHang(String maMH, String tenMH, int soLuongMH, double giaMH) throws RemoteException;

}
