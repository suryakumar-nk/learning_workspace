def generate_parenthesis(n: int) -> list[str]:
    result = []

    def create(left: int, right: int, res: str):
        if (left+right) == n*2:
            result.append(res)
            return
        if left < n:
            create(left+1, right, res+'(')
        if right < left:
            create(left, right+1, res+')')

    create(0, 0, '')
    return result


print(generate_parenthesis(5))
