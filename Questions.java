

public class Questions {
	
	public static String[][] init_Questions() {
		String[][] life = new String[8][24];
		//kid life
		life[0][0] = "You are a young and happy toddler. One day, at day care, you see a nice toy that another kid is playing with. Do you…";
		life[0][1] = "Your mom is trying to sell the house and sends you to your room for a nap. Do you…";
		life[0][2] = "Your grandma asks if you want a new nightlight or a new teddy bear for your birthday. You ask for…";
		life[0][3] = "Your mom is forcing you to eat vegetables. Do you…";
		life[1][1] = "You make a new friend by sharing the toy. Do you…";
		life[1][2] = "The buyer thinks you're cute and buys the house. Does your family move to…";
		life[1][3] = "Your dad is cooking something on the stove. Do you…";
		life[2][2] = "Your parents are throwing you a birthday party. Do you have it at...";
		life[2][3] = "Your mom wants you to get more involved in your new home. Do you sign up for...";
		life[3][2] = "During the first day of kindergarten, you have to pick a hobby. Do you choose...";
		life[3][3] = "Your mom wants you to get more involved in your new home. Do you sign up for...";
		life[5][3] = "Everyone loves the arcade. You make a lot of new friends. Do you...";
		life[6][3] = "Your art teacher offers to teach you extra classes on the weekends. Do you...";
		life[7][3] = "Your music teacher offers to teach you extra classes on the weekends. Do you...";
		//high school life
		life[0][4] = "First day of High School! Do you wear...";
		return life;
	}
	public static String[]printOptions(int row, int column){
		String[] option = new String[2];
		if(row==0&&column==0) {
			option[0] = "Take the toy?";
			option[1] = "Ask to play with the kid?";
		}else if(row==0&&column==1){
			option[0] = "Sleep peacefully?";
			option[1] = "Cry and whine and make your mom carry you while she sells it?";	
		}else if(row==1&&column==1){
			option[0] = "Have your mom invite them over for a playdate?";
			option[1] = "Have them just be your friend at daycare?";	
		}else if(row==0&&column==2){
			option[0] = "A nightlight?";
			option[1] = "A teddy bear?";	
		}else if(row==1&&column==2){
			option[0] = "The city?";
			option[1] = "The country?";	
		}else if(row==2&&column==2){
			option[0] = "The amusement park?";
			option[1] = "The arcade?";	
		}else if(row==3&&column==2){
			option[0] = "Music?";
			option[1] = "Art?";	
		}else if(row==0&&column==3){
			option[0] = "Listen to her and eat the vegetables?";
			option[1] = "Throw a fit and demand cookies?";	
		}else if(row==1&&column==3){
			option[0] = "Ask to help?";
			option[1] = "Go watch cartoons?";	
		}else if(row==2&&column==3){
			option[0] = "Baseball?";
			option[1] = "Soccer?";	
		}else if(row==3&&column==3){
			option[0] = "Soccer?";
			option[1] = "Baseball?";	
		}else if(row==5&&column==3){
			option[0] = "Make yourself the leader of one group and stick with them?";
			option[1] = "Allow yourself to float between different groups?";	
		}else if(row==6&&column==3){
			option[0] = "Take the extra lessons?";
			option[1] = "Decide you're too cool for art lessons?";	
		}else if(row==7&&column==3){
			option[0] = "Decide you're too cool for music lessons?";
			option[1] = "Take the extra lessons?";	
		}
		else if(row==0&&column==4){
			option[0] = "Your favorite cool shirt?";
			option[1] = "A nicer looking outfit?";	
		}
		//Testing:
		//System.out.println(option[0]);
		//System.out.println(option[1]);
		return option;
		
	}
	
	public static String printQuestion(String[][] life, int row, int column) {
		//Testing:
		//System.out.println(life[row][column]);
		return life[row][column];
	}
	/* Testing:
	public static void main(String[] args) {
		String[][] life = init_Questions();
		printQuestion(life, 1,1);
		printOptions(1,1);
	}
	*/
}
