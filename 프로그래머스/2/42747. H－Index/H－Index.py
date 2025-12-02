def solution(citations):
    answer = 0
    citations.sort()
    for i in range(1, len(citations)+1):
        h = i
        count = 0
        for j in range(len(citations)):
            if citations[j] >= h:
                count += 1
        if count >= h:
            answer = max(answer, i)
    return answer