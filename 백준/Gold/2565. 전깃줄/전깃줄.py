import sys
input = sys.stdin.readline

n = int(input())
lines = [list(map(int, input().split())) for _ in range(n)]
sorted_lines = sorted(lines, key=lambda x: x[0]) # 왼쪽 전봇대 기준으로 정렬

dp = [1] + [0]*(n-1)
for idx in range(1, n):
    S, E = sorted_lines[idx]
    tmp_max = 1
    for i in range(idx):
        s, e = sorted_lines[i]
        if S > s and E > e:
            tmp_max = max(tmp_max, dp[i]+1)
    dp[idx] = tmp_max

print(n - max(dp))