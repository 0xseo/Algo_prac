def solution(enroll, referral, seller, amount):
    parent = {}
    money = {}
    answer = []
    
    for i, person in enumerate(enroll):
        parent[person] = referral[i]
        money[person] = 0
    
    for i, person in enumerate(seller):
        earn = amount[i] * 100
        cur = person
        while True:
            if earn == 0 or cur == '-':
                break
            pay = int(earn * 0.1)
            money[cur] += earn - pay
            earn = pay
            cur = parent[cur]
    
    for name in enroll:
        answer.append(money[name])
        
    return answer