//
import SwiftUI

private let lottoBallBackgrounds: [Color] = [
    Color(rgbHex: 0xc99d01),
    Color(rgbHex: 0x0c6389),
    Color(rgbHex: 0x880200),
    Color(rgbHex: 0x474e50),
    Color(rgbHex: 0x637619),
]
struct LottoBall: View {
    let num: Int
    var body: some View {
        let bgcolor = Int(num / 10)
        ZStack {
            Circle()
                .fill(lottoBallBackgrounds[bgcolor])
            VStack {
                Text(String(num))
                    .font(.title)
                    .foregroundStyle(.white)
            }
            .padding()
        }
        .frame(width: 60, height: 60)
    }
}

#Preview {
    HStack {
        LottoBall(num:1)
        LottoBall(num:11)
        LottoBall(num:21)
        LottoBall(num:31)
        LottoBall(num:41)
        LottoBall(num:45)
        LottoBall(num:23)
    }
}
