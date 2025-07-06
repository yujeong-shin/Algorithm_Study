import sys
input = sys.stdin.readline

n = 9
maps = [list(map(int, input().split())) for _ in range(n)]
targets = [(i, j) for i in range(n) for j in range(n) if maps[i][j] == 0]

def numDeplCheck(x, y, num):
    # 행 확인
    flag = False
    for i in range(n):
        if maps[x][i] == num or maps[i][y] == num:
            flag = True
            return flag

    # 3X3 sector 확인
    sRow, eRow, sCol, eCol = 0, 0, 0, 0
    if 0 <= x < 3:
        sRow, eRow = 0, 2
    elif x < 6:
        sRow, eRow = 3, 5
    else:
        sRow, eRow = 6, 8
    if 0 <= y < 3:
        sCol, eCol = 0, 2
    elif y < 6:
        sCol, eCol = 3, 5
    else:
        sCol, eCol = 6, 8
    for i in range(sRow, eRow+1):
        for j in range(sCol, eCol+1):
            if maps[i][j] == num:
                flag = True
    if flag:
        return flag
    return flag

def dfs(idx):
    if idx == len(targets):
        for row in maps:
            print(*row)
        exit()
    x, y = targets[idx]
    
    for num in range(1, 10):
        if not numDeplCheck(x, y, num):
            maps[x][y] = num
            dfs(idx+1)
            maps[x][y] = 0

dfs(0)