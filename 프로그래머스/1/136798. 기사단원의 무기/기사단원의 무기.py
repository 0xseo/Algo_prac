import math
def solution(number, limit, power):
    answer = 0
    # 1. 약수 개수 = pws
    pws = []
    # 1.1. 소수 리스트 pn [false, true] to index sqrt(number)
    pn = [True for _ in range(int(math.sqrt(number))+1)]
    pn[0] = False
    pn[1] = False
    for i in range(2, len(pn)):
        if pn[i]:
            for j in range(i * 2, len(pn), i):
                pn[j] = False
        
    # 1.2. 소인수분해 하기
    pws.append(1)
        
    for num in range(2, number+1):
        cnt = 1
        d = 2
        n = num
        
        # n이 1이 아닌 수이면 소인수분해 필요
        while n > 1 and d < len(pn):
            e = 0
            # 소수로만 나눌 것임
            if pn[d]:
                while n % d == 0:
                    n //= d
                    e += 1
                cnt *= e+1
            d += 1
        # 남은 n이 여전히 소수이면
        if n > 1: cnt *= 2
        pws.append(cnt)
        
    
    # 2. if(limit < pws[i]) pws[i] = power
    # 3. power 합 구하기
    for i in range(number):
        if limit < pws[i]:
            answer += power
        else:
            answer += pws[i]
    return answer