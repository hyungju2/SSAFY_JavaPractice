import java.util.List;

public interface ProductIMgr {
	public void add(Product s) throws ExsitException;
	public List<Product> search();
	public Product search(int pcode) throws Error;
	public void update(int pcode);
	public void delete(int pcode);
	public void save(String file) throws Exception;
	public void load(String file);
}
