package Behave;

import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;



	public class Pattern2 {
		
		private int currentFrame = 0;
		private int currentMove = 0;
		RegulatedMotor leftMotor;
		RegulatedMotor rightMotor;
		int[] pattern2 = {100,300,100,300,100,300,100};
	    boolean isFinished = false;

		
		public Pattern2(RegulatedMotor leftMotor, RegulatedMotor rightMotor) {
			
			this.leftMotor = leftMotor;
			this.rightMotor = rightMotor;
		}
	
	public void drawPattern() {
		
		boolean isTurned = ((getCurrentMove()%2 == 1 || getCurrentMove() == 1)&&(pattern2[getCurrentMove()]) == getCurrentFrame());
        boolean isDrawnCurrentLine = ((getCurrentMove()%2 ==0 || getCurrentMove() == 0) && (pattern2[getCurrentMove()]) == getCurrentFrame());
		
        if(isDrawnCurrentLine||isTurned)
				
				 {
	
            setCurrentMove(getCurrentMove() + 1);
			setCurrentFrame(0);
			
			if(getCurrentMove() == pattern2.length) {
				LCD.clear();
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
