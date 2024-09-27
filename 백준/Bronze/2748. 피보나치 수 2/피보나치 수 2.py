import sys
n =  int(sys.stdin.readline())
dp = [0] * (n+1)

for i in range(1, n+1):
    if i==1:
        dp[1]=1
    else:
        dp[i] = dp[i-2] + dp[i-1]
        
print(dp[n])