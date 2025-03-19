import sys
input = sys.stdin.readline

n, s = map(int, input().split())
arr = list(map(int, input().split()))
answer = 0
visited = [False]*len(arr)

def dfs(start, L, _sum):
    global answer
    if start >= n:
        return
    for i in range(start, len(arr)):
        if not visited[i]:
            visited[i] = True
            _sum += arr[i]
            if _sum == s:
                answer += 1
            dfs(i+1, L+1, _sum)
            visited[i] = False
            _sum -= arr[i]

dfs(0, 0, 0)
print(answer)