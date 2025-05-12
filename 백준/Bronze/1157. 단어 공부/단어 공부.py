import sys
from collections import defaultdict
input = sys.stdin.readline

word = input().rstrip()
WORD = word.upper()
d = defaultdict(int)

for ch in WORD:
    d[ch] = d[ch] + 1

max_value = -1
for cnt in d.values():
    max_value = max(max_value, cnt)

arr = []
for k, v in d.items():
    if v == max_value:
        arr.append(k)

if len(arr) <= 1:
    print(arr[0])
else:
    print("?")