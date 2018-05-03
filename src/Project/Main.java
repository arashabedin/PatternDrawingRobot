package Project;
import lejos.robotics.RegulatedMotor;

import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import MovingBehaviour.MovingBehaviour;
import MovingBehaviour.StateMachine;
import lejos.hardware.motor.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
public class Main {
	public static int pattern = 0;
	public static int currentFrame = 0;
	public static void main(String[] args) {
		StateMachine stateMachine;
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.D);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.A);
		MovingBehaviour b1 = new BehaviourForward(leftMotor,rightMotor);
	    EV3ColorSensor colorSensorLeft = new EV3ColorSensor(SensorPort.S4);
	    EV3ColorSensor colorSensorRight = new EV3ColorSensor(SensorPort.S1);
	    MovingBehaviour b2 = new BehaviourPatterns(leftMotor,rightMotor, colorSensorLeft, colorSensorRight);
	    MovingBehaviour b3 = new BehviourAvoidLeavingPaper(leftMotor,rightMotor, colorSensorLeft, colorSensorRight);
	    MovingBehaviour[] behaviours = {b3,b2,b1};
	    stateMachine = new StateMachine(behaviours);
	    stateMachine.go();
		
		}

}