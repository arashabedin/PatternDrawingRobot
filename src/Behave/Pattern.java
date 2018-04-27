package Behave;

import lejos.robotics.RegulatedMotor;

public abstract class Pattern {
	private int currentFrame = 0;
	private int currentMove = 0;
	RegulatedMotor leftMotor;
	RegulatedMotor rightMotor;
	
	public int getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}

	
	public int getCurrentMove() {
		return currentMove;
	}

	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}
	
}
