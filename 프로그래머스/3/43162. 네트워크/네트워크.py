def solution(n, computers):
    answer = 0
    visited = [0]*n
    def dfs(i, visited):
        for j in range(n):
            if not i==j and computers[i][j] == 1:
                if visited[j] == 0:
                    visited[j] = 1
                    dfs(j, visited)
    
    for i in range(n):
        if visited[i] == 0:
            visited[i] = 1
            answer += 1
            dfs(i, visited)
    
    return answer