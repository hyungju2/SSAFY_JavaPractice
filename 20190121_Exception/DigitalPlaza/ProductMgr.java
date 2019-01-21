package DigitalPlaza;

import java.util.ArrayList;


public interface ProductMgr {

	public void add(Product product) throws Exception; //제품 추가 
	public void delete(int productnum); //제품 삭제
	public ArrayList<Product> search(); //제품 전체 검색 
	public ArrayList<Product> search(int productnum) throws Exception; //가격 검색 
	public ArrayList<Product> searchTv(int size) throws Exception;
	public ArrayList<Product> searchRef(int capacity) throws Exception;
	public void open() throws Exception;
	public void close() throws Exception;
}
