import sys
input = sys.stdin.readline

n, k = map(int, input().split())
cards = list(map(int, input().split()))
d = list(map(int, input().split()))

for cnt in range(k):
    temp = [0]*n
    for i in range(len(d)):
        temp[d[i]-1] = cards[i]
    cards = temp[:]
print(*cards)