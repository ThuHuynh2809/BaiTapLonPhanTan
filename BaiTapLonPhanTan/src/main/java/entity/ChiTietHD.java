package entity;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "CTHD")
public class ChiTietHD implements Serializable  {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ChiTietHDId id;
	@Column(name = "soLuong")
	private int soLuong;

	@ManyToOne @JoinColumn(name = "maMH", insertable = false, updatable = false)
	private MatHang matHang;
	@OneToOne @JoinColumn(name = "maHD", insertable = false, updatable = false)
	private HoaDon hoaDon;

	@Formula("soLuong * (SELECT giaMatHang FROM MatHang WHERE MaMH = maMH)")
	private double tongTien;

	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public MatHang getMatHang() {
		return matHang;
	}
	public void setMatHang(MatHang matHang) {
		this.matHang = matHang;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public ChiTietHD(int soLuong, MatHang matHang, HoaDon hoaDon) {
		super();
		this.soLuong = soLuong;
		this.matHang = matHang;
		this.hoaDon = hoaDon;
		this.tongTien = soLuong* matHang.getGiaMatHang();
	}
	public ChiTietHD() {
		super();
	}
	public ChiTietHD(MatHang matHang, HoaDon hoaDon) {
		super();
		this.matHang = matHang;
		this.hoaDon = hoaDon;
	}
	@Override
	public String toString() {
		return "CTHD [soLuong=" + soLuong + ", matHang=" + matHang + ", hoaDon=" + hoaDon + ", tongTien=" + tongTien
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((matHang == null) ? 0 : matHang.hashCode());
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
		ChiTietHD other = (ChiTietHD) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (matHang == null) {
			if (other.matHang != null)
				return false;
		} else if (!matHang.equals(other.matHang))
			return false;
		return true;
	}
	
	
	
}
