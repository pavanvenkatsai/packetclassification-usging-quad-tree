import java.util.*;
import java.io.*;
class inputpacketfromdataset{
	public static void main(String []args){
		File file = new File("acl1trace.txt");
		try{
			Scanner sc = new Scanner(file);
			int count = 5000;
			while(sc.hasNextLine() && count>0){
				
				String sourceIP = sc.next();
				String destinationIP = sc.next();
				String sourceport = sc.next();
				String destinationport = sc.next();
				String care = sc.next();
				care = sc.next();
				packet pkt = processPacket(sourceIP,destinationIP,sourceport,destinationport);
				
				//System.out.println(count);
				count--;
				/*search sech = new search();
				sech.AQTsearch(head,pkt);*/
			}
		}
		catch(Exception e){
			System.out.println("file not found");
		}
	}
	public static packet processPacket(String sip, String dip, String sport, String dport){
		String sourceIP = integertoString(Long.parseLong(sip));
		String destinationIP = integertoString(Long.parseLong(dip));
		
		int sourceport = Integer.parseInt(sport);
		int destinationport = Integer.parseInt(dport);
		
		System.out.println(sourceIP+" "+destinationIP+" "+sourceport+" "+ destinationport);
		packet pkt = new packet(sourceIP,destinationIP,sourceport,destinationport);
		return pkt;
	}
	
	public static String integertoString(long val){
		StringBuilder temp = new StringBuilder();
		while (val > 0) {
            // storing remainder in binary array
			temp.insert(0,Long.toString(val % 2));
            val = val / 2;
        }
		int count = temp.length();
		for(int i=0;i<32-count;i++){
			temp.insert(0,0);
		}
		return temp.toString();
	}
}
