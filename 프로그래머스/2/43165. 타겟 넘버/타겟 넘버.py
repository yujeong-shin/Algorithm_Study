from collections import deque

def solution(numbers, target):
    answer = 0
    
    def dfs(idx, tmp_sum):
        nonlocal answer
        if idx == len(numbers):
            if tmp_sum == target:
                answer += 1
            return
                
        dfs(idx+1, tmp_sum+numbers[idx])
        dfs(idx+1, tmp_sum-numbers[idx])
        
    dfs(0, 0)
    return answer

'''
def solution(numbers, target):
    answer = 0
    queue = deque()
    queue.append((0, numbers[0]))
    queue.append((0, -numbers[0]))
    #print(queue)
    
    while queue:
        i, tmp_sum = queue.popleft()
        #print(i, tmp_sum)
        if i == len(numbers)-1 and tmp_sum == target:
            answer += 1            
        if i < len(numbers)-1:
            queue.append((i+1, tmp_sum + numbers[i+1]))
            queue.append((i+1, tmp_sum - numbers[i+1]))
    
    return answer
'''