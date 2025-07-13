create table if not exists lotto_draw_result (
        drw_no INT NOT NULL PRIMARY KEY,
        drw_no_date VARCHAR(200),
        drwt_no1 INT NOT NULL,
        drwt_no2 INT NOT NULL,
        drwt_no3 INT NOT NULL,
        drwt_no4 INT NOT NULL,
        drwt_no5 INT NOT NULL,
        drwt_no6 INT NOT NULL,
        bnus_no INT NOT NULL,
        tot_sell_amnt BIGINT,
        first_win_amnt INT,
        first_prz_wner_co INT,
        first_accum_amnt BIGINT,
        return_value VARCHAR(20)
);