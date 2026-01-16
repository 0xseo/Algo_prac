def solution(n, k, cmd):
    stack = []
    DLL = [[i-1, i+1] for i in range(-1, n+2)]
    curr = k
    # print(DLL, curr)
    for c in cmd:
        if c[0] == 'U':
            x = int(c.split()[1])
            for i in range(x):
                if DLL[curr+1][0] == -1:
                    break
                curr = DLL[curr+1][0]
        elif c[0] == 'D':
            x = int(c.split()[1])
            for i in range(x):
                if DLL[curr+1][1] == n:
                    break
                curr = DLL[curr+1][1]
        elif c[0] == 'C':
            DLL[DLL[curr+1][1]+1][0] = DLL[curr+1][0]
            DLL[DLL[curr+1][0]+1][1] = DLL[curr+1][1]
            stack.append(curr)
            # if DLL[DLL[curr+1][1]+1][0] == -1:
            #     curr += 1
            if DLL[DLL[curr+1][0]+1][1] == n:
                curr = DLL[curr+1][0]
            else:
                curr = DLL[curr+1][1]
        else:
            restore = stack.pop()
            DLL[DLL[restore+1][0]+1][1] = restore
            DLL[DLL[restore+1][1]+1][0] = restore
        # print(curr, stack)
    answer = ["O"] * n
    for i in stack:
        answer[i] = "X"
    return "".join(answer)