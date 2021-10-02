public class Lab_class_ex2_2 {
    public static void main(String[] arr) {
        Time start = new Time();
        start.setTime(15, 13, 46);
        Time end = new Time();
        end.setTime( 19, 2, 14);

        if (start.min > end.min) {
            end.min += 60;
            end.hour -= 1;
        }
        if (start.sec > end.sec) {
            end.sec += 60;
            end.min -= 1;
        }
        int hourDif = end.hour - start.hour;
        int minDif = end.min - start.min;
        int secDif = end.sec - start.sec;
        System.out.println("Разница составляет " + hourDif + ":" + minDif + ":" + secDif);
    }
}

class Time {
    int sec;
    int min;
    int hour;
    public void setTime(int hour, int min, int sec) {
        this.sec = sec;
        this.min = min;
        this.hour = hour;
    }
}