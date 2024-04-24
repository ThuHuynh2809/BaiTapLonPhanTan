/*
 * @ (#) HoaDonDao.java     1     22
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 22
 * @version: 18
 */


import entity.HoaDon;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface HoaDonDao extends Remote {
    public boolean themHoaDon(HoaDon hoaDon) throws RemoteException;
    public	HoaDon getHDTheoMa(String ma) throws RemoteException;
    public ArrayList<HoaDon> getHDTheoTenKH(String tenKH) throws RemoteException;
    public	ArrayList<HoaDon> getHDTheoNgay(Date ngayBatDau, Date ngayKetThuc) throws RemoteException;
    public	ArrayList<HoaDon> getHDTheoMaNV(String maNV) throws RemoteException;
    public	ArrayList<HoaDon> getHDtheoNgay(Date d) throws RemoteException;
    public	long demSoKHTrongNgay(Date d) throws RemoteException;
    public	long demSoKHTrongThang(String nam, String thang) throws RemoteException;
    public	long demSoKHTrongNam(String nam) throws RemoteException;
    public	long demSoMHTrongNgay(Date d) throws RemoteException;
    public	long demSoMHTrongThang(String nam, String thang) throws RemoteException;
    public	long demSoMHTrongNam(String nam) throws RemoteException;
    public long	 demSoKH(Date ngayBatDau,Date ngayKetThuc) throws RemoteException;
    public long demSoMH(Date ngayBatDau,Date ngayKetThuc) throws RemoteException;
    public long demSoLanKHDen(String maKH, Date ngayD, Date ngayKT) throws RemoteException;
}
