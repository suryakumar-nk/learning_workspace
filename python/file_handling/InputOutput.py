def maja():
    while(True):
        try:
            x = int(input("enter the num: "))
            print("the div is", 100/x)
        except ZeroDivisionError:
            print("The number should not be Zero 0")
        else:
            break