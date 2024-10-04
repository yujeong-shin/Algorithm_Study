import sys
input =sys.stdin.readline

n = int(input())
sanggeon_cards = list(map(int, input().split()))
sanggeon_cards.sort()
m = int(input())
cards = list(map(int, input().split()))

def binarcy_sesarch(target, start, end):
    if start > end :
        return 0
    
    mid = (start+end)//2
    if sanggeon_cards[mid] == target:
        return 1
    elif sanggeon_cards[mid] > target:
        return binarcy_sesarch(target, start, mid-1)
    else:
        return binarcy_sesarch(target, mid+1, end)

for card in cards:
    result = binarcy_sesarch(card, 0, n-1)
    print(result, end=" ")