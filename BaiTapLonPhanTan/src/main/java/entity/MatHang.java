package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "MatHang")
public class MatHang implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maMH")
	private String maMH;
	@Column(name = "tenMH")
	private String tenMatHang;
	@Column(name = "soLuongMH")
	private int soLuongMH;
	@Column(name = "giaMH")
	private double giaMatHang;

	@OneToMany(mappedBy = "matHang")
	private List<ChiTietDDP> chiTietDDP;

	@ManyToOne @JoinColumn(name = "maLoaiMH")
	private LoaiMH loaiMatHang;

	public String getMaMatHang() {
		return maMH;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMH = maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public int getSoLuongMatHang() {
		return soLuongMH;
	}

	public void setSoLuongMatHang(int soLuongMatHang) {
		this.soLuongMH = soLuongMatHang;
	}

	public double getGiaMatHang() {
		return giaMatHang;
	}

	public void setGiaMatHang(double giaMatHang) {
		this.giaMatHang = giaMatHang;
	}

	public LoaiMH getLoaiMatHang() {
		return loaiMatHang;
	}

	public void setLoaiMatHang(LoaiMH loaiMatHang) {
		this.loaiMatHang = loaiMatHang;
	}

	public MatHang(String maMatHang, String tenMatHang, int soLuongMatHang, double giaMatHang,
			LoaiMH loaiMatHang) {
		super();
		this.maMH = maMatHang;
		this.tenMatHang = tenMatHang;
		this.soLuongMH = soLuongMatHang;
		this.giaMatHang = giaMatHang;
		this.loaiMatHang = loaiMatHang;
	}
	public MatHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatHang(String maMatHang) {
		super();
		this.maMH = maMatHang;
	}

	@Override
	public String toString() {
		return "MatHang [maMatHang=" + maMH + ", tenMatHang=" + tenMatHang + ", soLuongMatHang=" + soLuongMH
				+ ", giaMatHang=" + giaMatHang + ", loaiMatHang=" + loaiMatHang + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMH == null) ? 0 : maMH.hashCode());
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
		MatHang other = (MatHang) obj;
		if (maMH == null) {
			if (other.maMH != null)
				return false;
		} else if (!maMH.equals(other.maMH))
			return false;
		return true;
	}
}
