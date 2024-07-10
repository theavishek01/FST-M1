num = int(input("Enter a number to determine odd/even: "))
mod = num%2

num = str(num)
if mod>0:
    print(num +" is odd")
else:
    print(num +" is even")