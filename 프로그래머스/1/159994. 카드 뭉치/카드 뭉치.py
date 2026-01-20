from collections import deque
def solution(cards1, cards2, goal):
    c1 = deque(cards1)
    c2 = deque(cards2)
    
    for word in goal:
        if c1:
            word1 = c1[0]
        else: 
            word1 = ""
        if c2:
            word2 = c2[0]
        else:
            word2 = ""
        if word1 != word and word2 != word:
            return "No"
        elif word1 == word:
            c1.popleft()
        elif word2 == word:
            c2.popleft()
    return "Yes"