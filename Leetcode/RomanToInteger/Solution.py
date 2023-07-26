from datetime import datetime

class Solution:
    def romanToInt(self, s: str) -> int:
        i = 0
        value = 0
        while (i<len(s)):
            print(i,"   ",s[i])
            if ((len(s) - i) >= 2):
                if (s[i] == 'I' and s[i+1] == 'V'):
                    value = value + 4
                    i = i+2
                    continue
                elif (s[i] == 'I' and s[i+1] == 'X'):
                    value = value + 9
                    i = i+2
                    continue
                elif (s[i] == 'X' and s[i+1] == 'L'):
                    value = value + 40
                    i = i+2
                    continue
                elif (s[i] == 'X' and s[i+1] == 'C'):
                    value = value + 90
                    i = i+2
                    continue
                elif (s[i] == 'C' and s[i+1] == 'D'):
                    value = value + 400
                    i = i+2
                    continue
                elif (s[i] == 'C' and s[i+1] == 'M'):
                    value = value + 900
                    i = i+2
                    continue
            if (s[i] == 'I'):
                value = value + 1
                i = i+1
                continue
            elif (s[i] == 'V'):
                value = value + 5
                i = i+1
                continue
            elif (s[i] == 'X'):
                value = value + 10
                i = i+1
                continue
            elif (s[i] == 'L'):
                value = value + 50
                i = i+1
                continue
            elif (s[i] == 'C'):
                value = value + 100
                i = i+1
                continue
            elif (s[i] == 'D'):
                value = value + 500
                i = i+1
                continue
            elif (s[i] == 'M'):
                value = value + 1000
                i = i+1
        return value

    def romanToInteger(self, s: str) -> int:
        # s = s.replace("IV", "IIII").replace("IX", "VIIII").replace("XL", "XXXX").replace("XC", "LXXXX").replace("CD", "CCCC").replace("CM", "DCCCC")
        # return sum(map(lambda x: roman_to_integer[x], s))
        i = 0
        value = 0
        while (i < len(s)):
            if (s[i] == 'I'):
                if ((len(s) - i) >= 2):
                    if (s[i+1] == 'V'):
                        value = value + 4
                        i = i+2
                        continue
                    if (s[i+1] == 'X'):
                        value = value + 9
                        i = i+2
                        continue
                value = value + 1
                i = i+1
            elif (s[i] == 'X'):
                if ((len(s) - i) >= 2):
                    if (s[i+1] == 'L'):
                        value = value + 40
                        i = i+2
                        continue
                    if (s[i+1] == 'C'):
                        value = value + 90
                        i = i+2
                        continue
                value = value + 10
                i = i+1
            elif (s[i] == 'C'):
                if ((len(s) - i) >= 2):
                    if (s[i+1] == 'D'):
                        value = value + 400
                        i = i+2
                        continue
                    if (s[i+1] == 'M'):
                        value = value + 900
                        i = i+2
                        continue
                value = value + 100
                i = i+1
            elif (s[i] == 'V'):
                value = value + 5
                i = i+1
                continue
            elif (s[i] == 'L'):
                value = value + 50
                i = i+1
                continue
            elif (s[i] == 'D'):
                value = value + 500
                i = i+1
                continue
            elif (s[i] == 'M'):
                value = value + 1000
                i = i+1
        return value
                    


start = datetime.now()
print(Solution.romanToInt(Solution, 'DCXXI'))
print (datetime.now() - start)
start = datetime.now()
print(Solution.romanToInteger(Solution, 'DCXXI'))
print (datetime.now() - start)
