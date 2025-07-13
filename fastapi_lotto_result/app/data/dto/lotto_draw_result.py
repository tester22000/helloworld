from pydantic import BaseModel, Field, ConfigDict

class LottoDrawResultDto(BaseModel):
	drw_no: int = Field(alias='drwNo')
	drw_no_date: str = Field(alias='drwNoDate')
	drwt_no1: int = Field(alias='drwtNo1')
	drwt_no2: int = Field(alias='drwtNo2')
	drwt_no3: int = Field(alias='drwtNo3')
	drwt_no4: int = Field(alias='drwtNo4')
	drwt_no5: int = Field(alias='drwtNo5')
	drwt_no6: int = Field(alias='drwtNo6')
	bnus_no: int = Field(alias='bnusNo')
	tot_sell_amnt: int = Field(alias='totSellamnt')
	first_win_amnt: int = Field(alias='firstWinamnt')
	first_prz_wner_co: int = Field(alias='firstPrzwnerCo')
	first_accum_amnt: int = Field(alias='firstAccumamnt')
	return_value: str = Field(alias='returnValue')

	model_config = ConfigDict(from_attributes=True)