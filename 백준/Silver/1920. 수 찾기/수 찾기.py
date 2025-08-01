import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

def binary_search(target, left, right):
    if left >= right:
        if arr[left] == target:
            print(1)
            return
        else:
            print(0)
            return
        
    mid = (left+right)//2
    if arr[mid] == target:
        print(1)
        return
    elif arr[mid] > target:
        binary_search(target, left, mid-1)
    else:
        binary_search(target, mid+1, right)

arr.sort()
for target in targets:
    binary_search(target, 0, len(arr)-1)