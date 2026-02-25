def solution(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    
    dp = [1 for _ in range(n+1)]
    for i in range(2, n+1):
        dp[i] = (dp[i-1] + dp[i-2] ) % 1000000007
    
    return dp[n]
        