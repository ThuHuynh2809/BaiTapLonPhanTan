package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.MacHangDao;
import entity.MatHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MatHangImpl extends UnicastRemoteObject implements MacHangDao {
	private EntityManager entityManager;
	
	public MatHangImpl() throws RemoteException {
		entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
	}
	
	@Override
	public boolean themMatHang(MatHang matHang) throws RemoteException {
		entityManager.getTransaction().begin();
		
		entityManager.persist(matHang);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public boolean updateMatHang(MatHang matHang) throws RemoteException {
		entityManager.getTransaction().begin();
		MatHang mh = entityManager.find(MatHang.class, matHang.getMaMatHang());
		mh.setTenMatHang(matHang.getTenMatHang());
		mh.setSoLuongMatHang(matHang.getSoLuongMatHang());
		mh.setGiaMatHang(matHang.getGiaMatHang());
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public boolean deleteMatHang(MatHang matHang) throws RemoteException {
		entityManager.getTransaction().begin();
		MatHang mh = entityManager.find(MatHang.class, matHang.getMaMatHang());
		entityManager.remove(mh);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public ArrayList<MatHang> getAllMatHangs() throws RemoteException {
		TypedQuery<MatHang> query = entityManager.createQuery("SELECT mh FROM MatHang mh", MatHang.class);
		return (ArrayList<MatHang>) query.getResultList();
	}
	
	@Override
	public MatHang getMHTheoMa(String ma) throws RemoteException {
		return entityManager.find(MatHang.class, ma);
	}
	
	@Override
	public MatHang getMHTheoTen(String ten) throws RemoteException {
		TypedQuery<MatHang> query = entityManager.createQuery("SELECT mh FROM MatHang mh WHERE mh.tenMatHang = :ten",
				MatHang.class);
		query.setParameter("ten", ten);
		return query.getSingleResult();
	}
	
	@Override
	public ArrayList<MatHang> getMHTheoLoai(String loai) throws RemoteException {
		TypedQuery<MatHang> query = entityManager
				.createQuery("SELECT mh FROM MatHang mh WHERE mh.loaiMatHang.tenLoai = :loai", MatHang.class);
		query.setParameter("loai", loai);
		return (ArrayList<MatHang>) query.getResultList();
	}
		
	@Override
	public MatHang getMHTheoTenMHVaLoaiMH(String tenMH, String loaiMH) throws RemoteException {
		TypedQuery<MatHang> query = entityManager.createQuery(
				"SELECT mh FROM MatHang mh WHERE mh.tenMatHang = :tenMH AND mh.loaiMatHang.tenLoai = :loaiMH",
				MatHang.class);
		query.setParameter("tenMH", tenMH);
		query.setParameter("loaiMH", loaiMH);
		return query.getSingleResult();
	}
	
	@Override
	 public ArrayList<MatHang> sortMaMatHang(String kieuSapXep) throws RemoteException {
        String sapXep = "DESC"; // Mặc định sắp xếp giảm dần
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            sapXep = "ASC";
        }
        String queryString = "SELECT mh FROM MatHang mh ORDER BY mh.maMatHang " + sapXep;
        TypedQuery<MatHang> query = entityManager.createQuery(queryString, MatHang.class);
        return new ArrayList<>(query.getResultList());
    }

	
    @Override
    public ArrayList<MatHang> sortLoaiMH(String kieuSapXep) throws RemoteException {
        String sapXep = "DESC"; // Mặc định sắp xếp giảm dần
        if ("ASC".equalsIgnoreCase(kieuSapXep)) {
            sapXep = "ASC";
        }
        String queryString = "SELECT mh FROM MatHang mh ORDER BY mh.loaiMatHang.tenLoai " + sapXep;
        TypedQuery<MatHang> query = entityManager.createQuery(queryString, MatHang.class);
        return new ArrayList<>(query.getResultList());
    }
	
	@Override
	public ArrayList<MatHang> getTenMH(String tenMH) throws RemoteException{
		TypedQuery<MatHang> query = entityManager.createQuery("SELECT mh FROM MatHang mh WHERE mh.tenMatHang = :tenMH", MatHang.class);
        query.setParameter("tenMH", tenMH);
        return (ArrayList<MatHang>) query.getResultList();
    }
	@Override
	public ArrayList<MatHang> getLoaiMH(String loaiMH) throws RemoteException{
		TypedQuery<MatHang> query = entityManager
				.createQuery("SELECT mh FROM MatHang mh WHERE mh.loaiMatHang.tenLoai = :loaiMH", MatHang.class);
		query.setParameter("loaiMH", loaiMH);
		return (ArrayList<MatHang>) query.getResultList();
	}
	
}


