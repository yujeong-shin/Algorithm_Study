import sys

r, c = map(int, input().split())
maps = []
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
for i in range(r):
    maps.append(list(input()))

s = set([ (0, 0, maps[0][0]) ]) # set 선언 및 값 삽입
answer = 0
while s:
    cx, cy, path = s.pop()
    answer = max(answer , len(path))
    for i in range(4):
        nx, ny = cx + dx[i], cy + dy[i]
        if 0 <= nx < r and 0 <= ny < c and maps[nx][ny] not in path:
                s.add((nx, ny, path + maps[nx][ny])) # 경로를 "A"+"B" = "AB" 문자열로 핸들링
print(answer)