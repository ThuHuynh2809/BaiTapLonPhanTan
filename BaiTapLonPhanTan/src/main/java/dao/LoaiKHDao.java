/*
 * @ (#) LoaiKHDao.java     1     22
 * Copyright (c) 2024 IUH. All rights reserved
 */

package dao;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 22
 * @version: 18
 */


import entity.LoaiKH;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface LoaiKHDao extends Remote {

    public List<LoaiKH> getAllLoaiKH() throws RemoteException;
    public LoaiKH getLoaiKHTheoMaLoai(String ma) throws RemoteException;
    public LoaiKH getMaLoaiKHTheoTen(String ten) throws RemoteException;

}
