package impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.TaiKhoanDao;
import entity.MatHang;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TaiKhoanImpl extends UnicastRemoteObject implements TaiKhoanDao{

	private EntityManager entityManager;
	
	public TaiKhoanImpl() throws RemoteException{
		entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
    }	

	@Override
	public boolean createTaiKhoan(String maTaiKhoan, String matKhau) throws RemoteException {
	    entityManager.getTransaction().begin();
	    TaiKhoan tk = new TaiKhoan();
	    tk.setMaTK(maTaiKhoan);
	    tk.setMatKhau(matKhau);
	    entityManager.persist(tk);
	    entityManager.getTransaction().commit();
		return false;
	}
	
	@Override
	public boolean updateTaiKhoan(String maTaiKhoan, String matKhau) throws RemoteException {
		entityManager.getTransaction().begin();
		TaiKhoan tk = entityManager.find(TaiKhoan.class, maTaiKhoan);
		tk.setMatKhau(matKhau);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public boolean deleteTaiKhoan(String maTaiKhoan) throws RemoteException {
		entityManager.getTransaction().begin();
		TaiKhoan tk = entityManager.find(TaiKhoan.class, maTaiKhoan);
		entityManager.remove(tk);
		entityManager.getTransaction().commit();
		return true;
	}
	
	@Override
	public ArrayList<TaiKhoan> getAllTaiKhoan() throws RemoteException {
		TypedQuery<TaiKhoan> query = entityManager.createQuery("SELECT tk FROM TaiKhoan tk", TaiKhoan.class);
		return (ArrayList<TaiKhoan>) query.getResultList();
		
	}
	
	@Override
	public TaiKhoan getTKTheoMa(String ma) throws RemoteException {
		return entityManager.find(TaiKhoan.class, ma);
	}
	@Override
	public TaiKhoan getMatKhauTheoMa(String ma) throws RemoteException {
		return entityManager.find(TaiKhoan.class, ma);
	}
	
}
