checkouts = []
books = []
borrowers = []
while True: 
    line = input()
    if line == 'Books':
        continue
    if line == 'Borrowers':
        books.extend(checkouts)
        checkouts = []
        continue
    if line == 'Checkouts':
        borrowers.extend(checkouts)
        checkouts = []
        continue
    if line=='EndOfInput':
        break
    checkouts.append(line)
booksDir = {}
for book in books:
    booksDir[book.split("~")[0]] = book.split("~")[1]
del(books)
borrowerDir = {}
for borrower in borrowers:
    borrowerDir[borrower.split("~")[0]] = borrower.split("~")[1]
del(borrower)
result = []
for checkout in checkouts:
    list = checkout.split("~")
    result.append(list[2]+'~'+borrowerDir[list[0]]+'~'+list[1]+'~'+booksDir[list[1]])
result.sort()
for res in result:
    print(res)