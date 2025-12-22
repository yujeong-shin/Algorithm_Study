from collections import deque

def D(num):
    return (2*num)%10000

def S(num):
    if num == 0:
        return 9999
    return num-1

def L(num):
    fst = num // 1000
    res = num % 1000
    return res * 10 + fst

def R(num):
    lst = num % 10
    res = num // 10
    return lst * 1000 + res

def bfs(num, path):
    queue = deque()
    queue.append((num, path))
    
    while queue:
        for l in range(len(queue)):
            n, p = queue.popleft()
            if n == B:
                print(p)
                return
            
            for nxt, cmd in [
                 (D(n), 'D'),
                 (S(n), 'S'),
                 (L(n), 'L'),
                 (R(n), 'R')
                 ]:
                if not visited[nxt]:
                    visited[nxt] = True
                    queue.append((nxt, p + cmd))
            
TC = int(input())
for tc in range(TC):
    visited = [False] * 10000
    A, B = map(int, input().split())
    visited[A] = True
    bfs(A, "")