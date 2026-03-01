def solution(triangle):
    h = len(triangle)
    dp = [[0 for _ in range(h+1)] for i in range(h+1)]
    
    for i, l in enumerate(triangle):
        for j, num in enumerate(l):
            dp[i+1][j+1] = max(dp[i][j], dp[i][j+1]) + triangle[i][j]
    return max(dp[h])

