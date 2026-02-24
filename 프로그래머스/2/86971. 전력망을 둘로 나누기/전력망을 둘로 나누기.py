import math
def solution(n, wires):
    def union(a, b):
        parents[find(a)] = parents[find(b)]
    def find(a):
        if parents[a] == a:
            return a
        parents[a] = find(parents[a])
        return parents[a]
    
    answer = set()
    
    for i, cutWire in enumerate(wires):
        parents = [i for i in range(n)]
        for j, w in enumerate(wires):
            if i == j:
                continue
            union(w[0]-1, w[1]-1)
        cnt = 0
        for k in range(n):
            if find(k) == find(0):
                cnt += 1
        answer.add(abs(n - 2*cnt))
        
    return min(answer)
        