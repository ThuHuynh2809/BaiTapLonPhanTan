package entity;

import entity.DonDatPhong;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.List;


@Entity
@Table(name = "CTDDP")
public class ChiTietDDP implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToOne @JoinColumn(name = "maDDP", insertable = false, updatable = false)
    private DonDatPhong donDatPhong;

    @EmbeddedId
    private ChiTietDDPId id;

    @Column(name = "soLuong")
    private int soLuongMH;

    @ManyToOne @JoinColumn(name = "maMH", insertable = false, updatable = false)
    private MatHang matHang;

    public DonDatPhong getDonDatPhong() {
        return donDatPhong;
    }

    public void setDonDatPhong(DonDatPhong donDatPhong) {
        this.donDatPhong = donDatPhong;
    }

    public int getSoLuongMH() {
        return soLuongMH;
    }

    public void setSoLuongMH(int soLuongMH) {
        this.soLuongMH = soLuongMH;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ChiTietDDP(DonDatPhong donDatPhong, int soLuongMH) {
        super();
        this.donDatPhong = donDatPhong;
        this.soLuongMH = soLuongMH;

    }

    public ChiTietDDP() {
        super();
    }



    @Override
    public String toString() {
        return "CTDDP [donDatPhong=" + donDatPhong + ", soLuongMH=" + soLuongMH + ", matHang=" + matHang + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((donDatPhong == null) ? 0 : donDatPhong.hashCode());
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
        ChiTietDDP other = (ChiTietDDP) obj;
        if (donDatPhong == null) {
            if (other.donDatPhong != null)
                return false;
        } else if (!donDatPhong.equals(other.donDatPhong))
            return false;
        if (matHang == null) {
            if (other.matHang != null)
                return false;
        } else if (!matHang.equals(other.matHang))
            return false;
        return true;
    }


}
