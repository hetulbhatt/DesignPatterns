class Singleton{

	private static Singleton single;

	private Singleton(){}

	public static Singleton getInstance(){
		if (single == null){
			single = new Singleton();
		}
		return single;
	}

}

public class SingletonDriver{
	public static void main(String[] args) {
		Singleton first = Singleton.getInstance();
		Singleton second = Singleton.getInstance();

		System.out.println(first+"	"+second);
	}
}