def solution(k, dungeons):
    answer = -1
    visited = [False]*len(dungeons)
    def dfs(L, K):
        nonlocal answer
        answer = max(answer, L)
        
        for i in range(len(dungeons)):
            if not visited[i] and K >= dungeons[i][0]:
                    visited[i] = True
                    dfs(L+1, K-dungeons[i][1])
                    visited[i] = False          
        
    dfs(0, k)
    return answer