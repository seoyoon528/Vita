import pandas as pd

# csv 파일 읽기
def readCsv(csvName):
    df = pd.read_csv(csvName, header=0, 
                     names=['start_time', 'custom', 'binning_data', 'tag_id', 'update_time', 'create_time', 'max', 'min', 'score', 'algorithm', 'time_offset', 'deviceuuid', 'comment', 'pkg_name', 'end_time', 'datauuid', ''], 
                     skiprows=1)
    return df

# 일 데이터 처리
def dayDF(df):
    df.rename(columns = {'score':'daily_wearable_stress', 'start_time':'date'}, inplace=True)
    df = df[['daily_wearable_stress', 'date']]
    df['date'] = df.date.str.split(' ').str[0] # 날짜 형식
    df2 = df.groupby('date', as_index=False).mean().round(0) # 날짜별 평균
    return df2