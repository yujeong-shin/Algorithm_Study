def solution(dirs):
    visited = [[[] for _ in range(11)] for _ in range(11)] # 좌표값+5로 접근해야 함
    x, y = 5, 5
    answer = 0
    moves = list(dirs)
    for move in moves:
        print("move : " + str(move))
        if move == 'U':
            nx = x-1
            ny = y
            print("U 이동")
            print("x, y : " + str(x) + ", " + str(y) +
                  "-> nx, ny: " + str(nx) + ", " + str(ny))
            if 0 <= nx <= 10 and 0 <= ny <= 10 :
                if 'U' not in visited[nx][ny] and 'D' not in visited[x][y]:
                    visited[nx][ny].append('U')
                    visited[x][y].append('D')
                    answer += 1
                    print("answer : " + str(answer))
                x, y = nx, ny
        elif move == 'D':
            nx = x+1
            ny = y
            print("D 이동")
            print("x, y : " + str(x) + ", " + str(y) +
                  "-> nx, ny: " + str(nx) + ", " + str(ny))
            if 0 <= nx <= 10 and 0 <= ny <= 10 :
                if 'D' not in visited[nx][ny] and 'U' not in visited[x][y]:
                    visited[nx][ny].append('D')
                    visited[x][y].append('U')
                    answer += 1
                    print("answer : " + str(answer))
                x, y = nx, ny
        elif move == 'L':
            nx = x
            ny = y-1
            print("L 이동")
            print("x, y : " + str(x) + ", " + str(y) +
                  "-> nx, ny: " + str(nx) + ", " + str(ny))
            if 0 <= nx <= 10 and 0 <= ny <= 10 :
                if 'L' not in visited[nx][ny] and 'R' not in visited[x][y]:
                    visited[nx][ny].append('L')
                    visited[x][y].append('R')
                    answer += 1
                    print("answer : " + str(answer))
                x, y = nx, ny
        else : # R
            nx = x
            ny = y+1
            print("R 이동")
            print("x, y : " + str(x) + ", " + str(y) +
                  "-> nx, ny: " + str(nx) + ", " + str(ny))
            if 0 <= nx <= 10 and 0 <= ny <= 10 :
                if 'R' not in visited[nx][ny] and 'L' not in visited[x][y]:
                    visited[nx][ny].append('R')
                    visited[x][y].append('L')
                    answer += 1
                    print("answer : " + str(answer))
                x, y = nx, ny
    return answer