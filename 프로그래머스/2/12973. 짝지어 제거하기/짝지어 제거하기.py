def solution(s):
    top = ''
    stack = []
    for word in s:
        if top != word:
            stack.append(word)
            top = word
        else:
            stack.pop()
            if len(stack) > 0:
                top = stack[-1]
            else:
                top = ''
    answer = 0
    if len(stack) == 0:
        answer = 1
    return answer