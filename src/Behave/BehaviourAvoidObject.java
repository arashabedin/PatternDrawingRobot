
package Behave;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
// adapted from Bagnall p. 274
public class BehaviourAvoidObject implements Behavior {
RegulatedMotor leftMotor;
RegulatedMotor rightMotor;
//InfraredAdapter irAdapter;

private EV3ColorSensor colorSensorLeft;
private EV3ColorSensor colorSensorRight;
private boolean suppressed = false;

public BehaviourAvoidObject(RegulatedMotor left, RegulatedMotor right, EV3ColorSensor colorSensorLeft, EV3ColorSensor colorSensorRight) {
this.leftMotor = left; this.rightMotor = right;
this.colorSensorLeft = colorSensorLeft;
this.colorSensorRight = colorSensorRight;
}
public boolean takeControl() {

if(colorSensorLeft.getColorID() == Colors.tableColor || colorSensorRight.getColorID() == Colors.tableColor) {
	
	return true;

}
return false;
}
public void action() {
	suppressed = false;
	if(colorSensorLeft.getColorID() == Colors.tableColor  && colorSensorRight.getColorID() ==  Colors.tableColor) {

		//leftMotor.rotate(-600,true); rightMotor.rotate(-600);
		leftMotor.backward();
		leftMotor.backward();

		return;
	}
	
	if(colorSensorLeft.getColorID() == Colors.tableColor ) {
		//LCD.drawString("left sensor  "+ colorSensorLeft.getColorID() , 0, 4);

		//leftMotor.rotate(-600,true); rightMotor.rotate(-600);
		//leftMotor.rotate(600,true); rightMotor.rotate(-600);
		leftMotor.forward();
		rightMotor.backward();
		return;

	}
	
	if(colorSensorRight.getColorID() ==  Colors.tableColor) {
		//LCD.drawString("right sensor " + colorSensorRight.getColorID(), 0, 4);

		//leftMotor.rotate(-600,true); rightMotor.rotate(-600);
		//leftMotor.rotate(-600,true); rightMotor.rotate(+600);
		
		leftMotor.backward();
		rightMotor.forward();
		return;

	}
	
	
	    

}
public void suppress() {
// The following from the book looks weird; not in accordance with the specification
//while(backing_up)
Thread.yield();
}

}