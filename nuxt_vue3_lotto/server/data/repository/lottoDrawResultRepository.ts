import { type LottoDrawResult } from '@/data/model/lottoDrawResult'
import { sqliteDB } from '#server/data/repository/sqlite'

export async function getLottoResult(drwNo: number) : Promise<LottoDrawResult | null> {
    return new Promise( (resolve, reject) => {
        sqliteDB.get('SELECT * FROM lotto_result WHERE drw_no=?',[drwNo],(err,row) =>{
            if(err){
                return reject(err)
            }
            if( row ) {
                const rawRow = row as {
                    drw_no: any,
                    drwno_date: any,
                    tot_sell_amnt: any,
                    first_win_amnt: any,
                    first_prz_wner_co: any,
                    first_win_tot_amnt: any,
                    drwt_no1: any,
                    drwt_no2: any,
                    drwt_no3: any,
                    drwt_no4: any,
                    drwt_no5: any,
                    drwt_no6: any,
                    bnusNo: any
                }
                resolve({
                    drwNo : rawRow['drw_no'],
                    drwNoDate: rawRow['drwno_date'],
                    totSellamnt: rawRow['tot_sell_amnt'],
                    firstWinamnt: rawRow['first_win_amnt'],
                    firstPrzwnerCo: rawRow['first_prz_wner_co'],
                    firstAccumamnt: rawRow['first_win_tot_amnt'],
                    drwtNo1: rawRow['drwt_no1'],
                    drwtNo2: rawRow['drwt_no2'],
                    drwtNo3: rawRow['drwt_no3'],
                    drwtNo4: rawRow['drwt_no4'],
                    drwtNo5: rawRow['drwt_no5'],
                    drwtNo6: rawRow['drwt_no6'],
                    bnusNo: rawRow['bnusNo'],
                } as LottoDrawResult)
            } 
            resolve(null)
        })
    })
}

const lotto_result_insert_sql = `
INSERT INTO lotto_result (
    drw_no,
    drwt_no1,
    drwt_no2,
    drwt_no3,
    drwt_no4,
    drwt_no5,
    drwt_no6,
    bnusNo,
    drwno_date,
    tot_sell_amnt,
    first_win_amnt,
    first_prz_wner_co,
    first_win_tot_amnt
) values(?,?,?,?,?,?,?,?,?,?,?,?,?)
`
export async function insertLottoResult(lottoResult : LottoDrawResult){
    return new Promise( (resolve, reject) => {
        sqliteDB.run(lotto_result_insert_sql,[
            lottoResult.drwNo,
            lottoResult.drwtNo1,
            lottoResult.drwtNo2,
            lottoResult.drwtNo3,
            lottoResult.drwtNo4,
            lottoResult.drwtNo5,
            lottoResult.drwtNo6,
            lottoResult.bnusNo,
            lottoResult.drwNoDate,
            lottoResult.totSellamnt,
            lottoResult.firstWinamnt,
            lottoResult.firstPrzwnerCo,
            lottoResult.firstAccumamnt,
        ],(err) => {
            if(err){
                reject(err)
            }
            resolve(null)
        })
    })
}

export async function deleteLottoResult(drwNo: number){
    return new Promise( (resolve, reject) => {
        sqliteDB.run('DELETE FROM lotto_result WHERE drw_no=?',[drwNo], (err) => {
            if(err){
                reject(err)
            }
            resolve(null)
        })
    })
}

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
export async function createLottoResult() {
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
