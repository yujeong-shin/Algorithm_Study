n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

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