import sys
input = sys.stdin.readline

n = int(input())
lectures = []
for _ in range(n):
    s, e = map(int, input().split())
    lectures.append(['s', s])
    lectures.append(['e', e])
sorted_lectures = sorted(lectures, key=lambda x: (x[1], x[0])) # x: (-x[1], -x[0]) 내림차순

answer = -sys.maxsize
room = 0
for lecture in sorted_lectures:
    if lecture[0] == 's':
        room += 1
        answer = max(answer, room)
    else:
        room -= 1
print(answer)