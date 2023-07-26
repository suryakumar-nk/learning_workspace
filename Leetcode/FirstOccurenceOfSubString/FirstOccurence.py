# from datetime import datetime

# haystack = 'mississippi'
# needle = 'issip'
# start = datetime.now()
# i = 0
# while(i < len(haystack)):
#     if (haystack[i] == needle[0]):
#         if (len(needle) == 1):
#             print(i)
#         if ((len(haystack) - i) < len(needle)):
#             print(-1)
#         for j in range(1, len(needle)):
#             if (haystack[i+j] != needle[j]):
#                 i = i+j-1
#                 break
#             if (j == len(needle)-1):
#                 print(i)
#     i = i+1
#     # if (k != -1):
#     #     break
# print(datetime.now() - start)
            

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        i = 0
        while(i < len(haystack)):
            if (haystack[i] == needle[0]):
                if (len(needle) == 1):
                    return i
                if ((len(haystack) - i) < len(needle)):
                    return -1
                for j in range(1, len(needle)):
                    if (haystack[i+j] != needle[j]):
                        break
                    if (j == len(needle)-1):
                        return i
            i = i+1
        return -1