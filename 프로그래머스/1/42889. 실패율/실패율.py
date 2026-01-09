def solution(N, stages):
    total = len(stages)
    reachUser = [0] * (N+2)
    failure = {}
    for stage in stages:
        reachUser[stage] += 1
    
    for stage in range(1, N+1):
        if reachUser[stage] == 0:
            failure[stage] = 0
        else:
            
            if total == 0:
                break
            failure[stage] = reachUser[stage] / total
            total -= reachUser[stage]
            
    
    answer = sorted(failure, key=lambda x : failure[x], reverse=True)
    # print(answer)
    return answer