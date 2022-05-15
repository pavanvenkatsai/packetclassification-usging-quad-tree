import java.util.*;
import java.io.*;
class inputfromdataset{
			StringBuilder ipprefix = new StringBuilder();
			String sipPrefix;
			String dipPrefix;
			int spnf;
			int spnl;
			int dpnf;
			int dpnl;
			classifier classifier1;
	inputfromdataset(){
		
		classifier1 = new classifier(752);
		
		File file = new File("acl1.txt");
		int count = 0;
		try{
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				String Rule = sc.nextLine();
				printrule(Rule,count);
				count++;
			}
		}
		catch(Exception e){
			System.out.println("file not found");
		}
		
		
	}
	
	public void printrule(String Rule,int count){
		
		int spacecount = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<Rule.length();i++){
			if(Rule.charAt(i)=='.'){
				constructipprefix(sb);
				sb = new StringBuilder();
			}
			else if(Rule.charAt(i)=='/'){
				constructipprefix(sb);
				sb = new StringBuilder();
				if(Rule.charAt(i+2)==' '){
					displayprefix(Rule.substring(i+1,i+2));
					i++;
				}
				else{
					displayprefix(Rule.substring(i+1,i+3));
					i++;
					i++;
				}
			}
			else if(Rule.charAt(i)==' '){

				if(spacecount == 3 ||spacecount == 4 ||spacecount == 5 || spacecount == 7){
					if(spacecount == 3){
						spnf = Integer.parseInt(sb.toString());
					}
					if(spacecount == 4){
						spnl = Integer.parseInt(sb.toString());
					}
					if(spacecount == 5){
						dpnf = Integer.parseInt(sb.toString());
					}
					if(spacecount == 7){
						dpnl = Integer.parseInt(sb.toString());
					}
					
					System.out.println(Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
				}
				
				spacecount++;
				if(spacecount==8){
					classifier1.rulesArray[count]= new rule(sipPrefix,dipPrefix,spnf,spnl,dpnf,dpnl);
					sipPrefix=null;
					break;
				}
					
			}
			else if(Rule.charAt(i)!=':'){
				sb.append(Character.toString(Rule.charAt(i)));
			}
			
		}
		//System.out.println(Integer.parseInt(sb.toString()));
	}
	
	public void constructipprefix(StringBuilder sb){
		int val = Integer.parseInt(sb.toString());
		StringBuilder temp = new StringBuilder();
		while (val > 0) {
            // storing remainder in binary array
			temp.insert(0,Integer.toString(val % 2));
            val = val / 2;
        }
		int count = temp.length();
		for(int i=0;i<8-count;i++){
			ipprefix.append("0");
		}
		ipprefix.append(temp.toString());
	}
	
	public void displayprefix(String str){
		StringBuilder prefix = new StringBuilder();
		int count = Integer.parseInt(str);
		for(int i=0;i<count;i++){
			System.out.print(ipprefix.toString().charAt(i));
			prefix.append(ipprefix.toString().charAt(i));
		}
		prefix.append("*");
		if(sipPrefix==null){
			sipPrefix=prefix.toString();
		}
		else{
			dipPrefix=prefix.toString();
		}
		System.out.println("*");
		ipprefix = new StringBuilder();
	}
}