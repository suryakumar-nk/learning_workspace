def read():
    fh = open("InputOutput.py", "r")
    print(fh.read())

def exception():
    n = int(input())
    try:
        print(10/n)
    except ZeroDivisionError:
        print("enter number is zero.... try another number")
        exception()