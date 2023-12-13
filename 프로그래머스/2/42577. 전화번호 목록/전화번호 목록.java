import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> phone_number_list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(phone_number_list);
        for (int i = 0; i < phone_number_list.size()-1; i++) {
            //문자열의 길이가 같거나, 뒤의 문자열의 길이가 더 긴 경우만 비교 가능
            if(phone_number_list.get(i).length() <= phone_number_list.get(i+1).length()){
                String head = phone_number_list.get(i);
                String comp = phone_number_list.get(i+1).substring(0, head.length());
                if(head.equals(comp)) {
                    answer=false;
                    break;
                }
            }
        }
        return answer;
    }
}