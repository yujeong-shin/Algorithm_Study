import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split())
plate = []
for i in range(n):
    plate.append(int(input()))
max_count = 0

sushi_count_list = [0] * (d+1)
sushi_count_list[c] = 1

count = 1
for i in range(0, k):
    sushi_count_list[plate[i]] += 1
    if sushi_count_list[plate[i]] == 1:
        count += 1
max_count = count

for i in range(k, n+k-1):
    sushi_count_list[plate[i-k]] -= 1
    if sushi_count_list[plate[i-k]] == 0:
        count -= 1
        
    sushi_count_list[plate[i%n]] += 1
    if sushi_count_list[plate[i%n]] == 1:
        count += 1
        
    max_count = max(max_count, count)
print(max_count)