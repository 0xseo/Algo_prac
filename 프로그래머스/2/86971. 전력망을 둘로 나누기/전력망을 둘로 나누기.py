def solution(n, wires):
    def cnt_cons(cons):
        visited = [False] * (n+1)
        q = [1]
        while q:
            cur = q.pop()
            for i, com in enumerate(cons[cur]):
                if com == 0 or i == cur:
                    continue
                if com == 1 and not visited[i]:
                    q.append(i)
                    visited[i] = True
            # break

        # print(cnt)
        return sum(visited)
    cons = [[0] * (n+1) for _ in range(n+1)]
    answer = []
    
    for i, j in wires:
        cons[i][j] = 1
        cons[j][i] = 1
    for i, j in wires:
        cons[i][j] = 0
        cons[j][i] = 0
        
        answer.append(abs(2 * cnt_cons(cons) - n))
                      
        cons[i][j] = 1
        cons[j][i] = 1
        
    return min(answer)
    
