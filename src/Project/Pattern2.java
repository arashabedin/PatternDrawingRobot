package Project;

import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;



	public class Pattern2 extends Pattern{
		
		final int patternWidth = 200;
        int[] pattern = {250,300};
		private boolean turnedLeft = false;
		
		public Pattern2(RegulatedMotor leftMotor, RegulatedMotor rightMotor) 
		{
			
			this.leftMotor = leftMotor;
			this.rightMotor = rightMotor;
		}
	
	public void drawPattern() {

		if(getCurrentMove() == 0) {
			// LCD.drawString("rotate", 0, 4 );

			if(!turnedLeft) {
				rightMotor.forward();
				leftMotor.stop();

				
			}else {
				leftMotor.forward();
				rightMotor.stop();

			}
			setCurrentFrame(getCurrentFrame()+1);

			if(getCurrentFrame() == pattern[getCurrentMove()]) {
				
				setCurrentFrame(0);
				setCurrentMove(1);
				if(turnedLeft) {
					turnedLeft=false;
				}else {
					turnedLeft=true;
				}
			}
			
		}else {
			
			//LCD.drawString("forward", 0, 4 );

			rightMotor.forward();
			leftMotor.forward();
			setCurrentFrame(getCurrentFrame() + 1);
			if(getCurrentFrame() == pattern[getCurrentMove()]) {
				
				setCurrentFrame(0);
				setCurrentMove(0);
			
				LCD.drawString("pattern2", 0, 4 );

				
			}
			
		}

					
			
	}
	
	
	
	
}
