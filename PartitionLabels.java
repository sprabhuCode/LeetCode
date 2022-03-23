You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
 
Implementation : 
Store the last occuring index of every charachter in an array. keep variable max to track the maximum ocuurence of an index in the uptil i'th index.
keep trak of prev to check the last formed subarray which can be divided into chunks
  
  
  public List<Integer> partitionLabels(String s) {
        
		 
		 int[] lastIndex = new int[26];
		 
		 for(int i=0;i<s.length();i++) {
			 lastIndex[s.charAt(i)-'a'] = i;
		 }
		 
		 List<Integer> result = new ArrayList<Integer>();
		 int max = 0;
		 int prev = -1;
		 
		 for(int i=0;i<s.length();i++) {
			 max = Math.max(max, lastIndex[s.charAt(i)-'a']);
			 if(i==max) {
				 result.add(max-prev);
				 prev = max;
				 max = i;
			 }
		 }
		 
	 return result;
        
    }
