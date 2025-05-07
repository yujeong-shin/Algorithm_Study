import sys
input = sys.stdin.readline

h, w, n, m = map(int, input().split())
answer = 1

if h % (n+1) >= 1:
    answer = answer * ((h//(n+1)) + 1)
else:
    answer = answer * (h//(n+1))

if w % (m+1) >= 1:
    answer = answer * ((w//(m+1)) + 1)
else:
    answer = answer * (w//(m+1))
print(answer)