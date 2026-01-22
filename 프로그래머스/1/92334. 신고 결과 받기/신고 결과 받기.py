def solution(id_list, report, k):
    answer = []
    reportedCntByReportedId = {}
    reporterListByReportedId = {}
    mailCntById = {}
    
    for i in id_list:
        reportedCntByReportedId[i] = 0
        reporterListByReportedId[i] = set()
        mailCntById[i] = 0
    
    for r in report:
        reporter = r.split()[0]
        reported = r.split()[1]
        
        if reporter not in reporterListByReportedId[reported]:
            reportedCntByReportedId[reported] += 1
            reporterListByReportedId[reported].add(reporter)
    
    stoppedUser = []
    for user in id_list:
        if reportedCntByReportedId[user] >= k:
            stoppedUser.append(user)
    
    for user in stoppedUser:
        for reporter in list(reporterListByReportedId[user]):
            mailCntById[reporter] += 1
    
    for user in id_list:
        answer.append(mailCntById[user])
        
    return answer