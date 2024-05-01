def reversePrefix(word: str, ch: str) -> str:
    try:
        a = word.index(ch)+1
        return word[:a][::-1]+word[a:]
    except:
        return word
    
print(reversePrefix('abcdefd', 'd'))