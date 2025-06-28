import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
num = [n for n in range(1, n+1)]
inorder = list(map(int, input().split()))
postorder = list(map(int, input().split()))
# enumerate : 순서가 있는 자료형(list, set, tuple, dictionary, string)을 입력으로 받았을 때, 인덱스와 값을 포함하여 리턴
inorder_idx = {value: index for index, value in enumerate(inorder)}

def build_preorder(in_l, in_r, post_l, post_r):
    if in_l > in_r or post_l > post_r:
        return
    
    root_num = postorder[post_r]
    print(root_num, end=" ")
    root_idx = inorder_idx[root_num] # 현재 루트노드의 중위순회 인덱스
    left_size = root_idx - in_l # 왼쪽 서브트리의 크기, 다음 post 순회를 위한 아주아주 중요한 변수

    '''
    return 루트 노드 +    
            build_preorder(왼쪽 서브트리의 중위순회 범위, 왼쪽 서브트리의 후위순회 범위)
            build_preorder(오른쪽 서브트리의 중위순회 범위, 오른쪽 서브트리의 후위순회 범위)

    중위순회 범위 : 현재 루트노드의 인덱스 기준으로 -1, +1
                                      root
                                       ↓
                    [   4,   2,   5,   1,   3]
                       ↓   ↓   ↓            ↓           
                      왼쪽 서브트리       오른쪽 서브트리

    후위순회 범위 :  post_l                            post_r
                    ↓                                 ↓
                    [왼쪽 서브트리] [오른쪽 서브트리] [루트]
                                  ↑
                     ★  post_l + lift_size-1
    '''

    build_preorder(in_l, root_idx-1, post_l, post_l+left_size-1)
    build_preorder(root_idx+1, in_r, post_l+left_size, post_r-1)

ans = build_preorder(0, n-1, 0, n-1)