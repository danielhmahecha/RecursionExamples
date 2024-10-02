import random 
import sys
param_1= int(sys.argv[1])

random_numbers=random.sample(range(1, param_1+1), param_1)

file = open(str(param_1)+"numbers.txt", "w+")
for number in random_numbers:
    f=open(str(param_1)+"numbers.txt", "a")
    f.write(str(number) +'\n')

f.close()
