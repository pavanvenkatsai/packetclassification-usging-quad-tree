import java.util.*;
class constructquadTree{
	
	public quadTreeNode create(classifier cl){
		
		return processRules(cl,0);
		
	}
	
	public quadTreeNode processRules(classifier cl, int idx){
		quadTreeNode Node = new quadTreeNode();
		
		ArrayList<rule> al00 = new ArrayList<rule>(); 
		ArrayList<rule> al01 = new ArrayList<rule>(); 
		ArrayList<rule> al10 = new ArrayList<rule>(); 
		ArrayList<rule> al11 = new ArrayList<rule>(); 
		
		for(int i=0;i<cl.sizeOfclassifier;i++){
			if(cl.rulesArray[i].sipPrefix.charAt(idx)=='*' || cl.rulesArray[i].dipPrefix.charAt(idx)=='*'){
				
				Node.al.add(new Area(cl.rulesArray[i].sipPrefix,cl.rulesArray[i].dipPrefix));
				
			}
			else if(cl.rulesArray[i].sipPrefix.charAt(idx)=='1' && cl.rulesArray[i].dipPrefix.charAt(idx)=='1'){ 
			
				al11.add(cl.rulesArray[i]);
				
			}
			else if(cl.rulesArray[i].sipPrefix.charAt(idx)=='1' && cl.rulesArray[i].dipPrefix.charAt(idx)=='0'){
				
				al10.add(cl.rulesArray[i]);
				
			}
			else if(cl.rulesArray[i].sipPrefix.charAt(idx)=='0' && cl.rulesArray[i].dipPrefix.charAt(idx)=='1'){
				
				al01.add(cl.rulesArray[i]);
				
			}
			else{
				
				al00.add(cl.rulesArray[i]);
				
			}
		}
		
		int next = ++idx;
		
		if(al00.size()!=0){
			
			classifier subclassifier1 = new classifier(al00.size());
			for(int i=0;i<al00.size();i++){
				subclassifier1.rulesArray[i]=al00.get(i);
			}
			
			Node.tl00=processRules(subclassifier1,next);
		}
		
		if(al01.size()!=0){
			
			classifier subclassifier2 = new classifier(al01.size());
			for(int i=0;i<al01.size();i++){
				subclassifier2.rulesArray[i]=al01.get(i);
			}
			
			Node.bl01=processRules(subclassifier2,next);
		}
		
		if(al10.size()!=0){
			
			classifier subclassifier3 = new classifier(al10.size());
			for(int i=0;i<al10.size();i++){
				subclassifier3.rulesArray[i]=al10.get(i);
			}
			
			Node.tr10=processRules(subclassifier3,next);
		}
		
		if(al11.size()!=0){
			
			classifier subclassifier4 = new classifier(al11.size());
			
			for(int i=0;i<al11.size();i++){
				subclassifier4.rulesArray[i]=al11.get(i);
			}
			
			Node.br11=processRules(subclassifier4,next);
		}
		
		return Node;
	}
	
	
	public quadTreeNode create1(classifier cl){
		ArrayList<Area> al = new ArrayList<Area>();
		
		for(int i=0;i<cl.sizeOfclassifier;i++){
			Area area = new Area(cl.rulesArray[i].sipPrefix,cl.rulesArray[i].dipPrefix);
			area.rp = new rulePointer(cl.rulesArray[i].sportnumber, cl.rulesArray[i].dportnumber, i);
			al.add(area);
		}
		
		return processRules1(al,0);
	}
	
	public quadTreeNode processRules1(ArrayList<Area> al, int idx){
		quadTreeNode Node = new quadTreeNode();
		
		ArrayList<Area> al00 = new ArrayList<Area>(); 
		ArrayList<Area> al01 = new ArrayList<Area>(); 
		ArrayList<Area> al10 = new ArrayList<Area>(); 
		ArrayList<Area> al11 = new ArrayList<Area>();
		
		for(int i=0;i<al.size();i++){
			if(al.get(i).sourceprefix.charAt(idx)=='*' || al.get(i).destinationprefix.charAt(idx)=='*'){
				Node.al.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='0' && al.get(i).destinationprefix.charAt(idx)=='0'){
				al00.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='0' && al.get(i).destinationprefix.charAt(idx)=='1'){
				al01.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='1' && al.get(i).destinationprefix.charAt(idx)=='0'){
				al10.add(al.get(i));
			}
			else{
				al11.add(al.get(i));
			}
		}
		
		int next = ++idx;
		
		if(al00.size()!=0){
			
			Node.tl00=processRules1(al00,next);
		}
		
		if(al01.size()!=0){
			
			Node.bl01=processRules1(al01,next);
		}
		
		if(al10.size()!=0){
					
			Node.tr10=processRules1(al10,next);
		}
		
		if(al11.size()!=0){
					
			Node.br11=processRules1(al11,next);
		}
		
		return Node;
	}
	
	
	
	// PQT
	public quadTreeNode create2(classifier cl){
		ArrayList<Area> al = new ArrayList<Area>();
		
		for(int i=0;i<cl.sizeOfclassifier;i++){
			Area area = new Area(cl.rulesArray[i].sipPrefix,cl.rulesArray[i].dipPrefix);
			area.rp = new rulePointer(cl.rulesArray[i].sportnumber, cl.rulesArray[i].dportnumber, i);
			al.add(area);
		}
		
		return processRules2(al,0);
	}
	
	public quadTreeNode processRules2(ArrayList<Area> al, int idx){
		
		quadTreeNode Node = new quadTreeNode();
		
		ArrayList<Area> al00 = new ArrayList<Area>(); 
		ArrayList<Area> al01 = new ArrayList<Area>(); 
		ArrayList<Area> al10 = new ArrayList<Area>(); 
		ArrayList<Area> al11 = new ArrayList<Area>();
		
		Node.al.add(al.get(0));
		if(al.size()==1)
			return Node;
		
		for(int i=1;i<al.size();i++){
			if(al.get(i).sourceprefix.charAt(idx)=='*' || al.get(i).destinationprefix.charAt(idx)=='*'){
				Node.al.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='0' && al.get(i).destinationprefix.charAt(idx)=='0'){
				al00.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='0' && al.get(i).destinationprefix.charAt(idx)=='1'){
				al01.add(al.get(i));
			}
			else if(al.get(i).sourceprefix.charAt(idx)=='1' && al.get(i).destinationprefix.charAt(idx)=='0'){
				al10.add(al.get(i));
			}
			else{
				al11.add(al.get(i));
			}
		}
		
		int next = ++idx;
		
		if(al00.size()!=0){
			
			Node.tl00=processRules2(al00,next);
		}
		
		if(al01.size()!=0){
			
			Node.bl01=processRules2(al01,next);
		}
		
		if(al10.size()!=0){
					
			Node.tr10=processRules2(al10,next);
		}
		
		if(al11.size()!=0){
					
			Node.br11=processRules2(al11,next);
		}
		
		return Node;
		
	}
	
}


