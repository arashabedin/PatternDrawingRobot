package Behave;

import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;



// Fibonacci pattern	
	public class Pattern1 {
		
		private int currentFrame = 0;
		private int currentMove = 0;
		RegulatedMotor leftMotor;
		RegulatedMotor rightMotor;
		private int a = 0;
		private int b = 1;
		int[] pattern1 = {100,300,100,300,100,300,100};
	    boolean isFinished = false;

		
		public Pattern1(RegulatedMotor leftMotor, RegulatedMotor rightMotor) {
			
			this.leftMotor = leftMotor;
			this.rightMotor = rightMotor;
		}
	
	public void drawPattern() {
		
		boolean isTurned = ((getCurrentMove()%2 == 1 || getCurrentMove() == 1)&&(pattern1[getCurrentMove()]) == getCurrentFrame());
        boolean isDrawnCurrentLine = ((getCurrentMove()%2 ==0 || getCurrentMove() == 0) && (pattern1[getCurrentMove()] * b) == getCurrentFrame());
		
        if(isDrawnCurrentLine||isTurned)
				
				 {
			
			if(b >= 34) {
				b = 1;
				a = 0;
			}
			
            setCurrentMove(getCurrentMove() + 1);
			setCurrentFrame(0);
			
			if(getCurrentMove() == pattern1.length) {
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
	
	
	private int getCurrentFrame() {
		return currentFrame;
	}


	private void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	
	private int getCurrentMove() {
		return currentMove;
	}

	private void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}
	
}
