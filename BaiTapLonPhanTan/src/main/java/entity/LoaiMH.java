package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "LoaiMatHang")
public class LoaiMH implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "maLoaiMH")
	private String maLoaiMH;
	@Column(name = "tenLoaiMH")
	private String tenLoaiMatHang;
	
	public String getMaLoaiMatHang() {
		return maLoaiMH;
	}
	public void setMaLoaiMatHang(String maLoaiMatHang) {
		this.maLoaiMH = maLoaiMatHang;
	}
	public String getTenLoaiMatHang() {
		return tenLoaiMatHang;
	}
	public void setTenLoaiMatHang(String tenLoaiMatHang) {
		this.tenLoaiMatHang = tenLoaiMatHang;
	}
	
	public LoaiMH(String maLoaiMatHang, String tenLoaiMatHang) {
		super();
		this.maLoaiMH = maLoaiMatHang;
		this.tenLoaiMatHang = tenLoaiMatHang;
	}
	public LoaiMH() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiMH(String maLoaiMatHang) {
		super();
		this.maLoaiMH = maLoaiMatHang;
	}
	
	@Override
	public String toString() {
		return "LoaiMatHang [maLoaiMatHang=" + maLoaiMH + ", tenLoaiMatHang=" + tenLoaiMatHang + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiMH == null) ? 0 : maLoaiMH.hashCode());
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
		LoaiMH other = (LoaiMH) obj;
		if (maLoaiMH == null) {
			if (other.maLoaiMH != null)
				return false;
		} else if (!maLoaiMH.equals(other.maLoaiMH))
			return false;
		return true;
	}
	
	
}
