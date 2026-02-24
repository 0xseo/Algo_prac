import heapq
def solution(N, road, K):
    # heapq.heappush(리스트, 값)
    # heapq.heappop(리스트)
    inf = 9e9
    hq = []
    distances = [inf for _ in range(N+1)]
    distances[1] = 0
    canGo = [[] for _ in range(N+1)]
    
    for s, e, c in road:
        canGo[s].append([e, c])
        canGo[e].append([s, c])
        
    for togo in canGo[1]:
        heapq.heappush(hq, togo)
    
    answer = 0
    
    while hq:
        togo = heapq.heappop(hq)
        if distances[togo[0]] > togo[1]:
            distances[togo[0]] = togo[1]
            for nextGo, nextCost in canGo[togo[0]]:
                heapq.heappush(hq, [nextGo, nextCost + distances[togo[0]]])
    
    for d in distances:
        if d <= K:
            answer += 1
        
        
    return answer