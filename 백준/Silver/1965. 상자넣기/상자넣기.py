import sys
input = sys.stdin.readline

n = int(input())
boxes = list(map(int, input().split()))
dp = [0]*n
dp[0] = 1

for i in range(1, n):
    temp_max = 0
    for j in range(i):
        if boxes[j] < boxes[i]:
            temp_max = max(temp_max, dp[j])
    dp[i] = temp_max + 1
print(max(dp))