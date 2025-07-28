import SwiftUI

struct ContentText : View {
    let text : String
    let width: Int
    var body : some View {
        ZStack {
            Rectangle()
                .fill(.white)
            Text(text)
                .font(.title3)
                .padding(1)
                .foregroundColor(.black)
        }
        .frame(width:CGFloat(width), height: 40)
        .padding(-3)
    }
}


#Preview {
    ContentText(text: "Hello", width: 500)
}
