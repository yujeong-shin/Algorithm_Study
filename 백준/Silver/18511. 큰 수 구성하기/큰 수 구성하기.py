import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))
result = -sys.maxsize

def DFS(num):
    global result
    if num > N :
        return
    else :
        result = max(result, num)
        for j in arr :
            next_num = num*10 + j
            DFS(next_num)

for i in arr :
    DFS(i)

print(result)