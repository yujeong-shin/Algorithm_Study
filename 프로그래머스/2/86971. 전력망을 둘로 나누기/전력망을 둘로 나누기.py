from collections import deque
import sys

def solution(n, wires):
    answer = sys.maxsize
    maps = [[0]*n for _ in range(n)]
    visited = [[0]*n for _ in range(n)]
    for x, y in wires:
        maps[x-1][y-1] = 1
        maps[y-1][x-1] = 1
    
    def bfs(start):
        visited = [False] * n
        queue = deque([start])
        visited[start] = True
        count = 1  # 시작 노드 포함
        
        while queue:
            node = queue.popleft()
            for j in range(n):
                if maps[node][j] == 1 and not visited[j]:
                    visited[j] = True
                    count += 1
                    queue.append(j)
        return count
    
    for i in range(n):
        for j in range(n):
            if maps[i][j] == 1:
                maps[i][j] = 0
                maps[j][i] = 0
                cnt1 = bfs(i)
                cnt2 = n - cnt1
                answer = min(answer, abs(cnt1-cnt2))
                maps[i][j] = 1
                maps[j][i] = 1
    
    return answer