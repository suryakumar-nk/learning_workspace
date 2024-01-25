import time
import threading

def square(arr):
    for i in arr:
        time.sleep(0.2)   # this weit time is to see the output of thread
        print("square of", i," is", i*i)

def cube(arr):
    for i in arr:
        time.sleep(0.2)   # this weit time is to see the output of thread
        print("cube of", i," is", i*i*i)

t = time.time()
arr = [1,2,3,4,5]
square(arr)
cube(arr)
print("Time taken without multi threading:", time.time() - t)
print()

t = time.time()
t1 = threading.Thread(target=square, args=(arr,))
t2 = threading.Thread(target=cube, args=(arr,))

t1.start()
t2.start()
# this join method will weit till the thred get completed
t1.join()
t2.join()

print("Time taken with multi threading:", time.time() - t)