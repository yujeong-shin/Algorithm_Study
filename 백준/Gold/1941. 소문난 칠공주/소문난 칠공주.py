import sys
input = sys.stdin.readline

maps = [list(input().strip()) for _ in range(5)]
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
answer = 0
visit = set()

def dfs(s_cnt, y_cnt, paths):
    global answer, visit
    if y_cnt > 3:
        return
    
    if len(paths) == 7:
        # tuple로 안 감싼 결과 : [(1, 0), (1, 1), (1, 2), (1, 3)]
        # set형에 담아 중복을 비교하기 위해서는 tuple 형으로 바꿔, 괄호 모양을 맞춰줘야 함
        paths = tuple(sorted(paths)) # tuple로 감싼 결과 : ((1, 0), (1, 1), (1, 2), (1, 3))
        if paths not in visit: # visit : {((1, 0), (1, 1), (1, 2), (1, 3)), ... }
            visit.add(paths)
            answer += 1
            return
        return # else인 경우도 바로 종료 (아래 for문 실행X)
              
    for path in paths:
        for i in range(4):
            nx = path[0] + dx[i]
            ny = path[1] + dy[i]
            if 0 <= nx < 5 and 0 <= ny < 5:
                if (nx, ny) not in paths:
                    if maps[nx][ny] == 'Y':
                        dfs(s_cnt, y_cnt+1, paths+[(nx, ny)])
                    else:
                        dfs(s_cnt+1, y_cnt, paths+[(nx, ny)])

for i in range(5):
    for j in range(5):
        if maps[i][j] == 'Y':
            dfs(0, 1, [(i, j)])
        else:
            dfs(1, 0, [(i, j)])

print(answer)