import sys
input = sys.stdin.readline

t = int(input())
unf = []

# def Find(v):
#     if unf[v] == v:
#         return v
#     else:
#         return Find(unf[v])

# def Union(a, b):
#     fa = Find(a)
#     fb = Find(b)
#     if fa != fb :
#         unf[fb] = fa
#     print(unf)

for _ in range(t):
    n = int(input())
    unf = [0] * (n + 1)
    for i in range(n+1):
        unf[i] = i

    for i in range(n-1):
        a, b = map(int, input().split())
        # print("a : " + str(a) + ", b : " + str(b))
        unf[b] = a
    
    node1, node2 = map(int, input().split())
    node1_parent_list = [node1]
    node2_parent_list = [node2]
    while unf[node1] != node1:
        node1_parent_list.append(unf[node1])
        node1 = unf[node1]
    # print(node1_parent_list)
    
    while unf[node2] != node2:
        node2_parent_list.append(unf[node2])
        node2 = unf[node2]
    # print(node2_parent_list)

    for parent in node2_parent_list:
        if parent in node1_parent_list:
            print(parent)
            break