
class classifier{
	int sizeOfclassifier;
	rule rulesArray[];
	classifier(int size){
		sizeOfclassifier= size;
		rulesArray = new rule[size];
		//System.out.println("classifier was created!");
	}
}

class rule{
	String sipPrefix;
	String dipPrefix;
	range sportnumber;
	range dportnumber;
	rule(String sip, String dip, int sprtfst, int sprtlst, int dprtfst, int dprtlst){
		sipPrefix=sip;
		dipPrefix=dip;
		sportnumber = new range(sprtfst,sprtlst);
		dportnumber = new range(dprtfst,dprtlst);
		//System.out.println("rule was created");
	}
}

class range{
	int first;
	int second;
	range(int f, int s){
		first = f;
		second =s;
	}
}
