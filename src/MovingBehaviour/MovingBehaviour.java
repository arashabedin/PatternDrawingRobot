package MovingBehaviour;

import lejos.robotics.RegulatedMotor;

public abstract class MovingBehaviour {
	protected RegulatedMotor leftMotor;
	protected RegulatedMotor rightMotor;
	
	abstract public boolean checkCondition();
	abstract public void action();
	
	
	
}
