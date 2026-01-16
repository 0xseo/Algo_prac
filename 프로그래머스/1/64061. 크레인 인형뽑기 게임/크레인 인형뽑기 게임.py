def solution(board, moves):
    N = len(board)
    cnt = [0] * (N)
    dolls = [[0] * (N) for _ in range(N)]
    
    for dolls in board:
        for i, doll in enumerate(dolls):
            if doll != 0:
                cnt[i] += 1
    stack = []
    answer = 0
    for i, move in enumerate(moves):
        if cnt[move-1] == 0:
            continue
        doll = board[N-cnt[move-1]][move-1]
        board[N-cnt[move-1]][move-1] = 0
        cnt[move-1] -= 1
        if len(stack) == 0:
            stack.append(doll)
        elif stack[-1] == doll:
            stack.pop()
            answer += 1
        else:
            stack.append(doll)
    return 2*answer