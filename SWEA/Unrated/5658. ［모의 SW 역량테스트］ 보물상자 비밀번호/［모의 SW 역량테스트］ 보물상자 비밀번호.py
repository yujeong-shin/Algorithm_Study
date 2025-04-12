from collections import deque

T = int(input())
for test_case in range(1, T + 1):
    n, k = map(int, input().split())
    arr = list(input())
    rotate_count = n // 4
    queue = deque(arr)
    s = set()
    
    for _ in range(rotate_count):  # 총 회전 횟수 = 변 길이만큼
        num_list = list(queue)
        for i in range(0, n, rotate_count):
            group = num_list[i:i + rotate_count]
            num = int(''.join(group), 16)
            s.add(num)
        queue.rotate(1)  # 오른쪽으로 1칸 회전
    sorted_s = sorted(s, reverse=True)
    print('#' + str(test_case) + ' ' + str(sorted_s[k-1]))