import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements ProductIMgr {
	List<Product> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	private ProductManager() {
	} // 생성자 private 1.

	private static ProductManager instance; // field는 static으로.

	public static ProductManager getInstance() {
		if (instance == null) {
			instance = new ProductManager();
		}
		return instance;
	} // 객체 생성 메소드는 public,static으로.

	public void add(Product s) throws ExsitException {
		for(Product p: list) {
		if(p.getPname().equals(s.getPname()))
			throw new ExsitException();
		}
		list.add(s);
	}

	public List<Product> search() {
		return list;
	}

	public Product search(int pcode) throws Error {
		Product temp = new Product();
		for (Product p : list) {
			if (p.getPcode() == pcode)
				return p;
		}
		throw new Error();
	} // pcode search

	public void update(int pcode) {
		int index = 0;
		System.out.println("변경하실 상품명과 가격을 입력하세요");
		String name = sc.next();
		int price = sc.nextInt();
		for (Product p : list) {
			if (p.getPcode() == pcode) {
				list.get(index).setPname(name);
				list.get(index).setPrice(price);
			}
			index++;
		}
	} // update

	public void delete(int pcode) {

		int index = 0;
		for (Product p : list) {
			if (p.getPcode() == pcode) {
				break;
			}
			index++;
		}
		list.remove(index);
	} // delete

	public void save(String file) throws Exception {
		FileOutputStream fos = new FileOutputStream("product.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (Product p : list) {
			oos.writeObject(p);
		}
		oos.close();
		fos.close();
	}

	public void load(String file) {
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			for (Product pd; (pd = (Product)ois.readObject())!= null;) {
				add(pd);
			}
		} catch (Exception e) {
		}
	}
}
