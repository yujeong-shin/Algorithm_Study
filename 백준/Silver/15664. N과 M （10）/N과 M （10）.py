n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

visited = [0] * n
answer = [0]*m
answers = []
def DFS(level, start):
    global n, m, numbers, visited, answer, answers
    if level==m:
        answers.append(answer.copy())
        return
    else:
        for i in range(start, n):
            if visited[i] != 1:
                visited[i] = 1
                answer[level] = numbers[i]
                DFS(level+1, i+1)
                visited[i] = 0
DFS(0, 0)

unique_answers = set(map(tuple, answers))
answers = list(map(list, unique_answers))
answers.sort()
for i in range(len(answers)):
    answer_string=''
    answer_string = ' '.join(map(str, answers[i]))
    print(answer_string)