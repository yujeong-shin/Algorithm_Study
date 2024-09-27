n, m = map(int, input().split())
numbers = [0] * n
for i in range(n):
    numbers[i] = i+1

answer = [0]*m
def DFS(level, start):
    global n, m, numbers, answer
    if level==m:
        answer_string=''
        answer_string = ' '.join(map(str, answer))
        print(answer_string)
        return
    else:
        for i in range(start, n):
            answer[level] = numbers[i]
            DFS(level+1, i)
DFS(0, 0)