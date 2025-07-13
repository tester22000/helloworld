//
//  LottoDrawResult.swift
//  lottoResult
//
//  Created by lee zainy on 6/29/25.
//
import SwiftUI


private var numberFormat: NumberFormatter {
    let formatter = NumberFormatter()
    formatter.numberStyle = .decimal
    return formatter
}

private func getNumberString(_ number: UInt64) -> String {
    return numberFormat.string(from: NSNumber(value: number)) ?? ""
}

struct LottoDrawResult: View {
    var lottoResult : LottoDrawData
    private func getDrawDate() -> String {
        let drawDate = lottoResult.drwNoDate
        let year = drawDate.substring(from: 0, to: 4)
        let month = drawDate.substring(from: 5, to: 7)
        let date = drawDate.substring(from: 8, to: 10)

        return "( \(year)년 \(month)월 \(date)일 추첨 )"
    }
    var body : some View {
        VStack {
            HStack {
                Text("\(lottoResult.drwNo)회")
                    .font(.largeTitle)
                    .foregroundColor(Color(rgbHex:0xfe6838))
                    .padding([.trailing],1)
                Text("당첨결과")
                    .font(.largeTitle)
            }.padding([.top], 60)
            Text("\(getDrawDate())")
                .font(.headline)
                .padding([.top],-10)
            HStack(alignment: .top) {
                VStack {
                    HStack {
                        LottoBall(num:lottoResult.drwtNo1)
                        LottoBall(num:lottoResult.drwtNo2)
                            .padding([.leading],4)
                        LottoBall(num:lottoResult.drwtNo3)
                            .padding([.leading],4)
                        LottoBall(num:lottoResult.drwtNo4)
                            .padding([.leading],4)
                        LottoBall(num:lottoResult.drwtNo5)
                            .padding([.leading],4)
                        LottoBall(num:lottoResult.drwtNo6)
                            .padding([.leading],4)
                    }
                    Text("당첨번호")
                        .font(.headline)
                        .padding([.top],20)
                }
                HStack {
                    Text("+")
                        .padding([.top],20)
                }
                VStack {
                    LottoBall(num:lottoResult.bnusNo)
                    Text("보너스")
                        .font(.headline)
                        .padding([.top],20)
                }
            }.padding([.top],40)
            VStack {
                HStack {
                    TitleText(text: "1등 총 당첨금액", width: 200)
                    TitleText(text: "당첨 게임 수" ,width: 100)
                    TitleText(text: "1게임당 당첨금액" ,width: 200 )
                }
                HStack {
                    CurrencyText(text: "\(getNumberString(lottoResult.firstAccumamnt))원", width: 200, textColor: .red)
                    ContentText(text: "\(lottoResult.firstPrzwnerCo)" ,width: 100)
                    CurrencyText(text: "\(getNumberString(lottoResult.firstWinamnt))원" ,width: 200, textColor: .black)
                }
            }.padding([.top],5)
        }
    }
}

#Preview {
    VStack {
        LottoDrawResult( lottoResult:
            LottoDrawData(
                returnValue: "success",
                drwNoDate: "2023-11-11",
                totSellamnt: 123214124,
                firstWinamnt: 12312321,
                firstPrzwnerCo: 123123,
                firstAccumamnt: 123123,
                drwtNo1: 1,
                drwtNo2: 11,
                drwtNo3: 21,
                drwtNo4: 31,
                drwtNo5: 41,
                drwtNo6: 45,
                bnusNo: 12,
                drwNo: 1234)
        )
    }
}
