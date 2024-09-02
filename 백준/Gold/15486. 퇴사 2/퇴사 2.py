'''
Step 1. 오늘 수익 = MAX(어제까지 수익 중 최대값, 오늘 수익)
Step 2. 오늘 업무를 수행한 뒤 수익(단, 퇴사전까지 끝나는 업무) = MAX(업무가 끝나는 날 기존 수익, 어제까지 수익 중 최대값 + 해당 업무 수익)
'''

import sys
n = int(sys.stdin.readline())
dp = [0 for _ in range(n+1)]

for i in range(1, n+1):
    t, p = map(int, sys.stdin.readline().split())
    dp[i] = max(dp[i-1], dp[i])
    
    finish_day = i + t - 1
    if(finish_day <= n):
        dp[finish_day] = max(dp[finish_day], dp[i-1]+p)

print(dp[-1])