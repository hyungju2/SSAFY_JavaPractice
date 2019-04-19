package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.util.DBDriver;
import com.ssafy.vo.User;

public class UserDaoImpl implements UserDao {

	Connection conn = DBDriver.getInstance().getConn();
	private List<User> list;

	public UserDaoImpl() {
		list = new LinkedList<>();
	}

	@Override
	public void signUp(User user) { // 회원가입
		String sql = "INSERT INTO User VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getAllergy());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void modify(String id, String password, String name, String address, String phone, String allergy) {
		String sql = "UPDATE User SET password=?, name=?, address=?, phone=?, allergy=? WHERE id=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareCall(sql);

			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setString(4, phone);
			pstmt.setString(5, allergy);
			pstmt.setString(6, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public User searchID(String id) {
		String sql = "SELECT * FROM User WHERE id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setPhone(rs.getString("phone"));
				user.setAllergy(rs.getString("allergy"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User signIn(String id, String password) { // 로그인
		System.out.println("i'm dao");
		String sql = "SELECT * FROM User WHERE id=? && password=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();

			System.out.println("test");
			while (rs.next()) {
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setAllergy(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(User user) {
		System.out.println("딜리트");
		String sql = "DELETE FROM User WHERE id=?";
		PreparedStatement pstmt = null;
		try {

			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, user.getId());
			System.out.println("딜리드 됐다");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void leave(User user) {

	}

	@Override
	public User searchUser(String id) {
		String sql = "SELECT * FROM User Where id=?";
		User user = new User();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Connection conn = DBDriver.getInstance().getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setPhone(rs.getString(5));
				user.setAllergy(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


}