import sys
input = sys.stdin.readline

k, n = map(int, input().split())
lines = [int(input()) for _ in range(k)]

left, right = 1, max(lines)
answer = -1
while left<=right:
    mid = (left+right)//2
    #print("left: " + str(left) + ", right: " + str(right) + ", mid: " + str(mid))
    sum = 0
    for line in lines:
        sum += (line//mid)
    
    if sum < n:
        right = mid-1
    else: # N개보다 많이 만드는 것도 N개를 만드는 것에 포함
        answer = max(answer, mid)
        left = mid+1

print(answer)