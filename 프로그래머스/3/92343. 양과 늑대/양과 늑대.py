from collections import deque

def solution(info, edges):
    def build_tree(edges):
        tree = [[] for _ in range(len(info))]
        for edge in edges:
            tree[edge[0]].append(edge[1])
        return tree
    
    tree = build_tree(edges)
    
    max_sheep = 0
#     (현재위치, 양, 늑대, canGo)
    q = deque([(0, 1, 0, set())])
    
    while q:
        current, sheep, wolf, canGo = q.popleft()
        max_sheep = max(sheep, max_sheep)
        canGo.update(tree[current])
#         tree에 기반하여 canGo에 자식 노드들 추가

        for next_location in canGo:
            if info[next_location]:
#                 늑대이면
                if sheep > wolf + 1:
                    q.append((next_location, sheep, wolf+1, canGo - {next_location}))
            else:
                q.append((next_location, sheep+1, wolf, canGo - {next_location}))

    answer = max_sheep
    return answer