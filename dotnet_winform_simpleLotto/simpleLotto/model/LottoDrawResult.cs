using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.model {
    public record class LottoDrawResult( 
        String returnValue = null, // 요청결과
        String drwNoDate = null,// 날짜
        long totSellamnt = 0,
        long firstWinamnt = 0, //1등 상금액
        int firstPrzwnerCo = 0, // 1등 당첨인원
        long firstAccumamnt = 0,
        int drwtNo1 = 0,// 로또번호 1
        int drwtNo2 = 0,// 로또번호 2
        int drwtNo3 = 0,// 로또번호 3
        int drwtNo4 = 0,// 로또번호 4
        int drwtNo5 = 0,// 로또번호 5
        int drwtNo6 = 0,// 로또번호 6
        int bnusNo = 0,// 로또 보너스 번호
        int drwNo = 0 // 로또회차
   );
}
