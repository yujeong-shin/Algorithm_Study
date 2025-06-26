import sys
input = sys.stdin.readline

n = int(input())
k = (2**n)-1 

def hanoi(n, start, end, mid):
    if n == 1: # 원판 하나 옮기는 경우라면 발판 생각하지 않고 그냥 옮김
        print(start, end)
        return
    
    #Step 1. n-1개의 원판을 end를 거쳐 start에서 mid로 이동
    hanoi(n-1, start, mid, end)
    #Step 2. n번째 크기의 원판을 end 위치로 이동
    print(start, end)
    #Step 3. mid로 옮겨 두었던 n-1개의 원판을 start를 거쳐 end로 이동
    hanoi(n-1, mid, end, start)
    
print(k)
hanoi(n, 1, 3, 2)