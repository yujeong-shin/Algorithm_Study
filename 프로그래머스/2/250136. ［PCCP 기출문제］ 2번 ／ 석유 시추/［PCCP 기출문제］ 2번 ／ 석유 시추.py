from collections import deque

def solution(land):
    answer = 0
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]
    n = len(land)
    m = len(land[0])
    visited = [[False]*m for _ in range(n)]
    oil = [0]*m
    
    def countOil(x, y):
        visited_col = set()
        queue = deque()
        queue.append((x, y))
        cnt = 0
        while queue:
            cx, cy = queue.popleft()
            cnt += 1 # 덩어리 면적
            visited_col.add(cy) # 방문한 열의 정보 1개만 저장
            for i in range(4):
                nx, ny = cx + dx[i], cy + dy[i]
                if 0 <= nx < n and 0 <= ny < m:
                    if land[nx][ny]==1 and not visited[nx][ny]:
                        visited[nx][ny] = True
                        #print("nx: " + str(nx) + ", ny: " + str(ny))
                        queue.append((nx, ny))
        #print(visited_col)
        for c in visited_col:
            oil[c] += cnt    
           # print(oil)
    
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                visited[i][j] = True
                #print("i: " + str(i) + ", j: " + str(j))
                countOil(i, j)
    #print(oil)
    answer = max(oil)
    return answer