class packet{
	String sourceipaddress;
	String destinationipaddress;
	int sourceportnumber;
	int destinationportnumber;
	
	packet(String sip,String dip,int spn,int dpn){
		sourceipaddress=sip;
		destinationipaddress=dip;
		sourceportnumber=spn;
		destinationportnumber=dpn;
	}
}