class validation{
	
	public boolean prefixvalidation(String str){
		if(str.length()>32)
			return false;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)!='1' && str.charAt(i)!='0')
				return false;
		}
		
		return true;
	}
	
	public boolean portvalidation(int pn){
		if(pn<0 || pn>65535)
			return false;
		return true;
	}
	
	public boolean packetvalidation(String sip, String dip, int spn, int dpn){
		
		/*
		Well-known ports. The well known ports are those from 0 - 1,023. ...
		Registered ports. The registered ports are those from 1,024 - 49,151. ...
		Dynamic and/or private ports. The dynamic and/or private ports are those from 49,152 - 65,535.
		*/
		if(sip.length()!=32 || dip.length()!=32 || spn<0 || spn>65535 || dpn<0 || dpn>65535 ){
			//System.out.println("length fault");
			return false;
		}
		
		else{
			for(int i=0;i<32;i++){
				if((sip.charAt(i)!='1' && sip.charAt(i)!='0') || (dip.charAt(i)!='1' && dip.charAt(i)!='0'))
					return false;
			}
		}
		return true;
	}
	
}
