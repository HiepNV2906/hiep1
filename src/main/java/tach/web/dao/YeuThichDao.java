/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tach.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import tach.web.connect.ConnectDatabase;
import tach.web.model.Sach;
import tach.web.model.YeuThich;

/**
 *
 * @author BV LAPTOP
 */
public class YeuThichDao extends ConnectDatabase{
    Connection cnn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public ArrayList<Sach> getSachYeuThich(int s){
        ArrayList<Sach> dsSachYeuThich = new ArrayList<>();
        try {
            String query = "select s.id_sach,s.ten_sach,s.mo_ta,s.so_trang,s.tac_gia,s.ngay_dang,s.img from dbo.Sach s inner join dbo.YeuThich yth ON s.id_sach=yth.id_sach where yth.id_user="+s;
            ConnectDatabase cnb = new ConnectDatabase();

            ps=this.conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                Sach s1=new Sach();
                s1.setID_Sach(rs.getInt(1));
                s1.setTenSach(rs.getString(2));
                s1.setMota(rs.getString(3));
                s1.setSoTrang(rs.getInt(4));
                s1.setTacGia(rs.getString(5));
                s1.setNgayDang(rs.getString(6));
                s1.setImg(rs.getString(7));
                dsSachYeuThich.add(s1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSachYeuThich;
    }
    
    public void deleteYeuThich(YeuThich yth){
        try {
            String query = "delete from dbo.YeuThich where id_sach="+yth.getID_Sach()+"and id_user="+yth.getID_User();
            ConnectDatabase cnb = new ConnectDatabase();
//            cnn=cnb.getConn();
            ps=this.conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertYeuThich(YeuThich yth){
        try {
            String query = "insert into dbo.YeuThich (id_sach,id_user) values (" + yth.getID_Sach() + "," +yth.getID_User()+ ")";
            ConnectDatabase cnb = new ConnectDatabase();
//            cnn=cnb.getConn();
            ps=this.conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
