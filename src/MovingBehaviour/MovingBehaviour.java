package MovingBehaviour;

import lejos.robotics.RegulatedMotor;

public abstract class MovingBehaviour {
	protected RegulatedMotor leftMotor;
	protected RegulatedMotor rightMotor;
	
	abstract public boolean takeControl();
	abstract public void action();
	
	
	
}
