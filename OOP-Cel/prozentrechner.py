def checkFirstInput(userInput:str):
    try:
        if userInput[-3] != ".":
            raise ValueError
    except:
        raise ValueError(f"{userInput} ist kein gültiger Betrag im Format 'XXX.YY'")
    try: 
        return float(userInput)
    except:
        raise ValueError(f"{userInput} ist kein gültiger Betrag im Format 'XXX.YY'")
def checkInput(userInput:str, betrag):
    if userInput == "0" or userInput == "+0" or userInput == "-0":
        raise InterruptedError()

    elif not 2 <= len(userInput) <= 4:
        print(f"{userInput} ist kein gültiger Aufschlag im Format '+/-XXX")
        raise ValueError
    else:
        try:
            (operator, aufschlag) = (userInput[0], userInput[1:])
            if operator == "+" and 1 <= int(aufschlag) <= 100:
                return betrag + betrag * (int(aufschlag) * 0.01)
            elif operator == "-" and 1 <= int(aufschlag) <= 100:
                return betrag - betrag * (int(aufschlag) * 0.01)
            else:
                raise ValueError
        except:
            print(f"{userInput} ist kein gültiger Aufschlag im Format '+/-XXX' im Bereich 1 - 100")
            raise ValueError()
runningFirst = True
betrag = 0
while runningFirst:
    try:
        betrag = checkFirstInput(input("EINGABE STARTWERT: "))
        runningFirst = False
    except ValueError as e:
        print(f"{e}")

running = True
while running:
    try:
        betrag = checkInput(input("EINGABE: "), betrag) 
        print(f"ausgabe: {betrag}")
    except ValueError:
        print(f"Keine gültige Eingabe")
    except InterruptedError:
        print(f"Quitting")
        running = False
