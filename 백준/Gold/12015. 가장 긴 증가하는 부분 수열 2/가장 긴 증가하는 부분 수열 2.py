import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

# 이분탐색 : 수가 들어갈 수 있는 위치 탐색
def binary_search(target):
    # print("==================")
    # print("target: " + str(target))
    if len(sorted_arr) == 0: # 비어있는 수열이라면 아묻따 추가
        sorted_arr.append(target)
        return
    
    if sorted_arr[-1] < target:
        sorted_arr.append(target) # 현재 숫자가 정렬된 수열의 가장 큰 값보다 크면 끝에 추가
        return
    
    # sorted_arr 수열에서 현재 숫자가 들어갈 자리에 나보다 큰 수가 있다면 나로 덮어쓰기
    # 1 2 4 3 의 경우 1 2 3으로 만들어 짐
    left = 0
    right = len(sorted_arr)-1
    while(left < right):
        mid = (left+right)//2
        # print("left: " + str(left) + ", right: " + str(right) + ", mid: " + str(mid))
        if sorted_arr[mid] < target: # 찾는 수가 mid 위치의 수보다 크다면 범위를 우측으로 조정
            left = mid+1
        else:                        # 찾는 수가 mid 위치의 수보다 작거나 같다면 범위를 좌측으로 조정
            right = mid
    sorted_arr[right] = target
        
sorted_arr = []
for num in arr:
    binary_search(num)
# print(sorted_arr)
print(len(sorted_arr))