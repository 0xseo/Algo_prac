from itertools import combinations
from collections import Counter

def solution(orders, course):
    answer = []
    for cnt in course:
        menu = []
        for person in orders:
            menu += combinations(sorted(person), cnt)
        counter = Counter(menu)
        if len(counter) > 0:
            maxx = max(counter.values())
            if maxx < 2:
                continue
            for c in counter.keys():
                if counter[c] == maxx:
                    answer.append("".join(c))
    return sorted(answer)