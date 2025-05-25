import sys
input = sys.stdin.readline

cnt = int(input())
s = input().rstrip()
sum = 0
for ch in s:
    sum = sum + int(ch)
print(sum)