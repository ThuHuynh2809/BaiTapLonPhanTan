package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.LoaiMH;

public interface LoaiMhDao extends Remote{

	boolean themLoaiMatHang(LoaiMH loaiMatHang) throws RemoteException;

	ArrayList<LoaiMH> getAllLoaiMatHang() throws RemoteException;

	LoaiMH getLMHTheoMa(String ma) throws RemoteException;

	LoaiMH getLMHTheoTen(String ten) throws RemoteException;

}
