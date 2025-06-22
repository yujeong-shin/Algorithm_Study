import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
cards = list(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

d = defaultdict(int)
for card in cards:
    d[card] += 1

for target in targets:
    if target in d.keys():
        print(str(d[target]), end=" ")
    else:
        print("0", end=" ")