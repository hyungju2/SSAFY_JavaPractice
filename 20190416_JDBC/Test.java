import java.util.List;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = ProductDAO.getInstance(); // 외부에서 생성 못함
		Product product = new Product();
		
		product.setKind("냉장고");
		product.setMaker("삼성");
		product.setPrice(9000000);
		product.setTitle("삼성냉장고");
		
		
		int result = dao.insertProduct(product);
		System.out.println("Insert 결과 : "+ result + "개의 행이 삽입되었습니다.");
		// input
		
		product.setKind("smart");
		product.setMaker("애플");
		product.setPrice(2000000);
		product.setTitle("phone");
		product.setIsbn(1);
		result = dao.updateProduct(product);
		
	/*	List<Product> list = dao.selectAll();
		
		for(Product b : list) {
			System.out.println(b);
		}
*/		
		
		
	} //end of main
}//end of class
