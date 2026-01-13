def solution(s):
    answer = 0
    for i in range(len(s)):
        stack = []
        word = s[i:] + s[:i]
        flag = True
        for w in word:
            if w == '[' or w == '{' or w == '(':
                stack.append(w)
            else:
                if len(stack) == 0:
                    flag = False
                    break
                toCheck = stack.pop()
                if w == ']' and toCheck == '[':
                    continue
                if w == '}' and toCheck == '{':
                    continue
                if w == ')' and toCheck == '(':
                    continue
                else:
                    flag = False
                    break
        if flag and len(stack) == 0:
            answer += 1
    return answer