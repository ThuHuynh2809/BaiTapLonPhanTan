/*
 * @ (#) HoaDonImpl.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package impl;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import dao.HoaDonDao;
import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TemporalType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class HoaDonImpl extends UnicastRemoteObject implements HoaDonDao {
    private EntityManager em;
    public HoaDonImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themHoaDon(HoaDon hoaDon) throws RemoteException {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(hoaDon);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public HoaDon getHDTheoMa(String ma) throws RemoteException {
        return em.find(HoaDon.class, ma);
    }

    @Override
    public ArrayList<HoaDon> getHDTheoTenKH(String tenKH) throws RemoteException {
        return (ArrayList<HoaDon>) em.createQuery("SELECT hd FROM HoaDon hd INNER JOIN hd.khachHang kh WHERE kh.tenKH LIKE :tenKH")
                .setParameter("tenKH", "%" + tenKH + "%")
                .getResultList();
    }

    @Override
    public ArrayList<HoaDon> getHDTheoNgay(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return (ArrayList<HoaDon>) em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.ngayLap BETWEEN :ngayBatDau AND :ngayKetThuc")
                .setParameter("ngayBatDau", ngayBatDau)
                .setParameter("ngayKetThuc", ngayKetThuc)
                .getResultList();
    }

    @Override
    public ArrayList<HoaDon> getHDTheoMaNV(String maNV) throws RemoteException {
        return (ArrayList<HoaDon>) em.createQuery("SELECT hd FROM HoaDon hd INNER JOIN hd.nhanVien nv WHERE nv.maNhanVien LIKE :maNV")
                .setParameter("maNV", "%" + maNV + "%")
                .getResultList();
    }

    @Override
    public ArrayList<HoaDon> getHDtheoNgay(Date d) throws RemoteException {
        return (ArrayList<HoaDon>) em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.ngayLap = :d")
                .setParameter("d", d)
                .getResultList();
    }

    @Override
    public long demSoKHTrongNgay(Date d) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT kh)from KhachHang kh inner join HoaDon hd on kh.maKhachHang = hd.khachHang.maKhachHang  WHERE hd.ngayLap = :d ")
                .setParameter("d", d)
                .getSingleResult();
    }

    @Override
    public long demSoKHTrongThang(String nam, String thang) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT kh)from KhachHang kh inner join HoaDon hd on kh.maKhachHang = hd.khachHang.maKhachHang  WHERE YEAR(hd.ngayLap) = :nam AND MONTH(hd.ngayLap) = :thang ")
                .setParameter("nam", nam)
                .setParameter("thang", thang)
                .getSingleResult();
    }

    @Override
    public long demSoKHTrongNam(String nam) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT kh)from KhachHang kh inner join HoaDon hd on kh.maKhachHang = hd.khachHang.maKhachHang  WHERE YEAR(hd.ngayLap) = :nam ")
                .setParameter("nam", nam)
                .getSingleResult();
    }

    @Override
    public long demSoMHTrongNgay(Date d) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT mh) from MatHang mh inner join ChiTietHD ct on mh.maMH = ct.matHang.maMH inner join HoaDon hd on ct.hoaDon.maHoaDon = hd.maHoaDon WHERE hd.ngayLap = :d ")
                .setParameter("d", d)
                .getSingleResult();
    }

    @Override
    public long demSoMHTrongThang(String nam, String thang) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT mh) from MatHang mh inner join ChiTietHD ct on mh.maMH = ct.matHang.maMH inner join HoaDon hd on ct.hoaDon.maHoaDon = hd.maHoaDon WHERE YEAR(hd.ngayLap) = :nam AND MONTH(hd.ngayLap) = :thang ")
                .setParameter("nam", nam)
                .setParameter("thang", thang)
                .getSingleResult();
    }

    @Override
    public long demSoMHTrongNam(String nam) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT mh) from MatHang mh inner join ChiTietHD ct on mh.maMH = ct.matHang.maMH inner join HoaDon hd on ct.hoaDon.maHoaDon = hd.maHoaDon WHERE YEAR(hd.ngayLap) = :nam ")
                .setParameter("nam", nam)
                .getSingleResult();
    }

    @Override
    public long demSoKH(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT kh)from KhachHang kh inner join HoaDon hd on kh.maKhachHang = hd.khachHang.maKhachHang  WHERE hd.ngayLap BETWEEN :ngayBatDau AND :ngayKetThuc ")
                .setParameter("ngayBatDau", ngayBatDau, TemporalType.DATE)
                .setParameter("ngayKetThuc", ngayKetThuc, TemporalType.DATE)
                .getSingleResult();
    }

    @Override
    public long demSoMH(Date ngayBatDau, Date ngayKetThuc) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT mh) from MatHang mh inner join ChiTietHD ct on mh.maMH = ct.matHang.maMH inner join HoaDon hd on ct.hoaDon.maHoaDon = hd.maHoaDon WHERE hd.ngayLap BETWEEN :ngayBatDau AND :ngayKetThuc ")
                .setParameter("ngayBatDau", ngayBatDau, TemporalType.DATE)
                .setParameter("ngayKetThuc", ngayKetThuc, TemporalType.DATE)
                .getSingleResult();
    }

    @Override
    public long demSoLanKHDen(String maKH, Date ngayD, Date ngayKT) throws RemoteException {
        return (Long) em.createQuery("SELECT COUNT(DISTINCT hd) from HoaDon hd WHERE hd.khachHang.maKhachHang = :maKH AND hd.ngayLap BETWEEN :ngayD AND :ngayKT ")
                .setParameter("maKH", maKH)
                .setParameter("ngayD", ngayD, TemporalType.DATE)
                .setParameter("ngayKT", ngayKT, TemporalType.DATE)
                .getSingleResult();
    }


}
