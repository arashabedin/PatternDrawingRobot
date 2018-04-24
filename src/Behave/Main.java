package Behave;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
public class Main {
	public static int pattern = 0;
	public static int currentFrame = 0;
	public static void main(String[] args) {
		
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.D);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		Behavior b1 = new BehaviourForward(leftMotor,rightMotor);
	    EV3ColorSensor colorSensorLeft = new EV3ColorSensor(SensorPort.S4);
	    EV3ColorSensor colorSensorRight = new EV3ColorSensor(SensorPort.S1);
		Behavior b2 = new BehaviourPatterns(leftMotor,rightMotor, colorSensorLeft, colorSensorRight);
		Behavior b3 = new BehaviourAvoidObject(leftMotor,rightMotor, colorSensorLeft, colorSensorRight);
		Behavior[] b1b2 = {b1,b2,b3};
		Arbitrator arby = new Arbitrator(b1b2);
		arby.go();
		}

}