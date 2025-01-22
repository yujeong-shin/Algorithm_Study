import sys
input = sys.stdin.readline
n = int(input())
arr = [0] * 367

for i in range(n):
    a, b = map(int, input().split())
    for j in range(a, b+1):
        arr[j] += 1
        
answer = 0
width, height = 0, 0
for i in range(len(arr)):
    if arr[i] == 0:
        if width>0 and height>0:
            answer += width*height
            width, height = 0, 0
        else:
            continue
    else:
        width += 1
        height = max(height, arr[i])
print(answer)