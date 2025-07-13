import "@/app/ui/global.css"
import { notoSansKr } from '@/app/ui/fonts'

export default function RootLayout({
    children,
}: {
    children: React.ReactNode
}) {
    return (
        <html lang="en">
            <body className={`${notoSansKr.className} antialiased`}>{children}</body>
        </html>
    )
}