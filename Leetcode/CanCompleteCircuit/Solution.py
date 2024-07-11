def can_complete_circuit(gas: list[int], cost: list[int]) -> int:
    n, total_surplus, surplus, start = len(gas), 0, 0, 0

    for i in range(n):
        total_surplus += gas[i] - cost[i]
        surplus += gas[i] - cost[i]
        if surplus < 0:
            surplus = 0
            start = i + 1
    return -1 if (total_surplus < 0) else start


print(can_complete_circuit([1, 2, 3, 4, 5], [2, 3, 4, 5, 1]))
print(can_complete_circuit([4, 5, 3, 1, 4], [5, 4, 3, 4, 2]))
print(can_complete_circuit([4, 5, 2, 6, 5, 3], [3, 2, 7, 3, 2, 9]))
