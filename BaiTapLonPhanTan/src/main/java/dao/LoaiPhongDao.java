package dao;

import entity.LoaiPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface LoaiPhongDao extends Remote {
    public List<LoaiPhong> getDanhSachLoaiPhong() throws RemoteException;

    public LoaiPhong getLoaiPhongTheoMa(String ma) throws RemoteException;

    public LoaiPhong getLoaiPhongTheoTen(String ten) throws RemoteException;

    public String getMaLoaiPhongTheoTen(String ten) throws RemoteException;




}
