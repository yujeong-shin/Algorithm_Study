n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

answer = [0]*m
def DFS(level):
    global n, m, numbers, answer
    if level==m:
        answer_string=''
        answer_string = ' '.join(map(str, answer))
        print(answer_string)
        return
    else:
        for i in range(n):
            answer[level] = numbers[i]
            DFS(level+1)
DFS(0)