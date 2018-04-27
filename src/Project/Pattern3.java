package Project;

import java.util.Random;


import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;



	public class Pattern3 extends Pattern{
		
		final int patternWidth = 200;
        int[] pattern = {1,400};
        boolean goStraight = false;		
		boolean turnLeft = false;
		public Pattern3(RegulatedMotor leftMotor, RegulatedMotor rightMotor) 
		{
			
			this.leftMotor = leftMotor;
			this.rightMotor = rightMotor;
		}
	
	public void drawPattern() {

if(goStraight) {
	
	leftMotor.forward();
	rightMotor.forward();
	setCurrentFrame(getCurrentFrame()+1);
	
	if(getCurrentFrame()>= pattern[getCurrentMove()]) {
		
		goStraight = false;
		setCurrentMove(0);
		
	}
}else {
	
	
	if(turnLeft) {
		
		leftMotor.forward();
		rightMotor.stop();
		
		setCurrentFrame(getCurrentFrame() + 1);
		if(getCurrentFrame()>=pattern[getCurrentMove()]) {
			setCurrentFrame(0);
		turnLeft = false;
		}
		
	}else {
		
		rightMotor.forward();
		leftMotor.stop();

		setCurrentFrame(getCurrentFrame() + 1);
		if(getCurrentFrame()>=pattern[getCurrentMove()]) {
			setCurrentFrame(0);
		turnLeft = true;
		}
		}
	
	Random random = new Random();
    if(random.nextInt(50) > 45){
    	goStraight= true;
    	setCurrentMove(1);
    	
    }
}

					
			
	}
	
	
	
	
}
