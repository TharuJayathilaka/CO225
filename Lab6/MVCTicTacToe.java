public class MVCTicTacToe{
	
	public static void main(String[]args){
		
		// making objects from other three classes
		TicTacToeModel model = new TicTacToeModel();
        TicTacToeView view = new TicTacToeView(model);
        TicTacToeController controller = new TicTacToeController(model, view);
		//view.setVisible(true);
		
		// we have to call this method to run the game
	    controller.runTheGame();
	
	}

}