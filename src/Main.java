public class Main {
    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = -1;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 0) { //проверяем на нули (если нули), то
            return 0; //возвращаем 0
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) { //во избежание переполнения допустимого значения (при делении минимально
            //допустимого числа(-2^31) по Integer на -1)
            return Integer.MAX_VALUE; //возвращаем максимально допустимое число по Integer
        }
        if (divisor == 1) { //если делитель = 1
            return dividend; //возвращаем делимое
        }
        if (divisor == -1) { //если делитель = -1
            return -dividend; //то возвращаем делимое со знаком "-"
        }
        if (divisor == dividend) { //если делитель и делимое равны между собой
            return 1; //возвращаем 1
        }
        long result = 0; //контейнер для подсчета результатов (будет работать в виде счетчика, который будет увеличиваться
        //при каждом отнимании делителя от делимого)

        long mathAbs = Math.abs((long) divisor); //создаем переменную, в которой будем хранить абсолютное (положительное)
        //число от делителя
        long mathAbs2 = Math.abs((long) dividend); //создаем переменную, в которой будем хранить абсолютное (положительное)
        //число от делимого

        for (long i = mathAbs2; i > 0; i = i - mathAbs) { //циклом проходимся по делимому числу и при каждой итерации отнимаем от
            //него делитель (таким образом мы сможем посчитать со скольки делителей состоит делимое)
            result++; //увеличиваем счетчик на единицу
        }
        if (mathAbs2 % mathAbs != 0) { //для того, чтобы при делении не затягивался хвостик от деления меньшего числа на большее,
            //что в случае с Integer дает еще одну единицу, мы эту единицу отнимем от счетчика результата, но при условии если
            //делимое не делиться нацело на делимое
            result = result - 1; //если есть хвостик при остатке от деления, то отнимем одну итерацию от счетчика результата
        }

        String str = String.valueOf(divisor); //переводим делитель в строку
        char[] ch = str.toCharArray(); //разбиваем строку на символы
        String str2 = String.valueOf(dividend); //переводим делимое в строку
        char[] ch2 = str2.toCharArray(); //разбиваем строку на символы
        if (ch[0] == '-' && ch2[0] == '-') { //если у делителя и делимого присутствует знак минус, то
            return (int) result; //возвращаем счетчик результат, приведенный к типу int
        } else if (ch[0] == '-' || ch2[0] == '-') { //иначе если у делителя или делимого присутствует знак минус, то
            return -((int) result); //возвращаем результат с минусовым знаком
        } else { //в других случаях
            return (int) result; //возвращаем счетчик результат, приведенный к типу int
        }


//        if (divisor == 0) {
//            return Integer.MAX_VALUE;
//        }
//        if (dividend == Integer.MIN_VALUE && divisor == -1) {
//            return Integer.MAX_VALUE;
//        }
//
//        // convert to long to avoid overflow
//        long dvd = Math.abs((long) dividend);
//        long dvs = Math.abs((long) divisor);
//
//        // initialize variables
//        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
//        int res = 0;
//
//        // repeat until dividend is smaller than divisor
//        while (dvd >= dvs) {
//            // find the largest multiple of divisor that fits into dividend
//            long multiple = dvs;
//            int shift = 0;
//            while (dvd >= (multiple << 1)) {
//                multiple <<= 1;
//                shift++;
//            }
//            dvd -= multiple;
//            res += (1 << shift);
//        }
//
//        return sign * res;
    }
}