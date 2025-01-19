arr = input()
sound = ['q', 'u', 'a', 'c', 'k']

total, answer = 0, 0
visited = [False] * len(arr)
while total < len(arr):
    cnt, pt = 0, 0
    for i in range(len(arr)):
        if visited[i]:
            continue
        if arr[i] != sound[pt]:
            continue

        visited[i] = True
        cnt += 1
        pt += 1
        if pt > 4:
            pt = 0

    total += cnt
    if cnt % 5 != 0 or cnt == 0:
        answer = -1
        break
    answer += 1
print(answer)