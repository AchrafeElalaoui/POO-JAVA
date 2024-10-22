package tp1.alaoui;

public class EX1 {
    public float[] trierNots(float[] tab) {
        float temp;
        for (int i = 0; i < tab.length; i++) {
            for (int j = i; j < tab.length; j++) {
                if(tab[j]<tab[i]) {
                    temp=tab[j];
                    tab[j]=tab[i];
                    tab[i]=temp;
                }
            }
        }
        return tab;
    }
    public float moyNots(float[] tab) {
        float somme=0,moyenne;
        for (int i = 0; i < tab.length; i++) {
            somme+=tab[i];
        }
        moyenne=somme/tab.length;
        return moyenne;
    }
    public float maxNots(float[] tab) {
        float max=tab[0];
        for (int i = 0; i < tab.length; i++) {
            if(max<tab[i]) {
                max=tab[i];
            }
        }
        return max;
    }
    public float minNots(float[] tab) {
        float min=tab[0];
        for (int i = 0; i < tab.length; i++) {
            if(min>tab[i]) {
                min=tab[i];
            }
        }
        return min;
    }
    public int nbrEtudient(float[] tab,float not) {
        int count=0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]==not) {
                count++;
            }
        }
        return count;
    }

}
