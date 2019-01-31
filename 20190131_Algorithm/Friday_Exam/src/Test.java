import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
	
		
		
	Scanner sc = new Scanner(System.in);
	int T=-1;
	List<Product> list = new ArrayList<>();
	ProductManager p = ProductManager.getInstance();
	
	while(T!=0) {


	System.out.println("1. 저장");
	System.out.println("2. 리턴");
	System.out.println("3. 상품정보");
	System.out.println("4. 코드로 변경");
	System.out.println("5. 삭제");
	System.out.println("6. 저장");
	System.out.println("7. 파일에서 읽어오기");
	System.out.println("0. 종료");
	System.out.println("숫자 입력");
	T=sc.nextInt();
	
	switch(T) {
	case 1:
	{
		System.out.println("int, string, int입력");
		int num = sc.nextInt();
		String str = sc.next();
		int num2 = sc.nextInt();
		p.add(new Product(num,str,num2));
	}
	break;
	case 2:
	{
		list = p.search();
		for(Product t:list) {
			System.out.println(t.toString());
		}
	}
	break;
	case 3:
	{
		System.out.println("pcode 입력");
		int num = sc.nextInt();
		p.search(num);
	}
	break;
	case 4:
	{
		System.out.println("pcode 입력");
		int num = sc.nextInt();
		p.update(num);
	}
	break;
	case 5:
	{
		System.out.println("삭제하실 번호 입력");
		int num = sc.nextInt();
		p.delete(num);
	}
	break;
	case 6:
	{
		System.out.println("저장");
		p.save("product.dat");
	}
	break;
	case 7:
	{
		p.load("product.dat");
	}
	break;
	default:
		break;
}
	}
	}
}
