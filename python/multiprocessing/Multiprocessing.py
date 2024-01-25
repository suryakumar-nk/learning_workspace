import multiprocessing
import threading

result = []

def square(arr):
    for i in arr:
        print("Square is", i*i)
        result.append(i*i)
    print("array inside the function", str(result))

print("WITHOUT MULTIPROCESSING")
arr = [1,2,3,4,5]
t1 = threading.Thread(target=square, args=(arr,))
t1.start()
t1.join()
print("array outside the function", str(result))
print()

print("AFTER MULTIPROCESSING")
result=[]
p1 = multiprocessing.Process(target=square, args=(arr,))
p1.start()
p1.join()
print("array outside the function", str(result))
