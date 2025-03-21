def solution(people, limit):
    answer = 0
    people.sort()
    
    lt, rt = 0, len(people)-1
    while lt < rt:
        if people[lt] + people[rt] > limit:
            #answer += 1
            rt = rt-1
        else:
            answer += 1
            lt, rt = lt+1, rt-1
    
    answer = len(people) - (2*answer) + answer
    
    return answer