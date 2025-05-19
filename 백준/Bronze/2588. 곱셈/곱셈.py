import sys
input = sys.stdin.readline

a = int(input())
b = int(input())
b_1 = b%10
b_10 = (b//10)%10
b_100 = (b//10)//10

res_1 = a * b_1
res_10 = a * b_10
res_100 = a * b_100
print(res_1)
print(res_10)
print(res_100)
print(res_100*100 + res_10*10 + res_1)