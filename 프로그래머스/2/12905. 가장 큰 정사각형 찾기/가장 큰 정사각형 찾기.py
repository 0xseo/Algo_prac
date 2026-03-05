def solution(board):
    n = len(board)
    m = len(board[0])
    dp = [[0] * m for i in range(n)]
    
    for i in range(n):
        for j in range(m):
            dp[i][j] = board[i][j]
    for y in range(1, n):
        for x in range(1, m):
            if board[y][x]:
                dp[y][x] = min(dp[y-1][x-1], dp[y-1][x], dp[y][x-1]) + 1
    return max(max(row) for row in dp) ** 2