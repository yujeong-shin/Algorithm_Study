import sys
input = sys.stdin.readline
TC = int(input())

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
def makeArrWithDir(n, d_idx):
    mid = n//2
    x, y = mid, mid
    temp = []
    while True:
        nx, ny = x+dx[d_idx], y+dy[d_idx]
        if 0 <= nx < n and 0 <= ny < n:
            temp.append((nx, ny))
            x, y = nx, ny
        else:
            break
    return temp

for tc in range(TC):
    n, d = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]
    
    top = makeArrWithDir(n, 0)
    right_top = makeArrWithDir(n, 1)
    right = makeArrWithDir(n, 2)
    right_down = makeArrWithDir(n, 3)
    down = makeArrWithDir(n, 4)
    left_down = makeArrWithDir(n, 5)
    left = makeArrWithDir(n, 6)
    left_top = makeArrWithDir(n, 7)
    
    if d < 0:
        d = 360 - abs(d)
    total_cnt = d//45
    for cnt in range(total_cnt):
        for i in range(n//2):
            temp = arr[right_top[i][0]][right_top[i][1]]
            arr[right_top[i][0]][right_top[i][1]] = arr[top[i][0]][top[i][1]]
            arr[top[i][0]][top[i][1]] = arr[left_top[i][0]][left_top[i][1]]
            arr[left_top[i][0]][left_top[i][1]] = arr[left[i][0]][left[i][1]]
            arr[left[i][0]][left[i][1]] = arr[left_down[i][0]][left_down[i][1]]
            arr[left_down[i][0]][left_down[i][1]] = arr[down[i][0]][down[i][1]]
            arr[down[i][0]][down[i][1]] = arr[right_down[i][0]][right_down[i][1]]
            arr[right_down[i][0]][right_down[i][1]] = arr[right[i][0]][right[i][1]]
            arr[right[i][0]][right[i][1]] = temp

    for i in range(len(arr)):
        print(*arr[i])