package serial;

import java.util.ArrayList;
import java.util.Random;

public class DriverSerial {
	static int STRING_SIZE = 1000000;
	private static final Random RAND = new Random(42);
	private static final int bound = 4;
	
	public static void main(String[ ]args) {
		String input = RANDOMIZE(STRING_SIZE);
		

        long ta = System.currentTimeMillis();
		ArrayList<Integer> SA = SuffixArrayS.buildSuffixArray(input);
        long tb = System.currentTimeMillis();
        long finalTimeSA = (tb-ta);
        
        ta = System.currentTimeMillis();
		ArrayList<Integer> lcp = LCP.buildLCP(input, SA);
        tb = System.currentTimeMillis();
        long finalTimeLCP = (tb-ta);

        System.out.println("NUMBER OF CHARACTERS: "+STRING_SIZE);
        System.out.println("SUFFIX ARRAY: "+finalTimeSA+" MS");
        System.out.println("LCP: "+finalTimeLCP+" MS");
        System.out.println("TOTAL TIME: "+(finalTimeLCP+finalTimeSA)+" MS");
        
	}
	
	public static String RANDOMIZE(int n) {
		String out = "";
		
		for(int i=0; i<STRING_SIZE; i++) {
			int j = RAND.nextInt(bound) ;
			switch(j%4) {
			case 0:
				out+="A";
				break;
			case 1:
				out+="C";
				break;
			case 2:
				out+="T";
				break;
			case 3:
				out+="G";
				break;
			}
			
		}
		
		out += "$";
		
		return out;
	}
	
}
