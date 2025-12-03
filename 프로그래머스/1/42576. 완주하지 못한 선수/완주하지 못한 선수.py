from collections import defaultdict

def solution(participant, completion):
    answer = ''
    d = defaultdict(int)
    for p in participant:
        d[p] += 1
        
    for c in completion:
        d[c] -= 1
        if d[c] == 0:
            d.pop(c)
    
    for name, count in d.items():
        answer = name
        # for c in range(count):
        #     answer.append(name)
    
    return answer