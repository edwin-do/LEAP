import random

names = []
def check_input(a):
    try:
        if len(a) > 1:
            return True
        elif len(a) == 0:
            return True
        else:
            return False

    except ValueError:
        return True

def generate():
    cont = True
    while(cont):
        f= open("names.txt","r")
        names = f.readlines()
        first_letter = input("Enter the first letter of the name: \n")
        while (check_input(first_letter)):
            first_letter = input("Enter the first letter of the name: \n")
        first_letter = first_letter.upper()

        possible_names = []
        for name in names:
            if name.startswith(first_letter):    
                possible_names.append(name)

        index = random.randint(0,len(possible_names))
        print(possible_names[index])
        c = input("Would you like to generate another name? y or n \n")
        if (c == 'y'):
            cont = True
        elif (c == 'n'):
            cont = False
        else:
            cont = False

generate()
