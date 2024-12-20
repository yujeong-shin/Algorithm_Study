import sys
import heapq
input = sys.stdin.readline

n = int(input())
plus = []
minus = []
zero = []
for i in range(n):
    num = int(input())
    if num < 0: minus.append(num)
    elif num > 0: plus.append(num)
    else: zero.append(num)

minus.sort()
plus.sort()
result = 0
while len(minus) > 1:
    a = minus[0]
    b = minus[1]
    minus = minus[2:]
    result += a*b
while len(plus) > 1:
    a = plus[-1]
    b = plus[-2]
    plus = plus[:-2]
    result += max(a*b, a+b)

if len(minus) > 0:
    if len(zero) > 0:
        result += minus[0]*0
    else:
        result += minus[0]
if len(plus) > 0:
    result += plus[0]
print(result)