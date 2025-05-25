import sys
input = sys.stdin.readline

cnt = int(input())
for c in range(cnt):
    s = input().rstrip()
    answer = s[0] + s[-1]
    print(answer)