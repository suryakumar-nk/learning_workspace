class MinStack:
    __a=[]
    def __init__(self):
        self.__a = []

    def push(self, val: int) -> None:
        self.__a.append(val)

    def pop(self) -> None:
        self.__a[-1]
        self.__a = self.__a[0:-1]

    def top(self) -> int:
        return self.__a[-1]

    def getMin(self) -> int:
        return min(self.__a)

m = MinStack()
print(m.push(4))
print(m.push(8))
print(m.getMin())
print(m.top())
print(m.pop())
print(m.top())

