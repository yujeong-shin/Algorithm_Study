import sys
input = sys.stdin.readline

n, m = map(int, input().split())
unf = [0]
for i in range(n+1):
    unf.append(i+1)

def Union(a, b):
    fa = Find(a)
    fb = Find(b)
    if fa != fb:
        unf[fa] = fb
def Find(v):
    if unf[v] == v:
        return v
    else:
        unf[v] = Find(unf[v])
        return unf[v]

for _ in range(m):
    oper, a, b = map(int, input().split())
    if oper == 0:
        if a == b:
            continue
        else:
            Union(a, b)
    else:
        if a == b:
            print("YES")
        else:
            if Find(a) == Find(b):
                print("YES")
            else:
                print("NO")