def solution(tickets):
    answer = []
    tickets.sort()
    #print(tickets)
    N = len(tickets)
    visited = [False] * N

    def dfs(path):
        if len(path) == N+1:
            answer.append(path[:])
            return 

        for i in range(N):
            if tickets[i][0] == path[-1] and visited[i] == False:
                visited[i] = True
                path.append(tickets[i][1])
                dfs(path)
                path.pop()
                visited[i] = False

    dfs(["ICN"])

    return answer[0]