import SwiftUI

struct PrevButton : View {
    let model : LottoDrawResultViewModel
    var body: some View {
        if model.drawData != nil && model.hasPrevious() {
            Button {
                model.dec()
            } label : {
                Image(systemName:"chevron.left")
                    .font(.largeTitle)
            }
            .padding([.top],20)
            .padding([.horizontal],10)
            .buttonStyle(.plain)
        } else {
            VStack {}
                .padding([.top],20)
                .padding([.horizontal],20)
        }
    }
}
