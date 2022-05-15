import java.util.*;
class classifierinput{
	//public static void main(String []args){
	classifier classifier1;
	classifierinput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of rules in a classifier:");
		int size = sc.nextInt();
		
		//String caretaker = sc.nextLine();
		
		classifier1 = new classifier(size);
		for(int i=0;i<size;i++){
			//System.out.println(i+":");
			String caretaker = sc.nextLine();
			
			String sipPrefix = sc.nextLine();
			String dipPrefix = sc.nextLine();
			int spnf = sc.nextInt();
			int spnl = sc.nextInt();
			int dpnf = sc.nextInt();
			int dpnl = sc.nextInt();
			//System.out.println(" sip "+sipPrefix+" dip "+dipPrefix+" spnf "+spnf+" spnl "+spnl+" dpnf "+dpnf+" dpnl "+dpnl);
			
			validation valid = new validation();
			
			boolean validResultSip = valid.prefixvalidation(sipPrefix);
			boolean validResultdip = valid.prefixvalidation(dipPrefix);
			
			boolean validResultSpnf = valid.portvalidation(spnf);
			boolean validResultSpnl = valid.portvalidation(spnl);
			boolean validResultdpnf = valid.portvalidation(dpnf);
			boolean validResultdpnl = valid.portvalidation(dpnl);
			
			if(validResultSip && validResultdip && validResultSpnf && validResultSpnl && 
			validResultdpnf && validResultdpnl && spnf<=spnl && dpnf<=dpnl)
			classifier1.rulesArray[i]= new rule(sipPrefix,dipPrefix,spnf,spnl,dpnf,dpnl);
			
			else{
				System.out.println("enter valid input :");
				return;
			}
		}
	}
}
