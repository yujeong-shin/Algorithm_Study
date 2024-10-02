from collections import deque

question = input()
deque = deque()
answer = 0
for i in range(len(question)):
    cur = question[i]
    if i == 0:
        deque.append(cur)
        continue
    else:
        if cur == ')':
            prev = question[i-1]
            if prev == '(':
                deque.pop()
                answer += len(deque)
            else:
                deque.pop()
                answer += 1
        else :
            deque.append(cur)
print(answer)