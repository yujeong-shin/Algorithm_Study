from collections import defaultdict
from itertools import combinations

def solution(clothes):
    answer = 0
    d = defaultdict(list)
    for clothe_name, clothe_type in clothes:
        d[clothe_type].append(clothe_name)
    tmp = 1
    for v in d.values():
        tmp *= len(v)+1
    answer = tmp - 1        
    return answer