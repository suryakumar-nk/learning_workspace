def max_profit_assignment(difficulty, profit, workers) -> int:
    max_diff = max(difficulty)
    profit_up_to_diff = [0] * (max_diff + 1)

    for d, p in zip(difficulty, profit):
        profit_up_to_diff[d] = max(profit_up_to_diff[d], p)

    for i in range(1, max_diff + 1):
        profit_up_to_diff[i] = max(profit_up_to_diff[i], profit_up_to_diff[i - 1])

    profit = 0
    for worker in workers:
        if worker > max_diff:
            profit += profit_up_to_diff[max_diff]
        else:
            profit += profit_up_to_diff[worker]

    return profit


print(max_profit_assignment([2, 4, 6, 8, 10], [10, 20, 30, 40, 50], [4, 5, 6, 7]))
