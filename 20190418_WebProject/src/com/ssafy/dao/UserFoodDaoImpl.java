package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.util.DBDriver;
import com.ssafy.vo.Food;
import com.ssafy.vo.User;
import com.ssafy.vo.UserFood;

public class UserFoodDaoImpl implements UserFoodDao {

	public List<UserFood> showUserFood(User user) {
		List<UserFood> list = new LinkedList<>();
		String id = user.getId();

		String sql = "SELECT eatfood.id, eatfood.code, eatfood.amount, food.name, food.img FROM eatfood INNER JOIN food ON eatfood.code = food.code ";
		sql += "WHERE id = ?";
		Connection conn = DBDriver.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeQuery();
			while (result.next()) {
				UserFood userFood = new UserFood();
				userFood.setUserId(result.getString(1));
				userFood.setFoodCode(result.getInt(2));
				userFood.setAmount(result.getInt(3));
				userFood.setFoodName(result.getString(4));
				userFood.setFoodImg(result.getString(5));
				list.add(userFood);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public void addUserFood(User user, int amount, int foodCode) {
		String userId = user.getId();
		String sql = "SELECT id, code, amount FROM eatfood WHERE id = ? AND code = ?";
		Connection conn = DBDriver.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, foodCode);
			result = pstmt.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			if (!result.next()) {
				result = null;
				pstmt = null;
				sql = "INSERT eatfood values(?,?,0,?)";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setInt(2, foodCode);
				pstmt.setInt(3, amount);
				pstmt.executeUpdate();
				
			} else {
				amount += result.getInt(3);
				pstmt.close();
				result.close();
				modifyUserFood(user, amount, foodCode);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (result != null) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void removeUserFood(User user, int foodCode) {
		String userId = user.getId();
		String sql = "DELETE FROM eatfood WHERE id = ? AND code = ?";
		Connection conn = DBDriver.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet result = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setInt(2, foodCode);
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
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void modifyUserFood(User user, int amount, int foodCode) {
		String userId = user.getId();
		String sql = "UPDATE eatfood SET amount=? WHERE id=? and code=?";
		Connection conn = DBDriver.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setString(2, userId);
			pstmt.setInt(3, foodCode);
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
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
