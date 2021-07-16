import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.WindowEvent;

class TicTacToeView extends JFrame {

    //to display 3x3 matrix of buttons
    GridLayout grid = new GridLayout(3, 3);
    JButton[] button;
    TicTacToeModel model;
    boolean endPoint=false;//by this we can get to know whether the game has overed or not
	private int dialogResult=0;
	boolean win=false;;

    public TicTacToeView(TicTacToeModel model) {
		
		//add title to the grid
        super("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(getContentPane());
        pack();
		// make visible to the user
        setVisible(true);
        this.model = model;
        endPoint = false;
    }

    public void addComponentsToPane(final Container pane) {
        final JPanel window = new JPanel();
        window.setLayout(grid);        
        window.setPreferredSize(new Dimension(300, 300));

        //we define 9 buttons to make 3x3 matrix 
        button = new JButton[9];

        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button[i].getPreferredSize();
			//add buttons to the grid
            window.add(button[i]);
        }

        pane.add(window);
    }
	
	public boolean checkWin() {
		
		//boolean win;
		
		// there only 8 patterens that player can use to win
		if((button[0].getText()==button[1].getText()) && (button[1].getText()==button[2].getText()) && button[1].getText()!=""){
			win=true;
		}else if((button[3].getText()==button[4].getText()) && (button[4].getText()==button[5].getText()) && button[3].getText()!=""){
			win=true;
		}else if((button[6].getText()==button[7].getText()) && (button[7].getText()==button[8].getText()) && button[6].getText()!=""){
			win=true;
		}else if((button[0].getText()==button[3].getText()) && (button[3].getText()==button[6].getText()) && button[0].getText()!=""){
			win=true;
		}else if((button[1].getText()==button[4].getText()) && (button[4].getText()==button[7].getText()) && button[1].getText()!=""){
			win=true;
		}else if((button[2].getText()==button[5].getText()) && (button[5].getText()==button[8].getText()) && button[2].getText()!=""){
			win=true;
		}else if((button[0].getText()==button[4].getText()) && (button[4].getText()==button[8].getText()) && button[0].getText()!=""){
			win=true;
		}else if((button[2].getText()==button[4].getText()) && (button[4].getText()==button[6].getText()) && button[2].getText()!=""){
			win=true;
		}else{
			win=false;
		}
		//System.out.println(win);
		return win;
		
	}
	
	// this method is used for ending the game
	public void stateIncresement() { 
        if (model.no_of_tries == 9 || checkWin() == true){
           endPoint = true;
		}
    }
    
	// when the game is over all the buttons are locked
    public void endGame() {
        for (int i = 0; i < 9; i++){
            button[i].setEnabled(false);
		}
    }
	
	//reset the game haven't implemented properly
	public void reset(){
		model.no_of_tries=0;
		endPoint = false;
		win=false;
		//System.out.println(win);
		//MVCTicTacToe.run = true;
		for(int i=0;i<9;i++){
			button[i].setText("");
			button[i].setEnabled(true);
		}
		//model.no_of_tries=0;
	}
	
	// Give the results
	public void giveResult(){
		//System.out.println(checkWin());
		//if one player has won, tell tha no of the player who has won.
		if(checkWin() == true){
		    JOptionPane.showMessageDialog(null,"Player "+model.icon+" has won!");
			System.exit(0);
		}
		//If there is not a winner tell that also
		else if(checkWin() == false){
		    JOptionPane.showMessageDialog(null,"Ooops! It's a draw...");
			System.exit(0);
		}
	}
	
}