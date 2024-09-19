n, d, k, c = map(int, input().split())
plate = []
plate = [int(input()) for _ in range(n)]
max_sushi = 0

lt = 0
rt = -1
arr = []
while(lt < n):
    if(rt-lt==k-1):
        sushi_count = len(set(arr))
        if not c in arr:
            sushi_count += 1
        max_sushi = max(max_sushi, sushi_count)
        del arr[0]
        lt += 1
    else:
        rt += 1
        arr.append(plate[rt%n])
print(max_sushi)