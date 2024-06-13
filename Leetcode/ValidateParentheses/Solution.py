def is_valid(s: str) -> bool:
    dic = {'(': ')', '{': '}', '[': ']'}
    stack = []
    for idx in s:
        if idx in '([{':
            stack.append(idx)
        elif len(stack) == 0 or idx != dic[stack.pop()]:
            return False
    return len(stack) == 0


print(is_valid("{[}]"))
