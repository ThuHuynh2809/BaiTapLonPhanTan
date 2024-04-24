package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import entity.TaiKhoan;

public interface TaiKhoanDao extends Remote{

	boolean createTaiKhoan(String maTaiKhoan, String matKhau) throws RemoteException;

	boolean updateTaiKhoan(String maTaiKhoan, String matKhau) throws RemoteException;

	boolean deleteTaiKhoan(String maTaiKhoan) throws RemoteException;

	ArrayList<TaiKhoan> getAllTaiKhoan() throws RemoteException;

	TaiKhoan getTKTheoMa(String ma) throws RemoteException;

	TaiKhoan getMatKhauTheoMa(String ma) throws RemoteException;

}
