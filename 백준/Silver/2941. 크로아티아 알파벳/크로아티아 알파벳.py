import sys
input = sys.stdin.readline

words = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
s = input().rstrip()
answer = 0

while len(s) > 0:
    if s[0:3] in words:
        answer = answer + 1
        s = s[3:]
    elif s[0:2] in words:
        answer = answer + 1
        s = s[2:]
    else:
        answer = answer + 1
        s = s[1:]

print(answer)