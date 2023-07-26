class MaxHeap:
    def __init__(self, v = []):
        self.size = 0
        self.value = []
        if (type(v) == list):
            for i in v:
                self.insert(i)
        else:
            self.value = [v]

    def getArray(self):
        return self.value

    def showTreeStructure(self):
        i = 0
        l = 1
        while(i < self.size):
            print(self.value[i],end=" ")
            if (i == pow(2,l)-2):
                print("\n")
                l = l+1
            i = i+1
    
    def insert(self, v):
        if (type(v) == int):
            v = [v]
        for i in v:
            self.value.append(i)
            self.size = self.size + 1
            self.sort()

    def sort(self):
        i = self.size - 1
        while (i > 0):
            if (i%2 == 0):
                j = (i-2)//2
            else:
                j = (i-1)//2
            if (self.value[i] > self.value[j]):
                self.value[i], self.value[j] = self.value[j], self.value[i]
                i = j
            else:
                i = 0


# b = MaxHeap([5,3,67,44,36,56,7,454,56,344,69,6,335])
b = MaxHeap([1,2,3,4,5,6,7])
print(b.showTreeStructure())
print(b.getArray())
b.insert(3)
b.insert(3)
b.insert([4,5,6,17,3,2])
print(b.showTreeStructure())
