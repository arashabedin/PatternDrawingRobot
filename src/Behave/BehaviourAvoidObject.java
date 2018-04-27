
package Behave;
import MovingBehaviour.MovingBehaviour;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;
public class BehaviourAvoidObject extends MovingBehaviour{


private EV3ColorSensor colorSensorLeft;
private EV3ColorSensor colorSensorRight;

public BehaviourAvoidObject(RegulatedMotor left, RegulatedMotor right, EV3ColorSensor colorSensorLeft, EV3ColorSensor colorSensorRight) {
this.leftMotor = left;
this.rightMotor = right;
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
	LCD.drawString("avoidObject", 0, 4 );

	if(colorSensorLeft.getColorID() == Colors.tableColor  && colorSensorRight.getColorID() ==  Colors.tableColor) {

		leftMotor.backward();
		leftMotor.backward();

		return;
	}
	
	if(colorSensorLeft.getColorID() == Colors.tableColor ) {
		
		leftMotor.forward();
		rightMotor.backward();
		return;

	}
	
	if(colorSensorRight.getColorID() ==  Colors.tableColor) {
		
		
		leftMotor.backward();
		rightMotor.forward();
		return;

	}
	
	
	    

}

}