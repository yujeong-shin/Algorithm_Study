n, m = map(int, input().split())
numbers = [0] * n
visited = [0] * n
for i in range(n):
    numbers[i] = i+1

answer = [0]*m
def DFS(level):
    global n, m, numbers, visited, answer
    if level==m:
        answer_string=''
        answer_string = ' '.join(map(str, answer))
        print(answer_string)
        return
    else:
        for i in range(n):
            if visited[i] != 1:
                visited[i] = 1
                answer[level] = numbers[i]
                DFS(level+1)
                visited[i] = 0
DFS(0)