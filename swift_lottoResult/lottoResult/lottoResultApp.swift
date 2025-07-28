import SwiftUI
import SwiftData

@main
struct lottoResultApp: App {
    var body: some Scene {
        WindowGroup {
            LottoResultScreen()
                .frame(width:800, height: 400)
        }
        .windowResizability(.contentSize)
        .defaultPosition(.center)
    }
}
