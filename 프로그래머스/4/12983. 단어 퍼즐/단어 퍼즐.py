def solution(strs, t):
    sizes = set([len(str) for str in strs])
    inf = 9e9
    dp = [inf] * (len(t)+1)
    dp[0] = 0
    
    for i in range(1, len(t)+1):
        word = t[:i]
        for s in sizes:
            if s > i:
                continue
            if word[i-s:] in strs:
                dp[i] = min(dp[i], dp[i-s] + 1)
    if dp[-1] != inf:
        return dp[-1]
    
    return -1
                