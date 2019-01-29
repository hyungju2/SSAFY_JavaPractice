package workshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SafeFood {
	public static void main(String[] args) throws Exception {
		int T=1;
		List<Food> list = new ArrayList<>();
		List<FoodNutrition> list2 = new ArrayList<>();
		FoodMethod f = new FoodMethod();
		FoodNutritionMethod fn = new FoodNutritionMethod();
	
		
		Scanner sc = new Scanner(System.in);
		while(T!=0)
		{
			System.out.println("Safe Food System");
			System.out.println("1. 전체 상품 보기");
			System.out.println("2. 상품 검색");
			System.out.println("0. 종료");
			
			T = sc.nextInt();
			if(T==1)
			{	list = f.search();
			
				for(Food fo : list)
				{
					System.out.println(fo);
				}
			}
			else if(T==2)
			{
				System.out.println("상품이름을 입력하세요.");
				String title = sc.next();
				list = f.search();
				
				for(Food fo : list)
				{
					if(fo.getName().equals(title))
						System.out.println(fo);
				}
				System.out.println("=====영양 성분입니다=====");
				list2 = fn.search();
				for(FoodNutrition fu: list2)
				{
					if(fu.getDESC_KOR().equals(title))
						System.out.println(fu);
				}
				
			}
		}
	}
}
