import SwiftUI

struct ContentView: View {
    private let lastDrwNo = lastDrawnNo()
    @State var model = LottoDrawResultViewModel()
    
    var body: some View {
        HStack(alignment: .center) {
            PrevButton(model: model)
            if model.drawData != nil {
                LottoDrawResult(lottoResult: model.drawData!)
                    .gesture(
                        DragGesture(minimumDistance: 0, coordinateSpace: .local)
                            .onEnded({ value in
                                if value.translation.width < 0 {
                                    if model.hasNext() {
                                        model.inc()
                                    }
                                }
                                if value.translation.width > 0 {
                                    // right
                                    if model.hasPrevious() {
                                        model.dec()
                                    }
                                }
                            }))
            }
            NextButton(model: model)
        }.onAppear() {
            model.drwNo = lastDrwNo
        }
    }
}

#Preview {
    HStack(alignment: .center) {
        Button {
            
        } label : {
            Image(systemName:"chevron.left")
            .font(.largeTitle)
        }
        .padding([.top],40)
        .padding([.horizontal],10)

        LottoDrawResult(lottoResult: LottoDrawData(
            returnValue: "success",
            drwNoDate: "2024-11-11",
            totSellamnt: 1111,
            firstWinamnt: 1111,
            firstPrzwnerCo: 11,
            firstAccumamnt: 1123,
            drwtNo1: 1,
            drwtNo2: 11,
            drwtNo3: 21,
            drwtNo4: 31,
            drwtNo5: 41,
            drwtNo6: 46,
            bnusNo: 5,
            drwNo: 1000
        ))
        Button {
            
        } label : {
            Image(systemName:"chevron.right")
            .font(.largeTitle)
        }
        .padding([.top],40)
        .padding([.horizontal],10)
    }
}
