interface Sweet{
	public int cost();
}

class Rasgulla implements Sweet{
	int price;

	public Rasgulla(){
		this.price = 15;
	}

	public int cost(){
		return this.price;
	}
}

class Gulabjambu implements Sweet{
	int price;

	public Gulabjambu(){
		this.price = 10;
	}

	public int cost(){
		return this.price;
	}

}

interface AddOn extends Sweet{
	public int cost();
}

class ChandiVarakh implements AddOn{
	Sweet inside;
	int cost;

	public ChandiVarakh(Sweet inside){
		this.cost = 25;
		this.inside = inside;
	}

	public int cost(){
		return this.cost + inside.cost();
	}
}

class Almonds implements AddOn{
	Sweet inside;
	int cost;

	public Almonds(Sweet inside){
		this.cost = 20;
		this.inside = inside;
	}

	public int cost(){
		return this.cost + inside.cost();
	}
}

public class DecoratorDriver{
	public static void main(String[] args) {
		Gulabjambu gb1 = new Gulabjambu();
		ChandiVarakh layer1 = new ChandiVarakh(gb1);
		Almonds layer2 = new Almonds(layer1);

		System.out.println("Final cost: "+layer2.cost());
	}
}