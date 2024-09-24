import sys

def dfs(num):
    global count, answer_count, anwer_list, answer_string

    if count > answer_count:
        return

    if num == 1:
        if count < answer_count:
            answer_count = count
            answer_string = ' '.join(map(str, answer_list))
        return

    if num % 3 == 0:
        count += 1
        answer_list.append(num // 3)
        dfs(num // 3)
        answer_list.pop()
        count -= 1

    if num % 2 == 0:
        count += 1
        answer_list.append(num // 2)
        dfs(num // 2)
        answer_list.pop()
        count -= 1

    count += 1
    answer_list.append(num - 1)
    dfs(num - 1)
    answer_list.pop()
    count -= 1

X = int(input())

count = 0
answer_count = sys.maxsize
answer_list = [X]
answer_string = ''
dfs(X)

print(answer_count)
print(answer_string)