import sys
start, end = input().split()
result = sys.maxsize

diff_len = len(end) - len(start)
for i in range(diff_len+1):
    temp = "*"*(diff_len-i) + start + "*"*i
    diff_count = 0
    for i in range(len(end)):
        if temp[i] == "*":
            continue
        else :
            if temp[i] != end[i]:
                diff_count += 1
    result = min(result, diff_count)

print(result)