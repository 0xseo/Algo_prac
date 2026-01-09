def solution(numbers):
    setA = set()
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            num = numbers[i] + numbers[j]
            setA.add(num)
    answer = sorted(list(setA))
    return answer