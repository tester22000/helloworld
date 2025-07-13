import SwiftUI

extension Color {
    init(rgbaHex: UInt) {
        self.init(
            .sRGB,
            red: Double((rgbaHex >> 24) & 0xff) / 255,
            green: Double((rgbaHex >> 16) & 0xff) / 255,
            blue: Double((rgbaHex >> 08) & 0xff) / 255,
            opacity: Double((rgbaHex >> 00) & 0xff) / 255
        )
    }
    init(rgbHex: UInt) {
        self.init(
            .sRGB,
            red: Double((rgbHex >> 16) & 0xff) / 255,
            green: Double((rgbHex >> 8) & 0xff) / 255,
            blue: Double((rgbHex >> 0) & 0xff) / 255
        )
    }
}

