import sys, copy, itertools
input = sys.stdin.readline

n = int(input())
s = []
for i in range(n):
    tmp = list(map(int, input().split()))
    s.append(tmp)

combi = [0]*(n//2)
visited = [False] * n
answer = sys.maxsize

# step 2. 링크 팀원 구해서 결과 계산
def calc(start_team):
    global answer
    link_team = []
    for i in range(n):
        if i not in start_team:
            link_team.append(i)
            
    start_s_list = list(itertools.permutations(start_team, 2))
    start_energy = 0
    for x, y in start_s_list:
        start_energy += s[x][y]
        
    link_s_list = list(itertools.permutations(link_team, 2))
    link_energy = 0
    for x, y in link_s_list:
        link_energy += s[x][y]
    answer = min(answer, abs(start_energy - link_energy))
    
# step 1. 스타트 팀원 고르기
def dfs(start, L):
    if L >= n//2:
        calc(combi)
        return
    for i in range(start, n):
        if not visited[i]:
            visited[i] = True
            combi[L] = i
            dfs(i+1, L+1)
            visited[i] = False
dfs(0, 0)
print(answer)