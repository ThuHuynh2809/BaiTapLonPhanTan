/*
 * @ (#) $NAME.java         4/23/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package impl;

import dao.DatPhongDao;
import entity.DonDatPhong;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 4/23/2024
 */
public class DatPhongImpl extends UnicastRemoteObject implements DatPhongDao {

    private static EntityManager em;

    public DatPhongImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themDDP(DonDatPhong ddp) throws RemoteException {
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(ddp);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean capNhatDDP(DonDatPhong ddp, String ma) throws RemoteException {
        em.getTransaction().begin();
        DonDatPhong donDatPhong = em.find(DonDatPhong.class, ma);
        donDatPhong.setNgayDen(ddp.getNgayDen());
        donDatPhong.setGioDen(ddp.getGioDen());
        donDatPhong.setPhong(ddp.getPhong());
        donDatPhong.setKhachHang(ddp.getKhachHang());
        donDatPhong.setNhanVien(ddp.getNhanVien());
        donDatPhong.setTrangThaiDDP(ddp.getTrangThaiDDP());
        donDatPhong.setNgayLap(ddp.getNgayLap());
        em.getTransaction().commit();
        return true;
    }

    @Override
    public int capNhatTrangThaiPhongvaDDP() throws RemoteException {
        String sql = "update phong\r\n"
                + "set tinhTrangPhong = case\r\n"
                + "when maPhong  in (select distinct maphong from DonDatPhong \r\n"
                + "					where (((DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen))-DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())) between 0 and 120 )\r\n"
                + "								and TrangThaiDDP like N'Chờ xác nhận')then N'Đặt trước'\r\n"
                + "when maPhong in( select distinct maPhong from DonDatPhong\r\n"
                + "	where (DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())-(DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen)))>0 and TrangThaiDDP like N'Chờ xác nhận') then N'Trống'\r\n"
                + "else phong.tinhTrangPhong\r\n"
                + "end\r\n"
                + "\r\n"
                + "update DonDatPhong\r\n"
                + "set TrangThaiDDP =N'Huỷ'\r\n"
                + "where (DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())-(DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen)))>0 and TrangThaiDDP like N'Chờ xác nhận'\r\n"
                + " ";

        em.createNamedQuery(sql, DonDatPhong.class).executeUpdate();
        return 1;
    }

    @Override
    public boolean capNhatTrangThaiDDP(String ma) throws RemoteException {
        em.getTransaction().begin();
        DonDatPhong ddp = em.find(DonDatPhong.class, ma);
        ddp.setTrangThaiDDP("Đã trả phòng");
        em.getTransaction().commit();
        return true;
    }

    @Override
    public List<DonDatPhong> getAllDDP() throws RemoteException {
        return (List<DonDatPhong>) em.createQuery("SELECT ddp FROM DonDatPhong ddp").getResultList();
    }

    @Override
    public List<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() throws RemoteException {
        return (List<DonDatPhong>) em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.trangThaiDDP = 'Hủy' OR ddp.trangThaiDDP = 'Đã trả phòng'").getResultList();
    }

    @Override
    public DonDatPhong getDDPTheoMa(String ma) throws RemoteException {
        return em.find(DonDatPhong.class, ma);
    }

    @Override
    public List<DonDatPhong> getDDPTheoMaKH(String ma) throws RemoteException {
        return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.khachHang.maKhachHang = '" + ma + "' AND ddp.trangThaiDDP = 'Chờ xác nhận'").getResultList();
    }

    @Override
    public List<DonDatPhong> getDDPTheoMaDDP(String ma) throws RemoteException {
        return em.createQuery("SELECT ddp FROM DonDatPhong ddp WHERE ddp.maDDP = '" + ma + "'").getResultList();
    }

    @Override
    public List<DonDatPhong> sortMaDDP(String type) throws RemoteException {
        String typeS = "DESC";
        if ("ASC".equalsIgnoreCase(type)) {
            typeS = "ASC";
        }
        String query = "SELECT ddp FROM DonDatPhong ddp ORDER BY ddp.maDDP " + typeS;

        TypedQuery<DonDatPhong> typedQuery = em.createQuery(query, DonDatPhong.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<DonDatPhong> sortDDPTheoLoaiPhong(String type) throws RemoteException {
        String typeS = "DESC";
        if ("ASC".equalsIgnoreCase(type)) {
            typeS = "ASC";
        }
        String query = "SELECT ddp FROM DonDatPhong ddp ORDER BY ddp.phong.loaiPhong.maLoaiPhong " + typeS;

        TypedQuery<DonDatPhong> typedQuery = em.createQuery(query, DonDatPhong.class);
        return typedQuery.getResultList();
    }
}
