import sys
input = sys.stdin.readline

str1 = list(input().rstrip())
str2 = list(input().rstrip())
len1 = len(str1)
len2 = len(str2)
dp = [[0]*(len2+1) for _ in range(len1+1)]

for i in range(1, len1+1):
    for j in range(1, len2+1):
        if str1[i-1] == str2[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1 
        else: # 추가 문자가 다른 경우, 각각 두 문자를 비교하기 전인 값 중 최댓값
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])
print(max(dp[len1]))