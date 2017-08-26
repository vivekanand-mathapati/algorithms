import java.util.*;

class LargestConsecutiveCharacter{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("String: ");
		String str = in.next();
		
		getLargestConsecutiveCharacter(str);
	}
	
	static void getLargestConsecutiveCharacter(String str){
		char current_char = str.charAt(0);
		char prev_char = str.charAt(0);
		char max_char = str.charAt(0);
		int max =0, count =0;
		for(int i=0;i<str.length();i++){
			current_char = str.charAt(i);
			if(current_char == prev_char){
				count += 1;
			}else{
				count = 1;
			}
			if(count > max){
				max = count;
				max_char = current_char;
			}
			prev_char = current_char;
		}
		System.out.print(max_char);		
	}
}

