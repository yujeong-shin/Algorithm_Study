import sys
input = sys.stdin.readline

dp = [1]*2 + [0]*29
def factorial(num):
    if dp[num]>0:
        return dp[num]
    if num == 1:
        return dp[num]
    dp[num] = num * factorial(num-1)
    return dp[num]

tc = int(input())
for t in range(tc):
    r, n = map(int, input().split())
    res = factorial(n) / (factorial(n-r)*factorial(r))
    print(int(res))