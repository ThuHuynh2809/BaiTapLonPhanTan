/*
 * @ (#) $NAME.java         4/23/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package impl;

import dao.LoaiPhongDao;
import entity.LoaiPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/23/2024
 */
public class LoaiPhongImpl extends UnicastRemoteObject implements LoaiPhongDao {

    private static EntityManager em;

    public LoaiPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public List<LoaiPhong> getDanhSachLoaiPhong() throws RemoteException {
        return em.createNamedQuery("LoaiPhong.getAllLoaiPhong", LoaiPhong.class)
                .getResultList();
    }

    @Override
    public LoaiPhong getLoaiPhongTheoMa(String ma) throws RemoteException {
        return em.createNamedQuery("LoaiPhong.getLoaiPhongTheoMa", LoaiPhong.class)
                .setParameter("ma", ma)
                .getSingleResult();
    }

    @Override
    public LoaiPhong getLoaiPhongTheoTen(String ten) throws RemoteException {
        return em.createNamedQuery("LoaiPhong.getLoaiPhongTheoTen", LoaiPhong.class)
                .setParameter("ten", ten)
                .getSingleResult();
    }

    @Override
    public String getMaLoaiPhongTheoTen(String ten) throws RemoteException {
        return em.createNamedQuery("LoaiPhong.getMaLoaiPTheoTen", String.class)
                .setParameter("ten", ten)
                .getSingleResult();
    }
}
