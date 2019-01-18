public class CarMgr {
	private Car[] cars = new Car[100];
	private int index = 0;
	
public void add(Car c) {
	cars[index] = c;
	index++;
}

public Car[] search()
{
		return cars;
}

public Car search(String num)
{
	Car recar = new Car();
	for(int i=0; i<index; i++)
	{
		if(cars[i].getNum().equals(num))
		{
			recar.setModel(cars[i].getModel());
			recar.setNum(cars[i].getNum());
			recar.setPrice(cars[i].getPrice());
		}	
	}
	return recar;
}


public Car[] search(int price)
{
	Car recar[] = new Car[100]; // 객체의 주소를 저장할 100칸 생성, 각 칸에는 null
	
	int ind = 0;
	for(int i=0; i<index; i++)
	{
		if(cars[i].getPrice()<price)
		{
			
			recar[ind] = cars[i];
			
			ind++;
		}
	}
	return recar;
}

public void update(String num, int price) {
	
	for(int i=0; i<index; i++)
	
		if(cars[i].getNum().equals(num))
		{
			cars[i].setPrice(price);
			System.out.println("차량번호 :"+cars[i].getNum()+"모델명 :"+cars[i].getModel()+"수정된 가격 :"+cars[i].getPrice());
		}
	}


public void delete(String num)
{
	for(int i=0; i<index; i++)
	{
		if(cars[i].getNum().equals(num))
		{
			if(i<index-1) {
			cars[i].setModel(cars[i+1].getModel());
			cars[i].setNum(cars[i+1].getNum());
			cars[i].setPrice(cars[i+1].getPrice());
		}
		}
	}
	
	index--;
	cars[index].setModel("");
	cars[index].setNum("");
	cars[index].setPrice(0);
	
}

public int size()
{
	return index;
}

public int totalPrice()
{
	int cnt = 0;
	for(int i=0;i<index; i++)
	{
		cnt+=cars[i].getPrice();
	}
	return cnt;
}


}
