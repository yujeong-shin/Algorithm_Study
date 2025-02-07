import sys
input = sys.stdin.readline

n, k = map(int, input().split())
items = [[0, 0]]
for i in range(n):
    w, v = map(int, input().split())
    items.append([w, v])
    
dp = [[0]*(k+1) for _ in range(n+1)]
for i in range(1, n+1):
    for j in range(1, k+1):
        w, v = items[i][0], items[i][1]
        
        if w > j: #case1) 현재 가방 크기(j)보다 현재 물건(i)의 무게(w)가 더 무거운 경우
            dp[i][j] = dp[i-1][j]
        else: #case2) 현재 물건을 현재 가방에 넣을 수 있는 경우
            dp[i][j] = max(dp[i-1][j], v + dp[i-1][j-w])
            #max(안 넣고 이전의 최댓값 유지, 넣고 가방의 남는 공간의 최댓값을 더해주는 경우)
print(dp[n][k])