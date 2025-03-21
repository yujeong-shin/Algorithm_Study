import sys, heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while len(scoville) >= 2:
        food1 = heapq.heappop(scoville)
        food2 = heapq.heappop(scoville)
        if food1 == 0 and food2 == 0:
            print(-1)
            sys.exit(0)
        if food1 >= K and food2 >= K:
            break;
        
        answer += 1
        new_food = food1 + (2*food2)
        heapq.heappush(scoville, new_food)
        
    if len(scoville) == 1:
        if scoville[0] < K:
            answer = -1
    return answer