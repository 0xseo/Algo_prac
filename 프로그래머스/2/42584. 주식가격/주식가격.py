def solution(prices):
    answer = []
    for i, now in enumerate(prices):
        time = 0
        for j in range(i+1, len(prices)):
            time += 1
            if prices[j] < now:
                break
        answer.append(time)
    return answer