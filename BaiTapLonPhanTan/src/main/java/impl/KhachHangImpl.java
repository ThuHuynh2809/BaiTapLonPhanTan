/*
 * @ (#) KhachHangImpl.java  1  4/22/2024
 * Copyright (c) 2024 IUH. All rights reserved
 */

package impl;
/*
 * @description:
 * @author: Nguyen Hoang Thai
 * @date: 4/22/2024
 * @version: 1.0
 */

import dao.KhachHangDao;
import entity.KhachHang;
import entity.LoaiKH;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import lombok.var;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class KhachHangImpl extends UnicastRemoteObject implements KhachHangDao {
    private final EntityManager entityManager;
    public KhachHangImpl() throws RemoteException {
        entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }

    @Override
    public boolean themKhachHang(KhachHang khachHang) throws RemoteException {
        try {
			entityManager.getTransaction().begin();
			entityManager.persist(khachHang);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
        }
    }

    @Override
    public boolean capNhatKH(KhachHang khachHang) throws RemoteException {
        try {
            entityManager.getTransaction().begin();
            KhachHang khachHang1 = entityManager.find(KhachHang.class, khachHang.getMaKhangHang());
            if(khachHang1 == null) {
                throw new Exception("KhÃ´ng tÃ¬m tháº¥y khÃ¡ch hÃ ng");
            }
            khachHang1.setTenKH(khachHang.getTenKH());
            khachHang1.setDiaChi(khachHang.getDiaChi());
            khachHang1.setSdt(khachHang.getSdt());
            khachHang1.setCccd(khachHang.getCccd());
            khachHang1.setNgaySinh(khachHang.getNgaySinh());
            khachHang1.setGioiTinh(khachHang.getGioiTinh());
            khachHang1.setDiemTichLuy(khachHang.getDiemTichLuy());
            khachHang1.setNgayDangKy(khachHang.getNgayDangKy());
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<KhachHang> getAllDanhSachKH() throws RemoteException {
        return (ArrayList<KhachHang>) entityManager.createQuery("select kh from KhachHang kh").getResultList();
    }
    @Override
	public KhachHang getKHTheoSDT(String sdt) throws RemoteException {
		return (KhachHang) entityManager.createQuery("select kh from KhachHang kh where kh.sdt = :sdt")
				.setParameter("sdt", sdt).getSingleResult();
	}

    @Override
    public KhachHang getKHTheoMa(String ma) throws RemoteException {
        return entityManager.find(KhachHang.class, ma);
    }

    @Override
    public ArrayList<KhachHang> getTenKH(String info) throws RemoteException {
        return (ArrayList<KhachHang>) entityManager.createQuery("select kh from KhachHang kh where kh.tenKH like :info")
                .setParameter("info", "%" + info + "%").getResultList();
    }

    @Override
    public ArrayList<KhachHang> getMaVaSDTKH(String info) throws RemoteException {
        return (ArrayList<KhachHang>) entityManager.createQuery("select kh from KhachHang kh where kh.maKhachHang = :info or kh.sdt = :info")
                .setParameter("info", info).getResultList();
    }

    @Override
    public ArrayList<KhachHang> sortMaKH() throws RemoteException {
        return (ArrayList<KhachHang>) entityManager.createQuery("select kh from KhachHang kh order by kh.maKhachHang desc").getResultList();
    }

    @Override
    public ArrayList<KhachHang> getKHTheoLoai(String maLoaiKH) throws RemoteException {
        return (ArrayList<KhachHang>) entityManager.createQuery("select kh from KhachHang kh where kh.loaiKH.maLoaiKH = :maLoaiKH")
                .setParameter("maLoaiKH", maLoaiKH).getResultList();
    }

    @Override
    public boolean themKHTheoDDP(KhachHang kh) throws RemoteException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(kh);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public LoaiKH getMaLoaiKHFromTen(String tenLoaiKH) throws RemoteException {
        return (LoaiKH) entityManager.createQuery("select lkh from LoaiKH lkh where lkh.tenLoaiKH = :tenLoaiKH")
                .setParameter("tenLoaiKH", tenLoaiKH).getSingleResult();
    }

    @Override
    public boolean checkSdtKH(String sdt) throws RemoteException {
        return (Long) entityManager.createQuery("select count(kh) from KhachHang kh where kh.sdt = :sdt")
                .setParameter("sdt", sdt).getSingleResult() > 0;
    }

    @Override
    public KhachHang getKHTheoTen(String info) throws RemoteException {
        return (KhachHang) entityManager.createQuery("select kh from KhachHang kh where kh.tenKH = :info")
                .setParameter("info", info).getSingleResult();
    }

	@Override
	public boolean huyKH(String maKH) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			entityManager.getTransaction().begin();
			KhachHang khachHang = entityManager.find(KhachHang.class, maKH);
			if (khachHang == null) {
				throw new Exception("KhÃ´ng tÃ¬m tháº¥y khÃ¡ch hÃ ng");
			}
			entityManager.remove(khachHang);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}


}
