def solution(record):
    members = {}
    for rec in record:
        code = rec.split()[0]
        uid = rec.split()[1]
        if code != "Leave":
            members[uid] = rec.split()[2]
    
    answer = []
    for rec in record:
        code = rec.split()[0]
        uid = rec.split()[1]
        if code == "Enter":
            answer.append(members[uid] + "님이 들어왔습니다.")
        elif code == "Leave":
            answer.append(members[uid] + "님이 나갔습니다.")
    return answer