import sys
input = sys.stdin.readline

answer = ""
s = input().rstrip()
while s != "":
    answer = answer + s + "\n"
    s = input().rstrip()
print(answer)