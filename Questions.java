

public class Questions {
	
	public static String[][] init_Questions() {
		String[][] life = new String[8][20];
		//kid life
		life[0][0] = "You are a young and happy toddler. One day, at day care, you see a nice toy that another kid is playing with. Do you...";
		life[0][1] = "Your mom is trying to sell the house and sends you to your room for a nap. Do you...";
		life[0][2] = "Your grandma asks if you want a new nightlight or a new teddy bear for your birthday. You ask for...";
		life[0][3] = "Your mom is forcing you to eat vegetables. Do you...";
		life[1][1] = "You make a new friend by sharing the toy. Do you..";
		life[1][2] = "The buyer thinks you're cute and buys the house. Does your family move to...";
		life[1][3] = "Your dad is cooking something on the stove. Do you...";
		life[2][2] = "Your parents are throwing you a birthday party. Do you have it at...";
		life[2][3] = "Your mom wants you to get more involved in your new home. Do you sign up for...";
		life[3][2] = "During the first day of kindergarten, you have to pick a hobby. Do you choose...";
		life[3][3] = "Your mom wants you to get more involved in your new home. Do you sign up for...";
		life[5][3] = "Everyone loves the arcade. You make a lot of new friends. Do you...";
		life[6][3] = "Your art teacher offers to teach you extra classes on the weekends. Do you...";
		life[7][3] = "Your music teacher offers to teach you extra classes on the weekends. Do you...";
		//high school life
		life[0][4] = "First day of High School! Do you wear...";
		life[0][5] = "The students love your cool shirt. They ask if you wanna go to the football game later tonight. Do you...";
		life[1][5] = "The teachers love your more formal attire.\nThey offer you to help them grade papers after school for volunteer hours. Do you...";
		life[0][6] = "Your parents are proud of you for making friends. They get you a car. Do you...";
		life[1][6] = "Your parents are nervous that you're not making enough friends.\nThey make you sign up for a new club. Do you join...";
		life[2][6] = "You decide to run for Student Council. Do you run for...";
		life[0][7] = "In retalitation, your younger sibling tells your crush that you like them. Do you...";
		life[1][7] = "Your younger sibling is very grateful and tells your parents how awesome you are.\nThey reward you with a gift of your choice. Do you choose...";
		life[2][7] = "You find a new \"friend\" ;) on your debate team. Do you...?";
		life[3][7] = "You find a new \"friend\" ;) on your mock trial team. Do you...?";
		life[4][7] = "You lose the President race. Do you...";
		life[5][7] = "You're the new Vice President. However, you don't get along with the President. Do you...";
		//college life
		life[0][8] = "College decision time! Do you...";
		life[0][9] = "First day of classes, and you sleep through your alarm, waking up as class starts. Do you...";
		life[1][9] = "First day of classes, and you sleep through your alarm, waking up as class starts. Do you...";
		life[0][10] = "Your professor is impressed when you explain to them what happened,\nbut you're still embarassed. Do you...";
		life[1][10] = "Your mom calls and asks how the first day went. Do you...";
		life[2][10] = "Your mom calls and asks how the first day went. Do you...";
		life[3][10] = "Your professor is impressed when you explain to them what happened,\nbut you're still embarassed. Do you...";
		life[0][11] = "Dropping the class was a good decision, it was the hardest class at the school.\nAs a replacement, do you take...";
		life[3][11] = "Turns out your mom knows the professor and they're good friends.\nAs a reward for going anyway, your mom sends you some money for some food. Do you go to...";
		life[4][11] = "Your mom is okay with you skipping, claiming that you need to focus on your personal health\n above all else. As a result, do you...";
		life[6][11] = "Turns out dropping the class would've blocked your schedule from graduating on time.\nAfter taking the class, you decide to major in...";
		//Early adult life
		life[0][12] = "Its your final year of college. Do you...";
		life[0][13] = "At grad school, you meet that special someone. Do you...";
		life[1][13] = "At your new job, you really dislike your coworker who sit nexts to you. Do you...";
		life[0][14] = "After moving in, you decide to have a romantic date. Do you...?";
		life[1][14] = "Your classes are really hard, and are taking a lot of time. Do you...";
		life[2][14] = "Creating a bond with the coworker increases productivity, and your boss gives you a bonus.\nWith that money, do you buy...";
		life[1][15] = "Your date loves the dinner. Do you...";
		life[2][15] = "Your significant other notices your effort, and decides to propose. Do you say...";
		life[3][15] = "Your significant other understands your decision, but is still upset.\nIn order to make them happy, do you...";
		life[4][15] = "Your coworkers get jealous of your new car and start to give you the cold shoulder. Do you...";
		life[5][15] = "With your new clothes, you have some new confidence, and ask your crush on a date.\nThey say yes, and you take them to...";
		//Adult life
		life[0][16] = "You're offered a big job in a new part of the country. Do you...";
		life[0][17] = "Your new boss doesn't seem to like you. Do you...";
		life[1][17] = "Your boss loves your commitment to the company, and gives you a promotion. To celebrate, do you...";
		life[0][18] = "Turns out there's a lot of dirt on your boss, and the company is glad he's gone.\nYour new boss wants to go out for a drink and leave work early . Do you...";
		life[2][18] = "You decide it's time for a pet. Do you choose...";
		life[0][19] = "Throughout the night, your boss keeps talking about taking the CEO's job. Do you...";
		life[4][19] = "Your parents decide they can't live on their own anymore. Do you...";
		life[5][19] = "Your parents decide they can't live on their own anymore. Do you...";
		return life;
	}
	public static String[]printOptions(int row, int column){
		String[] option = new String[2];
		if(row==0&&column==0) {
			option[0] = "Take the toy?";
			option[1] = "Ask to play with the kid?";
		}
		else if(row==0&&column==1){
			option[0] = "Sleep peacefully?";
			option[1] = "Cry and whine and make your\nmom carry you while she sells it?";	
		}
		else if(row==1&&column==1){
			option[0] = "Have your mom invite them over for a playdate?";
			option[1] = "Have them just be your friend at daycare?";	
		}
		else if(row==0&&column==2){
			option[0] = "A nightlight?";
			option[1] = "A teddy bear?";	
		}
		else if(row==1&&column==2){
			option[0] = "The city?";
			option[1] = "The country?";	
		}
		else if(row==2&&column==2){
			option[0] = "The amusement park?";
			option[1] = "The arcade?";	
		}
		else if(row==3&&column==2){
			option[0] = "Music?";
			option[1] = "Art?";	
		}
		else if(row==0&&column==3){
			option[0] = "Listen to her and eat the vegetables?";
			option[1] = "Throw a fit and demand cookies?";	
		}
		else if(row==1&&column==3){
			option[0] = "Ask to help?";
			option[1] = "Go watch cartoons?";	
		}
		else if(row==2&&column==3){
			option[0] = "Baseball?";
			option[1] = "Soccer?";	
		}
		else if(row==3&&column==3){
			option[0] = "Soccer?";
			option[1] = "Baseball?";	
		}
		else if(row==5&&column==3){
			option[0] = "Make yourself the leader\nof one group and stick with them?";
			option[1] = "Allow yourself to float\nbetween different groups?";	
		}
		else if(row==6&&column==3){
			option[0] = "Take the extra lessons?";
			option[1] = "Decide you're too cool for art lessons?";	
		}
		else if(row==7&&column==3){
			option[0] = "Decide you're too cool for music lessons?";
			option[1] = "Take the extra lessons?";	
		}
		//high school life
		else if(row==0&&column==4){
			option[0] = "Your favorite cool shirt?";
			option[1] = "A nicer looking outfit?";	
		}
		else if(row==0&&column==5){
			option[0] = "Go to the football game and do homework later?";
			option[1] = "Do your homework and skip the football game?";
		}
		else if(row==1&&column==5){
			option[0] = "Grade the papers?";
			option[1] = "Play golf with your friends?";
		}
		else if(row==0&&column==6){
			option[0] = "Refuse to drive your younger sibling?";
			option[1] = "Willingly become their chauffeur?";
		}
		else if(row==1&&column==6){
			option[0] = "Debate Team?";
			option[1] = "Mock Trial?";
		}
		else if(row==2&&column==6){
			option[0] = "President?";
			option[1] = "Vice President?";
		}
		else if(row==0&&column==7){
			option[0] = "Tell your crush the truth?";
			option[1] = "Deny what your sibling said?";
		}
		else if(row==1&&column==7){
			option[0] = "A new phone?";
			option[1] = "A computer?";
		}
		else if(row==2&&column==7){
			option[0] = "Keep them as a friend?";
			option[1] = "Ask them to the movies?";
		}
		else if(row==3&&column==7){
			option[0] = "Ask them to the movies?";
			option[1] = "Keep them as a friend?";
		}
		else if(row==4&&column==7){
			option[0] = "Spread rumors about the new President in your anger?";
			option[1] = "Forget about it and don't think about running again?";
		}
		else if(row==5&&column==7){
			option[0] = "Put your differences aside and work with them?";
			option[1] = "Team up with the rest of the\ncouncil to undermine the President?";
		}
		//college life
		else if(row==0&&column==8){
			option[0] = "Go to a big state school close to home?";
			option[1] = "Go to a small private school further from home?";
		}
		else if(row==0&&column==9){
			option[0] = "Go to class halfway through?";
			option[1] = "Skip class?";
		}
		else if(row==1&&column==9){
			option[0] = "Skip class?";
			option[1] = "Go to class halfway through?";
		}
		else if(row==0&&column==10){
			option[0] = "Drop the class?";
			option[1] = "Stay in it?";
		}
		else if(row==1&&column==10){
			option[0] = "Lie and say you went?";
			option[1] = "Tell her the truth?";
		}
		else if(row==2&&column==10){
			option[0] = "Tell her the truth?";
			option[1] = "Lie and say you went?";
		}
		else if(row==3&&column==10){
			option[0] = "Stay in it?";
			option[1] = "Drop the class?";
		}
		else if(row==0&&column==11){
			option[0] = "Macroeconomics?";
			option[1] = "Intro to Computer Programming?";
		}
		else if(row==3&&column==11){
			option[0] = "Chipotle?";
			option[1] = "Panera?";
		}
		else if(row==4&&column==11){
			option[0] = "Take up yoga?";
			option[1] = "Eliminate all junk food?";
		}
		else if(row==6&&column==11){
			option[0] = "Computer Science?";
			option[1] = "Economics?";
		}
		//early adult life
		else if(row==0&&column==12) {
			option[0] = "Go to Grad School?";
			option[1] = "Take your job offer and ignore grad school?";
		}
		else if(row==0&&column==12) {
			option[0] = "Go to Grad School?";
			option[1] = "Take your job offer and ignore grad school?";
		}
		else if(row==0&&column==13) {
			option[0] = "Move in with them?";
			option[1] = "Stay in your own place?";
		}
		else if(row==1&&column==13) {
			option[0] = "Put in a lot of effort\nto create a bond?";
			option[1] = "Try to get them fired?";
		}
		else if(row==0&&column==14) {
			option[0] = "Make them a homemade meal?";
			option[1] = "Take them out to a fancy restaurant?";
		}
		else if(row==1&&column==14) {
			option[0] = "Let the relationship take priority?";
			option[1] = "Put the relationship on the back burner?";
		}
		else if(row==2&&column==14) {
			option[0] = "A new sports car?";
			option[1] = "Some nice new clothes?";
		}
		else if(row==1&&column==15) {
			option[0] = "Propose?";
			option[1] = "Wait and keep the\nrelationship where it is?";
		}
		else if(row==2&&column==15) {
			option[0] = "Yes?";
			option[1] = "No?";
		}
		else if(row==3&&column==15) {
			option[0] = "Buy them a nice present?";
			option[1] = "Take them on a relaxing spa day?";
		}
		else if(row==4&&column==15) {
			option[0] = "Try to fix it by inviting them\nover for a barbeque?";
			option[1] = "Let them be jealous since you\nknow you're better than them?";
		}
		else if(row==5&&column==15) {
			option[0] = "A fancy restaurant?";
			option[1] = "The art museum and a coffee shop?";
		}
		//Adult life
		else if(row==0&&column==16) {
			option[0] = "Move across the country and start over?";
			option[1] = "Stay at your current company\nand work your way up?";
		}
		else if(row==0&&column==17) {
			option[0] = "Try to find some dirt on\nhim to get him fired?";
			option[1] = "Keep your head down and keep working?";
		}
		else if(row==1&&column==17) {
			option[0] = "Go out to the bar with your friends?";
			option[1] = "Treat yourself to a nice island vacation?";
		}
		else if(row==0&&column==18) {
			option[0] = "Go with them?";
			option[1] = "Stay at work and finish your project?";
		}
		else if(row==2&&column==18) {
			option[0] = "A black lab?";
			option[1] = "A turtle?";
		}
		else if(row==0&&column==19) {
			option[0] = "Tell your boss that he\nshouldn't do that?";
			option[1] = "Agree to help him take down the CEO?";
		}
		else if(row==4&&column==19) {
			option[0] = "Move them to a retirement home?";
			option[1] = "Invite them to come live with you?";
		}
		else if(row==5&&column==19) {
			option[0] = "Invite them to live with you?";
			option[1] = "Move them to a retirement home.";
		}
		//Testing:
		//System.out.println(option[0]);
		//System.out.println(option[1]);
		return option;
		
	}
	
	public static String printQuestion(String[][] life, int row, int column) {
		//Testing:
		//System.out.println(life[row][column]);
		if (column < 20)
			return life[row][column];
		else
			return life[row][column-1];
	}
	/* Testing:
	public static void main(String[] args) {
		String[][] life = init_Questions();
		printQuestion(life, 1,1);
		printOptions(1,1);
	}
	*/
}