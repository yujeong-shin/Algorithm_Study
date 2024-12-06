import sys
import math
input = sys.stdin.readline

n, m, k = map(int, input().split())
arr = []
for i in range(n):
    temp = int(input())
    arr.append(temp)

# 세그먼트 트리 초기화
treeHeight = math.ceil(math.log(n, 2)+1) # log(숫자, 밑) => log(2**2, 2) => log2 4
segTree = [0] * 2**treeHeight # 이진 트리 최대 노드 개수 : (2^h+1)-1
def init(start, end, idx):
    if start == end: # leaf node
        segTree[idx] = arr[start]
        return segTree[idx]
    
    mid = (start+end)//2
    segTree[idx] = init(start, mid, idx*2) + init(mid+1, end, idx*2+1)
    return segTree[idx]

# 세그먼트 트리를 사용해 구간 합 탐색
def sumFind(start, end, left, right, idx):
    if right < start or end < left:
        return 0
    if left <= start and end <= right:
        return segTree[idx]
    
    mid = (start+end)//2
    result = sumFind(start, mid, left, right, idx*2) + sumFind(mid+1, end, left, right, idx*2+1)
    return result

def modifySegTree(start, end, idx, modified_idx, diff):
    if start == end:
        segTree[idx] += diff
        return
    
    segTree[idx] += diff
    mid = (start+end)//2
    if modified_idx <= mid:
        modifySegTree(start, mid, idx*2, modified_idx, diff)
    else:
        modifySegTree(mid+1, end, idx*2+1, modified_idx, diff)
    segTree[idx] = segTree[idx * 2] + segTree[idx * 2 + 1]  # 부모 노드 업데이트
        
init(0, n-1, 1)
for i in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1: # modify
        diff = c - arr[b-1]
        arr[b - 1] = c
        modifySegTree(0, n-1, 1, b-1, diff)
    else: # print result
        print(sumFind(0, n-1, b-1, c-1, 1))