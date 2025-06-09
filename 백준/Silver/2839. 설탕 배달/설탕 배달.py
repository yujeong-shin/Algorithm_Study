import sys
input = sys.stdin.readline

n = int(input())
answer = sys.maxsize

for i in range(n//5 + 1):
    for j in range(n//3 + 1):
        if (5*i) + (3*j) == n:
            answer = min(answer, i+j)

if answer == sys.maxsize:
    print(-1)
else:
    print(answer)