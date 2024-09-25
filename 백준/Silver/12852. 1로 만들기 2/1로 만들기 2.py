n = int(input())  
  
dp = [i for i in range(n + 1)]  
dp[1] = 0  
history = [i for i in range(n + 1)]  
history[1] = 0

for i in range(2, n + 1):  
    dp[i] = dp[i - 1] + 1  
    history[i] = i - 1  
  
    if i % 3 == 0 and dp[i] > dp[i // 3] + 1:  
        dp[i] = dp[i // 3] + 1  
        history[i] = i // 3  
    if i % 2 == 0 and dp[i] > dp[i // 2] + 1:  
        dp[i] = dp[i // 2] + 1  
        history[i] = i // 2

answer_list = []
answer_list.append(n)
back_num = n  
while history[back_num] != 0:  
    answer_list.append(history[back_num])
    back_num = history[back_num]
print(dp[n])
print(*answer_list)