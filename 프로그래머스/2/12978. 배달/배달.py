import heapq
def solution(N, road, K):
    # heapq.heappush(리스트, 값)
    # heapq.heappop(리스트)
    inf = 9e9
    graph = [[-1 for _ in range(N + 1)] for _ in range(N + 1)]
    
    dist = [inf] * (N+1)
    dist[1] = 0
    
    for edge in road:
        if graph[edge[0]][edge[1]] == -1:
            graph[edge[0]][edge[1]] = edge[2]
        else:
            graph[edge[0]][edge[1]] = min(graph[edge[0]][edge[1]], edge[2])
        if graph[edge[1]][edge[0]] == -1:
            graph[edge[1]][edge[0]] = edge[2]
        else:
            graph[edge[1]][edge[0]] = min(graph[edge[1]][edge[0]], edge[2])
    
    h = []
    heapq.heappush(h, (0, 1))
    
    while h:
        cost, node = heapq.heappop(h)

        for i, t in enumerate(graph[node]):
            if t == -1:
                continue
            if cost + t <= dist[i]:
                dist[i] = cost + t
                heapq.heappush(h, (cost + t, i))
    # print(dist)
    answer = 0
    for c in dist[1:]:
        if c <= K:
            answer += 1
