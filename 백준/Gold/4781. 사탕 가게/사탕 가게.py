import sys
input = sys.stdin.readline

while(True):
    n, m = map(float, input().split())
    n, m = int(n), int(m*100 + 0.5) # rounding error
    if n == 0 and m == 0:
        break
        
    dp = [0] * (m+1)
    for i in range(n):
        c, p = map(float, input().split())
        cost, price = int(c), int(p*100+0.5)
        for j in range(price, m+1):
            dp[j] = max(dp[j], dp[j-price]+cost)
    print(dp[m])