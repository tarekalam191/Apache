num = int(input('Enter a Number:'))
arr1=[]
arr2=[]
for i in range(1,num+1):
    for j in range(1,i+1):
        arr2.append(i*j)
    arr1.append((arr2))
    arr2=[]
print(arr1)