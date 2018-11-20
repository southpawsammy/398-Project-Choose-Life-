
public class Questions {
	
	public static String[][] init_Questions() {
		String[][] life = new String[4][4];
		life[0][0] = "This is question 0,0";
		life[0][1] = "This is question 0,1";
		life[0][2] = "This is question 0,2";
		life[0][3] = "This is question 0,3";
		life[1][1] = "This is question 1,1";
		life[1][2] = "This is question 1,2";
		life[1][3] = "This is question 1,3";
		life[2][2] = "This is question 2,2";
		life[2][3] = "This is question 2,3";
		life[3][3] = "This is question 3,3";
		return life;
	}
	public static String[]printOptions(int row, int column){
		String[] option = new String[2];
		//Do this with if(row==x && column==y) so that we can specify the answers for each question
		option[0] = "This is Option 1 for question "+row+","+column;
		option[1] = "This is Option 2 for question "+row+","+column;
		return option;
		
	}
	protected int nextQuestion;
	
	public static String printQuestion(String[][] life, int row, int column) {
		return life[row][column];
	}
}
