num = int(input('Enter The Number of Rows:'))
for i in range(num):
    for j in range(i,num):
        print(' ', end=' ')
    for j in range(i+1):
       print('*', end=' ')
    print()

fruits = ["Orange", "Apple", "Banana"]
fruits.append("Kiwi")
print(fruits)

fruits = ["Orange", "Apple", "Banana"]
fruits.extend(["Kiwi", "Watermelon"])
print(fruits)