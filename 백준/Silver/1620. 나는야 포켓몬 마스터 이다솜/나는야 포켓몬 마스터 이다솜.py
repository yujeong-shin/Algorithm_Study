import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = {}
for i in range(1, n+1):
    address = input().strip()
    num = str(i)
    maps[address] = num
    maps[num] = address
for _ in range(m):
    q = input().strip()
    print(maps[q])