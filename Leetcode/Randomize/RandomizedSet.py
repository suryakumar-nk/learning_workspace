import random

class RandomizedSet:

    def __init__(self):
        self.a = []

    def insert(self, val: int) -> bool:
        if val in self.a:
            return False
        self.a.append(val)
        return True


    def remove(self, val: int) -> bool:
        if val not in self.a:
            return False
        self.a.remove(val)
        return True


    def getRandom(self) -> int:
        return random.choice(self.a)
        


# Your RandomizedSet object will be instantiated and called as such:
obj = RandomizedSet()
param_1 = obj.insert(1)
print(param_1)
param_2 = obj.remove(2)
print(param_2)
param_1 = obj.insert(2)
print(param_1)
print(obj.getRandom())
print(obj.getRandom())
param_1 = obj.insert(2)
print(param_1)