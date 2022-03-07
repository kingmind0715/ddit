package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06_WildCardTest {
	public static void main(String[] args) {
		
		FruitBox<Fruit> fruitBox = 
				new FruitBox<>();
		FruitBox<Apple> appleBox =
				new FruitBox<>();
		
		FruitBox<?> fb = new FruitBox<Apple>();
		fb = new FruitBox<Fruit>();
		
		
		//garbageBox.add(new Garbage());
		//garbageBox.add(new Garbage());
		
		//Juicer.makeJuice(garbageBox);
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
	}
}

class Juicer {
	
	//static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<?> box) {
		
		String fruitListStr = "";
		
		int cnt = 0;
		for(Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			}else {
				fruitListStr += "," + f;
			}
			
			cnt++;
		}
		
		System.out.println(fruitListStr + "=> 쥬스완성!");
	}
}



class Fruit {
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {

	public Grape() {
		super("포도");
	}
}

class Garbage {
	
	@Override
	public String toString() {
		return "쓰레기";
	}
}

// 과일 상자
class FruitBox<T extends Fruit> {
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
	
}




