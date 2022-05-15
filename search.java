class search{
	
	quadTreeNode resNode = null;
	int minRule = Integer.MAX_VALUE;
	int index = -1;
	
	void AQTsearch(quadTreeNode head, packet pkt){
		Aqtsearch(head,pkt,0);
	}
	
	void Aqtsearch(quadTreeNode head, packet pkt, int idx){
		if(head==null || idx==32)
			return;
		
		//System.out.println(idx);
		if(head.al.size()!=0){	
			for(int i=0;i<head.al.size();i++){
				if(ismatch(pkt,head.al.get(i))){
					//System.out.print(idx+" ");
					if(isinrange(pkt,head.al.get(i)))
					System.out.println("Mathched area "+head.al.get(i).sourceprefix +" "+head.al.get(i).destinationprefix+" R"+head.al.get(i).rp.ruleindex);
					System.out.println();
				}
			}	
		}
		
		int next = 1+idx;
		
		if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("00");
			Aqtsearch(head.tl00,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='1'){
			//System.out.println("01");
			Aqtsearch(head.bl01,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='1' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("10");
			Aqtsearch(head.tr10,pkt,next);
		}
		else{
			//System.out.println("11");
			Aqtsearch(head.br11,pkt,next);
		}
		
	}
	
	boolean ismatch(packet pkt, Area ar){
		String source = ar.sourceprefix;
		String destination = ar.destinationprefix;
		
		String sourcepkt = pkt.sourceipaddress;
		String destinationpkt = pkt.destinationipaddress;
		
		for(int i=0;i<source.length()-1;i++){
			if(source.charAt(i)!=sourcepkt.charAt(i))
				return false;
		}
		
		for(int i=0;i<destination.length()-1;i++){
			if(destination.charAt(i)!=destinationpkt.charAt(i))
				return false;
		}
		return true;
	}
	
	boolean isinrange(packet pkt, Area ar){
		int sourceno = pkt.sourceportnumber;
		int destinationno = pkt.destinationportnumber;
		
		return (ar.rp.sportnumber.first<=sourceno && sourceno<=ar.rp.sportnumber.second && ar.rp.dportnumber.first<=destinationno && destinationno<=ar.rp.dportnumber.second);
	}

	void AQTsearch1(quadTreeNode head, packet pkt){
		Aqtsearch1(head,pkt,0);
	}
	
	boolean Aqtsearch1(quadTreeNode head, packet pkt, int idx){
		boolean isfound = false;
		if(head==null || idx == 32)
			return false;
		
		//System.out.println(idx);
		
		boolean tl00 = false;
		boolean tr10 = false;
		boolean bl01 = false;
		boolean br11 = false;
		
		int next = 1+idx;
		
		if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("00");
			tl00 = Aqtsearch1(head.tl00,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='1'){
			//System.out.println("01");
			bl01 = Aqtsearch1(head.bl01,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='1' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("10");
			tr10 = Aqtsearch1(head.tr10,pkt,next);
		}
		else{
			//System.out.println("11");
			br11 = Aqtsearch1(head.br11,pkt,next);
		}
		
		if(tl00 || tr10 || bl01 || br11)
			return true;
		
		if(head.al.size()!=0){	
			for(int i=0;i<head.al.size();i++){
				if(ismatch(pkt,head.al.get(i))){
					//System.out.print(idx+" ");
					if(isinrange(pkt,head.al.get(i))){
					System.out.println("Mathched area "+head.al.get(i).sourceprefix +" "+head.al.get(i).destinationprefix+" R"+head.al.get(i).rp.ruleindex);
					System.out.println();
					return true;
					}
				}
			}	
		}
		
		return isfound;
	}
	
	
	void PQTsearch(quadTreeNode head, packet pkt){
		Pqtsearch(head,pkt,0);
		System.out.println("Mathched area "+resNode.al.get(index).sourceprefix +" "+resNode.al.get(index).destinationprefix+" R"+minRule);
		System.out.println();
	}
	
	// used for PQT
	void Pqtsearch(quadTreeNode head, packet pkt, int idx){
		if(head==null || idx == 32)
			return;
		
		//System.out.println(idx);
		if(head.al.size()!=0){	
			for(int i=0;i<head.al.size();i++){
				if(ismatch(pkt,head.al.get(i))){
					//System.out.print(idx+" ");
					if(isinrange(pkt,head.al.get(i))){
						if(minRule>head.al.get(i).rp.ruleindex){
							minRule = head.al.get(i).rp.ruleindex;
							index = i;
							resNode = head;
						}
					}
				}
			}	
		}
		
		int next = 1+idx;
		
		if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("00");
			Pqtsearch(head.tl00,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='0' && pkt.destinationipaddress.charAt(idx)=='1'){
			//System.out.println("01");
			Pqtsearch(head.bl01,pkt,next);
		}
		else if(pkt.sourceipaddress.charAt(idx)=='1' && pkt.destinationipaddress.charAt(idx)=='0'){
			//System.out.println("10");
			Pqtsearch(head.tr10,pkt,next);
		}
		else{
			//System.out.println("11");
			Pqtsearch(head.br11,pkt,next);
		}
	}
	
}