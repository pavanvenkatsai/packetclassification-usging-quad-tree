import java.util.*;
class quadTreeNode{
	ArrayList<Area> al = new ArrayList<Area>();
	quadTreeNode tl00=null;
	quadTreeNode tr10=null;
	quadTreeNode bl01=null;
	quadTreeNode br11=null;
}

class Area{
	rulePointer rp;
	String sourceprefix;
	String destinationprefix;
	Area(String sp, String dp){
		sourceprefix=sp;
		destinationprefix=dp;
	}
}

class rulePointer{
	range sportnumber;
	range dportnumber;
	int ruleindex;
	rulePointer(range spn, range dpn, int ri){
		sportnumber=spn;
		dportnumber=dpn;
		ruleindex=ri;
	}
}