import sys
input = sys.stdin.readline

target = int(input())

teduri_num = 0
house_num = 1

while house_num < target:
    teduri_num += 1
    add_num = teduri_num*6
    house_num = house_num + add_num
print(teduri_num + 1)