import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maps = [list(map(int, input().split())) for _ in range(n)]
houses = []
chicken_zip = []

for i in range(n):
    for j in range(n):
        if maps[i][j] == 1:
            houses.append([i, j])
        elif maps[i][j] == 2:
            chicken_zip.append([i, j])

def calc(m_chicken_zip): # m개의 치킨 집이 주어졌을 때
    chicken_path_sum = 0
    for house in houses : # 모든 집에 대해 가장 가까운 치킨 집 찾아 도시의 치킨 거리 구하기
        chicken_path = sys.maxsize
        for chicken in m_chicken_zip:
            temp = abs(house[0]-chicken[0]) + abs(house[1]-chicken[1])
            if temp < chicken_path:
                chicken_path = temp
        chicken_path_sum += chicken_path
    return chicken_path_sum

m_chicken_zip = [0]*m # m개 고른 치킨 집
visited = [0]*len(chicken_zip) # 전체 치킨 집 개수
answer = sys.maxsize
def dfs(start, L):
    global answer
    if L == m:
        result = calc(m_chicken_zip)
        answer = min(answer, result)
    else:
        for i in range(start, len(chicken_zip)):
            if visited[i] == 0: # 아직 방문하지 않은 치킨 집이라면
                visited[i] = 1
                m_chicken_zip[L] = chicken_zip[i]
                dfs(i+1, L+1)
                visited[i] = 0

dfs(0, 0)
print(answer)