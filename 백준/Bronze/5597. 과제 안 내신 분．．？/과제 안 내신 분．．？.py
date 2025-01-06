import sys
input = sys.stdin.readline

student = [0]*31
for i in range(28):
    num = int(input())
    student[num] = 1

for i in range(1, 31):
    if student[i] == 0:
        print(i)