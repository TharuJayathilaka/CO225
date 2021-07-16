public class TicTacToeModel{
	public int no_of_tries=0;// to specify the which player is playing now
	public String icon="";  // Icon of the each player
	//boolean gameEnd=false;//by this we can get to know whether the game has overed or not
	
	public TicTacToeModel(){
		no_of_tries=0;
	}
	
	public void setPlayerNo(){
	 // players play one after the other, so counting the no of tries we can get to know which player is playing now
		if(no_of_tries %2!=0){
			icon = "2";
		}else if(no_of_tries %2==0){
			icon = "1";
		}		
	}
	
	public void increseNoTries(){
		//increase the no of tries.
		no_of_tries++;
	}
	

	public boolean checkWin1(String values[]) {
		boolean win;
		
		// there only 8 patterens that player can use to win
		if((values[0]==values[1]) && (values[1]==values[2]) && values[1]!=""){
			win=true;
		}else if((values[3]==values[4]) && (values[4]==values[5]) && values[3]!=""){
			win=true;
		}else if((values[6]==values[7]) && (values[7]==values[8]) && values[6]!=""){
			win=true;
		}else if((values[0]==values[3]) && (values[3]==values[6]) && values[0]!=""){
			win=true;
		}else if((values[1]==values[4]) && (values[4]==values[7]) && values[1]!=""){
			win=true;
		}else if((values[2]==values[5]) && (values[5]==values[8]) && values[2]!=""){
			win=true;
		}else if((values[0]==values[4]) && (values[4]==values[8]) && values[0]!=""){
			win=true;
		}else if((values[2]==values[4]) && (values[4]==values[6]) && values[2]!=""){
			win=true;
		}else{
			win=false;
		}
		//System.out.println(win);
		return win;
		
	}

}