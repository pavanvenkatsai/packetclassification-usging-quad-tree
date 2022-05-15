import java.util.*;
import java.io.*;
class initializer{
	public static void main(String []args){
		
		// taking from commandprompt
		//classifierinput clinput = new classifierinput();
		// taking data from acl1
		inputfromdataset clinput= new inputfromdataset();
		
		constructquadTree cqtinstance = new constructquadTree();
		
		quadTreeNode head = cqtinstance.create1(clinput.classifier1);
		traversequadTree tqt = new traversequadTree();
		
		tqt.traverse(head);
		
		
		validation valid = new validation();
		packet pkt;
		
		File file = new File("acl1trace.txt");
		try{
			int count = 7500;
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine() && count>0){
				
				String sourceIP = sc.next();
				String destinationIP = sc.next();
				String sourceport = sc.next();
				String destinationport = sc.next();
				String care = sc.next();
				care = sc.next();
				pkt = processPacket(sourceIP,destinationIP,sourceport,destinationport);
				//System.out.println(count);
				count--;
				if(valid.packetvalidation(pkt.sourceipaddress,pkt.destinationipaddress,pkt.sourceportnumber,pkt.destinationportnumber)){
					search sech = new search();
					sech.AQTsearch1(head,pkt);
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
		}
		
		
		/*
		packetinput pktinput = new packetinput();
		search sc = new search();
		sc.AQTsearch(head,pktinput.pkt);*/
		
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