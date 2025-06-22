import sys

li = list(True for _ in range(1000001))
li[0] = False
li[1] = False
for i in range(2, 1000001):
    if li[i]:
        for j in range(i * 2, 1000001, i):
            li[j] = False
        
T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    
    count = 0
    for i in range(2, N // 2 + 1):
        if (li[i] and li[N - i]):
            count += 1
            
    print(count)