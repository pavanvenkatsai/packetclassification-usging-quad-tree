import java.util.*;
class packetinput{
	packet pkt;
	packetinput(){
		Scanner sc = new Scanner(System.in);
		String sip = sc.nextLine();
		String dip = sc.nextLine();
		int spn = sc.nextInt();
		int dpn = sc.nextInt();
		
		validation valid = new validation();
		
		boolean validResult = valid.packetvalidation(sip,dip,spn,dpn);
        
		if(validResult ==false)
				System.out.println("invalid input");
		else{
			pkt = new packet(sip,dip,spn,dpn);
			System.out.println("valid packet was passed!");
		}
	}
}
