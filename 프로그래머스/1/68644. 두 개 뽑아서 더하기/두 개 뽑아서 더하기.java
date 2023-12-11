import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer;
        Arrays.sort(numbers);
        
        /*
        // 1, 1, 2, 3, 4
        int count=0;
        int[] ch = new int[numbers.length*numbers.length-1];
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                if(ch[numbers[i]+numbers[j]]==0){
                    ch[numbers[i]+numbers[j]]=1;
                    count++;
                }
            }
        }
        // ch 0  1  2  3  4  5  6  7  8  9
        //    0  0  1  1  1  1  1  1  0  0
        
        answer = new int[count];
        int index=0;
        for(int sum=0; sum<ch.length; sum++) {
            if(ch[sum]==1) {
                answer[index]=sum;
                index++;
            }
        }
        */
        
        /*
        // 1, 1, 2, 3, 4
        int[] sum_numbers = new int[numbers.length*numbers.length-1];
        int index=0;
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                sum_numbers[index] = i + j;
                index++;
            }
        }
        answer = Arrays.stream(sum_numbers).distinct().toArray();
        */
        
        // 1, 1, 2, 3, 4
        int[] numbers_combi = new int[numbers.length*numbers.length-1];
        int combi_count=0;
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                numbers_combi[combi_count] = numbers[i]+numbers[j];
                combi_count++;
            }
        }
        System.out.println(Arrays.toString(numbers_combi));
        
        int[] temp = Arrays.copyOfRange(numbers_combi, 0, combi_count);
        Arrays.sort(temp);
        int[] new_temp = new int[temp.length];
        
       int index=0;
       for (int i = 0; i < temp.length; i++) {
           if(i==temp.length-1) {
               new_temp[index] = temp[i];
               index++;
               break;
           }
           if(temp[i] != temp[i+1]) {
               new_temp[index] = temp[i];
               index++;
           }
       }
       answer = Arrays.copyOfRange(new_temp, 0, index);
        
        return answer;
    }
}