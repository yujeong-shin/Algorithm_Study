import sys
input = sys.stdin.readline

s = input().rstrip()
alpha = []
cnt = 26
for i in range(cnt):
    alpha.append(chr(97+i))

answer = ""
for ch in alpha:
    if ch in s:
        answer = answer + str(s.index(ch)) + " "
        #answer.append(s.index(ch))
    else:
        answer = answer + "-1 "
        # print(-1)
print(answer)