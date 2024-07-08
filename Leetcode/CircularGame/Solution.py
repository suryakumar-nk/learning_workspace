def find_the_winner(n: int, k: int) -> int:
    friends = [x for x in range(1, n + 1)]
    friends = [0] + friends
    i = 1
    n = len(friends)-1
    while n > 1:
        i += (k - 1)
        i = n if i % n == 0 else i % n if i > n else i
        friends.pop(i)
        n -= 1
    return friends[-1]


print(find_the_winner(5, 3))
