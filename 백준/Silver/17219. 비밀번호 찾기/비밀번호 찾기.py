import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = {}
for _ in range(n):
    address, password = map(str, input().split())
    maps[address] = password
for _ in range(m):
    q = input().strip()
    print(maps[q])