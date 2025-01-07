import sys
input = sys.stdin.readline
num_arr = list(input().strip())
answer = 0
answer_temp = []

for i in range(len(num_arr)):
    num = int(num_arr[i])
    num_2 = []
    while num > 1:
        temp = num % 2
        num_2.insert(0, temp)
        num //= 2
    num_2.insert(0, num)
    
    if i != 0 and len(num_2) != 3:
        zero_count = 3 - len(num_2)
        prefix = str("0"*zero_count)
        pre_num_2 = prefix + str("".join(map(str, num_2)))
        answer_temp.append(pre_num_2)
    else:
        answer_temp.append(str("".join(map(str, num_2))))

answer_temp = "".join(answer_temp)
if int(answer_temp) > 0:
    answer = int(answer_temp)
print(answer)