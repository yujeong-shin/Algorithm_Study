def solution(word):
    alpha = ['A', 'E', 'I', 'O', 'U']
    answer = 0
    found = False  # 목표 단어를 찾으면 전체 종료. 더 이상 탐색X

    def dfs(cur_str):
        nonlocal answer, found
        if cur_str == word:
            found = True
            return
        if len(cur_str) == 5:
            return
        
        for a in alpha:
            if found:
                return
            answer += 1
            dfs(cur_str + a)

    dfs('')
    return answer