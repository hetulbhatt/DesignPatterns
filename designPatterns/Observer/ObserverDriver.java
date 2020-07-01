/***
What are Observable and Observers?
Check this analogy.

We have one service that changes it's 
state at every indefinite amount of time.

We are a part of a collection of clients
who need to keep track of the service's
state as precisely as possible.

The service is Observable, and
the clients are observers.

Why such names?
Service can be observed
thus called Observable.
Clients, once they register themselves
for notifications, become observers.


Thus, one to Many relationship 
of change notification is 
called the Observer Design Pattern.
***/

import java.util.ArrayList;

interface IObservable{
	public void add (IObserver o);
	public void remove (IObserver o);
	public void notifyEveryone();
}

interface IObserver{
	public void update();
}

class WeatherStation implements IObservable{
	ArrayList<IObserver> observers;
	int temperature;

	public WeatherStation(){
		this.observers = new ArrayList<IObserver>();
	}

	public void add(IObserver o){
		this.observers.add(o);
	}

	public void remove(IObserver o){
		this.observers.remove(o);
	}

	public void notifyEveryone(){
		for (int i=0; i<observers.size(); i++){
			observers.get(i).update();
		}
	}

	public int getTemperature(){
		return this.temperature;
	}
}

class Phone implements IObserver{
	WeatherStation station;

	public Phone(WeatherStation station){
		this.station = station;
		station.add(this);
	}

	public void update(){
		System.out.println("Phone's display shows temperature: "+this.station.getTemperature());
	}
}

class WashingMachine implements IObserver{
	WeatherStation station;

	public WashingMachine(WeatherStation station){
		this.station = station;
		station.add(this);
	}

	public void update(){
		System.out.println("WashingMachine's display shows temperature: "+this.station.getTemperature());
	}
}

class ObserverDriver{
	public static void main(String[] args) {
		WeatherStation station = new WeatherStation();
		Phone phone = new Phone(station);
		WashingMachine washer = new WashingMachine(station);

		station.notifyEveryone();
	}
}