from collections import deque

def solution(skill, skill_trees):
    answer = 0
    for tree in skill_trees:
        queue = deque(skill)
        whether = True
        
        for temp in tree:
            if temp not in queue:
                continue
            else:
                if temp == queue[0]:
                    queue.popleft()
                else:
                    whether = False
                    break
        if whether:
            answer += 1
            
    return answer