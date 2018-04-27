package MovingBehaviour;

public class StateMachine {
	MovingBehaviour[] movingBehaviours;
	
	public StateMachine(MovingBehaviour[] movingBehaviours) {
		this.movingBehaviours = movingBehaviours;
		
	}
	
	public void go() {
	
	 try {
	        while (true) {
	        
	        	for(int i = 0; i<movingBehaviours.length; i++) {
	        		
	        		if(movingBehaviours[i].takeControl()) {
	        			movingBehaviours[i].action();
	        			break;
	        		}
	        		
	        	}
	        	
	        	
	            Thread.sleep(1);
	        }
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
}
