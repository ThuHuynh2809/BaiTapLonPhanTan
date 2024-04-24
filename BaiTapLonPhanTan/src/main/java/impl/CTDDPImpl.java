/*
 * @ (#) $NAME.java         4/24/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package impl;

import dao.CTDDPDao;
import entity.ChiTietDDP;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/24/2024
 */
public class CTDDPImpl implements CTDDPDao {

    private static EntityManager em;

    public CTDDPImpl() {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themCTDDP(ChiTietDDP ddp) throws RemoteException {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(ddp);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean xoaCTDDP(String maDDP, String maMH) throws RemoteException {
        em.createQuery("DELETE ChiTietDDP d WHERE d.donDatPhong.id = :maDDP AND d.matHang.id = :maMH")
                .setParameter("maDDP", maDDP)
                .setParameter("maMH", maMH)
                .executeUpdate();
        return true;
    }

    @Override
    public boolean suaSoLuongMH(String maDDP, String maMH, int soLuong) throws RemoteException {
        em.createQuery("UPDATE ChiTietDDP d SET d.soLuongMH = :soLuongMH WHERE d.donDatPhong.id = :maDDP AND d.matHang.id = :maMH ")
                .setParameter("maDDP", maDDP)
                .setParameter("maMH", maMH)
                .executeUpdate();
        return true;
    }

    @Override
    public ChiTietDDP getCTDDPTheoMa(String maDDP, String maMH) throws RemoteException {
        return (ChiTietDDP) em.createQuery("SELECT d FROM ChiTietDDP d WHERE d.donDatPhong.id = :maDDP AND d.matHang.id = :maMH")
                .setParameter("maDDP", maDDP)
                .setParameter("maMH", maMH)
                .getSingleResult();
    }

    @Override
    public ArrayList<ChiTietDDP> getCTDDPTheoMaDDP(String ma) throws RemoteException {

        return (ArrayList<ChiTietDDP>) em.createQuery("SELECT d FROM ChiTietDDP d WHERE d.donDatPhong.id = :ma")
                .setParameter("ma", ma)
                .getResultList();
    }
}
