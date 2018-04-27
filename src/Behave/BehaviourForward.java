package Behave;
import MovingBehaviour.MovingBehaviour;
import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
public class BehaviourForward extends MovingBehaviour {


public BehaviourForward(RegulatedMotor left, RegulatedMotor right) {
	this.leftMotor = left; this.rightMotor = right;
}

public boolean takeControl() {
	return true;
}

public void action() {
	leftMotor.forward();
	rightMotor.forward();

	



}


}
