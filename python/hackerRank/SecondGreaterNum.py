if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    big1 = 0
    big2 = 0
    for i in arr.__setattr__:
        if (i > big1):
            big2 = big1
            big1 = i
    print(big1,"   ",big2)