import SwiftUI

struct NextButton : View {
    let model : LottoDrawResultViewModel
    var body: some View {
        if model.drawData != nil && model.hasNext() {
            Button {
                model.inc()
            } label : {
                Image(systemName:"chevron.right")
                    .font(.largeTitle)
            }
            .padding([.top],20)
            .padding([.horizontal],10)
        } else {
            VStack{}
                .padding([.top],20)
                .padding([.horizontal],20)
        }
    }
}
