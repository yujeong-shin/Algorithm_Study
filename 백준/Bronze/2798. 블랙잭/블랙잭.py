import sys
input = sys.stdin.readline

n, m = map(int, input().split())
cards = list(map(int, input().split()))

answer = 0
for i in range(0, len(cards)-2):
    for j in range(i+1, len(cards)-1):
        for k in range(j+1, len(cards)):
            temp = cards[i] + cards[j] + cards[k]
            if temp <= m:
                if m - temp < m - answer:
                    answer = temp
print(answer)