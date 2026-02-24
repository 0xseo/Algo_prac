def solution(n, computers):
    def union(a, b):
        parents[find(a)] = find(b)

    def find(a):
        if parents[a] == a:
            return a
        parents[a] = find(parents[a])
        return parents[a]
    
    stack = [0]
                    
    parents = [i for i in range(n)]
    
    for i, connection in enumerate(computers):
        for j, state in enumerate(connection):
            if i != j and state == 1:
                if find(i) != find(j):
                    union(i, j)
    
    cons = set()
    for i in range(n):
        if find(i) not in cons:
            cons.add(find(i))
    return len(cons)