import heapq
min_heap = []

def deleteNum(flag):
    if len(min_heap) > 0:
        if flag == -1: # 최솟값 삭제
            heapq.heappop(min_heap)
        else: 
            min_heap.sort()
            min_heap.pop() # 최댓값 삭제
            
def solution(operations):
    answer = []
    for operation in operations:
        oper, num = operation.split()
        num = int(num)
        if oper == 'I':
            heapq.heappush(min_heap, num)
        else:
            deleteNum(num)
            
    min_heap.sort()
    if min_heap:
        answer.append(min_heap[-1])
        answer.append(min_heap[0])
    else:
        answer.append(0)
        answer.append(0)

    return answer