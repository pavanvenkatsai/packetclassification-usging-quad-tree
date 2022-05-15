class traversequadTree{
	void traverse(quadTreeNode head){
		printtree(head,0);
	} 
	void printtree(quadTreeNode head, int idx){
		if(head.al.size()!=0){
			System.out.print("level --"+idx+" ");
			for(int i=0;i<head.al.size();i++){
				
				System.out.print(head.al.get(i).sourceprefix+" "+head.al.get(i).destinationprefix+" ,");
			}
			System.out.println();
		}
		if(head.tl00!=null){
			//System.out.println("tl00");
			printtree(head.tl00,1+idx);
			//System.out.println("back");
		}
		if(head.tr10!=null){
			//System.out.println("tr10");
			printtree(head.tr10,1+idx);
			//System.out.println("back");
		}
		if(head.bl01!=null){
			//System.out.println("bl01");
			printtree(head.bl01,1+idx);
			//System.out.println("back");
		}
		if(head.br11!=null){
			//System.out.println("br11");
			printtree(head.br11,1+idx);
			//System.out.println("back");
		}
	}
}