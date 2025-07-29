using simpleLotto.data.model;
using simpleLotto.service;
using simpleLotto.service.external;
using simpleLotto.utils;

namespace simpleLotto
{
    public partial class LottoResultForm : Form {
        int drwNo = LottoUtils.LastDrawnNo();
        public LottoResultForm() {
            InitializeComponent();
        }

        private void displayDrawDate(String drwDate) {
            String year = drwDate.Substring(0, 4);
            String month = drwDate.Substring(5, 2);
            String day = drwDate.Substring(8, 2);
            labelDrwDate.Text = $"({year}년 {month}월 {day}일 추첨)";
        }

        private void displayDrawPrize(LottoDrawResult drawResult) {
            String totalAmount = String.Format("{0:#,###}", drawResult.firstAccumamnt);
            String firstPrize = String.Format("{0:#,###}", drawResult.firstWinamnt);
            labelTotal.Text = $"{totalAmount}원";
            labelPrize.Text = $"{firstPrize}원";
            labelCount.Text = $"{drawResult.firstPrzwnerCo}";
        }
        private void showLottoResult(LottoDrawResult result) {
            if (this.InvokeRequired) {
                this.Invoke(new Action<LottoDrawResult>(showLottoResult), result);
            } else {

                labelBall1.SetNumber(result.drwtNo1);
                labelBall2.SetNumber(result.drwtNo2);
                labelBall3.SetNumber(result.drwtNo3);
                labelBall4.SetNumber(result.drwtNo4);
                labelBall5.SetNumber(result.drwtNo5);
                labelBall6.SetNumber(result.drwtNo6);
                labelBonus.SetNumber(result.bnusNo);
                labelDrwNo.Text = $"{result.drwNo}회";
                labelBall1.Update();
                boxLeft.Visible = drwNo > 0 ? true : false;
                boxRight.Visible = drwNo < LottoUtils.LastDrawnNo() ? true : false;
                displayDrawDate(result.drwNoDate);
                displayDrawPrize(result);
            }
        }

        protected override async void OnActivated(EventArgs e) {
            base.OnActivated(e);
            await LoadLottoResult(drwNo);
        }

        private async Task LoadLottoResult(int drwNo) {
            try {
                LottoDrawResult result = await LottoResultService.GetLottoDrawResult(drwNo);
                showLottoResult(result);
            } catch (Exception ex) {
                //
            }
        }

        private async void boxLeft_Click(object sender, EventArgs e) {
            if (drwNo > 0) {
                drwNo -= 1;
                await LoadLottoResult(drwNo);
            }
        }

        private async void boxRight_Click(object sender, EventArgs e) {
            if (drwNo < LottoUtils.LastDrawnNo()) {
                drwNo += 1;
                await LoadLottoResult(drwNo);
            }
        }
    }
}
