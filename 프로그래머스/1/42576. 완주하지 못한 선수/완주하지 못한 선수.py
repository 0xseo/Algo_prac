def solution(participant, completion):
    part_dict = {}
    for p in participant:
        if p in part_dict.keys():
            part_dict[p] += 1
        else:
            part_dict[p] = 1
    for c in completion:
        if part_dict[c] > 1:
            part_dict[c] -= 1
        else:
            del part_dict[c]
    for person in part_dict.keys():
        return person
    # return 'answer'