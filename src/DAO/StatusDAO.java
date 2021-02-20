package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BEAN.Status;

public class StatusDAO {
	public static ArrayList<Status> listStatus(Connection conn) {
		ArrayList<Status> list = new ArrayList<Status>();
		String sql = "SELECT * FROM uploadfile.status;";
		PreparedStatement ptmt = null;
		try {
			ptmt = conn.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Status status = new Status();
				status.setID(rs.getInt("StatusID"));
				status.setStatusContent(rs.getNString("statusContent"));
				status.setStatusImg(rs.getNString("statusImg"));
				status.setStatusTitle(rs.getNString("statusName"));
				status.setStatusName(rs.getNString("statusTitle"));
				list.add(status);
			}

		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {

			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public static boolean addStatus(Connection conn, Status status) {
		String sql = "insert into status(statusContent,statusName,statusImg,statusTitle) values(?,?,?,?)";
		PreparedStatement ptmt = null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, status.getStatusContent());
			ptmt.setString(2, status.getStatusName());
			ptmt.setString(3, status.getStatusImg());
			ptmt.setString(4, status.getStatusTitle());
			ptmt.executeQuery();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return false;
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public static boolean deleteStatus(Connection conn, int statusID) {
		String sql = "DELETE FROM status WHERE (StatusID = ?);";
		PreparedStatement ptmt = null;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, statusID);
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return false;
		} finally {
			try {
				ptmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return true;
	}

}
