import sys
from collections import deque
input = sys.stdin.readline

N, L = map(int, input().split())
arr = list(map(int, input().split()))

dq = deque()
for i in range(N):
    # 덱에 값이 존재 && 맨 오른쪽 객체의 value가 현재 객체의 value보다 클 경우, 정답이 될 수 없으므로 제거
    # 1개가 아닌 dq에 존재하는 모든 원소를 제거
    while dq and dq[-1][1] > arr[i]:
        dq.pop()
    
    # 덱에 현재 객체 추가 (index, value)
    dq.append([i+1, arr[i]])
    
    # sliding window 값이 3을 넘어간다면, 맨 왼쪽 객체는 범위에서 빠진 것이므로 제거
    if dq[-1][0] - dq[0][0] >= L:
        dq.popleft()
    
    print(dq[0][1], end=" ")