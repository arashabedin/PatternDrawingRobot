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
	Pattern2 pattern2;


	private EV3ColorSensor colorSensorLeft;
	private EV3ColorSensor colorSensorRight;
	private int pattern = 0;

	public BehaviourPatterns(RegulatedMotor left, RegulatedMotor right, EV3ColorSensor colorSensorLeft, EV3ColorSensor colorSensorRight) {
		//this.leftMotor = left; this.rightMotor = right;
		pattern1 = new Pattern1(left,right );
		pattern2 = new Pattern2(left,right );

		this.colorSensorLeft = colorSensorLeft;
		this.colorSensorRight = colorSensorRight;
	}
	
	
	
	

	public boolean takeControl() {
	
		if(colorSensorLeft.getColorID() == Colors.redColor || colorSensorRight.getColorID() == Colors.redColor) {
			setPattern(1);
			return true;
		}
		if(colorSensorLeft.getColorID() == Colors.yellowColor || colorSensorRight.getColorID() == Colors.yellowColor) {
			setPattern(2);
			return true;
		}
		if(getPattern() != 0) {
			return true;
		}
		return false;
	}

	private boolean suppressed = false;
	public void action() {
		   suppressed = true;

		switch (getPattern()) {
		case 1: pattern1.drawPattern();	
		break;
		case 2: pattern2.drawPattern();
		
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