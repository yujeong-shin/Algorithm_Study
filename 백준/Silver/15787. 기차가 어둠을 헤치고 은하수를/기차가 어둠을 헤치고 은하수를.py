import sys
input = sys.stdin.readline

n, m = map(int, input().split())
trains = [[0]*20 for _ in range(n)]

for i in range(m):
    arr = list(map(int, input().split()))
    if arr[0] == 1:
        train_num, seat_num = arr[1]-1, arr[2]-1
        if not trains[train_num][seat_num] :
            trains[train_num][seat_num] = 1
    elif arr[0] == 2:
        train_num, seat_num = arr[1]-1, arr[2]-1
        if trains[train_num][seat_num] :
            trains[train_num][seat_num] = 0
    elif arr[0] == 3:
        train_num = arr[1]-1
        for j in range(18, -1, -1):
            trains[train_num][j+1] = trains[train_num][j]
        trains[train_num][0] = 0
    else:
        train_num = arr[1]-1
        for j in range(1, 20):
            trains[train_num][j-1] = trains[train_num][j]
        trains[train_num][19] = 0
        
occupied_list = []
answer = 0
for train in trains:
    temp = []
    for i in range(20):
        if train[i] == 1:
            temp.append(i)
    if temp not in occupied_list:
        occupied_list.append(temp)
        answer += 1
print(answer)