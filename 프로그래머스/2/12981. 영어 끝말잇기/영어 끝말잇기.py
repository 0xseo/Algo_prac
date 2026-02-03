def solution(n, words):
    alphabet = words[0][0]
    wordSet = set()
    
    for i, word in enumerate(words):
        if word[0] == alphabet and word not in wordSet:
            alphabet = word[-1]
            wordSet.add(word)
        else:
            return [i % n + 1, i // n + 1]
    return [0, 0]