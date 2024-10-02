from collections import deque
import sys

input = sys.stdin.readline
k = int(input())

deque = deque()
for i in range(k):
    num = int(input())
    if num == 0:
        deque.pop()
    else :
        deque.append(num)

sum = 0
for i in range(len(deque)):
    sum += deque.pop()
print(sum)