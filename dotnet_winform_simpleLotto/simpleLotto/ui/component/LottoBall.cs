using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.Ui.Component {
    public class LottoBall : Label, IComponent {

        private static Color[] BallColors = {
            ColorTranslator.FromHtml("#c99d01"),
            ColorTranslator.FromHtml("#0c6389"),
            ColorTranslator.FromHtml("#880200"),
            ColorTranslator.FromHtml("#474e50"),
            ColorTranslator.FromHtml("#637619")
        };

        public int Number { get; set; }

        private Color GetCircleColor() {
            return BallColors[Number / 10];
        }

        public void SetNumber(int number) {
            Number = number;
            Refresh();
        }
        protected override void OnPaint(PaintEventArgs e) {
            base.OnPaint(e);
            Width = 60;
            Height = 60;
            Text = $"{Number}";
            //this.BackColor = GetCircleColor();

            Graphics g = e.Graphics;
            SizeF sizef = g.MeasureString(Text, Font);
            using Brush circleBrush = new SolidBrush( GetCircleColor() );
            g.FillEllipse(circleBrush, 0, 0, 59, 59);
            using Brush textBrush = new SolidBrush(Color.White);
            g.DrawString(Text, Font, textBrush, (int)(Number < 10 ? sizef.Width / 2+ 4: sizef.Width / 4), sizef.Height / 4-2);
        }
    }
}
