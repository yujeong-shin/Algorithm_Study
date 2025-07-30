import sys
input = sys.stdin.readline

INF = sys.maxsize
n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
dp = [[-1]*(1<<n) for _ in range(n)]

def dfs(cur, visited):
    if visited == (1 << n) - 1:
        return graph[cur][0] if graph[cur][0] else INF

    if dp[cur][visited] != -1:
        return dp[cur][visited]

    dp[cur][visited] = INF
    for next in range(n):
        if not graph[cur][next] or visited & (1 << next):
            continue
        dp[cur][visited] = min(dp[cur][visited], dfs(next, visited | (1 << next)) + graph[cur][next])
    
    return dp[cur][visited]

# 시작 지점은 어느 집이 되어도 상관없다.
# 0 → 1 → 2 → 3 → 0과 2 → 3 → 0 → 1 → 2처럼 순회하는 경로의 정답이 동일하기 때문이다.
print(dfs(0, 1))