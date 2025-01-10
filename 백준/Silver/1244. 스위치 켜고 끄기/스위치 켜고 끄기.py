import sys
input = sys.stdin.readline

light_num = int(input())
lights = list(map(int, input().split()))
lights.insert(0, 0)
cnt = int(input())

def swap(num):
    global lights
    lights[num] = 1 - lights[num]
        
for i in range(cnt):
    sex, num = map(int, input().split())
    if sex == 1:
        for idx in range(1, len(lights)):
            if idx % num == 0:
                swap(idx)
    else:
        swap(num)
        range_cnt = 1
        while(True):
            lt = num-range_cnt
            rt = num+range_cnt
            if lt <= 0 or rt >= len(lights):
                break
            else:
                if lights[lt] == lights[rt]:
                    swap(lt)
                    swap(rt)
                    range_cnt += 1
                else:
                    break
                    
lights = lights[1:] # 처음에 추가한 0번째 원소 삭제
start_idx = 0
print_range = 20
while(True):
    end_idx = start_idx + print_range
    if end_idx < len(lights):
        print(*lights[start_idx:end_idx])
        start_idx = end_idx
    else:
        print(*lights[start_idx:len(lights)])
        break