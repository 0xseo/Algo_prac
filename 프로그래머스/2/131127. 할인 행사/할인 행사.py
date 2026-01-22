
def solution(want, number, discount):
    wantToBuy = {}
    for i, w in enumerate(want):
        wantToBuy[w] = number[i]
    day = 0
    dayCnt = 0
    discounted = {}
    for i, d in enumerate(discount):
        if i >= 10:
            break
        if d in discounted.keys():
            discounted[d] += 1
        else:
            discounted[d] = 1
    
    answer = 0
    for eachDay in range(len(discount) - 9):
        flag = True
        for w in wantToBuy.keys():
            if w not in discounted.keys() or wantToBuy[w] > discounted[w]:
                flag = False
                break
        if flag:
            answer += 1
        if eachDay == len(discount) - 10:
            break
        discounted[discount[eachDay]] -= 1
        if discount[eachDay + 10] in discounted.keys():
            discounted[discount[eachDay + 10]] += 1
        else:
            discounted[discount[eachDay + 10]] = 1
        
    return answer