def solution(array, commands):
    answer = []
    for i, j, k in commands:
        tmp_arr = array[i-1:j]
        tmp_arr.sort()
        answer.append(tmp_arr[k-1])
    return answer