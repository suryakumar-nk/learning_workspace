def min_moves_to_seat(seats: list[int], students: list[int]) -> int:
    count = 0
    students.sort()
    seats.sort()
    for i in range(len(seats)):
        count += abs(seats[i] - students[i])
    return count


print(min_moves_to_seat([12,14,19,19,12], [19,2,17,20,7]))
