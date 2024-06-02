s = ["H","a","n"," ","a","n","a","h"]
n = len(s)
for i in range(0, (n//2)):
    s[i], s[n-i-1] = s[n-i-1], s[i]
print(s)