import sys
input = sys.stdin.readline

t, w = map(int, input().split())
tree = [0] + [int(input()) for _ in range(t)]
dp = [[0 for _ in range(w+1)] for _ in range(t+1)]

for i in range(1, t+1):
    if tree[i] == 1: # 0번 움직였을 때 기준으로, t초에서 자두를 먹을 수 있는지 판단
        dp[i][0] = dp[i-1][0] + 1 # 0번 움직였을 때 tree[t]==1라면 먹을 수 있음
    else:
        dp[i][0] = dp[i-1][0]
    
    for j in range(1, w+1): # 1번 이상 움직이는 경우에 대해 탐색
        # 자두를 먹을 수 있는 경우
        if j%2==1 and tree[i]==2: # 이동 횟수 홀수(2번 나무 밑), 2번 나무에서 자두 떨어짐
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1 # 1초 전 우치에서 움직여서 받아 먹을건지, 현재 위치에서 받아 먹을건지
        elif j%2==0 and tree[i]==1: # 이동 횟수 짝수(1번 나무 밑), 1번 나무에서 자두 떨어짐
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1
        # 자두를 못 먹는 경우(자두가 떨어지는 나무 != 현재 서 있는 나무)
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) # 1초 전 먹을 수 있는 자두 최대 개수 유지
            # 움직여서 못 먹는 경우, 움직이지 않아서 못 먹는 경우 비교
print(max(dp[t]))