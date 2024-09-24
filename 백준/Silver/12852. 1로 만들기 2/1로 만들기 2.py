from collections import deque

n = int(input())
q = deque()
q.append([n])


def bfs():
    while q:
        arr = q.popleft() # 정답 후보 리스트 한 줄 추출

        x = arr[0]
        if x == 1:
            return arr

        if x % 3 == 0:
            q.append([x//3] + arr) # 기존 리스트를 뒤에 붙임으로써 경로 파악 [1, 3, 9, 10]

        if x % 2 == 0:
            q.append([x//2]+arr)

        q.append([x-1]+arr)

res = bfs()
print(len(res)-1)
print(*res[::-1]) # 리스트를 대괄호 없이 역순으로 출력 (start:end:direction)