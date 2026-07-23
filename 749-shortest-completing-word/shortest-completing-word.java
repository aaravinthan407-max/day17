class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
         licensePlate = licensePlate.replaceAll("[0-9\s]", "").toLowerCase();
         int[] chars = new int[26];   //To save the frequency of all letters in licensePlate
         ArrayList<String> list = new ArrayList<>();  // To save all words that satisfy requirement

         for (char c: licensePlate.toCharArray()) { //saving frequency of all letters in licensePlate
             chars[c - 'a']++;
         }

         for (String word: words) {
             int[] dummy = new int[26];
             boolean found = true;         
             for (char c: word.toCharArray()) { 
                 dummy[c - 'a']++;
             }

             
             for (int i = 0; i < chars.length; i++) {
                 if (dummy[i] < chars[i]) {
                     found = false;    
                     break;
                 }
             }

             
             if (found) { 
                 list.add(word);
             }
         }

         int min = Integer.MAX_VALUE; int pos = 0;  
         for (int i = 0; i < list.size(); i++) {
             if (list.get(i).length() < min) {
                 pos = i;
                 min = list.get(i).length();
             }
         }
         return list.get(pos);
    }
}