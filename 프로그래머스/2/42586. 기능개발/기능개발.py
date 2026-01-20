import math
def solution(progresses, speeds):
    daysLeft = [0] * len(progresses)
    for i, p in enumerate(progresses):
        daysLeft[i] = math.ceil((100 - p) / speeds[i])
    
    curDay = -1
    answer = []
    for i, days in enumerate(daysLeft):
        if curDay < days:
            curDay = days
            answer.append(1)
        elif curDay >= days:
            answer[-1] += 1
    return answer