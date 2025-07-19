export interface LottoDrawResult {
    returnValue: string; // 요청결과
    drwNoDate: string; // 날짜
    totSellamnt: number;
    firstWinamnt: number; //1등 상금액
    firstPrzwnerCo: number; // 1등 당첨인원
    firstAccumamnt: number;
    drwtNo1: number; // 로또번호 1
    drwtNo2: number; // 로또번호 2
    drwtNo3: number; // 로또번호 3
    drwtNo4: number; // 로또번호 4
    drwtNo5: number; // 로또번호 5
    drwtNo6: number; // 로또번호 6
    bnusNo: number; // 로또 보너스 번호
    drwNo: number; // 로또회차
}
