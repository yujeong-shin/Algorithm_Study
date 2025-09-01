import sys
input = sys.stdin.readline

n, m = map(int, input().split())
namu = list(map(int, input().split()))

left, right = 0, max(namu)
while left<=right:
    mid = (left+right)//2
    temp_sum = 0
    for num in namu:
        if num >= mid:
            temp_sum += num-mid
            
    if temp_sum >= m:
        left = mid+1
    else:
        right = mid-1
print(right)