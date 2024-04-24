package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class DAOSinhMaTuDong {
	private EntityManager entityManager;

	public DAOSinhMaTuDong() {
		entityManager = Persistence.createEntityManagerFactory("maria").createEntityManager();
	}

	public String getMaMH() {
		String maMH = "";
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery(
					"SELECT CONCAT('MH', RIGHT(CONCAT('000', COALESCE(CAST(SUBSTRING(m.maMH, 3) AS int), 0) + 1), 3)) FROM MatHang m WHERE m.maMH LIKE 'MH%'");
			maMH = (String) query.getSingleResult();
			entityManager.getTransaction().commit();
		} catch (NoResultException e) {
			// Xử lý nếu không tìm thấy kết quả
			maMH = "MH001"; // Giá trị mặc định nếu không tìm thấy kết quả
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return maMH;
	}

	public String getMaNV() {
		String maNV = "";
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery(
					"SELECT CONCAT('NV', RIGHT(CONCAT('000', COALESCE(CAST(SUBSTRING(n.maNV, 3) AS int), 0) + 1), 3)) FROM NhanVien n WHERE n.maNV LIKE 'NV%'");
			maNV = (String) query.getSingleResult();
			entityManager.getTransaction().commit();
		} catch (NoResultException e) {
			// Xử lý nếu không tìm thấy kết quả
			maNV = "NV001"; // Giá trị mặc định nếu không tìm thấy kết quả
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return maNV;
	}

	public String getMaKH() {
		String maKH = "";
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery(
					"SELECT CONCAT('KH', RIGHT(CONCAT('000', COALESCE(CAST(SUBSTRING(k.maKH, 3) AS int), 0) + 1), 3)) FROM KhachHang k WHERE k.maKH LIKE 'KH%'");
			maKH = (String) query.getSingleResult();
			entityManager.getTransaction().commit();
		} catch (NoResultException e) {
			// Xử lý nếu không tìm thấy kết quả
			maKH = "KH001"; // Giá trị mặc định nếu không tìm thấy kết quả
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}
		return maKH;
	}
}
