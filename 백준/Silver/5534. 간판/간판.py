import sys
input = sys.stdin.readline

n = int(input())
answer_word = input().strip()
names = []
answer = 0
for _ in range(n):
    names.append(input().rstrip())

for name in names:
    flag = False
    for start in range(0, len(name)-len(answer_word)+1):
        if not flag:
            for d in range(1, len(name)):
                if name[start] != answer_word[0]:
                    break
                else:
                    temp = []
                    cnt = 1
                    idx = start
                    temp.append(name[start])
                    while cnt < len(answer_word):
                        idx += d
                        if idx >= len(name):
                            break
                        temp.append(name[idx])
                        cnt += 1
                    if len(temp) == len(answer_word):
                        temp_string = "".join(temp)
                        if temp_string == answer_word:
                            answer += 1
                            flag = True
                            break
print(answer)
