using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.data.model {
    public class LottoDrawResult {
        [Key]
        public int drwNo { get; set; }// 로또회차
        public string returnValue { get; set; } = null; // 요청결과
        public string drwNoDate { get; set; } = null;// 날짜
        public long totSellamnt { get; set; } = 0;
        public long firstWinamnt { get; set; } = 0; //1등 상금액
        public int firstPrzwnerCo { get; set; } = 0; // 1등 당첨인원
        public long firstAccumamnt { get; set; } = 0;
        public int drwtNo1 { get; set; } = 0;// 로또번호 1
        public int drwtNo2 { get; set; } = 0;// 로또번호 2
        public int drwtNo3 { get; set; } = 0;// 로또번호 3
        public int drwtNo4 { get; set; } = 0;// 로또번호 4
        public int drwtNo5 { get; set; } = 0;// 로또번호 5
        public int drwtNo6 { get; set; } = 0;// 로또번호 6
        public int bnusNo { get; set; } = 0;// 로또 보너스 번호
    }
}
