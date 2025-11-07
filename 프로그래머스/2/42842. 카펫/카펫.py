def solution(brown, yellow):
    by = brown + yellow
    arr = []
    for i in range(1, by):
        if by % i == 0:
            arr.append(i)
    
    for row in arr:
        for col in arr:
            if row * col == by and row >= col:
                if (row-2) * (col-2) == yellow:
                    return [row, col]