import heapq
def solution(n, costs):
    answer = 0
    reachable = [[] for _ in range(n)]
    
    for edge in costs:
        reachable[edge[0]].append((edge[1], edge[2]))
        reachable[edge[1]].append((edge[0], edge[2]))
        
    connected = set()
    pq = [(0, 0)]
    
    while True:
        if len(connected) == n:
            break
            
        cost, node = heapq.heappop(pq)
        if node in connected:
            continue

        connected.add(node)
        answer += cost

        for next_node, next_cost in reachable[node]:
            if next_node not in connected:
                heapq.heappush(pq, (next_cost, next_node))
                
    return answer
