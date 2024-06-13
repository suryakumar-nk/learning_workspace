def isNStraightHand(hand: list[int], groupSize: int) -> bool:
    n = len(hand)
    if n % groupSize != 0:
        return False
    hand.sort()
    for i in range(n):
        if hand[i] >= 0:
            next = hand[i] + 1
            hand[i] = -1
            count = 1
            i += 1
            while i < n and count < groupSize:
                if hand[i] == next:
                    next = hand[i] + 1
                    hand[i] = -1
                    count += 1
                i += 1
            if not count == groupSize:
                return False
    return True

print(isNStraightHand([1,2,3,6,2,3,4,7,8], 3))