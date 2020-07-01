/***
there is a factory and products.
factory produces product.

factory -> interface
		-> implementaion class

product -> interface
		-> implementated classes
***/

abstract class Pen{
	String brand;
	double price;

	@Override
	public String toString(){
		return "Brand: "+brand+"\nPrice: "+price;
	}
}

class ButterFlow extends Pen{
	public ButterFlow(){
		super.brand = "Reynolds";
		super.price = 10;
	}
}

class Natural extends Pen{
	public Natural(){
		super.brand = "Sanio";
		super.price = 2;
	}
}

class Finegrip extends Pen{
	public Finegrip(){
		super.brand = "Cello";
		super.price = 5;
	}
}

class PenFactory{
	Pen getPen(double budget){
		if(budget>=10){
			return new ButterFlow();			
		}
		else if (budget>=5){
			return new Finegrip();
		}
		else if (budget>=2){
			return new Natural();
		}
		else{
			return null;
		}
	}
}

public class FactoryMethodDriver{
	public static void main(String[] args) {
		PenFactory factory = new PenFactory();
		Pen pen1 = factory.getPen(3);
		Pen pen2 = factory.getPen(7);
		Pen pen3 = factory.getPen(15);
		System.out.println(pen1);
		System.out.println(pen2);
		System.out.println(pen3);
	}
}