def solution(a, b):
    answer = 0
    if a == b:
        return a
    temp = max(a, b)
    a = min(a, b)
    b = temp
    for i in range(a, b):
        answer += i
    return answer+b