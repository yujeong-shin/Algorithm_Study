class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        while(n>0){
            temp += Integer.toString(n%3);
            n /= 3;
        }

        int temp_length = temp.length()-1;
        for (int i = 0; i < temp.length(); i++) {
            answer += Character.getNumericValue(temp.charAt(i)) * (int)Math.pow(3, temp_length);
            temp_length--;
        }
        return answer;
    }
}