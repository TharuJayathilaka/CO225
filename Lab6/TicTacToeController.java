import java.awt.event.ActionEvent;

//this waits until user do something or press something
import java.awt.event.ActionListener;
import javax.swing.JButton;

class TicTacToeController implements ActionListener{
	 
	TicTacToeModel model;
	TicTacToeView view;
	
	public TicTacToeController(TicTacToeModel model,TicTacToeView view){
		this.model=model;// define the model object in aeasy way to access inside the class
		this.view=view;// define the view object in aeasy way to access inside the class
		addActionListeners();
	}
	
	public void addActionListeners(){
		for(int i=0;i<9;i++){
			// get the user values to the buttons
			view.button[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
        if (view.endPoint == false) {
            model.setPlayerNo();
			// get the user values to the buttons
            ((JButton) event.getSource()).setText(model.icon);
			//if one player uses a button that button can't use again
			((JButton) event.getSource()).setEnabled(false);
            model.increseNoTries();
        }
    }
	
	// run the game
	public void  runTheGame() {
		boolean run = true;
        
		//run the game
        while (run) {
			// increse the steps of the game
            view.stateIncresement();
            if (view.endPoint == true) {
                view.endGame();  //lock the all the buttons after one player win or when all the buttons have used
				view.giveResult();// give the result
				// game stop specified
                run = false;
            }
            //System.out.println(view.endPoint);
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
