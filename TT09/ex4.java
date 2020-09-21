class Time {
    private String nome = "";

    public Time() {
        this.nome = "";
    }

    public Time(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

public class ex4 {

    public static int compareNome(Time time1, Time time2) {

        String t1 = time1.getNome();
        String t2 = time2.getNome();
        int count = 0;
        int resposta = 0;

        resposta = funcaoRec(t1.toUpperCase(), t2.toUpperCase(), count);

        return resposta;

    }

    public static int funcaoRec(String time1, String time2, int count) {

        int check = 0;

        if (time1.charAt(count) == time2.charAt(count)) {
            funcaoRec(time1, time2, count++);
        } else if (time1.charAt(count) < time2.charAt(count)) {
            check = 1;
        } else {
            check = 2;
        }
        return check;
    }
    public static void main(String[] args) {
        Time t1 = new Time("intz");
        Time t2 = new Time("pain");
        compareNome(t1, t2);
    }
}
