def solution(land):
    n = len(land)
    dp = [[land[0][i] for i in range(4)] for j in range(2)]
    
    for i in range(1,n):
        for j in range(4):
            dp[1][j] = max(dp[0][:j] + dp[0][j+1:]) + land[i][j]
        for j in range(4):
            dp[0][j] = dp[1][j]
        
            
    return max(dp[1])
    
    