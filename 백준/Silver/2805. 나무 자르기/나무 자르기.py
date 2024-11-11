import sys
n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

start, end = 0, max(trees)

while start <= end:
    sum = 0
    mid = (start + end) // 2

    for tree in trees:
        if tree > mid:
            sum += tree - mid
    
    if sum < m:  # 가져갈 수 있는 나무 길이 합이 목표보다 작은 경우
        end = mid - 1  # 높이를 낮춰야 함
    else:  # 가져갈 수 있는 나무 길이 합이 목표보다 크거나 같은 경우
        start = mid + 1  # 높이를 높여야 함

print(end)