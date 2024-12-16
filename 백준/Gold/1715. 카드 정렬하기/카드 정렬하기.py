import sys
import heapq
input = sys.stdin.readline

n = int(input())
cards = []

for i in range(n):
    cards.append(int(input()))
    #heapq.heappush(cards, int(input()))
heapq.heapify(cards)

result = 0
while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    temp = a + b
    
    result += temp
    heapq.heappush(cards, temp)
print(result)


#for i in range(n):
#    temp = int(input())
#    cards.append(temp)
#cards.sort()

#dp = [0] * n
#dp[1] = cards[0] + cards[1]
#if n >= 2:
#    for i in range(2, n):
#        dp[i] = dp[i-1] + cards[i]
#print(sum(dp))