package dao;

import entity.DonDatPhong;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DatPhongDao extends Remote {

    public boolean themDDP(DonDatPhong ddp) throws RemoteException;

    public boolean capNhatDDP(DonDatPhong ddp, String ma) throws RemoteException;

    public int capNhatTrangThaiPhongvaDDP() throws RemoteException;

    public boolean capNhatTrangThaiDDP(String ma) throws RemoteException;

    public List<DonDatPhong> getAllDDP() throws RemoteException;

    public List<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() throws RemoteException;

    public DonDatPhong getDDPTheoMa(String ma) throws RemoteException;

    public List<DonDatPhong> getDDPTheoMaKH(String ma) throws RemoteException;

    public List<DonDatPhong> getDDPTheoMaDDP(String ma) throws RemoteException;

    public List<DonDatPhong> sortMaDDP(String type) throws RemoteException;

    public List<DonDatPhong> sortDDPTheoLoaiPhong(String type) throws RemoteException;




}

