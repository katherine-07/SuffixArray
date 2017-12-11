package serial;

import java.util.ArrayList;

public class LCP {
	
	public static ArrayList<Integer> buildLCP(String input, ArrayList<Integer> suffixArray){
		int n = suffixArray.size();
		ArrayList<Integer> LCP = new ArrayList<Integer>();
		ArrayList<Integer> inverseSuffArr = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			inverseSuffArr.add(0);
			LCP.add(0);
		}

		for (int i=0; i < n; i++) {
			inverseSuffArr.set(suffixArray.get(i), i);
		}
		
		int len = 0;
		
		for(int i=0; i<n ; i++) {
	        if (inverseSuffArr.get(i) == n-1)
	        {
	        	len = 0;
	            continue;
	        }
	        
	        int nxt = suffixArray.get(inverseSuffArr.get(i)+1);

	        // while string still has characters to compare,
	        //if substring A's charat LEN == substringB charat LEN; add len
	        while ((i+len) < n && (nxt+len) < n && input.charAt(i+len)==input.charAt(nxt+len)){
	            len++;
	        }
	 
	        LCP.set(inverseSuffArr.get(i), len); //len would be the longest prefix for substring A & B
	 
	        // Deleting the starting character from the string.
	        if (len>0)
	            len--;
		}
		
		return LCP;
		
	}
	
}
