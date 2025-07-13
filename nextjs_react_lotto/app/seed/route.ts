
import { sqliteDB } from "../lib/db/sqlite"

const lotto_result_sql = `
    create table if not exists lotto_result (
        drw_no INT NOT NULL PRIMARY KEY,
        drwt_no1 INT NOT NULL,
        drwt_no2 INT NOT NULL,
        drwt_no3 INT NOT NULL,
        drwt_no4 INT NOT NULL,
        drwt_no5 INT NOT NULL,
        drwt_no6 INT NOT NULL,
        bnusNo INT NOT NULL,
        drwno_date VARCHAR(200),
        tot_sell_amnt BIGINT,
        first_win_amnt INT,
        first_prz_wner_co INT,
        first_win_tot_amnt BIGINT
    );
`
async function createLottoResult() {
    return new Promise( (resolve, reject) => {
        sqliteDB.run(lotto_result_sql,
            (err: Error) => {
                if(err){
                    return reject(err)
                }
                return resolve(null)
            }
        )
    })

}

export async function GET() {
    try {
        await createLottoResult()
        return Response.json({ message: 'Database seeded successfully' });
    } catch (err) {
        return Response.json({ err }, { status: 500 });
    }
}