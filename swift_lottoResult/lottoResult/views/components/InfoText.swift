import SwiftUI

struct InfotText : View {
    let text : String
    let width: Int
    let height: Int
    let color: Color
    let textColor: Color
    var body : some View {
        ZStack {
            Rectangle()
                .fill(color)
            Text(text)
                .font(.title3)
                .padding(1)
                .foregroundColor(textColor)
        }
        .frame(width:CGFloat(width), height: CGFloat(height))
        .padding(-3)
    }
}


#Preview {
    InfotText(text: "Hello", width: 500, height: 30, color: Color.red, textColor: Color.white)
}
