import sys
from collections import deque
input = sys.stdin.readline
n = int(input())

maps = []
for _ in range(n):
    maps.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def split_island(start, end, num):
    queue = deque()
    queue.append([start, end])
    while queue:
        cur = queue.popleft()
        cx = cur[0]
        cy = cur[1]
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if maps[nx][ny] == 1:
                    maps[nx][ny] = num
                    queue.append([nx, ny])
islandNum = 2
for i in range(n):
    for j in range(n):
        if maps[i][j] == 1:
            maps[i][j] = islandNum
            split_island(i, j, islandNum)
            islandNum += 1

answer = sys.maxsize
def BFS(num):
    visited = [[0]*n for _ in range(n)]
    queue = deque()
    for i in range(n):
        for j in range(n):
            if maps[i][j] == num:
                queue.append([i, j, 0])
    while queue:
        cur = queue.popleft()
        cx, cy, count = cur[0], cur[1], cur[2]
        visited[cx][cy] = 1
        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]
            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                # 다리 공간이면 확장
                if maps[nx][ny] == 0:
                    visited[nx][ny] = 1
                    queue.append([nx, ny, count+1])
                # 같은 섬이면 확장
                elif maps[nx][ny] == num or maps[cx][cy] == maps[nx][ny]:
                    visited[nx][ny] = 1
                    queue.append([nx, ny, count+1])
                else:
                    return count
for num in range(2, islandNum):
    temp = BFS(num)
    answer = min(answer, temp)
print(answer)