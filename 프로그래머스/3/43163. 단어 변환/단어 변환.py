from collections import deque
def solution(begin, target, words):
    answer = 0
    visited = [0] * len(words)
    queue = deque()
    queue.append((0, begin))
    
    def count_diff(st1, st2):
        cnt = 0
        for i in range(len(st1)):
            if st1[i] != st2[i]:
                cnt += 1
        return cnt
    
    def bfs():
        nonlocal answer
        while queue:
            level, cur_word = queue.popleft()

            if cur_word == target:
                answer = level
            
            for i in range(len(words)):
                if visited[i] == 0:
                    if count_diff(cur_word, words[i]) == 1:
                        visited[i] = 1
                        queue.append((level+1, words[i]))
    
    bfs()
    return answer