import sys
input = sys.stdin.readline

cur_left, cur_right = input().split()
typing_words = list(input().strip())
key_board = [['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'], ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'], ['z', 'x', 'c', 'v', 'b', 'n', 'm']]
left = ['q', 'w', 'e', 'r', 't', 'a', 's', 'd', 'f', 'g', 'z', 'x', 'c', 'v']

def calc(ch1, ch2):
    x1, y1, x2, y2 = 0, 0, 0, 0
    for x in range(len(key_board)):
        for y in range(len(key_board[x])):
            if key_board[x][y] == ch1:
                x1, y1 = x, y
            elif key_board[x][y] == ch2:
                x2, y2 = x, y
    dis = abs(x1-x2) + abs(y1-y2)
    return dis

answer = 0
for word in typing_words:
    if word in left:
        if word == cur_left:
            answer += 1
        else:
            answer += (calc(word, cur_left) + 1)
            cur_left = word
    else:
        if word == cur_right:
            answer += 1
        else:
            answer += (calc(word, cur_right) + 1)
            cur_right = word
print(answer)