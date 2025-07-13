using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace simpleLotto.component {
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
            this.Width = 60;
            this.Height = 60;
            this.Text = $"{Number}";
            //this.BackColor = GetCircleColor();

            Graphics g = e.Graphics;
            SizeF sizef = g.MeasureString(this.Text, this.Font);
            using Brush circleBrush = new SolidBrush( GetCircleColor() );
            g.FillEllipse(circleBrush, 0, 0, 59, 59);
            using Brush textBrush = new SolidBrush(Color.White);
            g.DrawString(this.Text, this.Font, textBrush, (int)(Number < 10 ? (sizef.Width / 2)+ 4: (sizef.Width / 4)), (sizef.Height / 4)-2);
        }
    }
}
