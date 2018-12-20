package design;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class calBean {
	private int id;
	private String name;
	private int age;
	private Date day = new Date();
	private String time;
	private String food;
	private int cal;
	
	//コンストラクタ
	public calBean() {
	}

	// ====================================
	// ゲッターメソッド
	// ====================================	
	public String r_time(){
		return this.time;
	}
	public Date r_day(){
		return this.day;
	}
	public String r_food(){
		return this.food;
	}
	public int r_cal(){
		return this.cal;
	}
	
	public String getUser(String id) {
		try {
			// データベースへのコネクションを取得
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			String sql = "select Name from User where id =" + id;
			// SQL の実行
			ResultSet rs = smt.executeQuery(sql);
			String username = "";
			while(rs.next()){
				username = rs.getNString("Name");
			}
			smt.close();
			con.close();
			return username;
		} catch (Exception e) {
			System.out.println("getUser:SQLException:"+e.getMessage());
			return "";
		}
	}
	public boolean createUser(String id,String name,String sex) {
		try {
			// データベースへのコネクションを取得
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			int count = smt.executeUpdate(
					"INSERT INTO User (Id,Name,Sex) VALUES"
					+ "(" + id + ",'" + name + "','" + sex + "')");
			smt.close();
			con.close();
			if (count>0) 
				return true;
			else 
				return false;
		} catch (Exception e) {
			System.out.println("createUser:SQLException:"+e.getMessage());
			return false;
		}
	}
	public ArrayList<calBean> getDate(String id) {
		ArrayList<calBean> list = new ArrayList<calBean>();
		try {
			// データベースへのコネクションを取得
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			String sql = "select Day,Time,Food,Cal from Date where id =" + id;
			ResultSet rs = smt.executeQuery(sql);
			calBean tmpSb = new calBean();
			
			// SQL の実行
			while(rs.next()){
				tmpSb.setDay(rs.getDate("Day"));
				tmpSb.setTime(rs.getNString("Time"));
				tmpSb.setFood(rs.getString("Food"));
				tmpSb.setCal(rs.getInt("Cal"));
				list.add(tmpSb);
			}
			
			rs.close();
			smt.close();
			con.close();
			return list;
		} catch (Exception e) {
			System.out.println("getDate:SQLException:"+e.getMessage());
			return list;
		}
	}
	
	public int getCal(String food) {
		try {
			// データベースへのコネクションを取得
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			String sql = "select Cal from Menu where Food ='" + food+"'";
			// SQL の実行
			ResultSet rs = smt.executeQuery(sql);
			int cal=0;
			while(rs.next()){
				cal += rs.getInt("Cal");
			}
			smt.close();
			con.close();
			return cal;
		} catch (Exception e) {
			System.out.println("getCal:SQLException:"+e.getMessage());
			return -1;
		}
	}
	public String getDay(String id,String day) {
		try {
			// データベースへのコネクションを取得
			Connection con = DBManager.getUserConnection();
			Statement smt = con.createStatement();
			String sql = "select Time,Food,Cal from Date where Day="+day+ "and id="+id;
			// SQL の実行
			ResultSet rs = smt.executeQuery(sql);
			String time = "";
			String cal = "";
			while(rs.next()){
				 time = rs.getNString("Time");
			}
			while(rs.next()){
				 cal = rs.getNString("Cal");
			}
			smt.close();
			con.close();
			return time;
		} catch (Exception e) {
			System.out.println("getUser:SQLException:"+e.getMessage());
			return "";
		}
	}
	
	// ====================================
	// セッターメソッド
	// ====================================
	
	public void setDay(Date Day){
		day = Day;
	}
	public void setTime(String Time){
		time = Time;
	}
	public void setFood(String Food){
		food = Food;
	}
	public void setCal(int Cal){
		cal = Cal;
	}
}
