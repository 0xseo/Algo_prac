def solution(arr1, arr2):
    row1 = len(arr1)
    col1 = len(arr1[0])
    row2 = len(arr2)
    col2 = len(arr2[0])
    
    answer = [[0] * col2 for i in range(row1)]
    
    for r in range(row1):
        for c in range(col2):
            for i in range(col1):
                answer[r][c] += arr1[r][i] * arr2[i][c]
    return answer