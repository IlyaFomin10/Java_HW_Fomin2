//Дана строка sql-запроса"select * from students where ".Сформируйте часть WHERE этого запроса,используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.Если значение null,то параметр не должен попадать в запрос.
//Параметры для фильтрации:{"name":"Ivanov","country":"Russia","city":"Moscow","age":"null"}

public class task1 {
    public static String QUERY = "select * from students where "; // для вывода формы запроса
    public static String PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} "; //параметры

    public static void main(String[] args) {
        String paramsNew = PARAMS.replace('{', ' ').replace('}', ' '); //убираем лишние символы
        String[] params = paramsNew.split(","); //создаем новый массив, где разделителем элементов служит ","
        StringBuilder stringBuilder = new StringBuilder(QUERY); //new StringBuilder с текстом для вывода формы запроса
        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":"); //разбиваем i-ый элемент по ":"
            if (!"null".equals(elements[1].trim())) { //Метод trim() в Java позволяет удалить пробелы в начале и конце строки
                stringBuilder.append(elements[0].trim()).append(" =").append(" '").append(elements[1].trim()).append("' "); //формируем строку
                if (i < params.length - 2)
                    stringBuilder.append("and "); //формируем строку
            }
        }
        System.out.println(stringBuilder); //вывод
    }
}