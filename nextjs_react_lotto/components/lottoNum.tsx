'use client'

import styles from '@/app/ui/css/lotto.module.css'

const ball_styles = [
    styles.ball1,
    styles.ball2,
    styles.ball3,
    styles.ball4,
    styles.ball5,
]
export default function LottoNumber({ 
    num, 
    withMargin = false}: 
    { num: number , withMargin: boolean
    }) {
    const num_style = Math.trunc(num / 10)
    const marginStr = withMargin ? "ml-[20px] " : "";
    return (
        <span className={`float-left ${marginStr} ${styles.ball_645} ${styles.lrg} ${ball_styles[num_style]}`}>
            {num}
        </span>
    )
}