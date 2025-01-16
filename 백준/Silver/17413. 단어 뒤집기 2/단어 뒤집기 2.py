import sys
input = sys.stdin.readline

string = list(input().rstrip())
temp = []
answer = []
flag = False

for pt in range(len(string)):
    if string[pt].isalpha() or string[pt].isnumeric():
        if flag:
            temp.append(string[pt])
        else:
            temp.append(string[pt])
    elif string[pt].isspace():
        if flag:
            temp.append(string[pt])
        else:
            if temp:
                answer.append("".join(temp[::-1]))
                temp = []
            answer.append(" ")  # 공백 처리
    elif string[pt] == '<':
        if temp:
            answer.append("".join(temp[::-1]))
            temp = []
        flag = True
        temp.append(string[pt])
    elif string[pt] == '>':
        temp.append(string[pt])
        answer.append("".join(temp))
        temp = []
        flag = False

if temp:
    answer.append("".join(temp[::-1]))

print("".join(answer).strip())