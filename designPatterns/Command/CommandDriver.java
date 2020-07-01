import java.util.ArrayList;

class RemoteControl{
	ICommand command;

	RemoteControl(){
	}

	public void setCommand(ICommand command){
		this.command = command;
	}

	void executeCommand(){
		command.execute();
	}
}

interface ICommand{
	public void execute();
}


class Light{
	public void on(){
		System.out.println("Light on");
	}

	public void off(){
		System.out.println("Light off");
	}
}

class LightOnCommand implements ICommand{
	Light light;

	public LightOnCommand(Light light){
		this.light = light;
	}

	public void execute(){
		this.light.on();
	}
}

class LightOffCommand implements ICommand{
	Light light;

	public LightOffCommand(Light light){
		this.light = light;
	}

	public void execute(){
		this.light.off();
	}
}

public class CommandDriver{
	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		Light light = new Light();

		remote.setCommand(new LightOnCommand(light));
		remote.executeCommand();

		remote.setCommand(new LightOffCommand(light));
		remote.executeCommand();
	}
}