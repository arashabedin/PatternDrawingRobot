package Behave;
import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
public class BehaviourForward implements Behavior {
RegulatedMotor leftMotor;
RegulatedMotor rightMotor;

public BehaviourForward(RegulatedMotor left, RegulatedMotor right) {
	this.leftMotor = left; this.rightMotor = right;
}

public boolean takeControl() {
	return true;
}

private boolean suppressed = false;
public void action() {
	suppressed = false;
	leftMotor.forward();
	rightMotor.forward();

	
	
while(!suppressed) Thread.yield();
	leftMotor.stop();
	rightMotor.stop();


}
public void suppress() {
	suppressed=true;
}

}
