def solution(clothes):
    answer = 1
    d = dict()
    
    for arr in clothes:
        if arr[1] in d:
            d[arr[1]] += 1
        else:
            d[arr[1]] = 1
    
    for key in d:
        answer *= d[key] + 1
    return answer-1