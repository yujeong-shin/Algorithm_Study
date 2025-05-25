import sys
input = sys.stdin.readline

tc = int(input())
for t in range(tc):
    answer = ""
    s_num, s = input().split()
    num = int(s_num)

    for ch in s:
        answer = answer + (ch)*num
    print(answer)