import SwiftUI

struct TitleText : View {
    let text : String
    let width: Int
    var body : some View {
        ZStack {
            Rectangle()
                .fill(.gray)
            Text(text)
                .font(.title3)
                .padding(1)
                .foregroundColor(.white)
        }
        .frame(width:CGFloat(width), height: 40)
        .padding(-3)
    }
}


#Preview {
    TitleText(text: "Hello", width: 500)
}
