const koreanFormatter = new Intl.NumberFormat('ko-KR')

export function numberFormat(num:number | bigint) {
    return koreanFormatter.format(num)
}