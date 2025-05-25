import sys
input = sys.stdin.readline

s_num1, s_num2 = input().split()
num1 = int(s_num1[::-1])
num2 = int(s_num2[::-1])

if num1 > num2:
    print(num1)
else:
    print(num2)