import sys
input = sys.stdin.readline

dial = [
    ["A", "B", "C"], # 3초
    ["D", "E", "F"],
    ["G", "H", "I"],
    ["J", "K", "L"],
    ["M", "N", "O"],
    ["P", "Q", "R", "S"],
    ["T", "U", "V"],
    ["W", "X", "Y", "Z"]
]

s = input().rstrip()
answer = 0
for ch in s:
    for idx in range(len(dial)):
        temp_arr = dial[idx]
        if ch in temp_arr:
            answer = answer + (idx + 3)
print(answer)