import java.util.*;
class Record{
    String id;
    String action;

    public Record(String id, String action) {
        this.id = id;
        this.action = action;
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        List<String> answers = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        Deque<Record> deque = new ArrayDeque<>();

        for (int i = 0; i < record.length ; i++) {
            String[] recordSplit = record[i].split(" ");

            //Enter
            //Map에 id 없으면 해당 id에 nickName add, deque에 출입 정보 add
            //Map에 id 있으면
            //    id에 nickName 값이 현재 입력된 값과 같으면 deque에 출입 정보 add
            //    id에 nickName 값이 현재 입력된 값과 다르면 Map Update, deque에 출입 정보 add
            // recordSplit[0] : Enter, recordSplit[1] : uid1234, recordSplit[2] : Muzi
            if(recordSplit[0].equals("Enter")) {
                if(!map.containsKey(recordSplit[1])) {
                    map.put(recordSplit[1], recordSplit[2]);
                    deque.addLast(new Record(recordSplit[1], recordSplit[0]));
                }
                else {
                    if(map.get(recordSplit[1]).equals(recordSplit[2])){
                        deque.addLast(new Record(recordSplit[1], recordSplit[0]));
                    }
                    else {
                        // 변경된 이름으로 덮어버리기
                        map.put(recordSplit[1], recordSplit[2]);
                        deque.addLast(new Record(recordSplit[1], recordSplit[0]));
                    }
                }
            }
            //Leave
            // deque에 출입 정보 add
            else if(recordSplit[0].equals("Leave")) {
                deque.addLast(new Record(recordSplit[1], recordSplit[0]));
            }
            //Change
            //Map 해당 id에 nickName 정보 Upate
            //출입한 것이 아니기 때문에 deque에 출입 정보 add할 필요 X
            //if문 없으면 indexBounds 에러발생. 예외가 있나?
            if (recordSplit.length == 3) {
                map.put(recordSplit[1], recordSplit[2]);
            }
        }

        //결과 출력
        int index=0;
        answer = new String[deque.size()];
        while(!deque.isEmpty()){
            Record rec = deque.removeFirst();
            if(rec.action.equals("Enter")){
                //"Prodo님이 들어왔습니다."
                answer[index] = map.get(rec.id) + "님이 들어왔습니다.";
            }
            else if(rec.action.equals("Leave")){
                //"Prodo님이 나갔습니다."
                answer[index] = map.get(rec.id) + "님이 나갔습니다.";
            }
            index++;
        }
       
        return answer;
    }
}