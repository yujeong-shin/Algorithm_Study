import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

lt, rt = 0, len(arr)-1
min_sum = abs(arr[lt]+arr[rt])
answer = [arr[lt], arr[rt]]

while lt < rt:
    sum = arr[lt] + arr[rt]
    if abs(sum) < min_sum:
        min_sum = abs(sum)
        answer = [arr[lt], arr[rt]]
        if min_sum == 0:
            break

    if sum < 0:
        lt += 1
    else:
        rt -= 1

print(*answer)