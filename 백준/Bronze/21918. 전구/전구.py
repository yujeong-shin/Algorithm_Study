import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lights = [0] + list(map(int, input().split()))

for t in range(m):
    mode, a, b = map(int, input().split())
    if mode == 1:
        lights[a] = b
    elif mode == 2:
        for i in range(a, b+1):
            if lights[i] == 0:
                lights[i] = 1
            else:
                lights[i] = 0
    elif mode == 3:
        for i in range(a, b+1):
            lights[i] = 0
    else:
        for i in range(a, b+1):
            lights[i] = 1
print(*lights[1:])