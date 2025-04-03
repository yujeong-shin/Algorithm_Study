from collections import defaultdict
import heapq

def solution(genres, plays):
    answer = []
    d = defaultdict(list)
    for i in range(len(genres)):
        d[genres[i]].append([i, plays[i]])
    
    for genre in d.keys():
        d[genre].sort(key= lambda x : -x[1])
    #print(d)
    
    min_heap = []
    for genre in d.keys():
        total_count = 0
        for idx, count in d[genre]:
            total_count += count
        heapq.heappush(min_heap, [-total_count, genre])
    #print(min_heap)
    
    while min_heap:
        total_count, genre = heapq.heappop(min_heap)
        total_count = -total_count
        if len(d[genre]) == 1:
            answer.append(d[genre][0][0])
        else:
            count1, count2 = d[genre][0][1], d[genre][1][1]
            index1, index2 = d[genre][0][0], d[genre][1][0]
            # 상위 2개가 재생 횟수가 같다면, 고유 번호가 낮은 노래를 먼저 수록
            if count1 == count2:
                if index1 < index2:
                    answer.append(index1)
                    answer.append(index2)
                else:
                    answer.append(index2)
                    answer.append(index1)
            else:
                    answer.append(index1)
                    answer.append(index2)  
    return answer