import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline

n = int(input())
dp = [[0, 1] for _ in range(n+1)]
visited = [0]*(n+1)
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(node):
    for child in graph[node]:
        if visited[child] == 0:
            visited[child] = 1
            dfs(child)
            
            # 내가(부모) 얼리어답터가 아니라면, 모든 자식들은 얼리어답터
            dp[node][0] += dp[child][1]
            # 내가(부모) 얼리어답터라면, 자식들은 상관없음. 최솟값 선택
            dp[node][1] += min(dp[child][0], dp[child][1])

visited[1] = 1
dfs(1)
print(min(dp[1]))