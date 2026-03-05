def solution(strs, t):
    n = len(t)
    
    dp = [float("inf")] * (n+1)
    dp[0] = 0
    
    sizes = set(len(s) for s in strs)
    
    for i in range(1, n+1):
        for size in sizes:
            if size <= i and t[i-size:i] in strs:
                dp[i] = min(dp[i], dp[i-size]+1)
    return -1 if dp[-1] == float("inf") else dp[-1]
                
