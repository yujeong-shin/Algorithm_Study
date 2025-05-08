import sys
input = sys.stdin.readline

def isTriangle(arr):
    flag = False
    arr.sort()
    if (arr[0] + arr[1]) > arr[2]:
        flag = True
    return flag

while True:
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break

    if a == b == c:
        print("Equilateral")
    elif a == b or b == c or a == c:
        arr = [a, b, c]
        if isTriangle(arr):
            print("Isosceles")
        else:
            print("Invalid")
    else:
        arr = [a, b, c]
        if isTriangle(arr):
            print("Scalene")
        else:
            print("Invalid")