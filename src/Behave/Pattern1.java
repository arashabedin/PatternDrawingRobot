package Behave;

import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;



// Fibonacci pattern	
	public class Pattern1 extends Pattern {
		
	
		private int a = 0;
		private int b = 1;
		int[] pattern = {100,300,100,300,100,300,100};

		
		public Pattern1(RegulatedMotor leftMotor, RegulatedMotor rightMotor) {
			
			this.leftMotor = leftMotor;
			this.rightMotor = rightMotor;
		}
	
	public void drawPattern() {
		
		boolean isTurned = ((getCurrentMove()%2 == 1 || getCurrentMove() == 1)&&(pattern[getCurrentMove()]) == getCurrentFrame());
        boolean isDrawnCurrentLine = ((getCurrentMove()%2 ==0 || getCurrentMove() == 0) && (pattern[getCurrentMove()] * b) == getCurrentFrame());
		
        if(isDrawnCurrentLine||isTurned)
				
				 {
			
			if(b >= 34) {
				b = 1;
				a = 0;
			}
			
            setCurrentMove(getCurrentMove() + 1);
			setCurrentFrame(0);
			
			if(getCurrentMove() == pattern.length) {
				LCD.clear();
				int temp_a = b;
				b = b + a;
				a = temp_a;
				setCurrentFrame(0);
	            setCurrentMove(0);
			}
		}
					
		else {

		if(getCurrentMove() == 0 || getCurrentMove() %2 == 0) {
			
			leftMotor.forward();
			rightMotor.forward();
			
		}else {
			
			leftMotor.backward();
			rightMotor.forward();
		}
		
		setCurrentFrame(getCurrentFrame()+1);
		LCD.drawString(b +"", 0, 4 );
	
		}		
	}
	

}
