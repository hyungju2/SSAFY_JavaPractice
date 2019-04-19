package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.util.DBDriver;
import com.ssafy.util.FoodSaxParser;
import com.ssafy.vo.Food;
import com.ssafy.vo.FoodPageBean;

public class FoodDaoImpl implements FoodDao {

	public FoodDaoImpl() {
//		loadData();
	}

	/**
	 * 식품 영양학 정보와 식품 정보를 xml 파일에서 읽어온다.
	 */
	public void loadData() {
		FoodSaxParser parser = new FoodSaxParser();
		List<Food> foods = parser.getFoods();// FoodNutritionSaxPaser를 이용하여 Food 데이터들을 가져온다
		Connection conn = DBDriver.getInstance().getConn();
		for (Food food : foods) {
			String sql = "INSERT INTO food VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, food.getCode());
				pstmt.setString(2, food.getName());
				pstmt.setDouble(3, food.getSupportpereat());
				pstmt.setDouble(4, food.getCalory());
				pstmt.setDouble(5, food.getCarbo());
				pstmt.setDouble(6, food.getProtein());
				pstmt.setDouble(7, food.getFat());
				pstmt.setDouble(8, food.getSugar());
				pstmt.setDouble(9, food.getNatrium());
				pstmt.setDouble(10, food.getChole());
				pstmt.setDouble(11, food.getFattyacid());
				pstmt.setDouble(12, food.getTransfat());
				pstmt.setString(13, food.getMaker());
				pstmt.setString(14, food.getMaterial());
				pstmt.setString(15, food.getImg());
				pstmt.setString(16, food.getAllergy());
				pstmt.executeUpdate(); // 삽입, 삭제, 수정
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)의 개수를 반환. web에서 구현할 내용. web에서 페이징 처리시
	 * 필요
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 개수
	 */
	public int foodCount(FoodPageBean bean) {
		return 0;
	}

	public List<Food> getFoods() {
		List<Food> list = new LinkedList<>();
		Connection connection = DBDriver.getInstance().getConn();
		String sql = "SELECT * FROM food";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				setFoods(food, rs);
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
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

	/**
	 * 검색 조건(key) 검색 단어(word)에 해당하는 식품 정보(Food)를 검색해서 반환.
	 * 
	 * @param bean 검색 조건과 검색 단어가 있는 객체
	 * @return 조회한 식품 목록
	 */
	public List<Food> searchAll(FoodPageBean bean) {
		List<Food> finds = new LinkedList<Food>();
		if (bean != null) {
			String key = bean.getKey();
			String word = bean.getWord();
			if (!key.equals("all") && word != null && !word.trim().equals("")) { // key null없다,
				finds = new LinkedList<Food>();
				String sql = "SELECT * FROM food WHERE " + key + " REGEXP ?";
				Connection conn = DBDriver.getInstance().getConn();
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, word);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						Food food = new Food();
						setFoods(food, rs);
						finds.add(food);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (rs != null) {
						try {
							rs.close();
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
			} else {
				finds = getFoods();
			}
		} else {
			finds = getFoods();
		}
		return finds;
	}

	/**
	 * 식품 코드에 해당하는 식품정보를 검색해서 반환.
	 * 
	 * @param code 검색할 식품 코드
	 * @return 식품 코드에 해당하는 식품 정보, 없으면 null이 리턴됨
	 */
	public Food search(int code) {

		Food food = new Food();
		String sql = "SELECT * FROM food WHERE code=?";
		Connection conn = DBDriver.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				setFoods(food, rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return food;
	}

	public List<String> containAllergy(String foodAllergy, String userAllergy) {
		String[] fa = foodAllergy.split(" ");
		String[] ua = userAllergy.split(",");
		List<String> result = new ArrayList<>();
		for (String userall : ua) {
			for (String foodall : fa) {
				if (userall.equals(foodall)) {
					result.add(foodall);
				}
			}
		}
		return result;
	}

	/**
	 * 가장 많이 검색한 Food 정보 리턴하기 web에서 구현할 내용.
	 * 
	 * @return
	 */
	public List<Food> searchBest() {
		return null;
	}

	public List<Food> searchBestIndex() {
		return null;
	}

	public static void setFoods(Food food, ResultSet rs) throws SQLException {
		food.setCode(rs.getInt(1));
		food.setName(rs.getString(2));
		food.setSupportpereat(rs.getDouble(3));
		food.setCalory(rs.getDouble(4));
		food.setCarbo(rs.getDouble(5));
		food.setProtein(rs.getDouble(6));
		food.setFat(rs.getDouble(7));
		food.setSugar(rs.getDouble(8));
		food.setNatrium(rs.getDouble(9));
		food.setChole(rs.getDouble(10));
		food.setFattyacid(rs.getDouble(11));
		food.setTransfat(rs.getDouble(12));
		food.setMaker(rs.getString(13));
		food.setMaterial(rs.getString(14));
		food.setImg(rs.getString(15));
		food.setAllergy(rs.getString(16));
	}

	public static void main(String[] args) {
		FoodDaoImpl dao = new FoodDaoImpl();
//		dao.loadData();
		System.out.println("===================================1번 코드 검색=============================");
		System.out.println(dao.search(1));
		System.out.println("===========================material로 검색=================================");
		print(dao.searchAll(new FoodPageBean("material", "감자전분", null, 0)));
		System.out.println("===========================maker로 검색=================================");
		print(dao.searchAll(new FoodPageBean("maker", "빙그레", null, 0)));
		System.out.println("===========================name으로 검색=================================");
		print(dao.searchAll(new FoodPageBean("name", "라면", null, 0)));
		System.out.println("============================================================");
		print(dao.searchAll(null));
		System.out.println("============================================================");
	}

	public static void print(List<Food> foods) {
		for (Food food : foods) {
			System.out.println(food);
		}
	}


}
