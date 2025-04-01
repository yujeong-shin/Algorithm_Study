from collections import deque

def solution(n, edge):
    answer = 0
    visited = [False] * (n+1)
    cnt = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    queue = deque()
    queue.append(1)
    visited[1] = True
    while queue:
        cx = queue.popleft()
        for nx in graph[cx]:
            if not visited[nx]:
                visited[nx] = True
                cnt[nx] = cnt[cx] + 1
                queue.append(nx)
    print(cnt)
    max_num = max(cnt)
    answer = cnt.count(max_num)
    return answer