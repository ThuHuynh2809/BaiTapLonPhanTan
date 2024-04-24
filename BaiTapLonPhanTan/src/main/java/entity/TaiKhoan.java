package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;


@Entity @Table(name = "TaiKhoan")
public class TaiKhoan  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name = "maTK")
	private String maTK;
	@Column(name = "matKhau")
	private String matKhau;

	@OneToOne(mappedBy = "taiKhoan")
	private NhanVien nhanVien;

	public String getMaTK() {
		return maTK;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
	public TaiKhoan() {
		super();
	}
	
	public TaiKhoan(String maTK, String matKhau) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
	}
	
	public TaiKhoan(String maTK) {
		super();
		this.maTK = maTK;
	}
	
	@Override
	public String toString() {
		return "TaiKhoan [maTK=" + maTK + ", matKhau=" + matKhau + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTK == null) ? 0 : maTK.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoan other = (TaiKhoan) obj;
		if (maTK == null) {
			if (other.maTK != null)
				return false;
		} else if (!maTK.equals(other.maTK))
			return false;
		return true;
	}
	
}
