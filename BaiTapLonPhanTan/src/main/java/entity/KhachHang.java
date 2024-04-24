package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


@Entity @Table(name = "KhachHang")
public class KhachHang implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name = "maKhachHang", length = 10, nullable = false)
	private String maKhachHang;
	@Column(name = "tenKH", length = 255 )
	private String tenKH;
	@Column(name = "diaChi", length = 255)
	private String diaChi;
	@Column(name = "sdt", length = 10)
	private String sdt;
	@Column(name = "cccd", 	length = 12)
	private String cccd;
	@Column(name = "ngaySinh", nullable = false)
	private Date ngaySinh;
	@Column(name = "gioiTinh", length = 10)
	private String gioiTinh;
	@Column(name = "diemTichLuy", nullable = false)
	private int diemTichLuy;
	@Column(name = "ngayDangKy", nullable = false)
	private Date ngayDangKy;

	@ManyToOne
	@JoinColumn(name = "maLoaiKH")
	private LoaiKH loaiKH;
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaKhangHang() {
		return maKhachHang;
	}
	public void setMaKhangHang(String maKhangHang) {
		this.maKhachHang = maKhangHang;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(java.util.Date date) {
		this.ngaySinh = (Date) date;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getDiemTichLuy() {
		return diemTichLuy;
	}
	public void setDiemTichLuy(int diemTichLuy) {
		this.diemTichLuy = diemTichLuy;
	}
	public Date getNgayDangKy() {
		return ngayDangKy;
	}
	public void setNgayDangKy(java.util.Date date) {
		this.ngayDangKy = (Date) date;
	}
	public LoaiKH getLoaiKH() {
		return loaiKH;
	}
	public void setLoaiKH(LoaiKH loaiKH) {
		this.loaiKH = loaiKH;
	}
	
	public KhachHang(String maKhangHang, String tenKH, String diaChi, String sdt, String cccd, Date ngaySinh,
			String gioiTinh, int diemTichLuy, Date ngayDangKy, LoaiKH loaiKH) {
		super();
		this.maKhachHang = maKhangHang;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.cccd = cccd;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemTichLuy = diemTichLuy;
		this.ngayDangKy = ngayDangKy;
		this.loaiKH = loaiKH;
	}
	
	public KhachHang() {
		super();
	}
	
	public KhachHang(String maKhangHang) {
		super();
		this.maKhachHang = maKhangHang;
	}
	
	
	public KhachHang(String maKhangHang, LoaiKH loaiKH, String tenKH, String sdt, String diaChi) {
		super();
		this.maKhachHang = maKhangHang;
		this.loaiKH = loaiKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	
	@Override
	public String toString() {
		return "KhachHang [maKhangHang=" + maKhachHang + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sdt=" + sdt
				+ ", cccd=" + cccd + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemTichLuy="
				+ diemTichLuy + ", ngayDangKy=" + ngayDangKy + ", loaiKH=" + loaiKH + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKhachHang == null) ? 0 : maKhachHang.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (maKhachHang == null) {
			if (other.maKhachHang != null)
				return false;
		} else if (!maKhachHang.equals(other.maKhachHang))
			return false;
		return true;
	}

}
