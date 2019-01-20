package DigitalPlaza;

import java.util.ArrayList;


public interface ProductMgr {

	public void add(Product product); //제품 추가 
	public void delete(int productnum); //제품 삭제
	public ArrayList<Product> search(); //제품 전체 검색 
	public ArrayList<Product> search(String name); //종류 검색 
	public ArrayList<Product> search(int price); //가격 검색 
	public void ProductOrder(String productName); //제품 주문 
}
