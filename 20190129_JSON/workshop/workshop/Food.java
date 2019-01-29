package workshop;

public class Food {
	private String name;
	private String cop;
	private String material;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCop() {
		return cop;
	}
	public void setCop(String cop) {
		this.cop = cop;
	}
	public String getMaterial() {
		return material;
	}
	@Override
	public String toString() {
		return "Food [name=" + name + ", cop=" + cop + ", material=" + material + "]";
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
}
