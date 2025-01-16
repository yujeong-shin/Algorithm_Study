import sys
input = sys.stdin.readline

n = int(input())
dic = {}
for i in range(n):
    file_end = input().rstrip().split(".")[1]
    if not file_end in dic:
        dic[file_end] = 1
    else:
        dic[file_end] += 1
        
dic_to_list = []
for key in dic.keys():
    dic_to_list.append([key, dic.get(key)])
    
answers = sorted(dic_to_list, key=lambda x:x[0])
for answer in answers:
    print(*answer)