/*
 * @ (#) LoaiKHDaoImpl.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package impl;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import dao.LoaiKHDao;
import entity.LoaiKH;
import entity.MatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class LoaiKHDaoImpl extends UnicastRemoteObject implements LoaiKHDao{
    private EntityManager entityManager;
    public LoaiKHDaoImpl() throws RemoteException {
        entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public List<LoaiKH> getAllLoaiKH() throws RemoteException {
        return entityManager.createQuery("select lk from LoaiKH lk", LoaiKH.class).getResultList();

    }

    @Override
    public LoaiKH getLoaiKHTheoMaLoai(String ma) throws RemoteException {
		return entityManager.find(LoaiKH.class, ma);
    }

    @Override
    public LoaiKH getMaLoaiKHTheoTen(String ten) throws RemoteException {
        return entityManager.createQuery("select lk from LoaiKH lk where lk.tenLoaiKH = :ten", LoaiKH.class)
                .setParameter("ten", ten).getSingleResult();
    }
}
