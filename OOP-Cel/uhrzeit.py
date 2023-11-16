class Uhrzeit:
    @staticmethod
    def check(input:str):
        h = int(input[0]) * 10 + int(input[1])
        m = int(input[3])*10 + int(input[4])
        s = int(input[6])*10 + int(input[7])
        sep_1 = input[2]
        sep_2 = input[5]
        if 0 <= h <= 23 and 0 <= m <= 59 and 0 <= s <= 59 and sep_1 == ":" and sep_2 == ":":
            return True
        else:
            return False

    def __init__(self,input:str):
        if self.check(input):
            self.hours = int(input[0])*10 + int(input[1])
            self.minutes = int(input[3])*10 + int(input[4])
            self.seconds = int(input[6])*10 + int(input[7])
            pass
        else:
            raise ValueError(f"Illegal value(s) in string {input}")

    def __str__(self):
        return f"{self.hours:0>2}:{self.minutes:0>2}:{self.seconds:0>2}"

    def __eq__(self, other):
        return (self.hours, self.minutes, self.seconds) == (other.hours, other.minutes, other.seconds)

    def inc(self):
        self.seconds += 1
        if self.seconds >= 60:
            self.seconds = 0
            self.minutes += 1
        if self.minutes >= 60:
            self.minutes = 0
            self.hours += 1
        if self.hours >= 24:
            self.hours = 0
            self.minutes = 0
            self.seconds = 0 
    
    def dec(self):
        self.seconds -= 1
        if self.seconds < 0:
            self.seconds = 59
            self.minutes -= 1
        if self.minutes < 0:
            self.minutes = 59
            self.hours -= 1
        if self.hours < 0:
            self.hours = 23
            self.minutes = 59
            self.seconds = 59
    @staticmethod
    def test():
        secondsInDay = 24*60*60
        secondsCounted = 0
        startUhrzeitInc = Uhrzeit("00:00:00")
        while secondsCounted < secondsInDay:
            startUhrzeitInc.inc()
            secondsCounted += 1
        if startUhrzeitInc == Uhrzeit("00:00:00"):
            print(f"TEST Uhrzeit.inc() passed {startUhrzeitInc} {secondsCounted}s counted")
        else:
            print(f"TEST Uhrzeit.inc() failed {startUhrzeitInc} {secondsCounted}s counted")

        secondsCounted = 0
        startUhrzeitDec = Uhrzeit("00:00:00")
        while secondsCounted < secondsInDay:
            startUhrzeitDec.dec()
            secondsCounted += 1
        if startUhrzeitDec == Uhrzeit("00:00:00"):
            print(f"TEST Uhrzeit.dec() passed {startUhrzeitDec} {secondsCounted}s counted")
        else:
            print(f"TEST Uhrzeit.dec() failed {startUhrzeitDec} {secondsCounted}s counted")


if __name__ == "__main__":
    print("CHECK", Uhrzeit.check("23:70:23"))
    print("UHRZEIT", Uhrzeit("23:23:50"))
    print("EQ", Uhrzeit("23:23:23") == Uhrzeit("23:23:50"))
    uz1 = Uhrzeit("23:59:59")
    print("NOTHING", uz1)
    uz1.inc()
    print("INC", uz1)
    uz1.dec()
    print("DEC", uz1)
    Uhrzeit.test()

