package Behave;

import MovingBehaviour.MovingBehaviour;
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

public class BehaviourPatterns extends MovingBehaviour  {
	
	
	Pattern1 pattern1;
	Pattern2 pattern2;


	private EV3ColorSensor colorSensorLeft;
	private EV3ColorSensor colorSensorRight;
	private int pattern = 0;

	public BehaviourPatterns(RegulatedMotor left, RegulatedMotor right, EV3ColorSensor colorSensorLeft, EV3ColorSensor colorSensorRight) {
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
		else if(colorSensorLeft.getColorID() == Colors.blueColor || colorSensorRight.getColorID() == Colors.blueColor) {
			setPattern(2);
			return true;
		}
		else if(getPattern() != 0) {
			return true;
		}
		return false;
	}

	public void action() {

		switch (getPattern()) {
		case 1: pattern1.drawPattern();	
		break;
		case 2: pattern2.drawPattern();
		
		}
		
	
		
		
	


	}




	private int getPattern() {
		return pattern;
	}


	private void setPattern(int pattern) {
		this.pattern = pattern;
	}

	

	}