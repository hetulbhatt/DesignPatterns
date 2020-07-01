// Rather than having methods in Duck class,
// have attributes of *able interface/s
// so that we can have easy mix and match

interface Flyable{
	public void fly();
}

interface Quackable{
	public void quack();
}

class Duck{
	Flyable f;
	Quackable q;

	Duck(Flyable f, Quackable q){
		this.f = f;
		this.q = q;
	}

	public void fly(){
		this.f.fly();
	}

	public void quack(){
		this.q.quack();
	}

	public String toString(){
		System.out.println("~~~~~~~");
		this.fly();
		this.quack();
		return "~~~~~~~";
	}
}

class JetFly implements Flyable{
	public void fly(){
		System.out.println("I fly like a jet");
	}
}

class NoFly implements Flyable{
	public void fly(){
		System.out.println("I don't fly");
	}
}

class SimpleQuack implements Quackable{
	public void quack(){
		System.out.println("I quack simply");
	}
}

class LoudQuack implements Quackable{
	public void quack(){
		System.out.println("I quack loudly");
	}
}

class StrategyDriver{
	public static void main(String[] args) {
		Duck rubberDuck = new Duck(new NoFly(), new LoudQuack());
		System.out.println(rubberDuck);
	}
}