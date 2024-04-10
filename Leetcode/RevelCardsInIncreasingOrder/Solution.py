def deckRevealedIncreasing(deck: list[int]) -> list[int]:
    deck.sort()
    n = len(deck)
    results = [0]*n
    indices = list(range(0, n))
    
    for i in range(0, n):
        results[indices[0]] = deck[i]
        if (i < (n-2)):
            indices = indices[2:]+[indices[1]]
        elif (i == (n-2)):
            indices = [indices[1]]
        else:
            indices = []
    return results

print(deckRevealedIncreasing([17,13,11,2,3,5,7]))