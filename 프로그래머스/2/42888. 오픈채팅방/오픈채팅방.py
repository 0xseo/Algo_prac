def solution(record):
    user = {}
    answer = []
    pr = {"Enter" : "님이 들어왔습니다.", "Leave": "님이 나갔습니다."}
    
    for rec in record:
        if 'Leave' in rec:
            continue
        cmd = rec.split()
        user[cmd[1]] = cmd[2]
    # print(user)
        
    for rec in record:
        if 'Change' in rec:
            continue
        answer.append(user[rec.split()[1]] + pr[rec.split()[0]])
        
    return answer
    
    
