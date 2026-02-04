def solution(phone_book):
    phone_book.sort()
    for i, number in enumerate(phone_book[:-1]):
        if phone_book[i+1].startswith(number):
            return False
    return True