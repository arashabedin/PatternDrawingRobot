package Behave;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.MovePilot;
import lejos.robotics.subsumption.Behavior;

public class BehaviourPatterns implements Behavior {
	
	
	Pattern1 pattern1;
	

	private EV3ColorSensor colorSensorLeft;
	private EV3ColorSensor colorSensorRight;
	private int pattern = 0;

	public BehaviourPatterns(RegulatedMotor left, RegulatedMotor right, EV3ColorSensor colorSensorLeft, EV3ColorSensor colorSensorRight) {
		//this.leftMotor = left; this.rightMotor = right;
		pattern1 = new Pattern1(left,right );
		this.colorSensorLeft = colorSensorLeft;
		this.colorSensorRight = colorSensorRight;
	}
	
	
	
	

	public boolean takeControl() {
		if(getPattern() != 0) {
			return true;
		}
		if(colorSensorLeft.getColorID() == Colors.leftSensorRed || colorSensorRight.getColorID() == Colors.rightSensorRed) {
			setPattern(1);
			return true;
		}
		return false;
	}

	private boolean suppressed = false;
	public void action() {

		switch (getPattern()) {
		case 1: pattern1.drawPattern();	
		break;
		
		
		}
		
	
		
		
	while(!suppressed) Thread.yield();
	


	}
	public void suppress() {
		suppressed=true;
	}




	private int getPattern() {
		return pattern;
	}


	private void setPattern(int pattern) {
		this.pattern = pattern;
	}

	

	}