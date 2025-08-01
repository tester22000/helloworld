class LottoDrawResult:
    drwNo = int
    drwNoDate = str
    drwtNo1 = int
    drwtNo2 = int
    drwtNo3 = int
    drwtNo4 = int
    drwtNo5 = int
    drwtNo6 = int
    bnusNo = int
    totSellamnt = int
    firstWinamnt = int
    firstPrzwnerCo = int
    firstAccumamnt = int
    returnValue = str

    def __init__(
        self,
        drwNo ,
        drwNoDate ,
        drwtNo1 ,
        drwtNo2 ,
        drwtNo3 ,
        drwtNo4 ,
        drwtNo5 ,
        drwtNo6 ,
        bnusNo ,
        totSellamnt ,
        firstWinamnt ,
        firstPrzwnerCo ,
        firstAccumamnt ,
        returnValue):
        self.drwNo = drwNo
        self.drwNoDate = drwNoDate
        self.drwtNo1 = drwtNo1
        self.drwtNo2 = drwtNo2
        self.drwtNo3 = drwtNo3
        self.drwtNo4 = drwtNo4
        self.drwtNo5 = drwtNo5
        self.drwtNo6 = drwtNo6
        self.bnusNo = bnusNo
        self.totSellamnt = totSellamnt
        self.firstWinamnt = firstWinamnt
        self.firstPrzwnerCo = firstPrzwnerCo
        self.firstAccumamnt = firstAccumamnt
        self.returnValue = returnValue