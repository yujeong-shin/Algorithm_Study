import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr.sort()

lt, rt = 0, len(arr)-1
answer = sys.maxsize
answer_list = [0, 0]

while lt < rt:
    sum = arr[lt] + arr[rt]
    if abs(sum) < answer:
        answer = abs(sum)
        answer_list = [arr[lt], arr[rt]]
        if answer == 0:
            break

    if sum < 0:
        lt += 1
    else:
        rt -= 1

print(*answer_list)