
class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++) {
            String st = Character.toString(my_string.charAt(i));
            if(!st.equals(letter)) answer+= st;
        }
        
        return answer;
    }
}