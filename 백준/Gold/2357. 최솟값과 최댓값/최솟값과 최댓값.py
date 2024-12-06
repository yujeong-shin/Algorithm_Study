import sys
import math
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []
for i in range(n):
    temp = int(input())
    arr.append(temp)

# 최솟값을 갖는 세그먼트 트리 초기화
treeHeight = math.ceil(math.log(n, 2)+1) # log(숫자, 밑) => log(2**2, 2) => log2 4
minSegTree = [0] * 2**treeHeight # 이진 트리 최대 노드 개수 : (2^h+1)-1
def minInit(start, end, idx):
    if start == end: # leaf node
        minSegTree[idx] = arr[start]
        return minSegTree[idx]
    
    mid = (start+end)//2
    minSegTree[idx] = min(minInit(start, mid, idx*2), minInit(mid+1, end, idx*2+1))
    return minSegTree[idx]

# 세그먼트 트리를 사용해 주어진 구간에 포함되는 최솟값 탐색
def minFind(start, end, left, right, idx):
    # start~end 범위에 포함되지 않는 경우
    if right < start or end < left:
        return sys.maxsize # 고려 대상에서 제외
    # 세그먼트 범위가 찾고자 하는 범위에 완전히 포함되는 경우
    if left <= start and end <= right:
        return minSegTree[idx]
    # 찾고자 하는 범위가 세그먼트 범위에 일부 존재하는 경우 => 반 나눠서 탐색 진행
    mid = (start+end)//2
    result = min(minFind(start, mid, left, right, idx*2), minFind(mid+1, end, left, right, idx*2+1))
    return result
    
# 최댓값을 갖는 세그먼트 트리 초기화
maxSegTree = [0] * 2**treeHeight # 이진 트리 최대 노드 개수 : (2^h+1)-1
def maxInit(start, end, idx):
    if start == end: # leaf node
        maxSegTree[idx] = arr[start]
        return maxSegTree[idx]
    
    mid = (start+end)//2
    maxSegTree[idx] = max(maxInit(start, mid, idx*2), maxInit(mid+1, end, idx*2+1))
    return maxSegTree[idx]

# 세그먼트 트리를 사용해 주어진 구간에 포함되는 최댓값 탐색
def maxFind(start, end, left, right, idx):
    # start~end 범위에 포함되지 않는 경우
    if right < start or end < left:
        return -sys.maxsize # 고려 대상에서 제외
    # 세그먼트 범위가 찾고자 하는 범위에 완전히 포함되는 경우
    if left <= start and end <= right:
        return maxSegTree[idx]
    # 찾고자 하는 범위가 세그먼트 범위에 일부 존재하는 경우 => 반 나눠서 탐색 진행
    mid = (start+end)//2
    result = max(maxFind(start, mid, left, right, idx*2), maxFind(mid+1, end, left, right, idx*2+1))
    return result

minInit(0, n-1, 1)
maxInit(0, n-1, 1)
for i in range(m):
    a, b = map(int, input().split())
    print(minFind(0, n-1, a-1, b-1, 1), maxFind(0, n-1, a-1, b-1, 1))