def solution(n, results):
    answer = 0
    grade = [[0]*(n+1) for _ in range(n+1)]
    for winner, loser in results:
        grade[winner][loser] = 1
        grade[loser][winner] = -1
    
    for k in range(1, n+1):
        for i in range(1, n+1):
            for j in range(1, n+1):
                # k선수를 거쳐서 비교했을때 i가 k를 이기고 k가 j를 이기면 i가 j를 이김
                if grade[i][k] == 1 and grade[k][j] == 1:
                    grade[i][j] = 1
                    grade[j][i] = -1
                # k선수를 거쳐서 비교했을때 i가 k에게 지고 k가 j에게 지면 j가 i를 이김
                if grade[i][k] == -1 and grade[k][j] == -1:
                    grade[i][j] = -1
                    grade[j][i] = 1
    
    for i in range(1, n+1):
        count = 0
        for j in range(1, n+1):
            if grade[i][j] == 0:
                count += 1
        if count == 1:
            answer += 1
    
    return answer