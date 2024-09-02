import sys
tc = int(input())
n = [int(sys.stdin.readline()) for _ in range(tc)]

dp = [0] * 1000001
dp[1]=1
dp[2]=2
dp[3]=4
    
for i in range(4, 1000001):
    dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1000000009
    
for target in n:
    print(dp[target])