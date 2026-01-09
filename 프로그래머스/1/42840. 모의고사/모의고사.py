def solution(numbers):
    score = [0] * 3
    patA = [1, 2, 3, 4, 5]
    patB = [2, 1, 2, 3, 2, 4, 2, 5]
    patC = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    patterns = [patA, patB, patC]
    for idx, ans in enumerate(numbers):
        for person, pat in enumerate(patterns):
            if (pat[idx % len(pat)] == ans):
                score[person]+=1
                
    mx = max(score)
    answer = []
    for i, sc in enumerate(score):
        if sc == mx:
            answer.append(i+1)
        
    return answer