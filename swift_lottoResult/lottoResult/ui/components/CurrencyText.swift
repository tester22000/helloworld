import SwiftUI

struct CurrencyText : View {
    let text : String
    let width: Int
    let textColor: Color
    var body : some View {
        ZStack {
            Rectangle()
                .fill(.white)
            HStack {
                Spacer()
                Text(text)
                    .font(.title3)
                    .padding(.trailing,8)
                    .foregroundColor(textColor)
            }
        }
        .frame(width:CGFloat(width), height: 40)
        .padding(-3)
    }
}


#Preview {
    CurrencyText(text: "Hello", width: 500, textColor: .red)
}
