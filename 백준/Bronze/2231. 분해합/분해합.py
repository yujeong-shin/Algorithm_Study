import sys
n = int(input())

def divide_sum(num):
    sum = num
    while(num > 0):
        sum += num%10
        num //= 10
    return sum

result = sys.maxsize
for i in range(n//2, n):
    temp = divide_sum(i)
    if temp == n:
        if temp < result :
            result = i

if result == sys.maxsize :
    print(0)
else :
    print(result)