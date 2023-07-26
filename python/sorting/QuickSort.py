def quickSort(a,l,r):
    if (r-l)<=1:
        return ()
    yellow = l+1
    # green = l+1
    for green in range(l+1, r):
        if (a[green]<=a[l]):
            (a[yellow], a[green]) = (a[green], a[yellow])
            yellow = yellow + 1
    (a[yellow - 1], a[l]) = (a[l], a[yellow-1])
    quickSort(a,l,yellow-1)
    quickSort(a,yellow,r)

# # quickSort([5,4,3,10,9,2,1],0,5)

# def Quicksort(A,l,r): # Sort A[l:r]
#     if r - l <= 1: # Base case
#         return ()

#     # Partition with respect to pivot, a[l]
#     yellow = l+1

#     for green in range(l+1,r):
#         if A[green] <= A[l]:
#             (A[yellow],A[green]) = (A[green],A[yellow])
#             yellow = yellow + 1

#     # Move pivot into place
#     (A[l],A[yellow-1]) = (A[yellow-1],A[l])

#     Quicksort(A,l,yellow-1) # Recursive calls
#     Quicksort(A,yellow,r)