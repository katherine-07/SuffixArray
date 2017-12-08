package serial;

import java.util.ArrayList;
import java.util.Arrays;

import reader.TextReader;

public class SuffixArrayS {
	private static ArrayList<Integer> ARR = new ArrayList<Integer>();
	private static ArrayList<Integer> A = new ArrayList<Integer>();
	private static ArrayList<Integer> C = new ArrayList<Integer>();
	private static ArrayList<Integer> G = new ArrayList<Integer>();
	private static ArrayList<Integer> T = new ArrayList<Integer>();
	private static ArrayList<Integer> S = new ArrayList<Integer>();
	
	private static TextReader reader = new TextReader();
	public static final String fileName = "input.txt";
	private static String input = reader.read(fileName);

	
	public static void main(String[] args) {
		System.out.println("I" + Integer.MAX_VALUE);
		for(int i = 0; i < input.length(); i++) {
		    if(input.charAt(i)=='A' || input.charAt(i)=='a'){
		    	A.add(i);
		    }else if(input.charAt(i)=='C' || input.charAt(i)=='c') {
		    	C.add(i);
		    }else if(input.charAt(i)=='G' || input.charAt(i)=='g') {
		    	G.add(i);
		    }else if(input.charAt(i)=='T' || input.charAt(i)=='t') {
		    	T.add(i);
		    }else if(input.charAt(i)=='$') {
		    	S.add(i);
		    }
		}

		A = sort(A, 2);
		C = sort(C, 2);
		G = sort(G, 2);
		T = sort(T, 2);
		
		ARR.addAll(S);
		ARR.addAll(A);
		ARR.addAll(C);
		ARR.addAll(G);
		ARR.addAll(T);
		
		for(int i = 0; i< ARR.size(); i++) {
			System.out.println(ARR.get(i));
		}
	}
	
	public static ArrayList<Integer> sort(ArrayList<Integer> list, int splitDivisor)
    {
    	if(list.size() <= 1) {
    		return list;
    	}else {
    		ArrayList<Integer> list1 = new ArrayList<Integer> (list.subList(0, list.size()/splitDivisor));
    		ArrayList<Integer> list2 = new ArrayList<Integer> (list.subList((list.size()/splitDivisor), list.size()));
    		
    		list1 = sort(list1, splitDivisor);
    		list2 = sort(list2, splitDivisor);
    		
    		return merge(list1, list2);
    	}
    	
    }
	
	private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		ArrayList<Integer> merged = new ArrayList<Integer>();
		int i = 0, j = 0;

		while (i < list1.size() && j < list2.size()){  
			
			if (input.charAt(list1.get(i)+1) < input.charAt(list2.get(j)+1)) {
				merged.add(list1.get(i));
				i++;
			} else if (input.charAt(list1.get(i)+1) > input.charAt(list2.get(j)+1)) {
				merged.add(list2.get(j));
				j++;
			} else if (input.charAt(list1.get(i)+1) == input.charAt(list2.get(j)+1)){
				if(checkEqual(list1.get(i)+1, list2.get(j)+1) == list1.get(i)) {
					merged.add(list1.get(i));	
					i++;
				}else {
					merged.add(list2.get(j));
					j++;
				}

			}

	    }
	    
	   while (i < list1.size()){  
			merged.add(list1.get(i)) ;
			i++;
			
		}


		while (j < list2.size()){    
			merged.add(list2.get(j));
			j++;
			
    	}
	    return merged;
	}
	
	private static int checkEqual(int l1, int l2) {
		int a = l1;
		int b = l2;
		int ans = 0; 
		
		while(input.charAt(a) == input.charAt(b)) {
			a++;
			b++;
		}

		
		if(input.charAt(a) < input.charAt(b)) {
			ans = l1;
		}else {
			ans= l2;
		}
		
		return ans;
	}
	
}
