/*
 * @ (#) $NAME.java         4/23/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package impl;

import dao.PhongDao;
import entity.Phong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/23/2024
 */
public class PhongImpl extends UnicastRemoteObject implements PhongDao {

    private static EntityManager em;

    public PhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themPhong(Phong p) throws RemoteException {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(p);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean huyPhong(String ma) throws RemoteException {
        em.getTransaction().begin();
        Phong p = em.find(Phong.class, ma);
        p.setTinhTrangPhong("LP004");
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean capNhatPhong(Phong phong) throws RemoteException {
        em.getTransaction().begin();
        Phong p = em.find(Phong.class, phong.getMaPhong());
        p.setGiaPhong(phong.getGiaPhong());
        p.setTinhTrangPhong(phong.getTinhTrangPhong());
        p.setLoaiPhong(phong.getLoaiPhong());
        p.setMoTa(phong.getMoTa());
        p.setSucChua(phong.getSucChua());
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean capNhatTrangThaiPhong(String ma, String tinhTrang) throws RemoteException {
        em.getTransaction().begin();
        Phong p = em.find(Phong.class, ma);
        p.setTinhTrangPhong(tinhTrang);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<Phong> getPhongTrongVaDaDat() throws RemoteException {
        return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.trangThaiDDP = 'Đang hoạt động' AND ddp.phong.loaiPhong.maLoaiPhong = 'LP004'", Phong.class)
                .getResultList();
    }

    @Override
    public Phong getPhongTheoMa(String ma) throws RemoteException {
        return em.find(Phong.class, ma);
    }

    @Override
    public List<Phong> getPhongDangHoatDong(Date ngayDen) throws RemoteException {
        return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.trangThaiDDP = 'Đang hoạt động' AND ddp.ngayDen = :ngayDen", Phong.class)
                .setParameter("ngayDen", ngayDen)
                .getResultList();
    }

    @Override
    public List<Phong> getPhongDangHoatDongTheo1() throws RemoteException {
        return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.trangThaiDDP = 'Đang hoạt động'", Phong.class)
                .getResultList();
    }

    @Override
    public List<Phong> getDanhSachPhong() throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE NOT p.loaiPhong.maLoaiPhong = 'LP004'", Phong.class)
                .getResultList();
    }

    @Override
    public Phong getPhongDangHoatDongTheoMa(String ma) throws RemoteException {
return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.trangThaiDDP = 'Đang hoạt động' AND ddp.phong.maPhong = :ma", Phong.class)
                .setParameter("ma", ma)
                .getSingleResult();
    }

    @Override
    public List<Phong> getPhongTheoMaLoaiPhong(String maLoaiPhong) throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = :maLoaiPhong", Phong.class)
                .setParameter("maLoaiPhong", maLoaiPhong)
                .getResultList();
    }

    @Override
    public Phong getGiaPhongTheoMa(String ma) throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.maPhong = :ma", Phong.class)
                .setParameter("ma", ma)
                .getSingleResult();
    }

    @Override
    public List<Phong> getPhongTheoLoai(String maLoaiPhong) throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = :maLoaiPhong", Phong.class)
                .setParameter("maLoaiPhong", maLoaiPhong)
                .getResultList();
    }

    @Override
    public List<Phong> getPhongThuongTrong() throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = 'LP001' AND p.tinhTrangPhong = 'Trống'", Phong.class)
                .getResultList();
    }

    @Override
    public List<Phong> getPhongVipTrong() throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.loaiPhong.maLoaiPhong = 'LP003' AND p.tinhTrangPhong = 'Trống'", Phong.class)
                .getResultList();
    }

    @Override
    public List<Phong> sortTheoGiaPhong(String kieuSapXep) throws RemoteException {
        String typeS = "DESC";
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            typeS = "ASC";
        }
        String query = "SELECT p FROM Phong p ORDER BY p.giaPhong " + typeS;
        TypedQuery<Phong> typedQuery = em.createQuery(query, Phong.class);
        return typedQuery.getResultList();
    }


    @Override
    public List<Phong> sortTheoMaPhong(String kieuSapXep) throws RemoteException {
        String typeS = "DESC";
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            typeS = "ASC";
        }

        String query = "SELECT p FROM Phong p ORDER BY p.maPhong " + typeS;
        TypedQuery<Phong> typedQuery = em.createQuery(query, Phong.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<Phong> sortTheoMaPhong() throws RemoteException {
        return null;
    }

    @Override
    public Phong getThongTinPhong(String maPhong) throws RemoteException {
        return em.find(Phong.class, maPhong);
    }

    @Override
    public List<Phong> getPhongTheoTinhTrang(String tinhTrang) throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.tinhTrangPhong = :tinhTrang", Phong.class)
                .setParameter("tinhTrang", tinhTrang)
                .getResultList();
    }

    @Override
    public List<Phong> getPhongTheoMaP(String maPhong) throws RemoteException {
        return em.createQuery("SELECT p FROM Phong p WHERE p.maPhong = :maPhong", Phong.class)
                .setParameter("maPhong", maPhong)
                .getResultList();
    }

    @Override
    public Phong getPhongTheoMaPhong(String maPhong) throws RemoteException {
        return em.find(Phong.class, maPhong);
    }
}
