import { getLastDrawnNo} from '@/utils/lottoUtils'

export const useLottoResultGlobal = () => useState('lottoResultGlobalData', () => ({
    lastDrwNo: getLastDrawnNo(),
}));