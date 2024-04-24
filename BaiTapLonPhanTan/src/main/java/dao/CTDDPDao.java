/*
 * @ (#) $NAME.java         4/24/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package dao;

import entity.ChiTietDDP;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/24/2024
 */
public interface CTDDPDao extends Remote {
    public boolean themCTDDP(ChiTietDDP ddp) throws RemoteException;

    public boolean xoaCTDDP(String maDDP, String maMH) throws RemoteException;

    public boolean suaSoLuongMH(String maDDP, String maMH, int soLuong) throws RemoteException;

    public ChiTietDDP getCTDDPTheoMa(String maDDP, String maMH) throws RemoteException;

    public ArrayList<ChiTietDDP> getCTDDPTheoMaDDP(String ma) throws RemoteException;


}
