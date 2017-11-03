package mamori.honzon.checker.light.Birthday;

/**
 * Created by Hirofumi_Kayamoto on 2017/11/02.
 */

public class Input_Born_Year {

    public int buffer_year;
    public int buffer_month;
    public int buffer_day;

    public  void Born_Year(int buf_year) {

        this.buffer_year *= 10;
        this.buffer_year += buf_year;
    }
    public  void Born_Month(int buf_month) {

        this.buffer_month *= 10;
        this.buffer_month += buf_month;
    }
    public  void Born_Day(int buf_day) {

        this.buffer_day *= 10;
        this.buffer_day += buf_day;
    }
    public void clear()
    {
        //データー初期化
        this.buffer_year=0;
        this.buffer_month=0;
        this.buffer_day=0;

    }









}
