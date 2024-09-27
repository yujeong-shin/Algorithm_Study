n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort() #내림차순 정렬은 reverse() 혹은 sort(reverse=True)

visited = [0] * n
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