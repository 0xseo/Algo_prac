def solution(nums):
    s = set(nums)
    if len(s) <= len(nums) // 2:
        return len(s)
    else:
        return len(nums) // 2